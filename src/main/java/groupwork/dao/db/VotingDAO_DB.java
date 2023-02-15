package groupwork.dao.db;

import groupwork.dao.api.IVotingDao;
import groupwork.dao.orm.api.IManager;
import groupwork.entity.SavedVoice;
import groupwork.entity.SingerEntity;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Map;

public class VotingDAO_DB implements IVotingDao {
    private final IManager manager;

    public VotingDAO_DB(IManager manager) {
        this.manager = manager;
    }



    @Override
    public List<SavedVoice> getVoiceList() {
        EntityManager entityManager = null;
        List<SavedVoice> savedVoices;
        try {
            entityManager = manager.getEntityManager();

            entityManager.getTransaction().begin();
            savedVoices  = entityManager.createQuery("FROM SavedVoice", SavedVoice.class).getResultList();
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            throw new RuntimeException("SQL exception", e.getCause());
        } finally {
            if (entityManager != null && entityManager.isOpen()) {
                entityManager.close();
            }
        }
        return savedVoices;

    }

    @Override
    public void authorization(long id) {
        EntityManager entityManager = null;
        try {
            entityManager = manager.getEntityManager();
            entityManager.getTransaction().begin();

            SavedVoice savedVoice = entityManager.find(SavedVoice.class, id);

            if(savedVoice != null) {
                savedVoice.setAuthorization(true);
                entityManager.merge(savedVoice);
                entityManager.getTransaction().commit();
            } else {
                entityManager.getTransaction().commit();
                throw new NullPointerException("Update is not possible.");
            }
        } catch (RuntimeException e) {
            throw new RuntimeException("DataBase error", e);
        } finally {
            if(entityManager != null) {
                entityManager.close();
            }
        }
    }

    @Override
    public long save(SavedVoice voice) {

        EntityManager entityManager = null;
        try {
            entityManager = manager.getEntityManager();
            entityManager.getTransaction().begin();
            entityManager.persist(voice);
            entityManager.getTransaction().commit();
            entityManager.close();
        } catch (Exception e) {
            throw new RuntimeException("SQL exception", e.getCause());
        } finally {
            if (entityManager != null && entityManager.isOpen()) {
                entityManager.close();
            }
        }
        return voice.getId();
    }
}

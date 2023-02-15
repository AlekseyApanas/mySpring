package groupwork.dao.orm.api;

import javax.persistence.EntityManager;

public interface IManager {

    EntityManager getEntityManager();

    void close();
}

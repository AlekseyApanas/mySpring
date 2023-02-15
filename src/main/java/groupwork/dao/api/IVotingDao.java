package groupwork.dao.api;

import groupwork.entity.SavedVoice;

import java.util.List;
import java.util.Map;

public interface IVotingDao {
    List<SavedVoice> getVoiceList();

    //Map<Long, Long> getIdAndKey();

    void authorization(long id);

    long save(SavedVoice voice);
}

package groupwork.service.api;

import groupwork.dto.SavedVoiceDTO;
import groupwork.dto.VoiceDTO;
import groupwork.entity.SavedVoice;

import java.util.List;
import java.util.Map;

public interface IVotesService {

    void save(VoiceDTO voice);

    Map<Long, Long> getIdAndKey();

    void authorization(long id);

    List<SavedVoiceDTO> get();
}

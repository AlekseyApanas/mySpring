package groupwork.service.api;

import groupwork.dto.SingerDTO;
import groupwork.entity.SingerEntity;

import java.util.List;

public interface ISingerService {

    boolean checkNumber(long number);

    List<SingerDTO> get();

    void delete(long id, long version);

    void create(SingerDTO singerDTO);

    void update(long id, SingerDTO singerDTO, long version);
    SingerDTO get(long id);
}

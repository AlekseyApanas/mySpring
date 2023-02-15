package groupwork.service.api;

import groupwork.dto.GenreDTO;
import groupwork.dto.SingerDTO;
import groupwork.entity.GenreEntity;

import java.util.List;

public interface IGenreService {

    boolean check(long number);

    List<GenreDTO> get();

    void delete(long id, long version);

    void create(GenreDTO genreDTO);

    void update(long id, GenreDTO genreDTO, long version);
    GenreDTO get(long id);

}

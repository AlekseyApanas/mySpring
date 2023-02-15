package groupwork.service;

import groupwork.dao.api.IGenreDao;
import groupwork.dto.GenreDTO;
import groupwork.entity.GenreEntity;
import groupwork.service.api.IGenreService;


import java.util.ArrayList;
import java.util.List;

public class GenreService implements IGenreService {

    private final IGenreDao dao;

    public GenreService(IGenreDao dao) {
        this.dao = dao;
    }

    @Override
    public boolean check(long number) {
        if (number == 0) {
            throw new IllegalArgumentException("Введите id жанра");
        }
        return this.dao.isContain(number);
    }

    @Override
    public List<GenreDTO> get() {
        List<GenreEntity> genreList = dao.getGenreList();

        List<GenreDTO> list = new ArrayList<>();

        for (GenreEntity genreEntity : genreList) {
            list.add(new GenreDTO(genreEntity.getName(), genreEntity.getId(),genreEntity.getVersion()));
        }

        return list;
    }

    @Override
    public void delete(long id, long version) {
        if (id == 0) {
            throw new IllegalArgumentException("Введите номер жанра");
        }
        if (dao.isContain(id)) {
            if (dao.get(id).getVersion() != version) {
                throw new IllegalArgumentException("Введена неправильная версия");
            }
            dao.delete(new GenreEntity(id));
        } else {
            throw new IllegalArgumentException("Нет жанра для удаления с таким id");
        }
    }

    @Override
    public void create(GenreDTO genreDTO) {
        String name = genreDTO.getName();
        if (name != null && !name.isBlank()) {
            dao.create(new GenreEntity(name));
        } else {
            throw new IllegalArgumentException("Не введен исполнитель");
        }
    }

    @Override
    public void update(long id, GenreDTO genreDTO, long version) {
        String genre = genreDTO.getName();
        if (genre == null || genre.isBlank()) {
            throw new IllegalArgumentException("Не введен жанр");
        }

        if (id == 0) {
            throw new IllegalArgumentException("Введите id жанра");
        }

        if (dao.isContain(id)) {
            if (dao.get(id).getVersion() != version) {
                throw new IllegalArgumentException("Введена неправильная версия");
            }
            dao.update(new GenreEntity(id, genre));

        } else {
            throw new IllegalArgumentException("Нет жанра для обновления с таким id");
        }
    }

    @Override
    public GenreDTO get(long id) {
        GenreEntity genreEntity = this.dao.get(id);
        return new GenreDTO(genreEntity.getName(), genreEntity.getId(),genreEntity.getVersion());
    }
}

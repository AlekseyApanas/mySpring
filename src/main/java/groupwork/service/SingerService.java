package groupwork.service;

import groupwork.dao.api.ISingerDao;
import groupwork.dto.SingerDTO;
import groupwork.entity.SingerEntity;
import groupwork.service.api.ISingerService;

import java.util.ArrayList;
import java.util.List;

public class SingerService implements ISingerService {

    private final ISingerDao dao;

    public SingerService(ISingerDao dao) {
        this.dao = dao;
    }

    @Override
    public boolean checkNumber(long number) {
        if (number == 0) {
            throw new IllegalArgumentException("Введите номер исполнителя");
        }
        return this.dao.isContain(number);
    }

    @Override
    public List<SingerDTO> get() {
        List<SingerEntity> singerList = dao.getSingerList();

        List<SingerDTO>list = new ArrayList<>();

        for (SingerEntity singerEntity : singerList) {
            list.add(new SingerDTO(singerEntity.getName(), singerEntity.getId(),singerEntity.getVersion()));
        }

        return list;
    }

    @Override
    public void delete(long id,long version) {
        if(dao.isContain(id)){
            if(dao.get(id).getVersion()!=version){
                throw new IllegalArgumentException("Введена неправильная версия");
            }
            dao.delete(new SingerEntity(id));
        }else {
            throw new IllegalArgumentException("Нет исполнителя для удаления с таким id");
        }
    }

    @Override
    public void create(SingerDTO singerDTO) {
        String name = singerDTO.getName();
        if (name != null && !name.isBlank()) {
            dao.create(new SingerEntity(name));
        } else {
            throw new IllegalArgumentException("Не введен исполнитель");
        }
    }

    @Override
    public void update(long id, SingerDTO singerDTO,long version) {
        String singer = singerDTO.getName();
        if (singer == null || singer.isBlank()) {
            throw new IllegalArgumentException("Не введено новое имя исполнителя");
        }

        if(dao.isContain(id)){
            if(dao.get(id).getVersion()!=version){
                throw new IllegalArgumentException("Введена неправильная версия");
            }
            dao.update(new SingerEntity(id, singer));
        } else {
            throw new IllegalArgumentException("Нет исполнителя для обновления с таким id");
        }
    }

    @Override
    public SingerDTO get(long id) {
        SingerEntity singerEntity = this.dao.get(id);
        return new SingerDTO(singerEntity.getName(), singerEntity.getId(),singerEntity.getVersion());

    }
}

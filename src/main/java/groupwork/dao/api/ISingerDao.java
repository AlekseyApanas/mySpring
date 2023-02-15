package groupwork.dao.api;

import groupwork.entity.SingerEntity;

import java.util.List;

public interface ISingerDao {
    List<SingerEntity> getSingerList();

    boolean isContain(long id);

    void delete(SingerEntity singerEntity);

    void create(SingerEntity singerEntity);

    void update(SingerEntity singerEntity);
    SingerEntity get(long id);
}

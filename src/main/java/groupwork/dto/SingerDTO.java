package groupwork.dto;

import java.util.Objects;

public class SingerDTO {
    private String name;
    private long id;
    private long version;
    public SingerDTO(String name, long id,long version) {
        this.name = name;
        this.id = id;
        this.version = version;
    }

    public SingerDTO(String name) {
        this.name = name;
    }

    public SingerDTO() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getVersion() {
        return version;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SingerDTO singerDTO = (SingerDTO) o;
        return id == singerDTO.id && version == singerDTO.version && Objects.equals(name, singerDTO.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, id, version);
    }

    @Override
    public String toString() {
        return "id = " + id + ",  name = " + name + ", version = " + version;
    }
}

package groupwork.dto;

import java.util.Objects;

public class GenreDTO {
    private String name;
    private long id;
    private long version;

    public GenreDTO(String name, long id, long version) {
        this.name = name;
        this.id = id;
        this.version = version;
    }

    public GenreDTO(String name) {
        this.name = name;
    }

    public GenreDTO() {
    }

    public long getVersion() {
        return version;
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

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GenreDTO genreDTO = (GenreDTO) o;
        return id == genreDTO.id && version == genreDTO.version && Objects.equals(name, genreDTO.name);
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

package groupwork.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "app.genres")
public class GenreEntity {
    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    private long id;
    @Version
    private long version;
    private String name;


    public GenreEntity() {
    }

    public GenreEntity(long id, String name) {
        this.id = id;
        this.name = name;
    }

    public GenreEntity(String name) {
        this.name = name;
    }

    public GenreEntity(long id) {
        this.id = id;
    }

    public long getVersion() {
        return version;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
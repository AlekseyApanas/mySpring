package groupwork.entity;


import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "app.votes")
public class SavedVoice {
    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    private Long id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinTable(
            name = "app.vote_artists",
            joinColumns =
            @JoinColumn(name = "voice_id"),
            inverseJoinColumns =
            @JoinColumn(nullable = false)
    )
    private SingerEntity singer;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "app.vote_genre",
            joinColumns =
            @JoinColumn(name = "voice_id"),
            inverseJoinColumns =
            @JoinColumn(nullable = false)
    )
    private List<GenreEntity> genres = new ArrayList<>();

    private String about;
    private String mail;
    private LocalDateTime dt_create;

    private long key;

    private boolean auth;

    public SavedVoice() {
    }

    public SavedVoice(SingerEntity singer, List<GenreEntity> genres, String message, String email, LocalDateTime creationTime, long key, boolean auth) {
        this.singer = singer;
        this.genres = genres;
        this.about = message;
        this.mail = email;
        this.dt_create = creationTime;
        this.key = key;
        this.auth = auth;
    }

    public Long getId() {
        return id;
    }

    public long getKey() {
        return key;
    }

    public boolean isAuthorization() {
        return auth;
    }

    public void setAuthorization(boolean auth) {
        this.auth = auth;
    }

    public SingerEntity getSinger() {
        return singer;
    }

    public List<GenreEntity> getGenres() {
        return genres;
    }

    public String getAbout() {
        return about;
    }

    public String getMail() {
        return mail;
    }

    public LocalDateTime getDt_create() {
        return dt_create;
    }
}

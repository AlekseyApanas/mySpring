package groupwork.dto;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
public class SavedVoiceDTO implements Comparable<SavedVoiceDTO>{
    private VoiceDTO voice;
    private LocalDateTime creationTime;

    private long key;

    private boolean authorization;

    public SavedVoiceDTO(VoiceDTO voice) {
        this.voice = voice;
        this.creationTime = LocalDateTime.now();
        this.key = (long) (Math.random()*10000);
        this.authorization = false;
    }

    public SavedVoiceDTO(VoiceDTO voice, LocalDateTime creationTime) {
        this.voice = voice;
        this.creationTime = creationTime;
        this.key = (long) (Math.random()*10000);
        this.authorization = false;

    }

    public boolean isAuthorization() {
        return authorization;
    }

    public long getKey() {
        return key;
    }

    public VoiceDTO getVoice() {
        return voice;
    }

    public void setVoice(VoiceDTO voice) {
        this.voice = voice;
    }
    public String getMail() {
        return voice.getMail();
    }

    public long getSinger() {
        return voice.getSinger();
    }

    public long[] getGenre() {
        return voice.getGenre();
    }

    public String getMessage() {
        return voice.getMessage();
    }

    public LocalDateTime getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(LocalDateTime creationTime) {
        this.creationTime = creationTime;
    }

    @Override
    public int compareTo(SavedVoiceDTO o) {
        return o.getCreationTime().compareTo(this.creationTime);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SavedVoiceDTO that = (SavedVoiceDTO) o;
        return key == that.key && Objects.equals(voice, that.voice) && Objects.equals(creationTime, that.creationTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(voice, creationTime, key);
    }

    @Override
    public String toString() {
        return "Verified voice: " +
                "voice = " + voice +
                ", creationTime = " + creationTime;
    }
}

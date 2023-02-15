package groupwork.service;

import groupwork.dao.api.IVotingDao;
import groupwork.dto.GenreDTO;
import groupwork.dto.SavedVoiceDTO;
import groupwork.dto.SingerDTO;
import groupwork.dto.VoiceDTO;
import groupwork.entity.GenreEntity;
import groupwork.entity.SavedVoice;
import groupwork.entity.SingerEntity;
import groupwork.service.api.IGenreService;
import groupwork.service.api.IMailService;
import groupwork.service.api.ISingerService;
import groupwork.service.api.IVotesService;

import java.time.LocalDateTime;
import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.regex.Pattern;

public class VoteService implements IVotesService {
    private final IVotingDao votingDao;

    private final ISingerService singerService;

    private final IGenreService genreService;
    private final IMailService mailService;

    private ExecutorService executorService = Executors.newFixedThreadPool(5);

    public VoteService(IVotingDao voiceDao, ISingerService singerService, IGenreService genreService,
                       MailService mailService) {
        this.votingDao = voiceDao;
        this.singerService = singerService;
        this.genreService = genreService;
        this.mailService = mailService;
    }


    @Override
    public void save(VoiceDTO voice) {
        check(voice);

        SavedVoiceDTO savedVoiceDTO = new SavedVoiceDTO(voice);

        String email = savedVoiceDTO.getMail();
        LocalDateTime creationTime = savedVoiceDTO.getCreationTime();
        String message = savedVoiceDTO.getMessage();
        long key = savedVoiceDTO.getKey();
        boolean auth = savedVoiceDTO.isAuthorization();
        long  singer_id = savedVoiceDTO.getSinger();
        SingerDTO s = singerService.get(singer_id);
        SingerEntity singer = new SingerEntity(s.getId(), s.getName());

        List<GenreEntity> genres = new ArrayList<>();
        for (long genre_id : savedVoiceDTO.getGenre()) {
            GenreDTO genreDTO = genreService.get(genre_id);
            genres.add(new GenreEntity(genreDTO.getId(), genreDTO.getName()));
        }

        SavedVoice savedVoice = new SavedVoice(singer, genres, message, email, creationTime, key, auth);
        long id = votingDao.save(savedVoice);
        executorService.submit(new Thread(() -> mailService.send(savedVoice, id)));
        //mailService.send(savedVoiceDTO);

    }

    @Override
    public Map<Long, Long> getIdAndKey() {
        Map<Long, Long> map = new HashMap<>();
        List<SavedVoice> savedVoices = votingDao.getVoiceList();
        for (SavedVoice savedVoice : savedVoices) {
            map.put(savedVoice.getId(), savedVoice.getKey());
        }
        return map;
    }

    @Override
    public void authorization(long id) {
        votingDao.authorization(id);
    }

    @Override
    public List<SavedVoiceDTO> get() {
        List<SavedVoiceDTO> savedVoiceDTOS = new ArrayList<>();
        List<SavedVoice> all = votingDao.getVoiceList();
        for (SavedVoice voice : all) {
            String email = voice.getMail();
            LocalDateTime creationTime = voice.getDt_create();
            String message = voice.getAbout();
            long id_singer = voice.getSinger().getId();

            List<GenreEntity> genre = voice.getGenres();
            long[] genres = new long[genre.size()];
            for (int i = 0; i < genres.length; i++) {
                genres[i] = genre.get(i).getId();
            }

            VoiceDTO voiceDTO = new VoiceDTO(id_singer, genres, message, email);
            savedVoiceDTOS.add(new SavedVoiceDTO(voiceDTO, creationTime));
        }
        return savedVoiceDTOS;
    }

    private void check(VoiceDTO voice) {
        long singer = voice.getSinger();
        if (!singerService.checkNumber(voice.getSinger())) {
            throw new IllegalArgumentException("Артист №" + singer + " отсутствует в списке выбора");
        }

        long[] genres = voice.getGenre();

        Set<Long> setGenre = new HashSet<>();

        for (long val : genres) {
            setGenre.add(val);
        }

        if (setGenre.size() < 3 || setGenre.size() > 5) {
            throw new IllegalArgumentException("Неверное количество жанров, должно быть от 3 до 5");
        }

        if (setGenre.size() != genres.length) {
            throw new IllegalArgumentException("Переданные жанры содержат дубли");
        }

        for (Long genre : setGenre) {
            if (!genreService.check(genre)) {
                throw new IllegalArgumentException("Введенный жанр №" + genre + " не содержится в списке");
            }
        }

        String aboutMe = voice.getMessage();
        if (aboutMe == null || aboutMe.isBlank()) {
            throw new IllegalArgumentException("Нужно ввести информацию о себе");
        }

        String email = voice.getMail();
        Pattern pattern = Pattern.compile("^[a-zA-Z0-9!#$%&'*+/=?^_`{|},~\\-]+(?:\\\\.[a-zA-Z0-9!#$%&'*+/=?^_`{|}~\\-]+)*@+[a-zA-Z0-9](?:[a-zA-Z0-9-]*[a-zA-Z0-9])?+\\.+[a-zA-Z]*$");
        if (!pattern.matcher(email).matches()) {
            throw new IllegalArgumentException("E-MAIL IS NOT CORRECT");
        }
    }
}

package groupwork.service;

//import groupwork.dao.memory.GenreDao;
//import groupwork.dao.memory.SingerDao;
//import groupwork.dao.memory.VotingDao;


class VoteServiceTest {
//    private final IVotesService votesService = new VoteService(new VotingDao(), new SingerService(new SingerDao()), new GenreService(new GenreDao()), MailServiceSingleton.getInstance());

//    @Test
//    public void testVotingServiceSave() {
//        int singer = 1;
//        int[] genre = {1, 2, 3};
//        String message = "lololo";
//        String mail="ivanivanov2023_18@mail.ru";
//        votesService.save(new VoiceDTO(singer, genre, message,mail));
//        boolean result = !votesService.get().isEmpty();
//        assertTrue(result);
//    }
//
//    @Test
//    public void testVotingServiceExceptionSingerIsMissing() {
//        int singer = 6;
//        int[] genre = {1, 2, 3};
//        String message = "lololo";
//        String mail="ivanivanov2023_18@mail.ru";
//        int exception = 0;
//        boolean result = false;
//        try {
//            votesService.save(new VoiceDTO(singer, genre, message,mail));
//        } catch (Exception e) {
//            exception = 1;
//        }
//        if (exception == 1) {
//            result = true;
//        }
//        assertTrue(result);
//    }
//
//    @Test
//    public void testVotingServiceExceptionNumberOfGenresMore() {
//        int singer = 1;
//        int[] genre = {1, 2, 3, 6, 8, 9};
//        String message = "lololo";
//        int exception = 0;
//        String mail="ivanivanov2023_18@mail.ru";
//        boolean result = false;
//        try {
//            votesService.save(new VoiceDTO(singer, genre, message,mail));
//        } catch (Exception e) {
//            exception = 1;
//        }
//        if (exception == 1) {
//            result = true;
//        }
//        assertTrue(result);
//    }
//
//    @Test
//    public void testVotingServiceExceptionNumberOfGenresLess() {
//        int singer = 2;
//        int[] genre = {1, 2};
//        String message = "lololo";
//        String mail="ivanivanov2023_18@mail.ru";
//        int exception = 0;
//        boolean result = false;
//        try {
//            votesService.save(new VoiceDTO(singer, genre, message,mail));
//        } catch (Exception e) {
//            exception = 1;
//        }
//        if (exception == 1) {
//            result = true;
//        }
//        assertTrue(result);
//    }
//
//    @Test
//    public void testVotingServiceExceptionNumberOfGenresDouble() {
//        int singer = 2;
//        int[] genre = {1, 2, 2};
//        String message = "lololo";
//        String mail="ivanivanov2023_18@mail.ru";
//        int exception = 0;
//        boolean result = false;
//        try {
//            votesService.save(new VoiceDTO(singer, genre, message,mail));
//        } catch (Exception e) {
//            exception = 1;
//        }
//        if (exception == 1) {
//            result = true;
//        }
//        assertTrue(result);
//    }
//
//    @Test
//    public void testVotingServiceExceptionNumberOfGenresDoesNotExist() {
//        int singer = 2;
//        int[] genre = {1, 2, 15};
//        String message = "lololo";
//        String mail="ivanivanov2023_18@mail.ru";
//        int exception = 0;
//        boolean result = false;
//        try {
//            votesService.save(new VoiceDTO(singer, genre, message,mail));
//        } catch (Exception e) {
//            exception = 1;
//        }
//        if (exception == 1) {
//            result = true;
//        }
//        assertTrue(result);
//    }
//
//    @Test
//    public void testVotingServiceExceptionInfoAboutUserDoesNotExist() {
//        int singer = 2;
//        int[] genre = {1, 2, 3};
//        String message = "";
//        String mail="ivanivanov2023_18@mail.ru";
//        int exception = 0;
//        boolean result = false;
//        try {
//            votesService.save(new VoiceDTO(singer, genre, message,mail));
//        } catch (Exception e) {
//            exception = 1;
//        }
//        if (exception == 1) {
//            result = true;
//        }
//        assertTrue(result);
//    }
}
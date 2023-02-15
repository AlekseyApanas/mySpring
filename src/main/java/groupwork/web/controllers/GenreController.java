package groupwork.web.controllers;

import groupwork.dto.GenreDTO;
import groupwork.service.api.IGenreService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/genre")

public class GenreController {
    private final IGenreService genreService;

    public GenreController(IGenreService iGenreService) {
        this.genreService = iGenreService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<GenreDTO> getList() {
        return genreService.get();
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    public GenreDTO getCard(@PathVariable("id") Long genreID) {
        return genreService.get(genreID);
    }

    @RequestMapping(path = "/{id}/{version}", method = RequestMethod.PUT)
    public void update(@PathVariable("id") Long genreID,
                       @PathVariable("version") Long version,
                       @RequestBody GenreDTO genreDTO) {
        genreService.update(genreID, genreDTO,version);
    }

    @RequestMapping(method = RequestMethod.POST)
    public void create(@RequestBody GenreDTO genreDTO) {
        genreService.create(genreDTO);
    }

    @RequestMapping(path = "/{id}/{version}", method = RequestMethod.DELETE)
    public void delete(@PathVariable("id") Long genreID,
                       @PathVariable("version") Long version) {
        genreService.delete(genreID,version);
    }
}

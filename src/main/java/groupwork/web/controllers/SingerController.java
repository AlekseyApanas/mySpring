package groupwork.web.controllers;

import groupwork.dto.SingerDTO;
import groupwork.service.api.ISingerService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/singer")
public class SingerController {
    private final ISingerService singerService;

    public SingerController(ISingerService singerService) {
        this.singerService = singerService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<SingerDTO> getList() {
        return singerService.get();
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    public SingerDTO getCard(@PathVariable("id") Long singerID) {
        return singerService.get(singerID);
    }

    @RequestMapping(path = "/{id}/{version}", method = RequestMethod.PUT)
    public void update(@PathVariable("id") Long singerID,
                       @PathVariable("version") Long version,
                       @RequestBody SingerDTO singerDTO) {
        singerService.update(singerID, singerDTO, version);
    }

    @RequestMapping(method = RequestMethod.POST)
    public void create(@RequestBody SingerDTO singerDTO) {
        singerService.create(singerDTO);
    }

    @RequestMapping(path = "/{id}/{version}", method = RequestMethod.DELETE)
    public void delete(@PathVariable("id") Long singerID,
                       @PathVariable("version") Long version) {
        singerService.delete(singerID, version);
    }
}

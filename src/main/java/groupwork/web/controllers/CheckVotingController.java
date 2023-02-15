package groupwork.web.controllers;


import groupwork.service.api.IVotesService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/check")
public class CheckVotingController {
    private final IVotesService service;

    public CheckVotingController(IVotesService iVotesService) {
        this.service = iVotesService;
    }

    @RequestMapping(path = "/{id}/key/{key}", method = RequestMethod.GET)
    public void check(@PathVariable("id") Long userID,
                      @PathVariable("key") Long key) {
        Map<Long, Long> map = service.getIdAndKey();
        if (map.containsKey(userID) && map.get(userID).equals(key)) {
            service.authorization(userID);
        }
    }
}

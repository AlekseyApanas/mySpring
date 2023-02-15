package groupwork.web.controllers;

import groupwork.dto.VoiceDTO;
import groupwork.service.MailService;
import groupwork.service.api.IVotesService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/answer")
public class UserAnswerController {
    private final IVotesService service;
    private final MailService sendEMailService;


    public UserAnswerController(IVotesService iVotesService,MailService mailService) {
        this.service = iVotesService;
        this.sendEMailService = mailService;
    }

    @RequestMapping(method = RequestMethod.POST)
    public void doPost(@RequestBody VoiceDTO voiceDTO) {
        service.save(voiceDTO);
    }
}
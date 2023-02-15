package groupwork.web.controllers;

import groupwork.dto.AllStatisticDTO;
import groupwork.service.api.IStatisticsService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/result")
public class ResultVotingController {
    private final IStatisticsService statisticsService;

    public ResultVotingController(IStatisticsService iStatisticsService) {
        this.statisticsService = iStatisticsService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public AllStatisticDTO doGet() {
        return statisticsService.getAllSort();
    }
}

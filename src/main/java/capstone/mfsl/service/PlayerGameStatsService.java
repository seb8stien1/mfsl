package capstone.mfsl.service;

import capstone.mfsl.dto.PlayersDTO;
import capstone.mfsl.dto.ResponseDTO;
import capstone.mfsl.dto.StatisticDTO;
import capstone.mfsl.dto.StatsResponseDTO;
import capstone.mfsl.model.statistics.PlayerGameStats;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PlayerGameStatsService {

    @Autowired
    ApiService apiService;

    @Value("${base.url}")
    String baseUrl;

    public ResponseEntity<List<PlayerGameStats>> getPlayerGameStats(String fixtureId) {
        List<PlayerGameStats> playerGameStats = new ArrayList<>();
        StatsResponseDTO statsResponse = new StatsResponseDTO();
        try {
//            get individual player stats for a specific game
            URL url = UriComponentsBuilder.fromUriString(baseUrl)
                    .path("/fixtures/players")
                    .queryParam("fixture", fixtureId)
                    .build().toUri().toURL();
            statsResponse = apiService.getRequest(url, StatsResponseDTO.class);

//            This request will be useful for determining the winner of the game
//            URL url = UriComponentsBuilder.fromUriString(baseUrl)
//                    .path("/fixtures/")
//                    .queryParam("id", fixtureId)
//                    .build().toUri().toURL();
//            statsResponse = apiService.getRequest(url, StatsResponseDTO.class);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        if (statsResponse == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        for (ResponseDTO responseDTO: statsResponse.getResponse()) {
            for (PlayersDTO players : responseDTO.getPlayers()){
                convert(players.getStatistics().get(0)).ifPresent(playerGameStats::add);
            }
        }
        return new ResponseEntity<>(playerGameStats, HttpStatus.OK);
    }

    private Optional<PlayerGameStats> convert(StatisticDTO stat) {
        PlayerGameStats playerGameStats = new PlayerGameStats();

        if (stat == null) {
            return Optional.empty();
        }

        if (stat.getCards() != null) {
            playerGameStats.setYellowCards(Optional.ofNullable(stat.getCards().getYellow()).orElse(0));
            playerGameStats.setRedCards(Optional.ofNullable(stat.getCards().getRed()).orElse(0));
        }
        if (stat.getDribbles() != null) {
            playerGameStats.setSuccessfulDribbles(Optional.ofNullable(stat.getDribbles().getSuccess()).orElse(0));
        }
        if (stat.getDuels() != null) {
            playerGameStats.setDuelsWon(Optional.ofNullable(stat.getDuels().getWon()).orElse(0));
        }
        if (stat.getFouls() != null) {
            playerGameStats.setFoulsDrawn(Optional.ofNullable(stat.getFouls().getDrawn()).orElse(0));
            playerGameStats.setFoulsCommitted(Optional.ofNullable(stat.getFouls().getCommitted()).orElse(0));
        }
        if (stat.getGames() != null) {
            playerGameStats.setMinutes(Optional.ofNullable(stat.getGames().getMinutes()).orElse(0));
            playerGameStats.setRating(Optional.ofNullable(stat.getGames().getRating()).orElse((float) 0));
        }
        if (stat.getGoals() != null) {
            playerGameStats.setGoalsScored(Optional.ofNullable(stat.getGoals().getTotal()).orElse(0));
            playerGameStats.setGoalsConceded(Optional.ofNullable(stat.getGoals().getConceded()).orElse(0));
            playerGameStats.setAssists(Optional.ofNullable(stat.getGoals().getAssists()).orElse(0));
            playerGameStats.setSaves(Optional.ofNullable(stat.getGoals().getSaves()).orElse(0));
        }
        if (stat.getPasses() != null) {
            playerGameStats.setPasses(Optional.ofNullable(stat.getPasses().getTotal()).orElse(0));
            playerGameStats.setKeyPasses(Optional.ofNullable(stat.getPasses().getKey()).orElse(0));
            playerGameStats.setPassAccuracy(Optional.ofNullable(stat.getPasses().getAccuracy()).orElse("0"));
        }
        if (stat.getPenalty() != null) {
            playerGameStats.setPenaltiesCommitted(Optional.ofNullable(stat.getPenalty().getCommited()).orElse(0));
            playerGameStats.setPenaltiesScored(Optional.ofNullable(stat.getPenalty().getScored()).orElse(0));
            playerGameStats.setPenaltiesMissed(Optional.ofNullable(stat.getPenalty().getMissed()).orElse(0));
            playerGameStats.setPenaltiesSaved(Optional.ofNullable(stat.getPenalty().getSaved()).orElse(0));
        }
        if (stat.getShots() != null) {
            playerGameStats.setShotsTaken(Optional.ofNullable(stat.getShots().getTotal()).orElse(0));
            playerGameStats.setShotsOnTarget(Optional.ofNullable(stat.getShots().getOn()).orElse(0));
        }
        if (stat.getTackles() != null) {
            playerGameStats.setTackles(Optional.ofNullable(stat.getTackles().getTotal()).orElse(0));
            playerGameStats.setShotBlocks(Optional.ofNullable(stat.getTackles().getBlocks()).orElse(0));
            playerGameStats.setInterceptions(Optional.ofNullable(stat.getTackles().getInterceptions()).orElse(0));
        }

        
        return Optional.of(playerGameStats);
    }
}

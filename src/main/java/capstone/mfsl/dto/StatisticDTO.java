package capstone.mfsl.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import java.io.Serializable;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class StatisticDTO implements Serializable {
    GameDTO games;
    Integer offsides;
    ShotDTO shots;
    GoalDTO goals;
    PassDTO passes;
    TackleDTO tackles;
    DuelDTO duels;
    DribbleDTO dribbles;
    FoulDTO fouls;
    CardDTO cards;
    PenaltyDTO penalty;
}
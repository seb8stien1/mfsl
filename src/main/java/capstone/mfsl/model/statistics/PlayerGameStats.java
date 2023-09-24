package capstone.mfsl.model.statistics;

//import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.lang.reflect.Field;


@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
//@Table(name = "matchDayTable")
public class PlayerGameStats {
//    @Id
    private String id;
    private int points;
    private int yellowCards;
    private int redCards;
    private int successfulDribbles;
    private int duelsWon;
    private int foulsDrawn;
    private int foulsCommitted;
    private int minutes;
    private float rating;
    private int goalsScored;
    private int goalsConceded;
    private int assists;
    private int saves;
    private int passes;
    private int keyPasses;
    private String passAccuracy;
    private int penaltiesCommitted;
    private int penaltiesScored;
    private int penaltiesMissed;
    private int penaltiesSaved;
    private int shotsTaken;
    private int shotsOnTarget;
    private int tackles;
    private int shotBlocks;
    private int interceptions;
    private int result;
    private String week;
//    @ManyToOne
    private Player player;

    public PlayerGameStats noNulls () throws IllegalAccessException {
        for(Field f : PlayerGameStats.class.getFields()) {

            if (f.get(this) != null) continue;
            if (f.getType() == Integer.TYPE || f.getType() == Float.TYPE) f.set(this, 0);
            if (f.getType() == String.class) f.set(this, " ");

        }
        return this;
    }
}
package capstone.mfsl.model.statistics;


//import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
//@Table(name = "PlayerTable")
public class Player {
//    @Id
    private String id;
    private String name;
    private String position;
//    @ManyToOne
    private Team team;
//    @OneToMany
    private List<PlayerGameStats> playerGameStats;

    public void addMatchday(PlayerGameStats matchDay) {
        this.playerGameStats.add(matchDay);
    }
}
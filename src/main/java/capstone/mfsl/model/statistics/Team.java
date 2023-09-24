package capstone.mfsl.model.statistics;

//import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
//@Table(name = "TeamTable")
public class Team {
//    @Id
    private String id;
    private String name;
    private String url;
//    @OneToMany
    private List<Player> players;
}
package capstone.mfsl.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import java.io.Serializable;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class LeagueDTO implements Serializable {

    Integer id;
    String name;
    String country;
    String logo;
    String flag;
    Integer season;
    String round;
}
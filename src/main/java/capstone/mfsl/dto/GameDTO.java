package capstone.mfsl.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import java.io.Serializable;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class GameDTO implements Serializable {
    Integer minutes;
    Integer number;
    String position;
    Float rating;
    boolean captain;
    boolean substitute;
}
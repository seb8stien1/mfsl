package capstone.mfsl.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import java.io.Serializable;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class GoalDTO implements Serializable {
    Integer total;
    Integer conceded;
    Integer assists;
    Integer saves;
}
package capstone.mfsl.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import java.io.Serializable;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class PenaltyDTO implements Serializable {
    Integer won;
    Integer commited;
    Integer scored;
    Integer missed;
    Integer saved;
}
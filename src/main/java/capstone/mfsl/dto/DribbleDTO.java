package capstone.mfsl.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import java.io.Serializable;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class DribbleDTO implements Serializable {
    Integer attempts;
    Integer success;
    Integer past;
}
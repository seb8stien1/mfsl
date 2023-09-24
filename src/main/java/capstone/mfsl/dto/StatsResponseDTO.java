package capstone.mfsl.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import java.io.Serializable;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class StatsResponseDTO implements Serializable {
    String get;
    List<String> errors;
    List<ResponseDTO> response;
}
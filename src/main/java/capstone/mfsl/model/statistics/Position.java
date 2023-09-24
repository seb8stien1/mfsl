package capstone.mfsl.model.statistics;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@ToString
@AllArgsConstructor
@Getter
public enum Position {
    Goalkeeper,
    Defender,
    Midfielder,
    Attacker
}
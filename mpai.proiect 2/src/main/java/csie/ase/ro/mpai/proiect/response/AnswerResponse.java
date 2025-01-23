package csie.ase.ro.mpai.proiect.response;

import csie.ase.ro.mpai.proiect.model.Question;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AnswerResponse {
    private int id;
    private String text;
    private boolean isCorrect;
}

package csie.ase.ro.mpai.proiect.request;

import csie.ase.ro.mpai.proiect.model.Answer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class QuestionRequest {
    private String text;
    private String imageUrl;
    private String category;
    private List<Answer> answers;
}

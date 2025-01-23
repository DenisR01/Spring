package csie.ase.ro.mpai.proiect.response;

import csie.ase.ro.mpai.proiect.model.Answer;
import jakarta.persistence.CascadeType;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class QuestionResponse {
    private int id;
    private String text;
    private String imageUrl;
    private String category;
    private List<AnswerResponse> answers;
}

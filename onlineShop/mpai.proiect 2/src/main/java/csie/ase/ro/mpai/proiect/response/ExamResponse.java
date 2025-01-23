package csie.ase.ro.mpai.proiect.response;

import csie.ase.ro.mpai.proiect.model.Question;
import csie.ase.ro.mpai.proiect.model.User;
import csie.ase.ro.mpai.proiect.visitor.Visitor;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ExamResponse {
    private int id;
    private UserResponse user;
    private int score;
    private List<QuestionResponse> questions;
    private boolean passed;
    private LocalDateTime createdAt;
}

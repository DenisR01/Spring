package csie.ase.ro.mpai.proiect.request;

import csie.ase.ro.mpai.proiect.model.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ExamRequest {
    private User user;
    private int score;
    private List<QuestionRequest> questions;
    private boolean passed;
    private LocalDateTime createdAt;
}

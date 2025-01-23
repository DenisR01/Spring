package csie.ase.ro.mpai.proiect.model;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "exams")
public class Exam {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE,
            CascadeType.DETACH, CascadeType.REFRESH},fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;
    private int score;
    @ManyToMany(
            cascade = CascadeType.PERSIST,
            fetch = FetchType.LAZY
    )
    @JoinTable(
            name = "exam_questions",
            joinColumns = @JoinColumn(
                    name = "exam_id"),
            inverseJoinColumns = @JoinColumn(
                    name = "question_id"
            )
    )
    private List<Question> questions;
    private boolean passed=false;
    private LocalDateTime createdAt;
}


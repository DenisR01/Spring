package csie.ase.ro.mpai.proiect.model;
import csie.ase.ro.mpai.proiect.response.ExamResponse;
import csie.ase.ro.mpai.proiect.visitor.Visitor;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "users")
public class User{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String cnp;
    @OneToMany(mappedBy = "user",
            cascade = {CascadeType.PERSIST, CascadeType.MERGE,
                    CascadeType.DETACH, CascadeType.REFRESH})
    private List<Exam> exams;
    public User(String cnp) {
        this.cnp = cnp;
    }

}

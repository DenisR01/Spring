package csie.ase.ro.mpai.proiect.response;

import csie.ase.ro.mpai.proiect.visitor.Visitor;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserResponse implements Visitor {
    private int id;
    private String cnp;


    public String visitExam(ExamResponse exam) {

        if (exam.isPassed()){
            System.out.println("Examenul a fost deja finalizat cu success. Nu poti participa din nou.");
        }

        return "Imi pare rau! Nu mai poti intra.";
    }

}

package csie.ase.ro.mpai.proiect.visitor;

import csie.ase.ro.mpai.proiect.response.ExamResponse;

public interface Visitor {
    String visitExam(ExamResponse exam);
}

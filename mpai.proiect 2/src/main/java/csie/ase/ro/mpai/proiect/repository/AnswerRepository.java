package csie.ase.ro.mpai.proiect.repository;

import csie.ase.ro.mpai.proiect.model.Answer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnswerRepository
extends JpaRepository<Answer, Integer> {

}

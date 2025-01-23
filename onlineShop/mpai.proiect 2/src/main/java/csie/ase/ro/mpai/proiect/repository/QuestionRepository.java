package csie.ase.ro.mpai.proiect.repository;

import csie.ase.ro.mpai.proiect.model.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuestionRepository extends JpaRepository<Question, Integer> {

}
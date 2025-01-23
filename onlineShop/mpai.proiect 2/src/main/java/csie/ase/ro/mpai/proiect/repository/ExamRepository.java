package csie.ase.ro.mpai.proiect.repository;

import csie.ase.ro.mpai.proiect.model.Exam;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ExamRepository extends JpaRepository<Exam, Integer> {
    List<Exam> findByUserId(int userId);
}

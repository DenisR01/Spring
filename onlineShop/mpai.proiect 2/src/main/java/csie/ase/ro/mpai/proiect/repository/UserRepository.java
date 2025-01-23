package csie.ase.ro.mpai.proiect.repository;

import csie.ase.ro.mpai.proiect.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    User findByCnp(String cnp);
}

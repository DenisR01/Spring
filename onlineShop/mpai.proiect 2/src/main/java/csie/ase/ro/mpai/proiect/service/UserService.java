package csie.ase.ro.mpai.proiect.service;

import csie.ase.ro.mpai.proiect.model.User;
import csie.ase.ro.mpai.proiect.repository.UserRepository;
import csie.ase.ro.mpai.proiect.response.ExamResponse;
import csie.ase.ro.mpai.proiect.response.UserResponse;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserService {
    private final UserRepository userRepository;
    private final ExamService examService;

    public UserService(UserRepository userRepository, ExamService examService) {
        this.userRepository = userRepository;
        this.examService = examService;
    }

    @PostConstruct
    private void init() {
        List<User> users = List.of(
                new User("5011122461243"),
                new User("5011122461245")
        );
        userRepository.saveAll(users);
    }

    public UserResponse findByCnp(String cnp) {
        return this.toUserResponse(userRepository.findByCnp(cnp));
    }

    private UserResponse toUserResponse(User user) {
        int id = user.getId();
        String cnp = user.getCnp();
        return new UserResponse(id, cnp);
    }

    public ExamResponse getExamForUser(int userId) {

        return examService.getExamByUserId(userId);
    }

    public String validateParticipation(UserResponse user, ExamResponse exam) {
        return user.visitExam(exam);
    }
}
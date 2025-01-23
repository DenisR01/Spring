package csie.ase.ro.mpai.proiect.service;

import csie.ase.ro.mpai.proiect.model.Exam;
import csie.ase.ro.mpai.proiect.model.Question;
import csie.ase.ro.mpai.proiect.model.User;
import csie.ase.ro.mpai.proiect.repository.ExamRepository;
import csie.ase.ro.mpai.proiect.repository.QuestionRepository;
import csie.ase.ro.mpai.proiect.repository.UserRepository;
import csie.ase.ro.mpai.proiect.response.ExamResponse;
import csie.ase.ro.mpai.proiect.response.QuestionResponse;
import csie.ase.ro.mpai.proiect.response.UserResponse;
import csie.ase.ro.mpai.proiect.specification.CorrectAnswerSpecification;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class ExamService {

    private final ExamRepository examRepository;
    private final QuestionService questionService;
    private final UserRepository userRepository;

    public ExamService(ExamRepository examRepository, QuestionService questionService, UserRepository userRepository) {
        this.examRepository = examRepository;
        this.questionService = questionService;
        this.userRepository = userRepository;
    }

    public ExamResponse generateExam(UserResponse userResponse) {
        List<Question> allQuestions = questionService.getAllQuestions();

        Collections.shuffle(allQuestions);

        List<Question> selectedQuestions = allQuestions.subList(0, Math.min(26, allQuestions.size()));

        Exam exam = new Exam();
        exam.setQuestions(selectedQuestions);
        exam.setCreatedAt(LocalDateTime.now());
        exam.setPassed(false);
        exam.setScore(-1);
        User user = userRepository.findByCnp(userResponse.getCnp());
        exam.setUser(user);

        return this.toExamResponse(examRepository.save(exam));
    }

    private ExamResponse toExamResponse(Exam exam) {
        int id = exam.getId();
        var user = mapToUserResponse(exam.getUser());
        int score = exam.getScore();
        boolean passed = exam.isPassed();
        LocalDateTime createdAt = exam.getCreatedAt();
        List<QuestionResponse> questions = exam.getQuestions()
                .stream()
                .map(questionService::toQuestionResponse)
                .collect(Collectors.toList());
        return new ExamResponse(id, user, score, questions, passed, createdAt);
    }

    public static UserResponse mapToUserResponse(User user) {
        return new UserResponse(user.getId(), user.getCnp());
    }

    public ExamResponse getExamById(int examId) {
        Exam exam = examRepository.findById(examId)
                .orElseThrow(() -> new RuntimeException("Exam not found"));
        return this.toExamResponse(exam);
    }

    public ExamResponse getExamByUserId(int userId) {
        List<Exam> exams = examRepository.findByUserId(userId)
                .stream()
                .sorted((e1, e2) -> e2.getCreatedAt().compareTo(e1.getCreatedAt()))
                .toList();

        if (!exams.isEmpty()) {
            return this.toExamResponse(exams.get(0));
        } else {
            return null;
        }
    }

    public void submitAnswers(int examId, Map<Integer, String> answersMap) {
        Exam exam = examRepository.findById(examId)
                .orElseThrow(() -> new RuntimeException("Exam not found"));

        int correctCount = 0;

        for (Map.Entry<Integer, String> entry : answersMap.entrySet()) {
            int questionIndex = entry.getKey();
            String selectedAnswerIdsString = entry.getValue();

            Set<Integer> selectedAnswerIds = Set.of(selectedAnswerIdsString.split(","))
                    .stream()
                    .map(Integer::parseInt)
                    .collect(Collectors.toSet());

            Question question = exam.getQuestions().get(questionIndex);

            CorrectAnswerSpecification answerSpec = new CorrectAnswerSpecification(selectedAnswerIds);
            if (answerSpec.isSatisfiedBy(question)) {
                correctCount++;
            }
        }

        exam.setScore(correctCount);
        exam.setPassed(correctCount >= 22);
        examRepository.save(exam);
    }
}

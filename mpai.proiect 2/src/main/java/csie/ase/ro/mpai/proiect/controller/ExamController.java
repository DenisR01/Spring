package csie.ase.ro.mpai.proiect.controller;

import csie.ase.ro.mpai.proiect.model.Exam;
import csie.ase.ro.mpai.proiect.model.User;
import csie.ase.ro.mpai.proiect.repository.ExamRepository;
import csie.ase.ro.mpai.proiect.request.ExamRequest;
import csie.ase.ro.mpai.proiect.response.ExamResponse;
import csie.ase.ro.mpai.proiect.response.UserResponse;
import csie.ase.ro.mpai.proiect.service.ExamService;
import jakarta.servlet.http.HttpSession;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/exams")
public class ExamController {
    private final ExamService examService;

    public ExamController(ExamService examService) {
        this.examService = examService;
    }

    @PostMapping("/generate")
    public ResponseEntity<ExamResponse> generateExam(@RequestBody UserResponse user) {
        if (user == null) {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
        ExamResponse newExam = examService.generateExam(user);

        return new ResponseEntity<>(newExam, HttpStatus.CREATED);
    }

    @GetMapping("/view/{examId}")
    public String viewExam(@PathVariable int examId,
                           @RequestParam(value = "questionIndex", defaultValue = "0") int questionIndex,
                           Model model,
                           HttpSession session) {

        ExamResponse examResponse = examService.getExamById(examId);
        if (examResponse == null) {
            model.addAttribute("error", "Exam not found.");
            return "error";
        }

        model.addAttribute("exam", examResponse);
        model.addAttribute("currentQuestion", examResponse.getQuestions().get(questionIndex));
        model.addAttribute("currentQuestionIndex", questionIndex);

        return "exam";
    }

    @PostMapping("/next")
    public String nextQuestion(@RequestParam int currentQuestionIndex,
                               @RequestParam int examId,
                               @RequestParam String selectedAnswers,
                               HttpSession session) {

        Map<Integer, String> answersMap = (Map<Integer, String>) session.getAttribute("answersMap");
        if (answersMap == null) {
            answersMap = new HashMap<>();
        }

        answersMap.put(currentQuestionIndex, selectedAnswers);
        session.setAttribute("answersMap", answersMap);

        int nextIndex = currentQuestionIndex + 1;
        return "redirect:/exams/view/" + examId + "?questionIndex=" + nextIndex;
    }

    @PostMapping("/submit")
    public String submitExam(@RequestParam int examId, HttpSession session) {
        Map<Integer, String> answersMap = (Map<Integer, String>) session.getAttribute("answersMap");

        if (answersMap != null) {
            examService.submitAnswers(examId, answersMap);
            session.removeAttribute("answersMap");
        }

        ExamResponse completedExam = examService.getExamById(examId);
        session.setAttribute("completedExam", completedExam);

        return "redirect:/exams/complete";
    }

    @GetMapping("/complete")
    public String examCompletePage(Model model, HttpSession session) {
        ExamResponse exam = (ExamResponse) session.getAttribute("completedExam");

        if (exam == null) {
            model.addAttribute("error", "Nu există un examen completat.");
            return "error";
        }

        model.addAttribute("score", exam.getScore());
        model.addAttribute("totalQuestions", 26);
        model.addAttribute("passed", exam.isPassed());

        return "examComplete";
    }
}

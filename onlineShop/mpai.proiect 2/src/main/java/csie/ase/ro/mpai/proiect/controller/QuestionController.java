package csie.ase.ro.mpai.proiect.controller;

import csie.ase.ro.mpai.proiect.builder.QuestionDirector;
import csie.ase.ro.mpai.proiect.response.QuestionResponse;
import csie.ase.ro.mpai.proiect.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/questions")
public class QuestionController {

    private final QuestionService questionService;

    public QuestionController(QuestionService questionService) {
        this.questionService = questionService;
    }

    @GetMapping
    public List<QuestionResponse> getAll(){
        return questionService.getAll();
    }


}

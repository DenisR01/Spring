package csie.ase.ro.mpai.proiect.service;

import csie.ase.ro.mpai.proiect.builder.QuestionDirector;
import csie.ase.ro.mpai.proiect.model.Answer;
import csie.ase.ro.mpai.proiect.model.Question;
import csie.ase.ro.mpai.proiect.repository.QuestionRepository;
import csie.ase.ro.mpai.proiect.response.QuestionResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionService {
    private final QuestionRepository questionRepository;
    private final QuestionDirector questionDirector;

    public QuestionService(QuestionRepository questionRepository, QuestionDirector questionDirector) {
        this.questionRepository = questionRepository;
        this.questionDirector = questionDirector;
    }

    public List<QuestionResponse> getAll(){
        return questionRepository.findAll()
                .stream()
                .map(this::toQuestionResponse)
                .toList();
    }

    public List<Question> getAllQuestions(){
        return questionRepository.findAll();
    }

    public QuestionResponse toQuestionResponse(Question question) {
        int id = question.getId();
        String text = question.getText();
        String imageUrl = question.getImageUrl();
        String category = question.getCategory();
        List<Answer> answers = question.getAnswers();
        QuestionResponse questionResponse;
        if(imageUrl != null){
            questionResponse = questionDirector.createImageQuestion(id, text, imageUrl, category,  answers);
        }
        else{
            questionResponse = questionDirector.createTextQuestion(id, text, category, answers);;
        }

        return questionResponse;
    }


}

package csie.ase.ro.mpai.proiect.builder;

import csie.ase.ro.mpai.proiect.model.Answer;
import csie.ase.ro.mpai.proiect.model.Question;
import csie.ase.ro.mpai.proiect.response.QuestionResponse;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class QuestionDirector {
    private final QuestionBuilder builder ;

    public QuestionDirector(QuestionBuilder builder) {
        this.builder = builder;
    }

    public QuestionResponse createImageQuestion(int id, String text, String imageUrl, String category, List<Answer> answers){
        builder.addId(id);
        builder.addText(text);
        builder.addImageUrl(imageUrl);
        builder.addCategory(category);
        builder.addAnswers(answers);
        return builder.build();
    }

    public QuestionResponse createTextQuestion(int id, String text, String category, List<Answer> answers){
        builder.addId(id);
        builder.addText(text);
        builder.addCategory(category);
        builder.addAnswers(answers);
        return builder.build();
    }
}

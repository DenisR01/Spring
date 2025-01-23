package csie.ase.ro.mpai.proiect.builder;

import csie.ase.ro.mpai.proiect.model.Answer;
import csie.ase.ro.mpai.proiect.model.Question;
import csie.ase.ro.mpai.proiect.response.AnswerResponse;
import csie.ase.ro.mpai.proiect.response.QuestionResponse;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class QuestionBuilder{

    private int id;
    private String text;
    private String imageUrl;
    private String category;
    private List<Answer> answers;

    public QuestionBuilder addId(int id) {
        this.id = id;
        return this;
    }

    public QuestionBuilder addText(String text) {
        this.text = text;
        return this;
    }

    public QuestionBuilder addImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
        return this;
    }

    public QuestionBuilder addCategory(String category) {
        this.category = category;
        return this;
    }

    public QuestionBuilder addAnswers(List<Answer> answers) {
        this.answers = answers;
        return this;
    }

    public QuestionResponse build(){
        QuestionResponse response = new QuestionResponse();
        response.setId(this.id);
        response.setText(this.text);
        response.setImageUrl(this.imageUrl);
        response.setCategory(this.category);
        response.setAnswers(this.answers.stream()
                .map(answer -> new AnswerResponse(answer.getId(), answer.getText(), answer.isCorrect()))
                .collect(Collectors.toList()));

        reset();
        return response;
    }

    private void reset() {
        this.id = 0;
        this.text = null;
        this.imageUrl = null;
        this.category = null;
        this.answers = null;
    }
}

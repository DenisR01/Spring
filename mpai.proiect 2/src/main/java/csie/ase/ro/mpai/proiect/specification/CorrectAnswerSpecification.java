package csie.ase.ro.mpai.proiect.specification;

import csie.ase.ro.mpai.proiect.model.Answer;
import csie.ase.ro.mpai.proiect.model.Question;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CorrectAnswerSpecification implements Specification<Question> {
    private final Set<Integer> selectedAnswerIds;

    public CorrectAnswerSpecification(Set<Integer> selectedAnswerIds) {
        this.selectedAnswerIds = selectedAnswerIds;
    }

    @Override
    public boolean isSatisfiedBy(Question question) {
        List<Integer> correctAnswerIds = question.getAnswers().stream()
                .filter(Answer::isCorrect)
                .map(Answer::getId)
                .toList();

        return new HashSet<>(correctAnswerIds).containsAll(selectedAnswerIds) && selectedAnswerIds.containsAll(correctAnswerIds);
    }
}
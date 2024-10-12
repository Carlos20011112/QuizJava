package mx.com.gm.quizjava;

public class MultipleChoiceQuestion implements Question{
    private final String questionText;
    private final String[] options;
    private final int correctAnswerIndex;

    public MultipleChoiceQuestion(String questionText, String[] options, int correctAnswerIndex) {
        this.questionText = questionText;
        this.options = options;
        this.correctAnswerIndex = correctAnswerIndex;
    }

    public String[] getOptions() {
        return options;
    }

    @Override
    public String getQuestion() {
        return questionText;
    }

    @Override
    public boolean isCorrect(int userAnswer) {
        return userAnswer == correctAnswerIndex;
    }
}


package mx.com.gm.quizjava;

// Ayudará a implementar otros tipos de preguntas (verdadero y falso, rellenar, etc.)
public interface Question {

    String getQuestion();
    boolean isCorrect(int userAnswer);

}

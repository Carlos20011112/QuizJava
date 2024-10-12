package mx.com.gm.quizjava;

import java.util.ArrayList;
import java.util.List;

public class QuestionBank {

    private final List<Question> questions;

    public QuestionBank() {
        this.questions = new ArrayList<>();
        loadQuestions();
    }

    private void loadQuestions() {
        questions.add(new MultipleChoiceQuestion("What is the difference between `==` and `equals()` in Java?",
                new String[]{"`==` compares reference equality, `equals()` compares content equality", "`==` compares content equality, `equals()` compares reference equality", "Both compare content equality"}, 0));

        questions.add(new MultipleChoiceQuestion("What is the purpose of the `volatile` keyword in Java?",
                new String[]{"To ensure visibility of changes to variables across threads", "To make variables immutable", "To prevent a variable from being garbage collected"}, 0));

        questions.add(new MultipleChoiceQuestion("How does the Java Memory Model handle synchronization with the `synchronized` keyword?",
                new String[]{"It uses object-level locks to prevent concurrent access", "It blocks all threads except the current thread", "It uses method-level locks to ensure thread safety"}, 0));

        questions.add(new MultipleChoiceQuestion("Explain the difference between Checked and Unchecked exceptions in Java.",
                new String[]{"Checked exceptions are checked at runtime, Unchecked exceptions are checked at compile-time", "Checked exceptions are checked at compile-time, Unchecked exceptions at runtime", "Both are checked at compile-time"}, 1));

        questions.add(new MultipleChoiceQuestion("What is the significance of the `final` keyword when applied to a class?",
                new String[]{"The class cannot be subclassed", "The class can only be instantiated once", "All methods of the class are immutable"}, 0));

        questions.add(new MultipleChoiceQuestion("In Java, what is the difference between `StringBuilder` and `StringBuffer`?",
                new String[]{"`StringBuilder` is thread-safe, `StringBuffer` is not", "`StringBuffer` is thread-safe, `StringBuilder` is not", "Both are thread-safe"}, 1));

        questions.add(new MultipleChoiceQuestion("What happens if you start a thread twice in Java?",
                new String[]{"The thread will run twice", "An `IllegalThreadStateException` will be thrown", "The second start call will be ignored"}, 1));

        questions.add(new MultipleChoiceQuestion("What is a memory leak in Java, and how can it occur?",
                new String[]{"It happens when unused objects are not garbage collected", "It happens when memory is allocated faster than it is deallocated", "It happens when variables are not initialized"}, 0));

        questions.add(new MultipleChoiceQuestion("What is the purpose of the `transient` keyword in Java?",
                new String[]{"To prevent fields from being serialized", "To prevent fields from being initialized", "To mark fields as immutable"}, 0));

        questions.add(new MultipleChoiceQuestion("What is a deadlock in Java and how can you avoid it?",
                new String[]{"When two threads are waiting for each other to release locks, avoid by ordering lock acquisition", "When a thread waits indefinitely for a resource, avoid by using `volatile`", "When memory is exhausted, avoid by freeing memory manually"}, 0));
        }

    public Question getQuestions(int index) {
        if(index >= 0 && index < questions.size()) {
            return questions.get(index);
        } else {
            return null;
        }
    }
    public int getListSize() {
        return questions.size();
    }
}
package mx.com.gm.quizjava;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/quiz")
public class QuizServlet extends HttpServlet {

    private QuestionBank questionBank;

/*Ayudará cuando las preguntas estén en bases de datos*/
    @Override
    public void init() {
        questionBank = new QuestionBank();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();

        Integer currentQuestion = (Integer) session.getAttribute("currentQuestion");


        if (currentQuestion == null) {
            currentQuestion = 0;
            session.setAttribute("currentQuestion", currentQuestion);
        }

        Question question = questionBank.getQuestions(currentQuestion);

        if (question == null || currentQuestion >= questionBank.getListSize()) {
            response.sendRedirect("result.jsp");
        } else {
            request.setAttribute("question", question);
            request.getRequestDispatcher("quiz.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession();
        Integer currentQuestion = (Integer) session.getAttribute("currentQuestion");

        //Verifica si hay alguna opción seleccionada
        int selectedOption = Integer.parseInt(request.getParameter("answer"));

        Question question = questionBank.getQuestions(currentQuestion);
        if (question != null && question.isCorrect(selectedOption)) {
            currentQuestion++;
            session.setAttribute("currentQuestion", currentQuestion);
            if (currentQuestion >= questionBank.getListSize()) {
                response.sendRedirect("result.jsp");
            } else {
                response.sendRedirect("quiz");
            }
        } else {
            session.invalidate();
            response.sendRedirect("result.jsp?status=fail");
        }
    }
}



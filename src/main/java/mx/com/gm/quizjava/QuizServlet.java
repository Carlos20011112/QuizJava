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
    private static final Question[] questions = {
        new Question("What is the size of int in Java?", new String[]{"4 bytes", "8 bytes", "16 bytes"}, 0),
        new Question("Which company developed Java?", new String[]{"Apple", "Sun Microsystems", "Microsoft"}, 1),
        new Question("What is the default value of a boolean in Java?", new String[]{"true", "false", "null"}, 1)
};

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        Integer currentQuestion = (Integer) session.getAttribute("currentQuestion");
        if (currentQuestion == null) {
            currentQuestion = 0;
            session.setAttribute("currentQuestion", currentQuestion);
        }

        if (currentQuestion >= questions.length) {
            response.sendRedirect("result.jsp");
        } else {
            request.setAttribute("question", questions[currentQuestion]);
            request.getRequestDispatcher("quiz.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        HttpSession session = req.getSession();
        Integer currentQuestion = (Integer) session.getAttribute("currentQuestion");

        int selectedOption = Integer.parseInt(req.getParameter("answer"));
        if (questions[currentQuestion].isCorrect(selectedOption)) {
            currentQuestion++;
            session.setAttribute("currentQuestion", currentQuestion);
            if (currentQuestion >= questions.length) {
                resp.sendRedirect("result.jsp");
            } else {
                resp.sendRedirect("quiz");
            }
        } else {
            session.invalidate();
            resp.sendRedirect("result.jsp?status=fail");
        }
    }
}



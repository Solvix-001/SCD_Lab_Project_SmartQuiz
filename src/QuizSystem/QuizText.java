package QuizSystem;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class QuizTest {

    @Test
    void testCorrectAnswer() {

        Quiz quiz = new Quiz();

        Question question = quiz.getQuestions().get(0);

        boolean result = quiz.checkAnswer(question, 'A');

        assertTrue(result);
    }

    @Test
    void testWrongAnswer() {

        Quiz quiz = new Quiz();

        Question question = quiz.getQuestions().get(0);

        boolean result = quiz.checkAnswer(question, 'B');

        assertFalse(result);
    }
}
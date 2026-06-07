package QuizSystem;

import java.util.ArrayList;

public class Quiz {

    private ArrayList<Question> questions;
    private int score;

    public Quiz() {
        questions = new ArrayList<Question>();
        score = 0;
        loadQuestions();
    }

    private void loadQuestions() {
        questions.add(new Question("What is Java?", "Programming Language", "Game", "Browser", "OS", 'A'));
        questions.add(new Question("Which keyword is used to create a class in Java?", "object", "class", "new", "main", 'B'));
        questions.add(new Question("Which method starts a Java program?", "start()", "run()", "main()", "execute()", 'C'));
    }

    public ArrayList<Question> getQuestions() {
        return questions;
    }

    public int getScore() {
        return score;
    }

    public boolean checkAnswer(Question question, char selectedAnswer) {

        try {
            if (question == null) {
                throw new Exception("Question not found");
            }

            if (question.getCorrectAnswer() == selectedAnswer) {
                score++;
                return true;
            }

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

        return false;
    }
}
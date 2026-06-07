package QuizSystem;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class QuizFrame extends JFrame {

    private Quiz quiz;
    private int currentQuestionIndex;

    private JLabel questionLabel;
    private JRadioButton optionA;
    private JRadioButton optionB;
    private JRadioButton optionC;
    private JRadioButton optionD;
    private ButtonGroup optionsGroup;
    private JButton nextButton;

    public QuizFrame() {
        quiz = new Quiz();
        currentQuestionIndex = 0;

        setTitle("Smart Quiz Platform");
        setSize(600, 350);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        questionLabel = new JLabel();
        questionLabel.setBounds(40, 30, 500, 30);
        add(questionLabel);

        optionA = new JRadioButton();
        optionA.setBounds(40, 80, 400, 30);
        add(optionA);

        optionB = new JRadioButton();
        optionB.setBounds(40, 120, 400, 30);
        add(optionB);

        optionC = new JRadioButton();
        optionC.setBounds(40, 160, 400, 30);
        add(optionC);

        optionD = new JRadioButton();
        optionD.setBounds(40, 200, 400, 30);
        add(optionD);

        optionsGroup = new ButtonGroup();
        optionsGroup.add(optionA);
        optionsGroup.add(optionB);
        optionsGroup.add(optionC);
        optionsGroup.add(optionD);

        nextButton = new JButton("Next");
        nextButton.setBounds(230, 250, 120, 35);
        add(nextButton);

        loadQuestion();

        nextButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                checkAndNext();
            }
        });

        setVisible(true);
    }

    private void loadQuestion() {
        Question question = quiz.getQuestions().get(currentQuestionIndex);

        questionLabel.setText((currentQuestionIndex + 1) + ". " + question.getQuestionText());
        optionA.setText("A. " + question.getOptionA());
        optionB.setText("B. " + question.getOptionB());
        optionC.setText("C. " + question.getOptionC());
        optionD.setText("D. " + question.getOptionD());

        optionsGroup.clearSelection();
    }

    private void checkAndNext() {
        char selectedAnswer = ' ';

        if (optionA.isSelected()) {
            selectedAnswer = 'A';
        } else if (optionB.isSelected()) {
            selectedAnswer = 'B';
        } else if (optionC.isSelected()) {
            selectedAnswer = 'C';
        } else if (optionD.isSelected()) {
            selectedAnswer = 'D';
        } else {
            JOptionPane.showMessageDialog(this, "Please select an answer.");
            return;
        }

        Question currentQuestion = quiz.getQuestions().get(currentQuestionIndex);
        quiz.checkAnswer(currentQuestion, selectedAnswer);

        currentQuestionIndex++;

        if (currentQuestionIndex < quiz.getQuestions().size()) {
            loadQuestion();
        } else {
        	String studentName = JOptionPane.showInputDialog(this, "Enter your name:");

        	FileManager fileManager = new FileManager();
        	fileManager.saveResult(studentName, quiz.getScore(), quiz.getQuestions().size());

        	JOptionPane.showMessageDialog(this, "Quiz Finished! Your Score: " + quiz.getScore() + "\nResult saved successfully.");
        	
            nextButton.setEnabled(false);
        }
    }
}
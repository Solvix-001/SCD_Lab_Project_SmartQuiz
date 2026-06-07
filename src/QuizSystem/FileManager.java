package QuizSystem;

import java.io.FileWriter;
import java.io.IOException;

public class FileManager {

    public void saveResult(String studentName, int score, int totalQuestions) {

        try {
            FileWriter writer = new FileWriter("quiz_results.txt", true);

            writer.write("Student Name: " + studentName + "\n");
            writer.write("Score: " + score + " out of " + totalQuestions + "\n");
            writer.write("-------------------------\n");

            writer.close();

        } catch (IOException e) {
            System.out.println("File Error: " + e.getMessage());
        }
    }
}
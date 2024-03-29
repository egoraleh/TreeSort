import java.io.FileWriter;
import java.io.IOException;

public class TestCreator {
    public static void main(String[] args) throws IOException {
        int razm = 100;
        for (int k = 0; k < 10; k++) {
            for (int j = 0; j < 10; j++) {
                String num = k + "" + j;
                FileWriter writer = new FileWriter("src/Tests/Created/test3/test_" + num + ".txt");
                writer.write(razm + "\n");
                for (int i = 0; i < razm; i++) {
                    int deg = (int) (Math.pow(-1, (int) (Math.random() * 100)));
                    int n = (int) (Math.random() * 10000) * deg;
                    writer.write(n + "\n");
                }
                writer.close();
                razm += 100;
            }
        }
    }
}
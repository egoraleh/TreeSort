import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Main {
    public static void main(String[] args) throws IOException {
        OutputStream results = Files.newOutputStream(Paths.get("src/results3.txt"));
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                String num = i + "" + j;
                FileReader file = new FileReader("src/Tests/Created/test3/test_" + num + ".txt");
                BufferedReader reader = new BufferedReader(file);
                int size = Integer.parseInt(reader.readLine());
                int[] arr = new int[size];
                for (int k = 0; k < size; k++) {
                    arr[k] = Integer.parseInt(reader.readLine());
                }
                Tree tree = new Tree(arr[0]);
                long start = System.nanoTime();
                for (int z : arr) {
                    tree.insert(tree.getNode(), z);
                }
                long finish = System.nanoTime();
                double time = (double) (finish - start) / 1000000;
                results.write((size + "    " + time + "    " + tree.getIter() + "\n").getBytes());
                OutputStream fwasc = Files.newOutputStream(Paths.get("src/Tests/ascending order/test3/test_" + num + ".txt"));
                OutputStream fwdesc = Files.newOutputStream(Paths.get("src/Tests/descending order/test3/test_" + num + ".txt"));
                tree.inOrderAsc(tree.getNode(), fwasc);
                tree.inOrderDesc(tree.getNode(), fwdesc);
            }
        }
    }
}

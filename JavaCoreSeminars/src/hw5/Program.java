package hw5;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Objects;
import java.util.Random;

import static java.nio.file.StandardCopyOption.REPLACE_EXISTING;

public class Program {
    public static void main(String[] args) throws IOException {
        taskOne(".\\backup");
        taskTwo();
        taskThree(".\\taskTwo.txt .\\taskThree.txt");
    }

    static void taskOne(String backupDir) throws IOException {
        if (Files.notExists(Path.of(backupDir)))
            Files.createDirectory(Paths.get(backupDir));

        File file = new File(".");
        for (File f : Objects.requireNonNull(file.listFiles())) {
            if (f.isFile())
                Files.copy(f.toPath(), Paths.get(backupDir,f.getName()), REPLACE_EXISTING);
        }
    }

    static void taskTwo(){
        int[][] matrix = createMatrix(3,3);
        showMatrix(matrix);
        String fileName = "taskTwo.txt";

        try (DataOutputStream outputStream = new DataOutputStream(new FileOutputStream(fileName))) {
            int value = 0;
            int bitPosition = 0;

            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[i].length; j++) {
                    int fieldValue = matrix[i][j] & 0b11;
                    value |= fieldValue << bitPosition;
                    bitPosition += 2;
                    if (bitPosition >= 8) {
                        outputStream.write(value);
                        value = 0;
                        bitPosition = 0;
                    }
                }
            }

            if (bitPosition > 0) {
                outputStream.write(value);
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static int[][] createMatrix(int m, int n){
        int[][] matrix = new int[m][n];
        Random random = new Random();
        for(int i = 0; i < m; i++){
            for (int j = 0; j < n; j++) {
                matrix[i][j] = random.nextInt(0,4);
            }
        }
        return matrix;
    }

    private static void showMatrix(int[][] matrix){
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + "\t");
            }
            System.out.println();
        }
    }

    final static String PREFIX = "prefix_";
    static void taskThree(String files){
        String[] namesOfFiles = files.split(" ");
        for (String name: namesOfFiles){
            Path path = Path.of(name);
            if (Files.exists(path) && Files.isRegularFile(path)){
                path.toFile().renameTo(new File(PREFIX + path.getFileName()));
            }
        }

    }
}

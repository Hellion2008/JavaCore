package hw5;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Objects;

import static java.nio.file.StandardCopyOption.REPLACE_EXISTING;

public class Program {
    public static void main(String[] args) throws IOException {
        taskOne(".\\backup");
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

    }
}

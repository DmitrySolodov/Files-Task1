import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Main {
    public static void addDirectory (File file, StringBuilder log) {
        if (file.mkdir()) {
            log.append("Каталог " + file.getAbsolutePath() + " успешно создан\n");
        } else {
            log.append("Ошибка создания директории " + file.getAbsolutePath() + "\n");
        }
    }

    public static void addFile (File file, StringBuilder log) throws IOException {
        if (file.createNewFile()) {
            log.append("Файл в каталоге " + file.getAbsolutePath() + " успешно создан\n");
        } else {
            log.append("Ошибка создания файла " + file.getAbsolutePath() + "\n");
        }
    }
    public static void main(String[] args) {
        StringBuilder log = new StringBuilder();
        //Первый этап
        File srsDirectory = new File("E://Games/src");
        addDirectory(srsDirectory, log);

        File resDirectory = new File("E://Games/res");
        addDirectory(resDirectory, log);

        File savegamesDirectory = new File("E://Games/savegames");
        addDirectory(savegamesDirectory, log);

        File tempDirectory = new File("E://Games/temp");
        addDirectory(tempDirectory, log);

        //Второй этап
        File mainDirectory = new File(srsDirectory, "main");
        addDirectory(mainDirectory, log);

        File testDirectory = new File(srsDirectory, "test");
        addDirectory(testDirectory, log);

        //Третий этап
        File mainJava = new File(mainDirectory, "Main.java");
        try {
            addFile(mainJava, log);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }

        File utilsJava = new File(mainDirectory, "Utils.java");
        try {
            addFile(utilsJava, log);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }

        //Четвертый этап
        File drawablesDirectory = new File(resDirectory, "drawables");
        addDirectory(drawablesDirectory, log);

        File vectorsDirectory = new File(resDirectory, "vectors");
        addDirectory(vectorsDirectory, log);

        File iconsDirectory = new File(resDirectory, "icons");
        addDirectory(iconsDirectory, log);

        //Пятый этап
        File tempTxt = new File(tempDirectory, "temp.txt");
        try {
            addFile(tempTxt, log);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }

        try (FileWriter writer = new FileWriter(tempTxt, true)) {
            writer.write(String.valueOf(log));
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        } ;
    }
}

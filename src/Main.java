import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void addDirectory (List<File> folderList, StringBuilder log) {
        for (File catalog : folderList) {
            if (catalog.mkdirs()) {
                log.append("Каталог " + catalog.getAbsolutePath() + " успешно создан\n");
            } else {
                log.append("Ошибка создания директории " + catalog.getAbsolutePath() + "\n");
            }
        }
    }

    public static void addFile (List<File> fileslist, StringBuilder log) {
        for (File files : fileslist) {
            try {
                if (files.createNewFile()) {
                    log.append("Файл в каталоге " + files.getAbsolutePath() + " успешно создан\n");
                } else {
                    log.append("Ошибка создания файла " + files.getAbsolutePath() + "\n");
                }
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }
    public static void printLogsToFile (String directory, StringBuilder log) {
        try (FileWriter writer = new FileWriter(directory, true)) {
            writer.write(String.valueOf(log));
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static void main(String[] args) {
        StringBuilder log = new StringBuilder();
        List<File> folderList = new ArrayList<>();
        folderList.add(new File("E://Games/savegames"));
        folderList.add(new File("E://Games/src/main"));
        folderList.add(new File("E://Games/src/test"));
        folderList.add(new File("E://Games/res/drawables"));
        folderList.add(new File("E://Games/res/vectors"));
        folderList.add(new File("E://Games/res/icons"));
        folderList.add(new File("E://Games/temp/"));

        List<File> filesList = new ArrayList<>();
        filesList.add(new File("E://Games/src/main/Main.java"));
        filesList.add(new File("E://Games/src/main/Utils.java"));
        filesList.add(new File("E://Games/temp/temp.txt"));

        addDirectory(folderList, log);
        addFile(filesList, log);
        printLogsToFile("E://Games/temp/temp.txt", log);

    }
}

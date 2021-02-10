package ru.job4j.io.search;

import ru.job4j.io.SearchFiles;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class SearchFile {

    private SearchFiles setPredicate(String findType, String s) {
        SearchFiles searchFiles = null;
        switch (findType) {
            case("name"):
                searchFiles = new SearchFiles(p -> p.toFile().getName().equals(s));
                break;
            case("mask"):
                String maskName = s.substring(0, s.indexOf(".")).replaceAll("\\*", "");
                String maskExt = s.substring(s.indexOf(".") + 1).replaceAll("\\*", "");
                searchFiles = new SearchFiles(p -> p.toFile().getName().contains(maskName)
                        && p.toFile().getName().contains(maskExt));
                break;
            case("regex"):
                Pattern pattern = Pattern.compile(s);
                searchFiles = new SearchFiles(p -> pattern.matcher(p.toFile().getName()).matches());
                break;
            default:
                break;
        }
        return searchFiles;
    }

    private List<File> getFileList(ArgCheck argCheck) throws IOException {
        Path root = Paths.get(argCheck.getDirectory());
        SearchFiles searchFiles = setPredicate(argCheck.getFindType(), argCheck.getFileName());
        Files.walkFileTree(root, searchFiles);
        List<Path> pathList = searchFiles.getPaths();
        List<File> fileList = new ArrayList<>();
        for (Path path: pathList) {
            fileList.add(path.toFile());
        }
        return fileList;
    }

    private void writeOutput(List<File> fileList, File file) {
        try (PrintWriter printWriter = new PrintWriter(
                new BufferedWriter(
                        new FileWriter(file)))) {
            for (File fileFrom: fileList) {
                printWriter.println(fileFrom);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {
        if (args.length != 4) {
            throw new IllegalArgumentException("Incorrect parameters. "
                    + "Set parameter -d to define directory to search in,"
                    + "-n to define file name, mask or regular expression,"
                    + "-t to choose name, mask or regex,"
                    + "-o to define file to save search.");
        }
        ArgCheck argCheck = new ArgCheck(args);
        if (argCheck.valid()) {
            SearchFile searchFile = new SearchFile();
            List<File> fileList = searchFile.getFileList(argCheck);
            searchFile.writeOutput(fileList, new File(argCheck.getOutput()));
        }
    }
}
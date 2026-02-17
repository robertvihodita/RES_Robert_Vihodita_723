package repository;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.regex.*;

public abstract class InFileRepository<T>
        implements IRepository<T> {

    protected String filename;

    public InFileRepository(String filename) {
        this.filename = filename;
    }

    @Override
    public List<T> findAll() {

        List<T> list = new ArrayList<>();

        try {
            String content =
                    new String(Files.readAllBytes(Paths.get(filename)));
            content = content.trim();
            if (content.startsWith("["))
                content = content.substring(1);

            if (content.endsWith("]"))
                content = content.substring(0, content.length() - 1);

            String[] objects = content.split("},");

            Pattern pattern =
                    Pattern.compile("\"(\\w+)\"\\s*:\\s*\"?([^,\"}]+)\"?");
            for (String obj : objects) {

                Map<String,String> map = new HashMap<>();

                Matcher m = pattern.matcher(obj);

                while (m.find()) {

                    map.put(m.group(1), m.group(2));
                }
                list.add(mapEntity(map));
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + filename);
        }

        return list;
    }
    protected abstract T mapEntity(Map<String,String> map);

}

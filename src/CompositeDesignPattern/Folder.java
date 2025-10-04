package CompositeDesignPattern;

import java.util.ArrayList;
import java.util.List;

public class Folder implements FileSystem {

    private final List<FileSystem> fileSystems;
    private final String name;

    public Folder(String name) {
        this.name = name;
        this.fileSystems = new ArrayList<>();
    }

    public void add(FileSystem fs){
        fileSystems.add(fs);
    }

    @Override
    public void ls() {
        System.out.println("Folder: " + name);
        for(FileSystem fs : fileSystems){
            // Recursion
            fs.ls();
        }
    }
}

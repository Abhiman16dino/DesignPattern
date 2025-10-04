package CompositeDesignPattern;

public class Main {
    public static void main(String[] args) {

        // Root Folder
        Folder folder = new Folder("Downloads");

        // Adding files to root folder
        File file = new File("1.jpg");
        File file2 = new File("2.jpg");
        File file3 = new File("3.jpg");
        folder.add(file);
        folder.add(file2);
        folder.add(file3);

        // Adding sub-folder to root folder
        Folder folder2 = new Folder("Movies");
        // Adding files to sub-folder
        File file4 = new File("avengers.mp4");
        File file5 = new File("BigHero6.mp4");
        folder2.add(file4);
        folder2.add(file5);

        // Adding sub-folder to root folder
        folder.add(folder2);

        // Listing all files and folders
        folder.ls();



    }
}

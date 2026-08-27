package Projects.FileSystem.FileSystemCommandDesignPattern.ConcreteClasses;

import Projects.FileSystem.FileSystemCommandDesignPattern.FileSystemNode;

public class Directory extends FileSystemNode {

    public Directory(String name) {
        super(name);
    }

    /**
     * @return
     */
    @Override
    public boolean isFile() {
        return false;
    }

    /**
     * @param depth
     */
    @Override
    public void display(int depth) {
        String indent = " ".repeat(depth * 2);

        System.out.println(indent + " Directory: " + getName() + " (" + getChildren().size() + ") of items");

        for (FileSystemNode file: getChildren()) {
            file.display(depth + 1);
        }
    }
}

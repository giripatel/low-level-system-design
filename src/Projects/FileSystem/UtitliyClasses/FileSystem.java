package Projects.FileSystem.UtitliyClasses;

import Projects.FileSystem.FileSystemCommandDesignPattern.ConcreteClasses.Directory;
import Projects.FileSystem.FileSystemCommandDesignPattern.ConcreteClasses.File;
import Projects.FileSystem.FileSystemCommandDesignPattern.FileSystemNode;

public class FileSystem {
    private FileSystemNode root;
    private static FileSystem instance;

    private FileSystem() {
        this.root = new Directory("/");
    }

    public static FileSystem getInstance() {
        if (instance == null) {
            instance = new FileSystem();
        }
        return instance;
    }

    public boolean isValidPath(String path) {
        return path != null && !path.isEmpty() && path.startsWith("/");
    }

    public boolean createPath(String path) {
        System.out.println("check 1: "+ isValidPath(path));
        if (!isValidPath(path)) return false;
        System.out.println("check 2");

        String[] components = path.split("/");

        FileSystemNode current = root;

        for (int i = 0; i < components.length - 1; i ++) {
            String component = components[i];

            if (component.isEmpty()) continue;

            if (!current.hasChild(component)) {

                FileSystemNode newDir = new Directory(component);
                current.addNode(component, newDir);
            }

            FileSystemNode child = current.getNode(component);
            System.out.println("check 3");
            // if it is file can not navigate through it
            if (child.isFile()) {
                return false;
            }
            System.out.println("check 4");
            current = child;
        }

        String newComponentName = components[components.length - 1];
        System.out.println("check 5");
        if (newComponentName.isEmpty()) return false;

        FileSystemNode newComponent;
        if (newComponentName.contains(".")) {
            newComponent = new File(newComponentName);
        } else {
            newComponent = new Directory(newComponentName);
        }

        current.addNode(newComponentName, newComponent);
        return true;
    }

    private FileSystemNode getNode(String path) {
        if (!isValidPath(path)) {
            return null;
        }

        if(path.equals("/")) return root;

//        int lastIndex = path.lastIndexOf("/");
//        String lastNode = path.substring(lastIndex + 1);
        String[] components = path.split("/");
        FileSystemNode current = root;
        for (String component: components) {
            if (component == null || component.isEmpty()) continue;

            if (!current.hasChild(component)) {
                return null;
            }

            current = current.getNode(component);
        }

        return current;
    }

    public boolean deletePath(String path) {

        if (!isValidPath(path)) return false;

        if (path.equals("/")) return false;

        String parentPath = getParentPath(path);

        FileSystemNode parent = getNode(parentPath);

        if (parent == null) return false;

        int lastIndex = path.lastIndexOf("/");
        String component = path.substring(lastIndex + 1);

        if (!parent.hasChild(component)) return false;

        return parent.removeChild(component);
    }

    private String getParentPath(String path) {
        if (!isValidPath(path)) return null;

        int lastIndex = path.lastIndexOf("/");

        return path.substring(0, lastIndex);
    }

    public void display() {
        root.display(0);
    }

    public boolean setFileContent(String path, String content) {
        FileSystemNode node = getNode(path);
        if (node == null || !node.isFile()) return false;
        File file = (File) node;
        file.setContent(content);
        return true;
    }

    public String getFileContent(String path) {
        FileSystemNode node = getNode(path);
        if (node == null || !node.isFile()) return null;
        File file = (File) node;
        return file.getContent();
    }
}

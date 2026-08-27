package Projects.FileSystem.FileSystemCommandDesignPattern;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public abstract class FileSystemNode {
    String name;
    Map<String, FileSystemNode> children;
    LocalDateTime createdDate;
    LocalDateTime modifiedDate;

    public FileSystemNode(String name) {
        this.name = name;
        this.children = new HashMap<>();
        this.createdDate = LocalDateTime.now();
    }

    protected void updateModifiedDate() {
        this.modifiedDate = LocalDateTime.now();
    }

    public void addNode(String name, FileSystemNode fileSystemNode) {
        if (!children.containsKey(name))
            children.put(name, fileSystemNode);
    }

    public FileSystemNode getNode(String name) {
        if (!children.containsKey(name))
            return null;
        return children.get(name);
    }

    public abstract boolean isFile();
    public abstract void display(int depth);

    public boolean hasChild(String name) {
        return children.containsKey(name);
    }

    public String getName() {
        return name;
    }

    public Collection<FileSystemNode> getChildren() {
        return children.values();
    }

    public boolean removeChild(String name) {
        if (!children.containsKey(name)) return false;
        children.remove(name);
        return true;
    }

    public LocalDateTime getCreatedAt() {
        return createdDate;
    }

    public LocalDateTime getModifiedAt() {
        return modifiedDate;
    }
}

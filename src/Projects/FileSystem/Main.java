package Projects.FileSystem;

import Projects.FileSystem.UtitliyClasses.FileSystem;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        FileSystem fileSystem = FileSystem.getInstance();

        Scanner scanner = new Scanner(System.in);

        boolean isRunning = true;

        System.out.println("File manager commands");
        System.out.println("1. create <path> - Create new path");
        System.out.println("2. write <path> <content> - Write content to a file");
        System.out.println("3. read <path> - Read content form a file");
        System.out.println("4. delete <path> - Delete a path");
        System.out.println("5. display - Show entire file system");
        System.out.println("6. exit - Exit the program");

        while (isRunning) {
            System.out.println("Enter command: ");

            String input = scanner.nextLine().trim();
            String[] parts = input.split("\\s+", 3);

            if (parts.length == 0) continue;

            String command = parts[0].toLowerCase();
            try {
                switch (command) {
                    case "create" :
                        if (parts.length >= 2) {
                            String path = parts[1];
                            System.out.println("Path: " + path);
                            boolean isCreated = fileSystem.createPath(path);
                            System.out.println(isCreated? "Path created successfully" : "Failed to create path");
                        } else {
                            System.out.println("Usage: create <path>");
                        }
                        break;
                    case "write" :
                        if (parts.length >= 3) {
                            String path = parts[1];
                            boolean isWritten = fileSystem.setFileContent(path, parts[2]);
                            System.out.println(isWritten? "Successfully updated the content" : "Failed to update content");
                        } else {
                            System.out.println("Usage: write <path> <content>");
                        }
                        break;
                    case "read":
                        if (parts.length >= 2) {
                            String path = parts[1];
                            String content = fileSystem.getFileContent(path);
                            if (content == null) {
                                System.out.println("Failed to read content");
                            } else {
                                System.out.println("Content: " + content);
                            }
                        } else {
                            System.out.println("Usage: read <path>");
                        }
                        break;

                    case "delete":
                        if (parts.length >= 2) {
                            String path = parts[1];
                            boolean isDeleted = fileSystem.deletePath(path);
                            System.out.println(isDeleted? "Successfully deleted" : "Failed to delete");
                        } else {
                            System.out.println("Usage: delete <path>");
                        }
                        break;

                    case "display":
                        if (parts.length >= 2) {
                            String path = parts[1];
                            fileSystem.display();
                        } else {
                            System.out.println("Usage: delete <path>");
                        }
                        break;
                    case "exit":
                    // Exit the program
                    isRunning = false;
                    System.out.println("Exiting...");
                    break;
                    default:
                        // Handle unknown commands
                        System.out.println(
                                "Unknown command. Available commands: create, write, read, delete, display, exit");
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }
}

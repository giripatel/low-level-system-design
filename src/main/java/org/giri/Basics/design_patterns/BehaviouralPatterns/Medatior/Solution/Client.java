package main.java.org.giri.Basics.design_patterns.BehaviouralPatterns.Medatior.Solution;

public class Client {
    public static void main(String[] args) {
        ChatRoom chatRoom = new ChatRoom("pavilion");
        ChatUser user1 = new ChatUser("Giri", chatRoom);
        ChatUser user2 = new ChatUser("John", chatRoom);
        ChatUser user3 = new ChatUser("Madhu", chatRoom);
        ChatUser user4 = new ChatUser("Ravi", chatRoom);


        chatRoom.addUser(user1);
        chatRoom.addUser(user2);
        chatRoom.addUser(user3);
        chatRoom.addUser(user4);

        user1.sendMessage("Hey floks");

    }
}

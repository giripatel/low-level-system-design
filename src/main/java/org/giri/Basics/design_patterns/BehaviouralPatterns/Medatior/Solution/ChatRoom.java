package main.java.org.giri.Basics.design_patterns.BehaviouralPatterns.Medatior.Solution;

import main.java.org.giri.Basics.design_patterns.BehaviouralPatterns.Medatior.Problem.User;

import java.util.ArrayList;
import java.util.List;

public class ChatRoom implements ChatMediator{
    private String name;
    private List<ChatUser> users;

    public ChatRoom(String name) {
        this.name = name;
        this.users = new ArrayList<>();
    }

    public void addUser(ChatUser user) {
        users.add(user);
    }

    @Override
    public void sendMessage(String message, ChatUser chatuser) {
        for (ChatUser user: users) {
            if (user != chatuser) {
                user.receiveMessage(chatuser, message);
            }
        }
    }

    public List<ChatUser> getUsers(){
        return users;
    }
}

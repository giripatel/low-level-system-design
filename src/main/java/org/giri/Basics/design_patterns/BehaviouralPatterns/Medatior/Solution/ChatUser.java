package main.java.org.giri.Basics.design_patterns.BehaviouralPatterns.Medatior.Solution;

public class ChatUser {
    private String name;
    private ChatMediator chatMediator;

    public ChatUser(String name, ChatMediator chatMediator) {
        this.name = name;
        this.chatMediator = chatMediator;
    }
    public void sendMessage(String message){
        System.out.println(this.name  + " : sent message everyone");
        chatMediator.sendMessage(message, this);
    }
    public void receiveMessage(ChatUser user, String message) {
        System.out.println(message + " : from " + user.name + " to : " + name);
    }
}

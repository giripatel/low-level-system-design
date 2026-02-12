package main.java.org.giri.Basics.design_patterns.BehaviouralPatterns.Medatior.Solution;

import main.java.org.giri.Basics.design_patterns.BehaviouralPatterns.Medatior.Problem.User;

import java.util.HashMap;
import java.util.Map;

public interface ChatMediator {

   void sendMessage(String message, ChatUser user);
   void addUser(ChatUser user);
}

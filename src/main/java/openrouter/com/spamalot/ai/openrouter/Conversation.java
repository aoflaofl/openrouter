package openrouter.com.spamalot.ai.openrouter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import openrouter.com.spamalot.ai.openrouter.model.Character;
import openrouter.com.spamalot.ai.openrouter.model.Message;

public class Conversation {

  Character character;
  List<Message> messages = new ArrayList<>();

  Conversation(Character value) {

    this.character = value;
  }

  void addMessage(Message message) {

    this.messages.add(message);
  }

  public Character getCharacter() {

    return character;
  }

  public List<Message> getMessages() {

    return messages;
  }

  public void printItOut() {

    System.out.println("## Model: " + character.getModelInfo().getName());
    System.out.println("* * *");

    Collections.sort(messages, Comparator.comparing(Message::getUpdatedAtInstant));

    for (Message message : messages) {
      System.out.println();
      if (message.getCharacterId().equals("USER")) {
        System.out.println("### " + message.getCharacterId());
      } else {
        System.out.println("### " + character.getModelInfo().getShortName());
      }
      System.out.println();
      System.out.println(message.getContent());
    }
  }
}

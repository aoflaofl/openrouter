package com.spamalot.ai.openrouter;

import com.spamalot.ai.openrouter.model.Character;
import com.spamalot.ai.openrouter.model.Message;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Conversation {

  private static final Logger LOGGER = LoggerFactory.getLogger(Conversation.class);
  Character character;
  List<Message> messages = new ArrayList<>();

  Conversation(Character value) {

    this.character = value;
  }

  void addMessage(Message message) {
    // LOGGER.info("Adding message: {} {} {}", message.getUpdatedAt(),
    // message.getContent(), message.getCharacterId());
    this.messages.add(message);
  }

  public Character getCharacter() {

    return character;
  }

  public List<Message> getMessages() {

    return messages;
  }

  public void printItOut(PrintWriter writer) {

    writer.println("## Model: " + character.getModelInfo().getName());
    writer.println("* * *");

    Collections.sort(messages, Comparator.comparing(Message::getUpdatedAtInstant));

    for (Message message : messages) {
      writer.println();
      if (message.getCharacterId().equals("USER")) {
        writer.print("### " + message.getCharacterId());
      } else {
        writer.print("### " + character.getModelInfo().getShortName());
      }

      writer.println(" (Time: " + message.getUpdatedAt() + ")");

      writer.println(message.getContent());
      LOGGER.info("Writing message: {} {} {}", message.getUpdatedAt(), message.getContent(), message.getCharacterId());
    }
  }
}

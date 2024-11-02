package com.spamalot.ai.openrouter;

import com.spamalot.ai.openrouter.model.Character;
import com.spamalot.ai.openrouter.model.Message;
import java.io.PrintWriter;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

class Conversation {

  private static final Logger LOGGER = LoggerFactory.getLogger(Conversation.class);
  private Character character;
  private List<Message> messages = new ArrayList<>();
  private Instant firstAiResponseTime = Instant.now();

  Conversation(Character value) {

    this.character = value;
  }

  void addMessage(Message message) {
    this.messages.add(message);
    if (message.getCharacterId().equals("USER")) {
      return;
    }

    if (message.getUpdatedAtInstant().isBefore(firstAiResponseTime)) {
      firstAiResponseTime = message.getUpdatedAtInstant();
    }
  }

  public Character getCharacter() {

    return character;
  }

  public List<Message> getMessages() {

    return messages;
  }

  public Instant getFirstAiResponseTime() {
    return firstAiResponseTime;
  }

  void printItOut(PrintWriter writer) {

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
      writer.println();
      LOGGER.info("Writing message: {} {} {}", message.getUpdatedAt(), message.getContent(), message.getCharacterId());
    }
  }
}

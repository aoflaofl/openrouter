
package openrouter.com.spamalot.ai.openrouter;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.databind.ObjectMapper;

import openrouter.com.spamalot.ai.openrouter.model.Root;
import openrouter.com.spamalot.ai.openrouter.model.Character;
import openrouter.com.spamalot.ai.openrouter.model.Message;

public class Main {
  private static final Logger logger = LoggerFactory.getLogger(Main.class);

  public static void main(String[] args) {

    Map<String, Conversation> conversations = loadConversations();

    if (conversations == null) {
      logger.error("Failed to load conversations");
    }

    for (Map.Entry<String, Conversation> entry2 : conversations.entrySet()) {
      entry2.getValue().printItOut();
    }

  }

  private static Map<String, Conversation> loadConversations() {

    Map<String, Conversation> conversations = new HashMap<>();
    ObjectMapper mapper = new ObjectMapper();
    try {
      Root root = mapper.readValue(new File("src/main/resources/Brainstorm - Sat Sep 28 2024.json"), Root.class);
      processCharacters(root, conversations);
      processMessages(root, conversations);
    } catch (IOException e) {
      logger.error("Failed to parse JSON file", e);
      return null;
    }
    return conversations;
  }

  private static void processCharacters(Root root, Map<String, Conversation> conversations) {

    Map<String, Character> characters = root.getCharacters();
    for (Map.Entry<String, Character> entry : characters.entrySet()) {
      String key = entry.getKey();
      Character value = entry.getValue();
      conversations.put(key, new Conversation(value));
    }
  }

  private static void processMessages(Root root, Map<String, Conversation> conversations) {

    Map<String, Message> messages = root.getMessages();
    for (Map.Entry<String, Message> entry : messages.entrySet()) {
      Message value = entry.getValue();
      if (value.getCharacterId().equals("USER")) {
        for (Map.Entry<String, Conversation> entry2 : conversations.entrySet()) {
          entry2.getValue().addMessage(value);
        }
      } else {
        conversations.get(value.getCharacterId()).addMessage(value);
      }
    }
  }
}

package com.spamalot.ai.openrouter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.spamalot.ai.openrouter.model.Character;
import com.spamalot.ai.openrouter.model.Message;
import com.spamalot.ai.openrouter.model.Root;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main {
  private static final Logger LOGGER = LoggerFactory.getLogger(Main.class);

  public static void main(String[] args) {
    List<String> jsonFiles = findJsonFiles("src/main/resources/AI");
    LOGGER.info("Found {} JSON files", jsonFiles.size());

    for (String jsonFile : jsonFiles) {
      LOGGER.info("Processing JSON file: {}", jsonFile);
      Map<String, Conversation> conversations = loadConversations(jsonFile);
      if (conversations.isEmpty()) {
        LOGGER.error("Failed to load conversations");
      } else {
        String mdFile = changeJsonToMd(jsonFile);
        try (PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter(mdFile)))) {
          List<Conversation> conversationList = new ArrayList<>(conversations.values());
          for (Conversation entry : conversationList) {
            LOGGER.info("getFirstAiResponseTime: {}", entry.getFirstAiResponseTime());
          }

          Collections.sort(conversationList, Comparator.comparing(Conversation::getFirstAiResponseTime));

          for (Conversation entry : conversationList) {
            entry.printItOut(writer);
          }
        } catch (IOException e) {
          LOGGER.error("Error writing to file: {}", mdFile, e);
        }

      }
    }

  }

  private static String changeJsonToMd(String filePath) {
    if (filePath == null || filePath.isEmpty()) {
      LOGGER.error("Invalid file path: {}", filePath);
      return filePath;
    }

    if (!filePath.toLowerCase().endsWith(".json")) {
      LOGGER.warn("File does not have .json extension: {}", filePath);
      return filePath;
    }

    int lastDotIndex = filePath.lastIndexOf('.');
    if (lastDotIndex != -1) {
      return filePath.substring(0, lastDotIndex) + ".md";
    }

    return filePath;
  }

  private static List<String> findJsonFiles(String rootDir) {
    List<String> jsonFiles = new ArrayList<>();
    File root = new File(rootDir);

    if (!root.exists() || !root.isDirectory()) {
      LOGGER.error("Invalid root directory: {}", rootDir);
      return jsonFiles;
    }

    findJsonFilesRecursive(root, rootDir, jsonFiles);
    return jsonFiles;
  }

  private static void findJsonFilesRecursive(File currentDir, String rootDir, List<String> jsonFiles) {
    File[] files = currentDir.listFiles();
    if (files == null) {
      return;
    }

    for (File file : files) {
      if (file.isDirectory()) {
        findJsonFilesRecursive(file, rootDir, jsonFiles);
      } else if (file.isFile() && file.getName().toLowerCase().endsWith(".json")) {
        LOGGER.info("Found JSON file: {}", file.getAbsolutePath());
        jsonFiles.add(file.getAbsolutePath());
      }
    }
  }

  private static Map<String, Conversation> loadConversations(String conversation) {

    Map<String, Conversation> conversations = new HashMap<>();
    ObjectMapper mapper = new ObjectMapper();
    try {
      Root root = mapper.readValue(new File(conversation), Root.class);

      if (root.getVersion() == null || !root.getVersion().equals("orpg.1.0")) {
        LOGGER.error("{} is not a orpg.1.0 conversation file skipping", conversation);
        return conversations;
      }

      processCharacters(root, conversations);
      processMessages(root, conversations);
    } catch (IOException e) {
      LOGGER.error("Failed to parse JSON file", e);
    }
    return conversations;
  }

  private static void processCharacters(Root root, Map<String, Conversation> conversations) {

    Map<String, Character> characters = root.getCharacters();
    for (Map.Entry<String, Character> entry : characters.entrySet()) {
      String key = entry.getKey();
      LOGGER.info("Character: {} {}", key, entry.getValue().getModelInfo().getName());
      Character value = entry.getValue();
      conversations.put(key, new Conversation(value));
    }
  }

  private static void processMessages(Root root, Map<String, Conversation> conversations) {

    Map<String, Message> messages = root.getMessages();
    for (Map.Entry<String, Message> entry : messages.entrySet()) {
      String msgKey = entry.getKey();
      LOGGER.info("Message: {}", msgKey);

      Message msgValue = entry.getValue();
      String characterId = msgValue.getCharacterId();

      LOGGER.info("Character: {}", characterId);

      if (characterId.equals("USER")) {
        for (Map.Entry<String, Conversation> entry2 : conversations.entrySet()) {
          entry2.getValue().addMessage(msgValue);
        }
      } else {
        conversations.get(characterId).addMessage(msgValue);

      }
    }
  }
}

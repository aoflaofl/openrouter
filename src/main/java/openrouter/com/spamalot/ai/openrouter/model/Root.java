package openrouter.com.spamalot.ai.openrouter.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Map;

public class Root {
  @JsonProperty("version")
  private String version;

  @JsonProperty("characters")
  private Map<String, Character> characters;

  @JsonProperty("messages")
  private Map<String, Message> messages;

  // Getters and setters
  public String getVersion() {

    return version;
  }

  public void setVersion(String version) {

    this.version = version;
  }

  public Map<String, Character> getCharacters() {

    return characters;
  }

  public void setCharacters(Map<String, Character> characters) {

    this.characters = characters;
  }

  @Override
  public String toString() {

    return "Root{" + "version='" + version + '\'' + ", characters=" + characters + '}';
  }

  public Map<String, Message> getMessages() {

    return messages;
  }
}
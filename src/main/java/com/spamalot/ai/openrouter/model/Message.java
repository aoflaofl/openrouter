package com.spamalot.ai.openrouter.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.time.Instant;
import java.util.List;
import java.util.Map;

public class Message {
  @JsonProperty("characterId")
  private String characterId;

  @JsonProperty("content")
  private String content;

  @JsonProperty("id")
  private String id;

  @JsonProperty("updatedAt")
  private String updatedAt;

  @JsonProperty("metadata")
  private Map<String, Object> metadata;

  @JsonProperty("attachments")
  private List<String> attachments;

  @JsonProperty("isGenerating")
  private boolean isGenerating;
  
  @JsonProperty("isRetrying")
  private boolean isRetrying;
  
  public String getCharacterId() {

    return characterId;
  }

  public String getContent() {

    return content;
  }

  public String getId() {

    return id;
  }

  public String getUpdatedAt() {

    return updatedAt;
  }

  public Map<String, Object> getMetadata() {

    return metadata;
  }

  public List<String> getAttachments() {

    return attachments;
  }

  public Instant getUpdatedAtInstant() {

    return Instant.parse(updatedAt);
  }

}

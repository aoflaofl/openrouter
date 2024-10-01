package com.spamalot.ai.openrouter.model;

import com.fasterxml.jackson.annotation.JsonProperty;

class DataPolicy {
  @JsonProperty("url")
  private String url;

  @JsonProperty("training")
  private boolean training;

  @JsonProperty("requires_user_ids")
  private boolean requiresUserIds;

  // Getters and setters
  // (omitted for brevity, but you should include them)
}
package com.spamalot.ai.openrouter.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ModelInfo {
  @JsonProperty("id")
  private int id;

  @JsonProperty("slug")
  private String slug;

  @JsonProperty("hf_slug")
  private String hfSlug;

  @JsonProperty("updated_at")
  private String updatedAt;

  @JsonProperty("created_at")
  private String createdAt;

  @JsonProperty("hf_updated_at")
  private String hfUpdatedAt;

  @JsonProperty("name")
  private String name;

  @JsonProperty("short_name")
  private String shortName;

  @JsonProperty("author")
  private String author;

  @JsonProperty("description")
  private String description;

  @JsonProperty("context_length")
  private int contextLength;

  @JsonProperty("modality")
  private String modality;

  @JsonProperty("has_text_output")
  private boolean hasTextOutput;

  @JsonProperty("group")
  private String group;

  @JsonProperty("instruct_type")
  private String instructType;

  @JsonProperty("default_system")
  private String defaultSystem;

  @JsonProperty("default_stops")
  private String[] defaultStops;

  @JsonProperty("hidden")
  private boolean hidden;

  @JsonProperty("router")
  private String router;

  @JsonProperty("base_model_slug")
  private String baseModelSlug;

  @JsonProperty("warning_message")
  private String warningMessage;

  @JsonProperty("endpoint")
  private Endpoint endpoint;

  @JsonProperty("variant")
  private String variant;

  @JsonProperty("deleted")
  private boolean deleted;

  @JsonProperty("deprecated")
  private boolean deprecated;

  @JsonProperty("experimental")
  private boolean experimental;

  @JsonProperty("weight_url")
  private String weightUrl;

  @JsonProperty("default_transforms")
  private String[] defaultTransforms;

  @JsonProperty("versions")
  private String[] versions;

  public String getName() {

    return name;
  }

  public String getShortName() {

    return shortName;
  }

  // Getters and setters
  // (omitted for brevity, but you should include them)
}
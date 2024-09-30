package openrouter.com.spamalot.ai.openrouter.model;

import com.fasterxml.jackson.annotation.JsonProperty;

class Model {
  @JsonProperty("id")
  private Integer id;

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

  @JsonProperty("description")
  private String description;

  @JsonProperty("author")
  private String author;

  @JsonProperty("hidden")
  private boolean hidden;

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

  @JsonProperty("default_stops")
  private String[] defaultStops;

  @JsonProperty("default_system")
  private String defaultSystem;

  @JsonProperty("warning_message")
  private String warningMessage;

  @JsonProperty("router")
  private String router;

  @JsonProperty("base_model_slug")
  private String baseModelSlug;

  @JsonProperty("variant")
  private String variant;

  // Getters and setters
  // (omitted for brevity, but you should include them)
}
package openrouter.com.spamalot.ai.openrouter.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Map;

public class Character {
  @JsonProperty("id")
  private String id;

  @JsonProperty("model")
  private String model;

  @JsonProperty("modelInfo")
  private ModelInfo modelInfo;

  @JsonProperty("updatedAt")
  private String updatedAt;

  @JsonProperty("samplingParameters")
  private Map<String, Object> samplingParameters;

  @JsonProperty("maxTokens")
  private int maxTokens;

  @JsonProperty("chatMemory")
  private int chatMemory;

  @JsonProperty("description")
  private String description;

  @JsonProperty("isDisabled")
  private boolean isDisabled;

  // Getters and setters
  public String getId() {

    return id;
  }

  public void setId(String id) {

    this.id = id;
  }

  public String getModel() {

    return model;
  }

  public void setModel(String model) {

    this.model = model;
  }

  public ModelInfo getModelInfo() {

    return modelInfo;
  }

  public void setModelInfo(ModelInfo modelInfo) {

    this.modelInfo = modelInfo;
  }

  public String getUpdatedAt() {

    return updatedAt;
  }

  public void setUpdatedAt(String updatedAt) {

    this.updatedAt = updatedAt;
  }

  public Map<String, Object> getSamplingParameters() {

    return samplingParameters;
  }

  public void setSamplingParameters(Map<String, Object> samplingParameters) {

    this.samplingParameters = samplingParameters;
  }

  public int getMaxTokens() {

    return maxTokens;
  }

  public void setMaxTokens(int maxTokens) {

    this.maxTokens = maxTokens;
  }

  public int getChatMemory() {

    return chatMemory;
  }

  public void setChatMemory(int chatMemory) {

    this.chatMemory = chatMemory;
  }

  public String getDescription() {

    return description;
  }

  public void setDescription(String description) {

    this.description = description;
  }

  @Override
  public String toString() {

    return "Character{" + "id='" + id + '\'' + ", model='" + model + '\'' + ", modelInfo=" + modelInfo + ", updatedAt='"
        + updatedAt + '\'' + ", samplingParameters=" + samplingParameters + ", maxTokens=" + maxTokens + ", chatMemory="
        + chatMemory + ", description='" + description + '\'' + '}';
  }
}
package com.spamalot.ai.openrouter.model;

import com.fasterxml.jackson.annotation.JsonProperty;

class Endpoint {
  @JsonProperty("name")
  private String name;

  @JsonProperty("model")
  private Model model;

  @JsonProperty("model_slug")
  private String modelSlug;

  @JsonProperty("provider_name")
  private String providerName;

  @JsonProperty("provider_display_name")
  private String providerDisplayName;

  @JsonProperty("provider_model_id")
  private String providerModelId;

  @JsonProperty("is_beta")
  private boolean isBeta;

  @JsonProperty("quantization")
  private String quantization;

  @JsonProperty("variant")
  private String variant;

  @JsonProperty("is_self_hosted")
  private boolean isSelfHosted;

  @JsonProperty("can_abort")
  private boolean canAbort;

  @JsonProperty("can_stream")
  private boolean canStream;

  @JsonProperty("context_length")
  private int contextLength;

  @JsonProperty("max_prompt_tokens")
  private Integer maxPromptTokens;

  @JsonProperty("max_completion_tokens")
  private int maxCompletionTokens;

  @JsonProperty("supported_parameters")
  private String[] supportedParameters;

  @JsonProperty("is_byok_required")
  private boolean isByokRequired;

  @JsonProperty("moderation_required")
  private boolean moderationRequired;

  @JsonProperty("data_policy")
  private DataPolicy dataPolicy;

  @JsonProperty("status_page")
  private String statusPage;

  @JsonProperty("pricing")
  private Pricing pricing;

  // Getters and setters
  // (omitted for brevity, but you should include them)
}
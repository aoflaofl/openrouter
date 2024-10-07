package com.spamalot.ai.openrouter.model;

import com.fasterxml.jackson.annotation.JsonProperty;

class Pricing {
  @JsonProperty("prompt")
  private String prompt;

  @JsonProperty("completion")
  private String completion;

  @JsonProperty("image")
  private String image;

  @JsonProperty("supports_tools")
  private boolean supportsTools;

  @JsonProperty("discount")
  private Long discount;

  @JsonProperty("companyDiscount")
  private Long companyDiscount;

  // Getters and setters
  // (omitted for brevity, but you should include them)
}
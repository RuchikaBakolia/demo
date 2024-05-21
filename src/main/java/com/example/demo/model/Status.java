package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
public class Status {
        @JsonProperty("description")
        private String description;

        @JsonProperty("indicator")
        private String indicator;

    public String getDescription() {
        return description;
    }

    public String getIndicator() {
        return indicator;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setIndicator(String indicator) {
        this.indicator = indicator;
    }
}
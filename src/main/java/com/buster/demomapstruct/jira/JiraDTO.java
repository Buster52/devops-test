package com.buster.demomapstruct.jira;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class JiraDTO {
    private String key;
    private String issueTypeName;
    private List<FixVersionDTO> fixVersions;
    @JsonProperty("estado")
    private String statusName;
}

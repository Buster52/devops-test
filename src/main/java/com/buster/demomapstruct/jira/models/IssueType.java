package com.buster.demomapstruct.jira.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(Include.NON_NULL)
public class IssueType {

    private String self;
    private String id;
    private String description;
    private String iconUrl;
    private String name;
    private boolean subtask;
    private int avatarId;
}

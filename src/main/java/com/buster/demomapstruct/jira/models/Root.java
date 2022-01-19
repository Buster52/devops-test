package com.buster.demomapstruct.jira.models;

import java.util.List;

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
public class Root {
    private String expand;
    private String id;
    private String self;
    private String key;
    private Fields fields;
    private List<FixVersion> fixVersions;
    private Status status; 
}

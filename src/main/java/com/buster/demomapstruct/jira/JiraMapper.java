package com.buster.demomapstruct.jira;

import com.buster.demomapstruct.jira.models.Root;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface JiraMapper {

  @Mapping(source = "root.fixVersions", target = "fixVersions")
  @Mapping(source = "root.fields.issuetype.name", target = "issueTypeName")
  @Mapping(source = "root.status.name", target = "statusName")
  JiraDTO toDTO(Root root);
}

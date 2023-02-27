package com.buster.demomapstruct.jira;

import java.io.File;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.buster.demomapstruct.jira.models.Root;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@AllArgsConstructor
public class JiraService {

    private final JiraMapper jiraMapper;

    public JiraDTO getIssue() {
        ObjectMapper mapper = new ObjectMapper();
        Root root = new Root();
        JiraDTO jira = new JiraDTO();
        try {
            File json = new File("D:/gonza/Documents/java-projects/demo-mapstruct/src/main/resources/test.json");
            root = mapper.readValue(
                    json,
                    Root.class);
            jira = jiraMapper.toDTO(root);

            return Optional.of(jira).orElseThrow(() -> new Exception("Objeto vacio"));

        } catch (Exception e) {
            log.error("Error {}", e.getMessage());
        }
        return jira;
    }
}

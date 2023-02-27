package com.buster.demomapstruct.jira;

import java.io.File;
import java.lang.module.Configuration;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Objects;
import java.util.Optional;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
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
            Resource resource = new ClassPathResource("test.json");
            File json = resource.getFile();
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

package com.buster.demomapstruct.jira;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("api/v1/jira")
@AllArgsConstructor
@Slf4j
public class JiraController {
    private final JiraService jiraService;

    @GetMapping()
    public ResponseEntity<JiraDTO> getIssues() {
        log.info("Call service");
        JiraDTO jiraDTO = jiraService.getIssue();
        return ResponseEntity.status(HttpStatus.OK).body(jiraDTO);
    }
}

package com.sitemate.challenge.bahattin.api.rest;

import com.sitemate.challenge.bahattin.model.dto.IssueView;
import com.sitemate.challenge.bahattin.model.entity.Issue;
import com.sitemate.challenge.bahattin.model.mappers.IssueModelMapper;
import com.sitemate.challenge.bahattin.services.IssueService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@CrossOrigin
@RequestMapping("/issues")
public class IssueController {
  private final IssueService issueService;

  public IssueController(IssueService issueService) {
    this.issueService = issueService;
  }

  @GetMapping("/get/{id}")
  public IssueView getIssueById(@PathVariable(name = "id") Long id) {
    return IssueModelMapper.toDto(issueService.getIssueById(id));
  }

  @GetMapping("/list")
  public List<IssueView> listAllIssues() {
    return issueService.getAllIssues().stream()
      .map(IssueModelMapper::toDto)
      .collect(Collectors.toList());
  }

  @PostMapping("/save")
  public Issue saveIssue(@RequestBody IssueView issueView) {
    Issue issue = IssueModelMapper.fromDto(issueView);
    if (issueView.getId() == null) {
      return issueService.createIssue(issue);
    } else {
      return issueService.updateIssue(issue.getId(), issue);
    }
  }

  @DeleteMapping("/delete/{id}")
  public void deleteIssueById(@PathVariable(name = "id") Long id) {
    issueService.deleteIssue(id);
  }
}

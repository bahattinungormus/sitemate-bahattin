package com.sitemate.challenge.bahattin.model.mappers;

import com.sitemate.challenge.bahattin.model.dto.IssueView;
import com.sitemate.challenge.bahattin.model.entity.Issue;

import java.util.UUID;

public class IssueModelMapper {
  public static Issue fromDto(IssueView issueView) {
    Issue issue = new Issue();
    issue.setId(issueView.getId());
    UUID uuid = issueView.getUuid() == null ? null : UUID.fromString(issueView.getUuid());
    issue.setUuid(uuid);
    issue.setTitle(issueView.getTitle());
    issue.setDescription(issueView.getDescription());
    return issue;
  }

  public static IssueView toDto(Issue issue) {
    IssueView issueView = new IssueView();
    String uuid = issue.getUuid() == null ? null : issue.getUuid().toString();
    issueView.setId(issue.getId());
    issueView.setUuid(uuid);
    issueView.setTitle(issue.getTitle());
    issueView.setDescription(issue.getDescription());
    return issueView;
  }
}

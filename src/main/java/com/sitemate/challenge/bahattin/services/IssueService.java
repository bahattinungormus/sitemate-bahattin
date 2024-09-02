package com.sitemate.challenge.bahattin.services;

import com.sitemate.challenge.bahattin.model.entity.Issue;
import com.sitemate.challenge.bahattin.repositories.IssueRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional(value = Transactional.TxType.REQUIRED)
public class IssueService {
  private final IssueRepository issueRepository;

  public IssueService(@Autowired IssueRepository issueRepository) {
    this.issueRepository = issueRepository;
  }

  public Issue createIssue(Issue issue) {
    return issueRepository.save(issue);
  }

  public Issue getIssueById(Long id) {
    return issueRepository.findById(id).orElse(null);
  }

  public List<Issue> getAllIssues() {
    List<Issue> issues = new ArrayList<>();
    issueRepository.findAll().forEach(issues::add);
    return issues;
  }

  public Issue updateIssue(Long id, Issue issue) {
    Issue existingIssue = getIssueById(id);
    existingIssue.setUuid(issue.getUuid());
    existingIssue.setTitle(issue.getTitle());
    existingIssue.setDescription(issue.getDescription());
    return issueRepository.save(existingIssue);
  }

  public void deleteIssue(Long id) {
    issueRepository.deleteById(id);
  }
}

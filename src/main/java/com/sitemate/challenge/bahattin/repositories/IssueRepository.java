package com.sitemate.challenge.bahattin.repositories;

import com.sitemate.challenge.bahattin.model.entity.Issue;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface IssueRepository extends CrudRepository<Issue, Long> {
}

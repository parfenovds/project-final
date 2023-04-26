package com.javarush.jira.bugtracking.internal.repository;

import com.javarush.jira.bugtracking.internal.model.Task;
import com.javarush.jira.common.BaseRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public interface TaskRepository extends BaseRepository<Task> {
    @Modifying
    @Query("update Task t set t.tags = ?1 where t.id = ?2")
    int updateTagsById(String tags, Long id);
    @Query("SELECT t FROM Task t LEFT JOIN FETCH t.project LEFT JOIN FETCH t.sprint LEFT JOIN FETCH t.activities")
    List<Task> getAll();


}
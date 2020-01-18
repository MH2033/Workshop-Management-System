package com.project.workshopmanagment.repository.form;

import com.project.workshopmanagment.entity.form.Question;
import org.springframework.data.repository.CrudRepository;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;

public interface QuestionRepository extends CrudRepository<Question, Long> {

    @PreAuthorize("hasAnyAuthority('ROLE_ORGANIZER', 'ROLE_SYSADMIN')")
    <S extends Question> S save(S s);
}

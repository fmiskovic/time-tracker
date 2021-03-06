package com.time.tracker.validators;

import com.time.tracker.errors.EntryDateException;
import com.time.tracker.model.Project;
import com.time.tracker.model.ProjectEntry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class ProjectEntryValidator {

    private final Logger log = LoggerFactory.getLogger(getClass());

    public void validateEntryDate(Project project, ProjectEntry entry) throws EntryDateException {
        LocalDate entryDate = entry.getEntryDate();
        LocalDate startDate = project.getStartDate();
        LocalDate endDate = project.getEndDate();

        if (entryDate.isBefore(startDate) || entryDate.isAfter(endDate)) {
            log.error("Project entry has invalid entryDate!");
            throw new EntryDateException();
        }
    }
}

package org.kshrd.mybatishomeworkonlinelearningplatform.service;

import org.kshrd.mybatishomeworkonlinelearningplatform.model.Instructor;
import org.kshrd.mybatishomeworkonlinelearningplatform.model.dto.request.InstructorRequest;

import java.util.List;

public interface InstructorService {
    Instructor addNewInstructor(InstructorRequest instructorRequest);

    Instructor findInstructorById(Long instructorId);

    Instructor updateInfoInstructorById(Long instructorId, InstructorRequest instructorRequest);

    void removeInstructorById(Long instructorId);

    List<Instructor> findAllInstructors(Integer offset, Integer limit);
}

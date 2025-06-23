package org.kshrd.mybatishomeworkonlinelearningplatform.service.serviceimpl;

import lombok.AllArgsConstructor;
import org.kshrd.mybatishomeworkonlinelearningplatform.exception.NotFoundException;
import org.kshrd.mybatishomeworkonlinelearningplatform.model.Instructor;
import org.kshrd.mybatishomeworkonlinelearningplatform.model.dto.request.InstructorRequest;
import org.kshrd.mybatishomeworkonlinelearningplatform.repository.InstructorRepository;
import org.kshrd.mybatishomeworkonlinelearningplatform.service.InstructorService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class InstructorServiceImpl implements InstructorService {

    private final InstructorRepository instructorRepository;

    @Override
    public Instructor addNewInstructor(InstructorRequest instructorRequest) {
        return instructorRepository.addNewInstructor(instructorRequest);
    }

    @Override
    public Instructor findInstructorById(Long instructorId) {
        Instructor instructor = instructorRepository.findInstructorById(instructorId);
        if (instructor == null) {
            throw new NotFoundException("Instructor with ID " + instructorId + " not found.");
        }
        return instructor;
    }

    @Override
    public Instructor updateInfoInstructorById(Long instructorId, InstructorRequest instructorRequest) {
        findInstructorById(instructorId);
        return instructorRepository.updateInfoInstructorById(instructorId, instructorRequest);
    }

    @Override
    public void removeInstructorById(Long instructorId) {
        findInstructorById(instructorId);
        instructorRepository.removeInstructorById(instructorId);
    }

    @Override
    public List<Instructor> findAllInstructors(Integer offset, Integer limit) {
        offset = (offset - 1) * limit;
        return instructorRepository.findAllInstructors(offset, limit);
    }
}

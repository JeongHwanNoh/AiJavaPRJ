package kopo.poly.service.impl;

import kopo.poly.dto.StudentDTO;
import kopo.poly.persistance.mapper.IStudentMapper;
import kopo.poly.service.IStudentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Slf4j
@RequiredArgsConstructor
@Service
public class StudentService implements IStudentService {
    private final IStudentMapper StudentMapper;
    @Override
    public List<StudentDTO> insertStudent(StudentDTO pDTO) throws Exception {

        log.info(this.getClass().getName() + ".insertStudent Start!");

        Optional<StudentDTO> res = Optional.ofNullable(
                StudentMapper.getStudent(pDTO)
        );

        if (!res.isPresent()) {
            StudentMapper.insertStudent(pDTO);
        }

        List<StudentDTO> rList = Optional.ofNullable(
                StudentMapper.getStudentList()
        ).orElseGet(ArrayList::new);

        log.info(this.getClass().getName() + ".insertStudent End!");

        return rList;

    }
}
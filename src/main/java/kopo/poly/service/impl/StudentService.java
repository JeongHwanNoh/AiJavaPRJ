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

        log.info(this.getClass().getName() + ".Student Start!");

        Optional<StudentDTO> res = Optional.ofNullable(
                StudentMapper.getStudent(pDTO)
        );

        if (!res.isPresent()) {
            StudentMapper.insertStudent(pDTO);
        }

        log.info(this.getClass().getName() + ".Student End!");
        List<StudentDTO> rList = Optional.ofNullable(
                StudentMapper.getStudentList()).orElseGet(ArrayList::new);
        return rList;
        }


    /*@Override
    public List<StudentDTO> updateStudent(StudentDTO pDTO) throws Exception {

        log.info(this.getClass().getName() + ".updateStudent Start!");

        Optional<StudentDTO> res = Optional.ofNullable(StudentMapper.getStudent(pDTO));
        if (res.isPresent()) {
            StudentMapper.updateStudent(pDTO);
            log.info(pDTO.getUserId() + "님이 수정되었습니다.");

        } else {
            log.info("회원이 존재하지 않아 수정되지 못했습니다.");
        }
        List<StudentDTO> rList = Optional.ofNullable(
                StudentMapper.getStudentList()).orElseGet(ArrayList::new);

        return rList;
    }

    @Override
    public List<StudentDTO> deleteStudent(StudentDTO pDTO) throws Exception {

        log.info(this.getClass().getName() + ".updateStudent Start!");
        Optional<StudentDTO> res = Optional.ofNullable(StudentMapper.getStudent(pDTO));

        if (res.isPresent()) {
            StudentMapper.deleteStudent(pDTO);
            log.info(pDTO.getUserId() + "님이 삭제되었습니다.");

        } else {
            log.info("회원이 존재하지 않아 삭제되지 못했습니다.");
        }

        List<StudentDTO> rList = Optional.ofNullable(
                StudentMapper.getStudentList()).orElseGet(ArrayList::new);

        return rList;*/
    }


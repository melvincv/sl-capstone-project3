package service;

import com.student.crudapp.model.Student;
import com.student.crudapp.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class StudentService {

    @Autowired
    StudentRepository studentRepository;

    //Get all the students
    public List<Student> getAllStudents() {
        List<Student> students = studentRepository.findAll();
        return students;
    }

    //display one student by id
    public Student getStudentById(int id) {
        return studentRepository.findById(id);
    }

    //save student in database
    public void saveStudent(Student student) {
        try{
            studentRepository.save(student);
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    //delete stuednt by id
    public void deleteStudent(int id) {
        try{
            studentRepository.deleteById(id);
        }catch(Exception e){
            e.printStackTrace();
        }
    }

}
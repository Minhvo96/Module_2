package Service;

import Model.Student;

import java.util.List;

public interface IStudentManagerService {
    List<Student> getAllStudents();
    Student findStudentById(long idStudent, List<Student> students);
    void updateStudentById(long idStudent, Student student, List<Student> students);
    void deleteStudentById(long idStudent, List<Student> students);
    void addStudent(Student student, List<Student> students);
    void sortStudentsByMediumScoreFromHigh(List<Student> students);
    void sortStudentsByMediumScoreFromLow(List<Student> students);


}

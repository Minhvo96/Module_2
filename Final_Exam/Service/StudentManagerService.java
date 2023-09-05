package Service;

import Model.Student;
import Utils.FileUtils;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class StudentManagerService implements IStudentManagerService {
    private String fileName = "D:\\CodeGym_Module\\Final_Exam\\Data\\Student.csv";

    public List<Student> getAllStudents() {
        return FileUtils.readFile(fileName);
    }
    public Student findStudentById(long idStudent, List<Student> students){
        for(Student s : students){
            if(s.getStudentID() == idStudent){
                return s;
            }
        }
        return null;
    }
    public void updateStudentById(long idStudent, Student student, List<Student> students) {
        for (Student s : students) {
            if (s.getStudentID() == idStudent) {
                s.setName(student.getName());
                s.setAge(student.getAge());
                s.setEgender(student.getEgender());
                s.setAddress(student.getAddress());
                s.setMediumScore(student.getMediumScore());
            }
        }
    }
    public void deleteStudentById(long idStudent, List<Student> students){
        for(int i = 0; i < students.size(); i++){
            if(students.get(i).getStudentID() == idStudent){
                students.remove(i);
                break;
            }
        }
    }
    public void addStudent(Student student, List<Student> students){
        students.add(student);
    }
    public void sortStudentsByMediumScoreFromHigh(List<Student> students) {
        Collections.sort(students, new Comparator<Student>() {
            @Override
            public int compare(Student s1, Student s2) {
                if (s1.getMediumScore() > s2.getMediumScore()) {
                    return -1;
                } else if (s1.getMediumScore() < s2.getMediumScore()) {
                    return 1;
                } else {
                    return 0;
                }
            }
        });
    }
    public void sortStudentsByMediumScoreFromLow(List<Student> students) {
        Collections.sort(students, new Comparator<Student>() {
            @Override
            public int compare(Student s1, Student s2) {
                if (s1.getMediumScore() < s2.getMediumScore()) {
                    return -1;
                } else if (s1.getMediumScore() > s2.getMediumScore()) {
                    return 1;
                } else {
                    return 0;
                }
            }
        });
    }


}

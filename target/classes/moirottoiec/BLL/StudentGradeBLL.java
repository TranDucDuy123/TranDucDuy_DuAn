/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package moirottoiec.BLL;

import java.util.List;
import moirottoiec.DAL.StudentGradeDAL;
import moirottoiec.DTO.StudentGrade;

/**
 *
 * @author Duy
 */
public class StudentGradeBLL {
    private StudentGradeDAL studentDAL;
    public StudentGradeBLL(){
        studentDAL = new StudentGradeDAL();
}
    public List<StudentGrade> getAllStudentGrade(){
        return studentDAL.getALLStudentGrade();
    }
    public List<StudentGrade> findStudentGrade(String keyword){
        return studentDAL.findStudentGrade(keyword);
    }
}

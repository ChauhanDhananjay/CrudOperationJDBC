package Controller;

import DAO.StudentDAO;

public class StudentController {
    private StudentDAO dao = new StudentDAO();
    public void addStudent(int id,String name,int age){
        if (dao.insertStudent(id, name, age)) {
            System.out.println("Student inserted successfully");
        } else {
            System.out.println("Insert failed");
        }
    }
    public void viewAllStudents() {
        dao.viewAllStudents();
    }
    public void viewStudentById(int id) {
        if (!dao.viewStudentById(id)) {
            System.out.println("Student not found with ID " + id);
        }
    }
    public void updateStudent(int id, String name, int age) {
        if (dao.updateStudentById(id, name, age)) {
            System.out.println("Student updated successfully");
        } else {
            System.out.println("Student not found");
        }
    }
    public void deleteStudent(int id) {
        if (dao.deleteStudentById(id)) {
            System.out.println("Student deleted successfully");
        } else {
            System.out.println("Student not found");
        }
    }

}

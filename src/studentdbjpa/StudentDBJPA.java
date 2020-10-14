/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studentdbjpa;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author black
 */
public class StudentDBJPA {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Student emp1 = new Student(1, "John", 3.5);
       Student emp2 = new Student(2, "Marry", 4.0);
       StudentTable.insertStudent(emp1);
       StudentTable.insertStudent(emp2);
       //Student emp;
       //emp = StudentTable.findStudentById(1);
       //if (emp != null) {
       //    emp.setName("Jack");
           //StudentTable.removeStudent(emp);
       //    StudentTable.updateStudent(emp);
       //}
       //List<Employee> empList = EmployeeTable.findEmployeeByName("Marry"); 
       List<Student> empList = StudentTable.findAllStudent();
       printAllEmployee(empList);
    }
    public static void printAllEmployee(List<Student> employeeList) {
        for(Student emp : employeeList) {
           System.out.print(emp.getId() + " ");
           System.out.print(emp.getName() + " ");
           System.out.println(emp.getGpa()+ " ");
       }
    }

    public void persist(Object object) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("StudentDBJPAPU");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        try {
            em.persist(object);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
    }
    
}

package kz.daru.demo;

import kz.daru.demo.db.Database;
import kz.daru.demo.model.Employee;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws SQLException {
        Database db = new Database();

        /*Employee employee = new Employee();
        employee.setName("Yerke");
        employee.setEmail("yeyesenov@dar.io");

        Employee employee2 = new Employee();
        employee2.setName("Zhasulan");
        employee2.setEmail("zhasulan@dar.io");

        Employee employee3 = new Employee();
        employee3.setName("Damir");
        employee3.setEmail("damir@dar.io");

        Employee employee4 = new Employee();
        employee4.setName("Zhazira");
        employee4.setEmail("zhazira@dar.io");



        db.createEmployee(employee);
        db.createEmployee(employee2);
        db.createEmployee(employee3);
        db.createEmployee(employee4);*/

        //Employee employee = db.getEmloyeeByName("Zhazira");
        //System.out.println(employee.getEmail() + "; name: " + employee.getName());

        List<Employee> employees = db.getEmloyeeByEmailDomen("@dar.kz");
        for (Employee e: employees) {
            System.out.println(e.getEmail() + "; name: " + e.getName());
        }


        System.out.println("Finish");
    }

}

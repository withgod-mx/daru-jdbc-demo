package kz.daru.demo.db;

import kz.daru.demo.model.Employee;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Database {

    public Connection connection() throws SQLException, ClassNotFoundException {
        String url = "jdbc:postgresql://127.0.0.1:5432/daru_test"; // *
        String name = "postgres";
        String password = "admin";

        Class.forName("org.postgresql.Driver");
        Connection connection = DriverManager.getConnection(url, name, password);
        return connection;
    }

    public boolean createEmployee(Employee employee) throws SQLException {
        Statement statement = null;
        try {
            statement = connection().createStatement();

            // INSERT INTO имя_таблицы (столбец1, столбец2, ... столбецN)
            //VALUES (значение1, значение2, ... значениеN)

            return statement.execute("insert into employee (name, email) VALUES ('" + employee.getName() + "', '" + employee.getEmail() + "')");


        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } finally {
            statement.close();
        }
    }

    public Employee getEmloyeeByName(String name) throws SQLException {
        Employee employee = new Employee();
        Statement st = null;
        ResultSet rs = null;
        try {
            st = connection().createStatement();
            rs = st.executeQuery("select id, name, email from employee where name = '" + name + "'");
            if (rs.next()) {
                employee.setId(rs.getInt("id"));
                employee.setName(rs.getString("name"));
                employee.setEmail(rs.getString("email"));
            }
            rs.close();
            st.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } finally {
            st.close();
            rs.close();
        }

        return employee;
    }


    public List<Employee> getEmloyeeByEmailDomen(String d) throws SQLException {
        List<Employee> employes = new ArrayList<>();
        Statement st = null;
        ResultSet rs = null;
        try {
            st = connection().createStatement();
            rs = st.executeQuery("select id, name, email from employee where email like '%@dar.io'");
            while (rs.next()) {
                Employee employee = new Employee();
                employee.setId(rs.getInt("id"));
                employee.setName(rs.getString("name"));
                employee.setEmail(rs.getString("email"));
                employes.add(employee);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } finally {
            st.close();
            rs.close();
        }

        return employes;
    }


}

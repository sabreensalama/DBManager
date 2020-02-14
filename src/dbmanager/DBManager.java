/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbmanager;

import com.mysql.cj.x.protobuf.MysqlxSql;
import java.sql.*;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author hp
 */
public class DBManager {

    ResultSet rs;
    Statement stmt;
    int count;
    Vector<Employee> emp;

    String query;

    private Connection conn;

    public DBManager() {
        emp = new Vector<Employee>();
        count = 0;
        try {

            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee?useSSL=false&serverTimezone=UTC", "root", "");
            stmt = conn.createStatement();
            query = new String("SELECT * FROM emplyeetable");
            rs = stmt.executeQuery(query);
            while (rs.next()) {
                Employee employee = new Employee(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6));
                emp.add(employee);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

    }

    Employee firstEmployee() {
        count = 0;
        return emp.get(count);

    }

    Employee lastEmployee() {
        count = emp.size() - 1;

        return emp.get(count);

    }

    Employee nextEmployee() {
        if (count < emp.size() - 1) {
            count++;
        }
        return emp.get(count);
    }

    Employee previousEmployee() {
        if (count > 0) {
            count--;
        }
        return emp.get(count);
    }

    void insertEmployee(int id, String f, String m, String l, String email, String phone) {
        Employee em = new Employee(id, f, m, l, email, phone);
        emp.add(em);
        try {
            PreparedStatement stmt = conn.prepareStatement("INSERT INTO emplyeetable VALUES (?,?,?,?,?,?)");
            stmt.setInt(1, id);
            stmt.setString(2, f);
            stmt.setString(3, m);
            stmt.setString(4, l);
            stmt.setString(5, email);
            stmt.setString(6, phone);
            int num = stmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DBManager.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    Employee deleteEmployee() {

        int id = emp.get(count).getId();
        emp.remove(count);
        PreparedStatement stmt;
        try {
            stmt = conn.prepareStatement("DELETE FROM emplyeetable WHERE id=?");
            stmt.setInt(1, id);
            int num = stmt.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(DBManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (count < emp.size() - 2) {
            return nextEmployee();
        } else {
            return previousEmployee();
        }
    }

    void UpdateEmployee(int id, String f, String m, String l, String email, String phone) {
        emp.get(count).setId(id);
        emp.get(count).setFirstName(f);
        emp.get(count).setFirstName(m);
        emp.get(count).setFirstName(l);
        emp.get(count).setFirstName(email);
        emp.get(count).setFirstName(phone);
        try {
            PreparedStatement stmt = conn.prepareStatement("UPDATE  emplyeetable SET firstname=?,middle=?,lastname=?,email=?,phone=? WHERE id =?");

            stmt.setString(1, f);
            stmt.setString(2, m);
            stmt.setString(3, l);
            stmt.setString(4, email);
            stmt.setString(5, phone);
            stmt.setString(6, Integer.toString(emp.get(count).getId()));

            stmt.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(DBManager.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}

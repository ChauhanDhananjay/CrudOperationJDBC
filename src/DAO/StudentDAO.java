package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import Connection.Connect;

public class StudentDAO {
    private static final String INSERT =
            "INSERT INTO students (id, name, age) VALUES (?, ?, ?)";
    private static final String SELECT_ALL =
            "SELECT * FROM students";
    private static final String SELECT_BY_ID =
            "SELECT * FROM students WHERE id = ?";
    private static final String UPDATE_BY_ID =
            "UPDATE students SET name = ?, age = ? WHERE id = ?";
    private static final String DELETE_BY_ID =
            "DELETE FROM students WHERE id = ?";

    public boolean insertStudent(int id, String name, int age) {
        try (Connection conn = Connect.createConnection();
             PreparedStatement ps = conn.prepareStatement(INSERT)) {

            ps.setInt(1, id);
            ps.setString(2, name);
            ps.setInt(3, age);

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

    public void viewAllStudents() {
        try (Connection conn = Connect.createConnection();
             PreparedStatement ps = conn.prepareStatement(SELECT_ALL);
             ResultSet rs = ps.executeQuery()) {

            if (!rs.next()) {
                System.out.println("No students found");
                return;
            }

            System.out.println("ID\tName\tAge");
            System.out.println("--------------------");

            do {
                System.out.println(
                        rs.getInt("id") + "\t" +
                                rs.getString("name") + "\t" +
                                rs.getInt("age"));
            } while (rs.next());

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public boolean viewStudentById(int id) {
        try (Connection conn = Connect.createConnection();
             PreparedStatement ps = conn.prepareStatement(SELECT_BY_ID)) {

            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (!rs.next()) {
                return false;
            }

            System.out.println("ID\tName\tAge");
            System.out.println("--------------------");
            System.out.println(
                    rs.getInt("id") + "\t" +
                            rs.getString("name") + "\t" +
                            rs.getInt("age"));
            return true;

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

    public boolean updateStudentById(int id, String name, int age) {
        try (Connection conn = Connect.createConnection();
             PreparedStatement ps = conn.prepareStatement(UPDATE_BY_ID)) {

            ps.setString(1, name);
            ps.setInt(2, age);
            ps.setInt(3, id);

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

    public boolean deleteStudentById(int id) {
        try (Connection conn = Connect.createConnection();
             PreparedStatement ps = conn.prepareStatement(DELETE_BY_ID)) {

            ps.setInt(1, id);
            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return false;
    }
}

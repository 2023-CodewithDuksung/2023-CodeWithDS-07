package com.example.hackathon07.repository.userrepository;

import com.example.hackathon07.domain.User;
import org.springframework.jdbc.datasource.DataSourceUtils;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class MysqlUserRepository {
//    private final DataSource dataSource;
//
//    public MysqlUserRepository(DataSource dataSource) {
//        this.dataSource = dataSource;
//    }
//
//    @Override
//    public User save(User user) {
//        String sql = "insert into member(name) values(?)";
//
//        Connection conn = null;
//        PreparedStatement pstmt = null;
//        ResultSet rs = null;
//
//        try {
//            conn = getConnection();
//
//            pstmt = conn.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
//            pstmt.setLong(1, user.getUser_id());
//
//            pstmt.executeUpdate();
//            rs = pstmt.getGeneratedKeys();
//
//            if (rs.next()) {
//                user.setUser_id(rs.getLong(1));
//            } else {
//                throw new SQLException("Failed to retrieve generated ID");
//            }
//            return user;
//        } catch (Exception e) {
//            throw new IllegalStateException(e);
//        } finally {
//            close(conn, pstmt, rs);
//        }
//    }
//
//    @Override
//    public Optional<User> findById(Long user_id) {
//        String sql = "select * from member where id = ?";
//
//        Connection conn = null;
//        PreparedStatement pstmt = null;
//        ResultSet rs = null;
//
//        try {
//            conn = getConnection();
//            pstmt = conn.prepareStatement(sql);
//            pstmt.setLong(1, user_id);
//            rs = pstmt.executeQuery();
//            if (rs.next()) {
//                User user = new User();
//                user.setUser_id(rs.getLong("USER_ID"));
//                user.setUserName(rs.getString("USER_NAME"));
//                return Optional.of(user);
//            } else {
//                return Optional.empty();
//            }
//        } catch (Exception e) {
//            throw new IllegalStateException(e);
//        } finally {
//            close(conn, pstmt, rs);
//        }
//    }
//
//    @Override
//    public List<User> findAll() {
//        String sql = "select * from member";
//
//        Connection conn = null;
//        PreparedStatement pstmt = null;
//        ResultSet rs = null;
//
//        try {
//            conn = getConnection();
//            pstmt = conn.prepareStatement(sql);
//            rs = pstmt.executeQuery();
//            List<User> members = new ArrayList<>();
//
//            while (rs.next()) {
//                User user = new User();
//                user.setUser_id(rs.getLong("USER_ID"));
//                user.setUserName(rs.getString("USER_NAME"));
//                members.add(user);
//            }
//            return user;
//        } catch (Exception e) {
//            throw new IllegalStateException(e);
//        } finally {
//            close(conn, pstmt, rs);
//        }
//    }
//
//    @Override
//    public Optional<User> findByName(String userName) {
//        String sql = "select * from member where name = ?";
//
//        Connection conn = null;
//        PreparedStatement pstmt = null;
//        ResultSet rs = null;
//
//        try {
//            conn = getConnection();
//            pstmt = conn.prepareStatement(sql);
//            pstmt.setString(1, userName);
//            rs = pstmt.executeQuery();
//
//            if (rs.next()) {
//                User user = new User();
//                user.setUser_id(rs.getLong("USER_ID"));
//                user.setUserName(rs.getString("USER_NAME"));
//                return Optional.of(user);
//            }
//            return Optional.empty();
//        } catch (Exception e) {
//            throw new IllegalStateException(e);
//        } finally {
//            close(conn, pstmt, rs);
//        }
//    }
//
//    private Connection getConnection() {
//        return DataSourceUtils.getConnection(dataSource);
//    }
//
//    private void close(Connection conn, PreparedStatement pstmt, ResultSet rs) {
//        try {
//            if (rs != null) {
//                rs.close();
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        try {
//            if (pstmt != null) {
//                pstmt.close();
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        try {
//            if (conn != null) {
//                close(conn);
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }
//    private void close(Connection conn) throws SQLException {
//        DataSourceUtils.releaseConnection(conn, dataSource);
//    }
}


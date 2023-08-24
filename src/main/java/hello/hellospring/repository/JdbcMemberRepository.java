package hello.hellospring.repository;

import hello.hellospring.domain.Member;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.datasource.DataSourceUtils;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import static org.springframework.jdbc.datasource.DataSourceUtils.getConnection;

public class JdbcMemberRepository implements MemberRepository {
    private final DataSource dataSource;
    private final JdbcTemplate jdbcTemplate;
    private final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public JdbcMemberRepository(DataSource dataSource) {
        this.dataSource = dataSource;
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public Member save(Member member) {
        // SQL 문
        String sql = "insert into Users(User_Name, Password_Hash) values(?, ?)";

        jdbcTemplate.update(connection -> {
            PreparedStatement pstmt = connection.prepareStatement(sql, new String[]{"User_ID"});
            pstmt.setString(1, member.getUserName());
            pstmt.setString(2, member.getPasswordHash());
            return pstmt;
        });

        return member;
    }

    @Override
    public List<Member> findAll() {
        String sql = "select * from Users";

        List<Member> members = jdbcTemplate.query(sql, memberRowMapper());

        return members;
    }

    @Override
    public Optional<Member> findByStudentNumber(Integer studentNumber) {
        String sql = "select * from Users where Student_Number = ?";

        List<Member> members = jdbcTemplate.query(sql, memberRowMapper(), studentNumber);

        if (!members.isEmpty()) {
            return Optional.of(members.get(0));
        }
        return Optional.empty();
    }



    @Override
    public boolean authenticate(Integer studentNumber, String password) {
        String sql = "select * from Users where Student_Number = ?";

        List<Member> members = jdbcTemplate.query(sql, memberRowMapper(), studentNumber);

        if (!members.isEmpty()) {
            Member member = members.get(0);
            return passwordEncoder.matches(password, member.getPasswordHash());
        }
        return false;
    }

    @Override
    public Optional<Member> findByUserName(String userName) {
        String sql = "select * from Users where User_Name = ?";

        List<Member> members = jdbcTemplate.query(sql, memberRowMapper(), userName);

        return members.stream().findAny();
    }

    private RowMapper<Member> memberRowMapper() {
        return (rs, rowNum) -> {
            Member member = new Member();
            member.setUser_id(rs.getLong("User_ID"));
            member.setUserName(rs.getString("User_Name"));
            member.setPasswordHash(rs.getString("Password_Hash"));
            member.setStudentNumber(rs.getInt("Student_Number"));
            member.setLevel(rs.getInt("Level"));
            return member;
        };
    }

    @Override
    public Optional<Member> findByUser_id(Long user_id) {
        String sql = "select * from Users where User_ID = ?";

        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            conn = getConnection(dataSource);
            pstmt = conn.prepareStatement(sql);
            pstmt.setLong(1, user_id);
            rs = pstmt.executeQuery();
            if (rs.next()) {
                Member member = new Member();
                member.setUser_id(rs.getLong("User_ID"));
                member.setUserName(rs.getString("User_Name"));
                return Optional.of(member);
            } else {
                return Optional.empty();
            }
        } catch (Exception e) {
            throw new IllegalStateException(e);
        } finally {
            close(conn, pstmt, rs);
        }
    }

    private void close(Connection conn, PreparedStatement pstmt, ResultSet rs) {
        try {
            if (rs != null) {
                rs.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            if (pstmt != null) {
                pstmt.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            if (conn != null) {
                close(conn);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void close(Connection conn) throws SQLException {
        DataSourceUtils.releaseConnection(conn, dataSource);
    }


}

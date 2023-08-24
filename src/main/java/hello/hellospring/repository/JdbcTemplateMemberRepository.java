package hello.hellospring.repository;

import hello.hellospring.domain.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class JdbcTemplateMemberRepository implements MemberRepository {
    /**
     * JdbcTemplate : Injection을 받을 수 있는 것 아님
     * DataSource가 필요
     */
    private final JdbcTemplate jdbcTemplate;
    private final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    /**
     * 생성자 1개 -> 스프링 빈으로 등록되면 Autowired 생략 가능
     */
    @Autowired
    public JdbcTemplateMemberRepository(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public Member save(Member member) {
        SimpleJdbcInsert jdbcInsert = new SimpleJdbcInsert(jdbcTemplate);
        jdbcInsert.withTableName("Users").usingGeneratedKeyColumns("user_id");

        Map<String, Object> parameters = new HashMap<>();
        parameters.put("User_Name", member.getUserName());

        Number key = jdbcInsert.executeAndReturnKey(new MapSqlParameterSource(parameters));
        member.setUser_id(key.longValue());
        return member;
    }


    // JdbcTemplateMemberRepository 클래스의 findByUser_id 메서드 수정
    @Override
    public Optional<Member> findByUser_id(Long user_id) {
        List<Member> result = jdbcTemplate.query("select * from Users where User_ID = ?", memberRowMapper(), user_id);
        return result.stream().findAny();
    }

    @Override
    public Optional<Member> findByUserName(String userName) {
        List<Member> result = jdbcTemplate.query("select * from Users where User_Name = ?", memberRowMapper(), userName);
        return result.stream().findAny();
    }

    @Override
    public Optional<Member> findByStudentNumber(Integer studentNumber) {
        List<Member> result = jdbcTemplate.query("select * from Users where Student_Number = ?", memberRowMapper(), studentNumber);
        return result.stream().findAny();
    }

    @Override
    public boolean authenticate(Integer studentNumber, String password) {
        Optional<Member> memberOptional = findByStudentNumber(studentNumber);
        if (memberOptional.isPresent()) {
            Member member = memberOptional.get();
            return validatePassword(password, member.getPasswordHash());
        }
        return false;
    }

    private boolean validatePassword(String inputPassword, String storedPasswordHash) {
        return passwordEncoder.matches(inputPassword, storedPasswordHash);
    }

    @Override
    public List<Member> findAll() {
        return jdbcTemplate.query("select * from Users", memberRowMapper());
    }

    private RowMapper<Member> memberRowMapper() {
        return (rs, rowNum) -> {
            Member member = new Member();
            member.setUser_id(rs.getLong("User_ID"));
            member.setUserName(rs.getString("User_Name"));
            return member;
        };
    }

//    private RowMapper<Member> memberRowMapper() {
//        return new RowMapper<Member>() {
//            @Override
//            public Member mapRow(ResultSet rs, int rowNum) throws SQLException {
//                Member member = new Member();
//                member.setId(rs.getLong("id"));
//                member.setName(rs.getString("name"));
//                return member;
//            }
//        }
//    }
}

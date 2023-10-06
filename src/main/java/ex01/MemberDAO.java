package ex01;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MemberDAO {

    // private Statement stmt;
    private PreparedStatement pstmt;
    private Connection con;

    public List<MemberVO> listMembers(){
        List<MemberVO> list = new ArrayList<MemberVO>();
        try {
            connDB();
            String query = "select * from t_member";

            System.out.println("prepareStatememt : " + query);
            pstmt = con.prepareStatement(query);
            ResultSet rs = pstmt.executeQuery(query);

            while(rs.next()){
                String id = rs.getString("id");
                String pwd = rs.getString("pwd");
                String name = rs.getString("name");
                String email = rs.getString("email");
                Date joinDate = rs.getDate("joinDate");
                MemberVO vo = new MemberVO();
                vo.setId(id);
                vo.setPwd(pwd);
                vo.setName(name);
                vo.setEmail(email);
                vo.setJoinDate(joinDate);
                list.add(vo);
            }
            rs.close();
            pstmt.close();
            con.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return list;
    }

    public void addMember(MemberVO vo){
        try {
            connDB();
            String id = vo.getId();
            String pwd = vo.getPwd();
            String name = vo.getName();
            String email = vo.getEmail();

            String query = "insert into t_member";
            query += "(id, pwd, name, email)";
            query += "values(?,?,?,?)";
            pstmt = con.prepareStatement(query);
            pstmt.setString(1, id);
            pstmt.setString(2, pwd);
            pstmt.setString(3, name);
            pstmt.setString(4, email);
            pstmt.executeUpdate();
            pstmt.close();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


    public void delMember(String id){
        try {
            connDB();
            String query = "delete from t_member" + "where id = ?";
            pstmt = con.prepareStatement(query);
            pstmt.setString(1, id);
            pstmt.executeUpdate();
            pstmt.close();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


    private void connDB(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/JSP";
            String user = "JSP";
            String pwd = "JSP";
            System.out.println("mysql 드라이버 로딩 성공");
            con = DriverManager.getConnection(url, user, pwd);
            System.out.println("connection 생성 성공");
//            stmt = con.createStatement();
//            System.out.println("Statement 생성 성공");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}

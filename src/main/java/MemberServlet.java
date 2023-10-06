import ex01.MemberDAO;
import ex01.MemberVO;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.List;

@WebServlet("/member")
public class MemberServlet extends HttpServlet {

    @Override
    public void init() throws ServletException {
        super.init();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        MemberDAO dao = new MemberDAO();
        List<MemberVO> list = dao.listMembers();
        out.print("<html><body>");
        out.println("<table border=1><tr align='center' bgcolor=lightgreen'>");
        out.println("<td>아이디</td><td>비밀번호</td><td>이름</td><td>이메일</td><td>가입일</td></tr>");

        for (int i = 0; i < list.size(); i++) {
            MemberVO vo = (MemberVO) list.get(i);
            String id = vo.getId();
            String pwd = vo.getPwd();
            String name = vo.getName();
            String email = vo.getEmail();
            Date joinDate = vo.getJoinDate();
            out.println("<tr><td>" + id + "</td><td>" + pwd + "</td><td>"
            + name + "</td><td>" + email + "</td><td>" + joinDate + "</td></tr>");
        }
        out.println("</table></body></html>");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}

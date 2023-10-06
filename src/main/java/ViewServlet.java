import ex01.MemberVO;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.List;

@WebServlet("/viewMembers")
public class ViewServlet extends HttpServlet {

    @Override
    public void init() throws ServletException {
        super.init();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        List memberList = (List) request.getAttribute("membersList");
        System.out.println("viewServlet");
        out.println("<html><body>");
        out.println("<table border=1> <tr align='center' bgcolor='lightgreen'>");
        out.println("<td>아이디</td><td>비밀번호</td><td>이름</td><td>이메일</td><td>가입일</td><td>삭제</td></tr>");
        for (int i = 0; i < memberList.size(); i++) {
            MemberVO vo = (MemberVO) memberList.get(i);
            String id = vo.getId();
            String pwd = vo.getPwd();
            String name = vo.getName();
            String email = vo.getEmail();
            Date joinDate = vo.getJoinDate();
            out.print("<tr><td>" + id + "</td><td>" + pwd + "</td><td>"
                    + name + "</td><td>" + email + "</td><td>" + joinDate + "</td><td>"
                    + "<a href='/member2?command=delMember&id=" + id + "'>삭제</a></td></tr>");
        }
        out.println("</table></body></html>");
        out.println("<a href='/memberForm.html'>새 회원 등록하기</a>");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}

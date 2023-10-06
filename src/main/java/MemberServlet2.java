import ex01.MemberDAO;
import ex01.MemberVO;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.List;

@WebServlet("/member2")
public class MemberServlet2 extends HttpServlet {

    @Override
    public void init() throws ServletException {
        super.init();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        MemberDAO dao = new MemberDAO();
        PrintWriter out = response.getWriter();
        String command = request.getParameter("command");
        System.out.println("command" + command);
        if (command != null && command.equals("addMember")) {
            String id = request.getParameter("id");
            String pwd = request.getParameter("pwd");
            String name = request.getParameter("name");
            String email = request.getParameter("email");
            MemberVO vo = new MemberVO();
            vo.setId(id);
            vo.setPwd(pwd);
            vo.setName(name);
            vo.setEmail(email);
            dao.addMember(vo);
        } else if (command != null && command.equals("delMember")) {
            String id = request.getParameter("id");
            dao.delMember(id);
        }
        List<MemberVO> list = dao.listMembers();
        out.println("<html><body>");
        out.println("<table border=1> <tr align='center' bgcolor='lightgreen'>");
        out.println("<td>아이디</td><td>비밀번호</td><td>이름</td><td>이메일</td><td>가입일</td><td>삭제</td></tr>");
        for (int i = 0; i < list.size(); i++) {
            MemberVO vo = (MemberVO) list.get(i);
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
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        MemberDAO dao = new MemberDAO();
        PrintWriter out = response.getWriter();
        String command = request.getParameter("command");
        System.out.println("command" + command);
        if (command != null && command.equals("addMember")) {
            String id = request.getParameter("id");
            String pwd = request.getParameter("pwd");
            String name = request.getParameter("name");
            String email = request.getParameter("email");
            MemberVO vo = new MemberVO();
            vo.setId(id);
            vo.setPwd(pwd);
            vo.setName(name);
            vo.setEmail(email);
            dao.addMember(vo);
        } else if (command != null && command.equals("delMember")) {
            String id = request.getParameter("id");
            dao.delMember(id);
        }
        List<MemberVO> list = dao.listMembers();
        out.println("<html><body>");
        out.println("<table border=1> <tr align='center' bgcolor='lightgreen'>");
        out.println("<td>아이디</td><td>비밀번호</td><td>이름</td><td>이메일</td><td>가입일</td><td>삭제</td></tr>");
        for (int i = 0; i < list.size(); i++) {
            MemberVO vo = (MemberVO) list.get(i);
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
}

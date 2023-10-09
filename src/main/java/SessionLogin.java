import ex01.MemberDAO;
import ex01.MemberVO;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/login8")
public class SessionLogin extends HttpServlet {

    @Override
    public void init() throws ServletException {
        super.init();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        String user_id = request.getParameter("user_id");
        String user_pw = request.getParameter("user_pw");
        MemberVO vo = new MemberVO();
        System.out.println("doPost : " + user_id + "," + user_pw);
        vo.setId(user_id);
        vo.setPwd(user_pw);
        MemberDAO dao = new MemberDAO();
        boolean result = dao.isEisted(vo);

        if (result){
            HttpSession session = request.getSession();
            session.setAttribute("isLogon", true);
            session.setAttribute("login.id", user_id);
            session.setAttribute("login.pwd", user_pw);
            out.println("<html><body>");
            out.println("안녕하세요. " + user_id + "님 !! <br>");
            out.println("<a href='show'>회원정보보기</a>");
            out.println("</body></html>");
        } else {
            out.println("<html><body><center>회원 아이디가 틀립니다.");
            out.println("<a href='login3.html'>다시 로그인하기</a>");
            out.println("</body></html>");
        }

    }
}

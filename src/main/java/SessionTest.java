import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/sess")
public class SessionTest extends HttpServlet {

    @Override
    public void init() throws ServletException {
        super.init();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        HttpSession session = request.getSession();
        out.println("세션 아이디 : " + session.getId() + "<br>");
        out.println("최초 세션 생성 시각 : " + session.getCreationTime() + "<br>");
        out.println("최근 세션 접근 시각 : " + session.getLastAccessedTime() + "<br>");
        out.println("기본 유효 시간 : " + session.getMaxInactiveInterval() + "<br>");
        session.setMaxInactiveInterval(5); // 유효 시간을 5초로 설정
        out.println("세션 유효 시간 : " + session.getMaxInactiveInterval() + "<br>");
        if (session.isNew()) {
            out.println("새 세션이 만들어졌습니다.");
        }
        session.invalidate(); // 세션 삭제
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}

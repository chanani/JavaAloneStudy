import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;
import java.util.Date;

@WebServlet("/set")
public class SetCookieValue extends HttpServlet {

    @Override
    public void init() throws ServletException {
        super.init();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        Date d = new Date();
        Cookie c = new Cookie("CookieTest", URLEncoder.encode("JSP프로그래밍입니다.", "utf-8"));
        // c.setMaxAge(24*60*60);
        c.setMaxAge(-1);
        response.addCookie(c);
        out.println("현재시간 : " + d);
        out.println("문자열을 cookie에 저장합니다.");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}

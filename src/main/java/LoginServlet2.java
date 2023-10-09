import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/login2")
public class LoginServlet2 extends HttpServlet {

    @Override
    public void init() throws ServletException {
        super.init();
        System.out.println("init login2");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        String id = request.getParameter("user_id");
        String pw = request.getParameter("user_pw");

        String data = "<html>";
        data += "<body>";
        data += "아이디 : " + id;
        data += "<br/>";
        data += "패스워드 : " + pw;
        data += "</body>";
        data += "</html>";
        out.print(data);

    }

    @Override
    public void destroy() {
        super.destroy();
        System.out.println("destroy 메서드 호출");
    }
}

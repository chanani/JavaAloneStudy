import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/login5")
public class LoginServlet5 extends HttpServlet {

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
        String id = request.getParameter("user_id");
        String pw = request.getParameter("user_pw");
        String address = request.getParameter("user_address");

        String data = "<html>";
        data += "<body>";
        data += "아이디 : " + id;
        data += "<br/>";
        data += "패스워드 : " + pw;
        data += "<br/>";
        data += "주소 : " + address;
        data += "<br/>";
        data += "<a href='http://localhost:8090/login2.html'>로그인 창으로 이동</a>";
        data += "</body>";
        data += "</html>";
        out.print(data);
    }

    @Override
    public void destroy() {
        super.destroy();
        System.out.println("destroy 실행");
    }
}

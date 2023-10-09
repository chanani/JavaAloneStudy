import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/show")
public class ShowMember extends HttpServlet {

    @Override
    public void init() throws ServletException {
        super.init();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        String id = "", pwd = "";
        Boolean isLogon = false;
        HttpSession session = request.getSession(false);
        if (session != null) {
            isLogon = (Boolean) session.getAttribute("isLogon");
            if (isLogon == true) {
                id = (String) session.getAttribute("login.id");
                pwd = (String) session.getAttribute("login.pwd");
                out.println("<html><body>");
                out.println("아이디 : " + id + "<br>");
                out.println("비밀번호 : " + pwd + "<br>");
                out.println("</body></html>");
            } else {
                response.sendRedirect("login3.html");
            }
        } else {
            response.sendRedirect("login3.html");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}

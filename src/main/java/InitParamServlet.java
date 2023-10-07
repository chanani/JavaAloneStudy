import javax.servlet.*;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "InitParamServlet",
            urlPatterns = {"/sInit", "/sInit2"},
            initParams = {
                    @WebInitParam(name="email", value="admin@jweb.com"),
                    @WebInitParam(name="tel", value="010-1111-2222")
            })
public class InitParamServlet extends HttpServlet {

    @Override
    public void init() throws ServletException {
        super.init();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        String email = getInitParameter("email");
        String tel = getInitParameter("tel");
        out.println("<html><body>");
        out.println("<table><tr>");
        out.println("<td>email : </td><td>" + email + "</td></tr>");
        out.println("<tr><td>전화번호 : </td><td>" + tel + "</td></tr>");
        out.println("</table></body></html>");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}

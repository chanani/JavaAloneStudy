import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/second")
public class SecondServlet extends HttpServlet {

    @Override
    public void init() throws ServletException {
        super.init();
        System.out.println("init 실행");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        // String name = request.getParameter("name");
        // String name = (String) request.getSession().getAttribute("name"); // redirect 포워딩 시 바인딩
        String name = (String) request.getAttribute("name");

        out.println("<html><body>");
        // out.println("sendRedirect를 이용한 실습");
        // out.println("refresh를 이용 이용한 redirect 실습");
        out.println("name : " + name);
        out.println("</body></html>");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}

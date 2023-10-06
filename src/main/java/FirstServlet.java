import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

public class FirstServlet extends HttpServlet {
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
        out.println("<h1>hello worldzzz<h1>");
        // response.sendRedirect("/second?name=lee"); // redirect를 이용한 서블릿 전달
        // response.addHeader("Refresh", "1;url=second"); // Refresh를 통한 redirect 전달
        // RequestDispatcher dispatcher = request.getRequestDispatcher("/second?name=chan"); // RequestDispatcher을 통한 get방식 전달
        // dispatcher.forward(request,response);
        // request.getSession().setAttribute("name", "lee"); // redirect 포워딩 시 바인딩
        // response.sendRedirect("second");
        request.setAttribute("name","chan"); // dispatch 포워딩 시 바인딩
        RequestDispatcher dispatcher = request.getRequestDispatcher("second"); // RequestDispatcher을 통한 get방식 전달
        dispatcher.forward(request,response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}

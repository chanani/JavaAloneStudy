import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/gugutest")
public class GuguTest extends HttpServlet {

    @Override
    public void init() throws ServletException {
        super.init();
        System.out.println("gugu init");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        int dan = Integer.parseInt(request.getParameter("dan"));
        out.print("<table border=1 width=800 align=center>");
        out.print("<tr align=center bgcolor='#FFFF66'>");
        out.print("<td colspan=2>" + dan + "단 출력 </td>");
        out.print("</tr>");
        for (int i = 1; i < 10; i++) {
            out.print("<tr align=center>");
            out.print("<td width=400>");
            out.print(dan + " * " + i);
            out.print("</td>");
            out.print("<td width=400>");
            out.print(i * dan);
            out.print("</td>");
            out.print("</tr>");
        }
        out.println("</table>");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}

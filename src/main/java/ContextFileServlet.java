import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.*;
import java.util.StringTokenizer;

@WebServlet("/cfile")
public class ContextFileServlet extends HttpServlet {

    @Override
    public void init() throws ServletException {
        super.init();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        ServletContext context = getServletContext();
        InputStream is = context.getResourceAsStream("/WEB-INF/bin/init.txt");
        BufferedReader buffer = new BufferedReader(new InputStreamReader(is));

        String menu = null;
        String menu_member = null;
        String menu_order = null;
        String menu_goods = null;
        while((menu=buffer.readLine()) != null){
            StringTokenizer tokens = new StringTokenizer(menu, ",");
            menu_member = tokens.nextToken();
            menu_order = tokens.nextToken();
            menu_goods = tokens.nextToken();
        }
        out.println("<html><body>");
        out.println(menu_member + "<br>");
        out.println(menu_order + "<br>");
        out.println(menu_goods + "<br>");
        out.println("</body></html>");
        out.close();

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}

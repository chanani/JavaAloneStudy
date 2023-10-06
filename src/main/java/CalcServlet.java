import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/calc")
public class CalcServlet extends HttpServlet {

    @Override
    public void init() throws ServletException {
        super.init();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        PrintWriter pw = response.getWriter();
        String command = request.getParameter("command");
        String won = request.getParameter("won");
        String operator = request.getParameter("operator");

        if (command != null && command.equals("calculate")){
            String result = calculate(Float.parseFloat(won), operator);
            pw.println("<html><font size=10>변환결과</font><br>");
            pw.println("<html><font size=10>" + result + "</font><br>");
            pw.println("<a href=/calc>환율 계산기</a>");
            return;
        }

        pw.println("<html><title>환율 계산기</title>");
        pw.println("<font size=5>환율 계산기</font><br>");
        pw.println("<form name='frmCalc' method='get' action='/calc'>");
        pw.println("원화 : <input type='text' name='won' size=10 />");
        pw.println("<select name='operator>");
        pw.println("<option value='dollar'>달러</option>");
        pw.println("<option value='en'>엔화</option>");
        pw.println("<option value='wian'>위안</option>");
        pw.println("<option value='pound'>파운드</option>");
        pw.println("<option value='euro'>유로</option>");
        pw.println("</select>");
        pw.println("<input type='hidden' name='command' value='calculate' />");
        pw.println("<input type='submit' value='변환' />");
        pw.println("</form>");
        pw.println("</html>");
        pw.close();


    }

    private static String calculate(float won, String operator){
        String result = null;
        if (operator.equals("dollar")){
            result = String.format("%.6f",won / 1348);
        }else if (operator.equals("en")){
            result = String.format("%.6f", won / 908);
        } else if (operator.equals("wian")){
            result = String.format("%.6f", won / 184.51);
        } else if (operator.equals("pound")){
            result = String.format("%.6f",won / 1641);
        } else if (operator.equals("euro")){
            result = String.format("%.6f", won / 1420);
        }
        return result;
    }


}

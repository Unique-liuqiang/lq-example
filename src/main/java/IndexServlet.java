import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 */
@WebServlet("/index")
public class IndexServlet extends HttpServlet{
    //private Integer count = 0;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp){
        // System.out.println(++count);
    }
}

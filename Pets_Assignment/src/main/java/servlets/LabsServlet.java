package servlets;

import Dao.LabsDAO;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(urlPatterns = "*.labs")
public class LabsServlet extends HttpServlet {
    private ObjectMapper objectMapper = new ObjectMapper();
    private LabsDAO labsDAO = new LabsDAO();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        try {
            String json = objectMapper.writeValueAsString(labsDAO.viewAll());
            System.out.println(json);
            resp.getWriter().append(json);
            resp.setContentType("application/json");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws IOException {



    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {

    }
    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws IOException {

    }

}

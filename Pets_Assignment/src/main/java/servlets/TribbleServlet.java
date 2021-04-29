package servlets;

import Dao.TribbleDOA;
import com.fasterxml.jackson.databind.ObjectMapper;
import controller.TribbleController;
import model.Tribble;
import service.TribbleService;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(urlPatterns = "*.Tribble")
public class TribbleServlet extends HttpServlet {
    private ObjectMapper objectMapper = new ObjectMapper();
    private TribbleService tribbleService = new TribbleService();
    private TribbleDOA tribbleDOA = new TribbleDOA();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException{

            BufferedReader reader = req.getReader();
            StringBuilder sb = new StringBuilder();

            String line;
            while((line = reader.readLine()) != null){
                sb.append(line);
            }
            String jsonString = sb.toString();

        //String json = null;
        try {
            String json = objectMapper.writeValueAsString(tribbleDOA.viewAll());
            System.out.println(json);
            resp.getWriter().append(json);
            resp.setContentType("application/json");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException{
        Tribble tribble = null;
        BufferedReader reader = req.getReader();
        StringBuilder sb = new StringBuilder();

        String line;
        while((line = reader.readLine()) != null){
            sb.append(line);
        }
        String jsonString = sb.toString();

        tribble = tribbleDOA.addTribble(objectMapper.readValue(jsonString, Tribble.class));

        String insert = objectMapper.writeValueAsString(tribble);
        resp.getWriter().append(insert);

        resp.setContentType("application/json");
        resp.setStatus(201);


    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws IOException{
        Tribble tribble = null;
        BufferedReader reader = req.getReader();
        StringBuilder sb = new StringBuilder();

        String line;
        while((line = reader.readLine()) != null){
            sb.append(line);
        }
        String jsonString = sb.toString();
        Tribble tribble1 = objectMapper.readValue(jsonString, Tribble.class);
        String name = tribble1.getName();
        tribbleDOA.deleteTribble(name);

    }



}

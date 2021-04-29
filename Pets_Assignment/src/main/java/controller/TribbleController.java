package controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import service.TribbleService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.sql.SQLException;

public class TribbleController {
    private ObjectMapper objectMapper = new ObjectMapper();
    private TribbleService ts = new TribbleService();

    public TribbleController() {
    }

    public TribbleController(TribbleService ts) {
        this.ts = ts;
    }

    public void getAll(HttpServletRequest req, HttpServletResponse resp) throws IOException, SQLException {
        BufferedReader reader = req.getReader();
        StringBuilder sb = new StringBuilder();

        String line;
        while((line = reader.readLine()) != null){
            sb.append(line);
        }
        String jsonString = sb.toString();

        String json = objectMapper.writeValueAsString(ts.fetchAllTribble());
        resp.getWriter().append(json);
        resp.setContentType("application/json");

    }


}

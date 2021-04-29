package service;

import Dao.TribbleDOA;
import model.Tribble;

import java.sql.SQLException;
import java.util.List;

public class TribbleService {
    private TribbleDOA tribbleDOA;

    public TribbleService() {
        this.tribbleDOA = tribbleDOA;
    }

    public List<Tribble> fetchAllTribble() throws SQLException {
        return tribbleDOA.viewAll();
    }

    public Tribble getById(int id){
        //return tr
        return null;
    }

    public  Tribble deleteTribble(String name){
        return tribbleDOA.deleteTribble(name);
    }

    public  Tribble AddTribble(String name, String color, String noise, String description){
        return tribbleDOA.addTribble(name, color, noise, description);
    }

    public  Tribble deleteTribble(int id, String name){
        return tribbleDOA.updateName(id, name);
    }

}

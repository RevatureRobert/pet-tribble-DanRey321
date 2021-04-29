import Dao.LabsDAO;
import Dao.TribbleDOA;
import model.Labs;
import service.TribbleService;

import java.sql.SQLException;

public class Driver {
  public static void main(String[] args) throws SQLException {

      //TribbleDOA tribbleDOA = new TribbleDOA();
      //TribbleService tribbleService = new TribbleService();
      //tribbleService.fetchAllTribble();

      //tribbleDOA.updateName(1, "RockyBalboa");
      //tribbleDOA.deleteTribble("Dan");
      //tribbleDOA.addTribble("Dan", "Brown", "English", "ehhh");
      //tribbleDOA.viewAll();
    //

      LabsDAO labsDAO = new LabsDAO();
      //labsDAO.viewAll();
      Labs labs = new Labs("New Lab", 3);
      labsDAO.deleteLab("New Lab");
  }
}

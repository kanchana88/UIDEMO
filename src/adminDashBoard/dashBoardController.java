package adminDashBoard;

import dbUtil.dbConnection;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Observable;
import java.util.ResourceBundle;

public class dashBoardController implements Initializable {
    @FXML
    private Button btnload;
    @FXML
    private TableView<amployee> employeeTable;
    @FXML
    private TableColumn<amployee,Integer> IDC;
    @FXML
    private TableColumn<amployee,String> NameC;
    @FXML
    private TableColumn<amployee,String >PositionC;
    @FXML
    private TableColumn<amployee,String> EmailC;
    @FXML
    private TableColumn<amployee,Double> SalaryC;

    private dbConnection db;
    private ObservableList<amployee> data;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        this.db = new dbConnection();


    }
    @FXML
    private void  loadEmployeedata(ActionEvent event){
        try {
            Connection conn = dbConnection.getConnection();
            this.data = FXCollections.observableArrayList();
            String sql = "select * from employee";
            ResultSet rs = conn.createStatement().executeQuery(sql);
            while (rs.next()){
                this.data.add(new amployee(rs.getString(i=1),
                        rs.getString(i=2),rs.getString(i=3),
                        rs.getString(i=4),rs.getString()ouble(i=5)));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }

        this.employeeTable.setItems(null);
        this.employeeTable.setItems(this.data);
    }

}//class

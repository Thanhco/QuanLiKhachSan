/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qlksgongcha;

import Database.DBConfig;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Sony Vaio
 */
public class LoginController implements Initializable {

    DBConfig db = new DBConfig();

    @FXML
    private TextField txtUserName;
    @FXML
    private PasswordField txtPassWord;
    @FXML
    private Button btnLogin;
    private Statement stm;
    private ResultSet rs;
    private PreparedStatement pst;
    private Connection con;
    @FXML
    private AnchorPane anchorPane_login;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            db.dbConnect();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(MainWindowsController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(MainWindowsController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    public void btnLoginAction(ActionEvent event) throws IOException, SQLException {
        con = db.getCon();
        String userName = txtUserName.getText();
        String passWord = txtPassWord.getText();
        String sql = "SELECT * FROM TaiKhoan WHERE TenDangNhap = ? and MatKhau = ? ";
        try {
            pst = con.prepareStatement(sql);
            pst.setString(1, userName);
            pst.setString(2, passWord);
            rs = pst.executeQuery();
            if (rs.next()) {
                Stage stage = (Stage) anchorPane_login.getScene().getWindow();
                stage.close();
                System.out.println("Show main");
                Parent root = FXMLLoader.load(getClass().getResource("MainWindows.fxml"));

                Scene scene = new Scene(root);

                stage.setScene(scene);
                stage.setTitle("Hệ thống quản lí Khách Sạn Gong Cha");
                stage.getIcons().add(new javafx.scene.image.Image("images/logo.png"));
                stage.show();
            } else {
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setContentText("Mật Khẩu Hoặc Tên Đăng Nhập Không Chính Xác");
                alert.setTitle("Cảnh Báo");
                alert.setHeaderText(null);
                alert.showAndWait();
            }
        } catch (IOException | SQLException e) {
        }
    }

    @FXML
    public void btnCancelLoginAction(ActionEvent event) {
        Alert alertCancel = new Alert(Alert.AlertType.CONFIRMATION);
        alertCancel.setContentText("Bạn có muốn thoát ?");
        alertCancel.setTitle("Cảnh Báo");
        alertCancel.setHeaderText(null);
        alertCancel.showAndWait();
        Stage stage = (Stage) anchorPane_login.getScene().getWindow();
        stage.close();
    }

}

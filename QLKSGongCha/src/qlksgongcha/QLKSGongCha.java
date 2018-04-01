/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qlksgongcha;

import java.awt.Image;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author Sony Vaio
 */
public class QLKSGongCha extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("MainWindows.fxml"));

        Scene scene = new Scene(root);

        stage.setScene(scene);
        stage.setTitle("Hệ thống quản lí Khách Sạn Gong Cha");
        stage.getIcons().add( new javafx.scene.image.Image("images/logo.png"));
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}

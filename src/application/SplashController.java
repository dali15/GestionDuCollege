package application;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class SplashController implements Initializable {

    @FXML AnchorPane ap;

    class ShowSplashScreen extends Thread{
        @Override
        public void run(){
            try {
                Thread.sleep(10000);

                Platform.runLater(() -> {
                    Stage login = new Stage();
                    Parent root = null;
                    try {
                        root = FXMLLoader.load(getClass().getResource("login_page.fxml"));
                    } catch (IOException ex) {
                        Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    Scene scene = new Scene(root);
                    login.setScene(scene);
                    login.show();
                    login.setMinHeight(400);
                    login.setMaxHeight(400);
                    login.setMinWidth(500);
                    login.setMaxWidth(500);
                    login.setTitle("Connection");
                    ap.getScene().getWindow().hide();
                });
            } catch (InterruptedException ex) {
                Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        new ShowSplashScreen().start();
    }
}


package org.velf.Model;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.StageStyle;

public class Messages {
    
    
    private static Messages instance;
    
    public Messages(){
        instance = this;
    }
    
    public static Messages getInstance(){
        return instance;
    }
    
    public static void showMsgi(String msg){
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Notification");
        String s = msg;
        alert.initStyle(StageStyle.UNDECORATED);
	alert.setContentText(s);
        alert.showAndWait();
    }
    
    public static void showMsga(String msg){
        Alert alert = new Alert(AlertType.WARNING);
        alert.setTitle("Notification");
        String s = msg;
        alert.initStyle(StageStyle.UNDECORATED);
	alert.setContentText(s);
        alert.showAndWait();
    }
    
     public static void showMsge(String msg){
        Alert alert = new Alert(AlertType.ERROR);
        alert.setTitle("Notificaction");
        String s = msg;
        alert.initStyle(StageStyle.UNDECORATED);
        alert.setResizable(false);
	alert.setContentText(s);
        alert.showAndWait();
     }
}

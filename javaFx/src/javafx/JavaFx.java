/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafx;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class MyJavaFX extends Application {
   
   public void start(Stage mainStage) {
      
      Label labResult = new Label();
      labResult.setLayoutX(300); // without offset
      labResult.setLayoutY(200); // without offset

      Button btnOK = new Button();
      btnOK.setLayoutX(500);
      btnOK.setLayoutY(350);
      btnOK.setText("Click me!");
      btnOK.setOnAction(e -> 
          labResult.setText("Mamat wuz here!")
      );
      
      Pane p1 = new Pane();
      p1.getChildren().add(labResult);
      p1.getChildren().add(btnOK);
      
      Scene myScene = new Scene(p1, 600, 400);
      mainStage.setTitle("My First JavaFX");
      mainStage.setScene(myScene);
      mainStage.show();     
   }
   
   public static void main(String args[]) {
      Application.launch(args);
   }   
}

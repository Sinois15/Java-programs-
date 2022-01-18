package week5_tut;

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
      labResult.setLayoutX(260); // without offset
      labResult.setLayoutY(175); // without offset
      
      Label labResult2 = new Label();
      labResult2.setLayoutX(500);
      labResult2.setLayoutY(25);

      Button btnOK = new Button();
      btnOK.setLayoutX(500);
      btnOK.setLayoutY(350);
      btnOK.setText("Click me!");
      btnOK.setOnAction(e -> 
          labResult.setText("Mamat wuz here!")
      );
      
      Button btn2 = new Button();
      btn2.setLayoutX(25);
      btn2.setLayoutY(350);
      btn2.setText("Click me too!");
      btn2.setOnAction(e -> 
              labResult2.setText("I wuz here too") 
      );
          
      
      
      Pane p1 = new Pane();
      p1.getChildren().add(labResult);
      p1.getChildren().add(labResult2);
      p1.getChildren().add(btnOK);
      p1.getChildren().add(btn2);
      
      Scene myScene = new Scene(p1, 600, 400);
      mainStage.setTitle("My First JavaFX");
      mainStage.setScene(myScene);
      mainStage.show();     
   }
   
   public static void main(String args[]) {
      Application.launch(args);
   }   
}
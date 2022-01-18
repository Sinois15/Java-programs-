package shapes;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class ShowCircle extends Application {
   
   public void start(Stage priStage) {
      Circle c1 = new Circle();
      c1.setCenterX(200);
      c1.setCenterY(100);
      c1.setRadius(50);
      c1.setStroke(Color.RED);
      c1.setFill(Color.YELLOW);
      
      Circle c2 = new Circle();
      c2.setCenterX(300);
      c2.setCenterY(100);
      c2.setRadius(50);
      c2.setStroke(Color.RED);
      c2.setFill(Color.GREY);
      
      Circle c3 = new Circle();
      c3.setCenterX(250);
      c3.setCenterY(100);
      c3.setRadius(100);
      c3.setStroke(Color.RED);
      c3.setFill(Color.color(0, 0, 0, 0));
      
      Pane pane = new Pane();
      pane.getChildren().add(c1);
      pane.getChildren().add(c2);
      pane.getChildren().add(c3);
      
      Scene scn = new Scene(pane, 600, 400);
      priStage.setScene(scn);
      priStage.show();
   }
   public static void main(String[] args){
       Application.launch(args);
   }
}

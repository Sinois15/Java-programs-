/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package idnumpolygon;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Polyline;
import javafx.stage.Stage;

/**
 *
 * @author User
 */
public class IDnumPolygon extends Application {
    
    
    public void start(Stage primaryStage) {
       
        
        
        StackPane root = new StackPane();
        root.getChildren().add(drawNum());
        
        
        Scene scene = new Scene(root, 300, 250);
        
        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public Polyline drawNum(){
        //array of coordinates
        double points[] = {100, 100, 120, 60, 120, 170, 100, 170, 200, 170,220, 170,200, 170, 200, 130, 160, 130, 200, 60, 200, 130, 220, 130};
        //creating a polyline using the array of coordinates as its points
        //the x and y coordinate will be read in pairs e.g 100, 100
        Polyline id = new Polyline(points);
        
        return id;
    }
    public static void main(String[] args) {
        launch(args);
    }
    
}

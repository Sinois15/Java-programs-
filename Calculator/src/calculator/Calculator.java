/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculator;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 *
 * @author User
 */
public class Calculator extends Application {
    
    @Override
    public void start(Stage mainStage) {
        
        Label resultTitle = new Label("Result");
        resultTitle.setLayoutX(50);
        resultTitle.setLayoutY(150);

        Label result = new Label();
        result.setLayoutX(100);
        result.setLayoutY(150);
        
        Label num1 = new Label("Enter the first number: ");
        num1.setLayoutX(50);
        num1.setLayoutY(25);
        TextField txtNum1 = new TextField();
        txtNum1.setLayoutX(200);
        txtNum1.setLayoutY(25);
        
        Label num2 = new Label("Enter the second number: ");
        num2.setLayoutX(50);
        num2.setLayoutY(50);
        TextField txtNum2 = new TextField();
        txtNum2.setLayoutX(200);
        txtNum2.setLayoutY(50);
        
        Button add = new Button();
        add.setLayoutX(50);
        add.setLayoutY(100);
        add.setText("Add");
        add.setOnAction(e -> {
            
            int n1 = Integer.parseInt(txtNum1.getText());
            int n2 = Integer.parseInt(txtNum2.getText());
            int sum = n1 + n2;
            result.setText(Integer.toString(sum));
        });
        
        Button substract = new Button();
        substract.setLayoutX(100);
        substract.setLayoutY(100);
        substract.setText("Substract");
        substract.setOnAction(e -> {
            
            int n1 = Integer.parseInt(txtNum1.getText());
            int n2 = Integer.parseInt(txtNum2.getText());
            int minus = n1 - n2;
            result.setText(Integer.toString(minus));
        });
        
        Button multiply = new Button();
        multiply.setLayoutX(175);
        multiply.setLayoutY(100);
        multiply.setText("Multiply");
        multiply.setOnAction(e -> {
            
            int n1 = Integer.parseInt(txtNum1.getText());
            int n2 = Integer.parseInt(txtNum2.getText());
            int product = n1 * n2;
            result.setText(Integer.toString(product));
        });

        Pane p1 = new Pane();
        p1.getChildren().add(num1);
        p1.getChildren().add(txtNum1);
        p1.getChildren().add(num2);
        p1.getChildren().add(txtNum2);
        p1.getChildren().add(add);
        p1.getChildren().add(substract);
        p1.getChildren().add(multiply);
        p1.getChildren().add(resultTitle);
        p1.getChildren().add(result);
        
        Scene myScene = new Scene(p1, 400, 250);
        mainStage.setTitle("My Calculator");
        mainStage.setScene(myScene);
        mainStage.show();
        
    }
        
    public static void main(String[] args) {
        launch(args);
    }
    
}

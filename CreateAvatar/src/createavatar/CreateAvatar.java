/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package createavatar;


import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.scene.shape.Rectangle;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 *
 * @author User
 */
public class CreateAvatar extends Application {
    private Pane p;
    private Scene scene;
    private TextField name, level;
    private ComboBox rpgClass;
    private Button create;
    private String classes[] = {"Knight", "Marksman", "Mage"};
    private File characters = new File("./data/characters.txt");
    private int avatarCount = -1;
    private ArrayList<Avatar> avatars = new ArrayList<>();
    private RpgClass k = new Knight();
    private RpgClass mk = new Marksman();
    private RpgClass mg = new Mage();
    private String cName;
    private int cLevel;
    private Rectangle rHp, rAtk, rDef, rSpd, rMp;
    private Label atkQuan, stop;
    
    @Override
    public void start(Stage mainStage) {
        
        stop = new Label("bij");
        stop.setLayoutX(200);
        stop.setLayoutY(150);
        
        //creating rectangles to represent stats
        //setting each rectangle to a different color
        rHp = new Rectangle(60, 150, 0, 10);
        rHp.setFill(Color.FORESTGREEN);
        rAtk = new Rectangle(60, 170, 0, 10);
        rAtk.setFill(Color.CRIMSON);
        rDef = new Rectangle(60, 190, 0, 10);
        rDef.setFill(Color.CADETBLUE);
        rSpd = new Rectangle(60, 210, 0, 10);
        rSpd.setFill(Color.GOLD);
        rMp = new Rectangle(60, 230, 0, 10);
        rMp.setFill(Color.AQUAMARINE);
        //array of rectangles to make changes more easily
        Rectangle stats[] = {rHp, rAtk, rDef, rSpd, rMp};
        
        //label to prompt user that their avatar has been created
        Label created = new Label();
        created.setLayoutX(250);
        created.setLayoutY(252);
        
       
        //label to prompt userr to enter their avatar name
        Label nameLab = new Label("Enter Name ");
        nameLab.setLayoutX(25);
        nameLab.setLayoutY(50);
        //textfield to enter avatar name
        name = new TextField();
        name.setLayoutX(125);
        name.setLayoutY(50);
        //changelistener to remove created prompt when a new name is entered
        name.textProperty().addListener(new ChangeListener<String>(){
            public void changed(ObservableValue<? extends String> ob,
                    String old, String newVal){
                created.setText("");
            }
        });
        
        //label to prompt user to enter their desired level
        Label levelLab = new Label("Enter level ");
        levelLab.setLayoutX(25);
        levelLab.setLayoutY(80);
        //textfield to enter level
        level = new TextField();
        level.setLayoutX(125);
        level.setLayoutY(80);
        
        //label to prompt user if anything is wrong with their data entered
        Label error = new Label();
        error.setLayoutX(10);
        error.setLayoutY(20);
        error.setTextFill(Color.RED);
        
        //labels to indicate the stat name
        Label atk = new Label();
        atkQuan = new Label();
        atkQuan.setLayoutX(10);
        atkQuan.setLayoutY(165);
        Label def = new Label();
        Label hp = new Label();
        Label spd = new Label();
        Label mp = new Label();
        //array of labels to make some changes easier
        Label statLabs[] = {hp, atk, def, spd, mp};
        
        //label to display rpg class description
        Label description = new Label();
        description.setLayoutX(285);
        description.setLayoutY(50);
        
        //label to prompt user to select a class
        Label classLab = new Label("Select character class");
        classLab.setLayoutX(25);
        classLab.setLayoutY(110);
        //drop down list to select class
        rpgClass = new ComboBox(FXCollections.observableArrayList(classes));
        rpgClass.setPromptText("Character class");
        rpgClass.setLayoutX(150);
        rpgClass.setLayoutY(110);
        
        //setting rpg class data to show when it is selected from the combobox
        rpgClass.setOnAction(e->{
            for (Rectangle stat : stats) {
                stat.setWidth(0);
            }
            atk.setText("atk");
            hp.setText("hp");
            def.setText("def");
            spd.setText("spd");
            mp.setText("mp");
            
            switch (rpgClass.getValue().toString()){
                case "Knight": 
                    showStats(k);
                    k.writeDescrip();
                    description.setText(k.getDescrip());
                    break;
                case "Marksman":
                    showStats(mk);
                    mk.writeDescrip();
                    description.setText(mk.getDescrip());
                    break;
                case "Mage":
                    showStats(mg);
                    mg.writeDescrip();
                    description.setText(mg.getDescrip());
                    break;
            }
        });
        
        //button to save data into csv file "characters"
        create = new Button("Create");
        create.setLayoutX(400);
        create.setLayoutY(250);
        create.setOnAction(e->{
           
            try{
            if (name.getText().equals("") || level.getText().equals("") 
                    || rpgClass.getSelectionModel().isEmpty()){
                created.setText("Avatar creation failed");
                created.setTextFill(Color.RED);
                error.setText("Fill out all the fields and choose your class! "
                        + "(＃`Д´)");
            }
            else{
                error.setText("");
                cName = name.getText();
                cLevel = Integer.parseInt(level.getText());
                avatars.add(new Avatar(cName, cLevel,
                        rpgClass.getValue().toString()));
                avatarCount++;
                created.setText("Avatar created and saved!");
                created.setTextFill(Color.GREEN);
                switch (rpgClass.getValue().toString()){
                    case "Knight": 
                        k.calcStats(avatars.get(avatarCount));
                        saveData(avatars.get(avatarCount), k);
                        break;
                    case "Marksman":
                        mk.calcStats(avatars.get(avatarCount));
                        saveData(avatars.get(avatarCount), mk);
                        break;
                    case "Mage":
                        mg.calcStats(avatars.get(avatarCount));
                        saveData(avatars.get(avatarCount), mg);
                        break;
                }
            }
            }catch(NumberFormatException nfe){
                //prompting user that avatar creation failed
                created.setText("Avatar creation failed");
                created.setTextFill(Color.RED);
                //specifying why the creation failed
                //prompting user if level entered is not a number
                error.setText("Your level should be a number! (＃`Д´)");
            }
            
            
        });
        
        
        p = new Pane();
        p.getChildren().add(nameLab);
        p.getChildren().add(name);
        p.getChildren().add(levelLab);
        p.getChildren().add(level);
        p.getChildren().add(classLab);
        p.getChildren().add(rpgClass);
        p.getChildren().add(create);
        p.getChildren().add(rHp);
        p.getChildren().add(rAtk);
        p.getChildren().add(rDef);
        p.getChildren().add(rSpd);
        p.getChildren().add(rMp);
        p.getChildren().add(error);
        p.getChildren().add(created);
        p.getChildren().add(description);
        p.getChildren().add(atkQuan);
        p.getChildren().add(stop);
        
        int x = 30, y = 145;
        for (int i = 0;i < statLabs.length; i++){
            statLabs[i].setLayoutX(x);
            statLabs[i].setLayoutY(y);
            y+=20;
            p.getChildren().add(statLabs[i]);
        }
        
        scene = new Scene(p, 500, 300, Color.DARKGRAY);
        
        mainStage.setScene(scene);
        mainStage.setTitle("Just A Character Creator(...For Now)");
        mainStage.show();
    }
    
    //method to save the avatar and class data into csv file "characters"
    public void saveData(Avatar avatar, RpgClass c){
        try {
            PrintWriter pw = new PrintWriter(new FileWriter(characters, true));
            
            pw.print(avatar.getName() + ":");
            pw.print(avatar.getLevel() + ":");
            pw.print(avatar.getRpgClass() + ":");
            pw.print(avatar.getHp() + ":");
            pw.print(avatar.getAtk() + ":");
            pw.print(avatar.getDef() + ":");
            pw.print(avatar.getSpd() + ":");
            pw.print(avatar.getMp());
            pw.println();
            pw.print(c.getClassName() + ":");
            pw.print(c.getbHp()+ ":");
            pw.print(c.getbAtk() + ":");
            pw.print(c.getbDef() + ":");
            pw.print(c.getbSpd() + ":");
            pw.print(c.getbMp());
            pw.println();
            pw.close();
        } catch (IOException e) {
            System.out.println("whoops");
        }
    }
    
    //method to adjust width of rectangles depending on class stats
    public void showStats(RpgClass c){
        rHp.setWidth(c.getbHp());
        rAtk.setWidth(c.getbAtk());
        rDef.setWidth(c.getbDef());
        rSpd.setWidth(c.getbSpd());
        rMp.setWidth(c.getbMp());
    }
    
    /*public void showStats(RpgClass c){
        AnimationTimer timer = new AnimationTimer(){
            boolean done = false;
            double stats[] = {c.getbAtk(), c.getbDef(), c.getbHp(), c.getbSpd(), c.getbMp()};
            Rectangle rects[] = {rAtk, rDef, rHp, rSpd, rMp};
            public void handle(long now){
                /*initBar(c.getbAtk(), rAtk);
                initBar(c.getbDef(), rDef);
                initBar(c.getbHp(), rHp);
                initBar(c.getbSpd(), rSpd);
                initBar(c.getbMp(), rMp);
                
                if (rAtk.getWidth()<c.getbAtk()){
                    rAtk.setWidth(rAtk.getWidth() + 5);
                    atkQuan.setText(String.valueOf(c.getbAtk()));
                }
                if (rDef.getWidth()<c.getbDef()){
                    rDef.setWidth(rDef.getWidth() + 5);    
                }
                if (rHp.getWidth()<c.getbHp()){
                    rHp.setWidth(rHp.getWidth() + 5);    
                }
                if (rSpd.getWidth()<c.getbSpd()){
                    rSpd.setWidth(rSpd.getWidth() + 5);    
                }
                if (rMp.getWidth()<c.getbMp()){
                    rMp.setWidth(rMp.getWidth() + 5);    
                }
                for (int i= 0; i<5; i++){
                    if(stats[i] == rects[i].getWidth()){
                        System.out.println(stats[i]);
                        System.out.println(rects[i].getWidth());
                        done = true;
                    }
                    else{
                        done = false;
                    }
                }
                if (done){
                    this.stop();
                    stop.setText("stop");
                }
            }
        };
        timer.start();
        
    }*/
    
    public void initBar(int stat, Rectangle r){
        
        if (r.getWidth()<stat){
            r.setWidth(r.getWidth() + 5);
            atkQuan.setText(String.valueOf(stat));
        }
       
    }
    
    
   
    public static void main(String[] args) {
        launch(args);
    }
    
}

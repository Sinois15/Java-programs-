
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.*;
import java.util.LinkedList;
import java.util.Scanner;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;
import javax.swing.Icon;

public class TestForm extends Application {

    private File myf = new File("data", "muuq.txt");
    private int totQues = 0;
    private int activeQ = 1;
    private Label labQuesNo, labQues, labName, progress;
    private ImageView imgQues, flag;
    private Label labA, labB, labC, labD, fname;
    private RadioButton radChoice1, radChoice2, radChoice3, radChoice4;
    private ToggleGroup grpChoices;
    private Button btnPrev, btnNext, btnSubmit;
    private Pane mainPane = new Pane();
    private Pane paneC;
    private Scene mainScene;
    private LinkedList<Question> quesList = new LinkedList<Question>();
    private String answers[] = new String[25];
    private WelcomeForm wf;
    private ResultForm rf;
    private WinnerForm wnf;
    private Image imgFlag, icon;
    private Integer startTime = 4;
    private Integer startTimeRtg1 = 59;
    private Integer startTimeRtg2 = 1000;

    private Timeline timeline;
    private Label lbTime;
    private Integer timeSecond;
    private Integer timeSecondRtg1;
    private Integer timeSecondRtg2;
    private boolean boolTimer = true;

    private File finalresults = new File("./data/finalresult.txt");

    private String name;

    public void start(Stage mainStage) throws FileNotFoundException {

        mainStage.setTitle("Knowledge Test 1");
        Label labNameDesc = new Label("Name: ");
        labNameDesc.setLayoutX(25);
        labNameDesc.setLayoutY(25);

        progress = new Label(activeQ + "of 25");
        progress.setLayoutX(400);
        progress.setLayoutY(25);
        progress.setStyle("-fx-font-size: 12pt;-fx-font-weight:bold;");

        labName = new Label();
        labName.setLayoutX(65);
        labName.setLayoutY(25);

        labQuesNo = new Label("");
        labQuesNo.setLayoutX(25);
        labQuesNo.setLayoutY(75);
        labQuesNo.setStyle("-fx-font-family:serif;-fx-text-fill:#0000ff;");

        labQues = new Label("");
        labQues.setLayoutX(25);
        labQues.setLayoutY(100);
        labQues.setStyle("-fx-font-size: 12pt;-fx-font-weight:bold;");

        imgQues = new ImageView();
        imgQues.setLayoutX(25);
        imgQues.setLayoutY(75);
        imgQues.setFitHeight(150);
        imgQues.setFitWidth(300);

        labA = new Label("A");
        labA.setLayoutX(25);
        radChoice1 = new RadioButton("");
        radChoice1.setLayoutX(50);

        labB = new Label("B");
        labB.setLayoutX(25);
        radChoice2 = new RadioButton("");
        radChoice2.setLayoutX(50);

        labC = new Label("C");
        labC.setLayoutX(25);
        radChoice3 = new RadioButton("");
        radChoice3.setLayoutX(50);

        labD = new Label("D");
        labD.setLayoutX(25);
        radChoice4 = new RadioButton("");
        radChoice4.setLayoutX(50);

        grpChoices = new ToggleGroup();

        radChoice1.setToggleGroup(grpChoices);
        radChoice2.setToggleGroup(grpChoices);
        radChoice3.setToggleGroup(grpChoices);
        radChoice4.setToggleGroup(grpChoices);

        paneC = new Pane();
        paneC.setLayoutX(25);
        paneC.setLayoutY(75);
        paneC.getChildren().add(imgQues);
        paneC.getChildren().add(labA);
        paneC.getChildren().add(radChoice1);
        paneC.getChildren().add(labB);
        paneC.getChildren().add(radChoice2);
        paneC.getChildren().add(labC);
        paneC.getChildren().add(radChoice3);
        paneC.getChildren().add(labD);
        paneC.getChildren().add(radChoice4);

        btnPrev = new Button("Prev");
        btnPrev.setLayoutX(25);
        btnPrev.setLayoutY(550);
        btnPrev.setStyle("-fx-pref-width: 75px;");
        btnPrev.setDisable(true);

        btnNext = new Button("Next");
        btnNext.setLayoutX(125);
        btnNext.setLayoutY(550);
        btnNext.setStyle("-fx-pref-width: 75px;");

        btnSubmit = new Button("Submit");
        btnSubmit.setLayoutX(300);
        btnSubmit.setLayoutY(550);
        btnSubmit.setStyle("-fx-pref-width: 75px;");

        readFromFile();

        radChoice1.setOnAction(e -> {

            quesList.get(activeQ - 1).setSelected(0, true);
            quesList.get(activeQ - 1).setSelected(1, false);
            quesList.get(activeQ - 1).setSelected(2, false);
            quesList.get(activeQ - 1).setSelected(3, false);
            //if (quesList.get(activeQ-1).getType() == 3){
            //answers [activeQ-1] = quesList.get(activeQ-1).getChoice(0).toURI().toString();
            //}
            answers[activeQ - 1] = quesList.get(activeQ - 1).getChoice(0);
        });

        radChoice2.setOnAction(e -> {

            quesList.get(activeQ - 1).setSelected(0, false);
            quesList.get(activeQ - 1).setSelected(1, true);
            quesList.get(activeQ - 1).setSelected(2, false);
            quesList.get(activeQ - 1).setSelected(3, false);

            answers[activeQ - 1] = quesList.get(activeQ - 1).getChoice(1);

        });

        radChoice3.setOnAction(e -> {

            quesList.get(activeQ - 1).setSelected(0, false);
            quesList.get(activeQ - 1).setSelected(1, false);
            quesList.get(activeQ - 1).setSelected(2, true);
            quesList.get(activeQ - 1).setSelected(3, false);

            answers[activeQ - 1] = quesList.get(activeQ - 1).getChoice(2);

        });

        radChoice4.setOnAction(e -> {

            quesList.get(activeQ - 1).setSelected(0, false);
            quesList.get(activeQ - 1).setSelected(1, false);
            quesList.get(activeQ - 1).setSelected(2, false);
            quesList.get(activeQ - 1).setSelected(3, true);

            answers[activeQ - 1] = quesList.get(activeQ - 1).getChoice(3);

        });

        if (totQues == 1) {
            btnNext.setDisable(true);
        }
        btnNext.setOnAction(e -> {
            activeQ++;
            progress.setText(activeQ + "/25");
            btnPrev.setDisable(false);
            if (activeQ == totQues) {
                btnNext.setDisable(true);
            }
            reloadQues();
        }
        );

        btnPrev.setOnAction(e -> {
            activeQ--;
            progress.setText(activeQ + "/25");
            btnNext.setDisable(false);
            if (activeQ == 1) {
                btnPrev.setDisable(true);
            }
            reloadQues();
        }
        );

        btnSubmit.setOnAction(e -> {
            int doneQ = 0;
            for (int i = 0; i < answers.length; i++) {
                if (answers[i] != null) {
                    doneQ++;
                }
            }
            if (doneQ == 25){
            saveToFile();
            mainStage.hide();
            rf = new ResultForm();
            rf.showStage();
            rf.setOnHiding(v -> {
                wf.showStage();
            });
            
            // COMMENT THIS PART FOR QUICKER TESTING
            }
             else{
             Label notDone = new Label("You have not answered all the wuestions yet!");
             notDone.setLayoutX(250);
             notDone.setLayoutY(500);
             notDone.setTextFill(Color.RED);
             mainPane.getChildren().add(notDone);
             }
            // UNCOMMENT IF RUNNING FOR REAL
        }
        );

        mainPane.getChildren().add(labNameDesc);
        mainPane.getChildren().add(labName);
        mainPane.getChildren().add(labQuesNo);
        mainPane.getChildren().add(labQues);
        mainPane.getChildren().add(progress);
        mainPane.getChildren().add(paneC);
        mainPane.getChildren().add(btnNext);
        mainPane.getChildren().add(btnPrev);
        mainPane.getChildren().add(btnSubmit);

        mainScene = new Scene(mainPane, 800, 600);
        mainStage.setScene(mainScene);
        reloadQues();
        try {
            icon = new Image(new FileInputStream("./pictures/logo.png"));
            mainStage.getIcons().add(icon);
        } catch (FileNotFoundException e) {
            System.out.println("ERROR: Unable to find logo.png");
        }

        wf = new WelcomeForm();

        wf.setOnHiding(e -> {

            if (wf.goWinner()) {
                wnf = new WinnerForm();
                wnf.showStage();
            } else {
                try {
                    imgFlag = new Image(new FileInputStream(wf.getCFinalistFlag()));
                } catch (FileNotFoundException fileNotFoundException) {
                    System.out.println("flag image not found");
                }

                labName.setText(wf.getCFinalistName());
                name = wf.getCFinalistName();

                flag = new ImageView(imgFlag);
                flag.setFitHeight(50);
                flag.setFitWidth(100);
                flag.setLayoutX(200);
                flag.setLayoutY(20);

                mainPane.getChildren().add(flag);
                onTimer(true);
                mainStage.show();
            }
        });

    }

    public void reloadQues() {
        radChoice1.setGraphic(null);
        radChoice2.setGraphic(null);
        radChoice3.setGraphic(null);
        radChoice4.setGraphic(null);

        labQuesNo.setText("Question" + Integer.toString(activeQ));
        labQues.setText(quesList.get(activeQ - 1).getTheQues());
        radChoice1.setText(quesList.get(activeQ - 1).getChoice(0));
        radChoice2.setText(quesList.get(activeQ - 1).getChoice(1));
        radChoice3.setText(quesList.get(activeQ - 1).getChoice(2));
        radChoice4.setText(quesList.get(activeQ - 1).getChoice(3));
        imgQues.setImage(null);

        if (quesList.get(activeQ - 1).getType() == 1) {

            labA.setLayoutX(75);
            labA.setLayoutY(75);
            radChoice1.setLayoutX(75);
            radChoice1.setLayoutY(75);
            labB.setLayoutX(75);
            labB.setLayoutY(125);
            radChoice2.setLayoutX(75);
            radChoice2.setLayoutY(125);
            labC.setLayoutX(75);
            labC.setLayoutY(175);
            radChoice3.setLayoutX(75);
            radChoice3.setLayoutY(175);
            labD.setLayoutX(75);
            labD.setLayoutY(225);
            radChoice4.setLayoutX(75);
            radChoice4.setLayoutY(225);

        }

        if (quesList.get(activeQ - 1).getType() == 2) {

            File pFile = new File("pictures/" + quesList.get(activeQ - 1).getQuesPic());
            Image img = new Image(pFile.toURI().toString());
            imgQues.setImage(img);
            labA.setLayoutY(275);
            radChoice1.setLayoutY(275);
            labB.setLayoutY(325);
            radChoice2.setLayoutY(325);
            labC.setLayoutY(375);
            radChoice3.setLayoutY(375);
            labD.setLayoutY(425);
            radChoice4.setLayoutY(425);

        }

        if (quesList.get(activeQ - 1).getType() == 3) {

            radChoice1.setText(" ");
            radChoice2.setText(" ");
            radChoice3.setText(" ");
            radChoice4.setText(" ");

            ImageView A = new ImageView(new Image(new File("pictures/" + quesList.get(activeQ - 1).getChoice(0)).toURI().toString()));
            ImageView B = new ImageView(new Image(new File("pictures/" + quesList.get(activeQ - 1).getChoice(1)).toURI().toString()));
            ImageView C = new ImageView(new Image(new File("pictures/" + quesList.get(activeQ - 1).getChoice(2)).toURI().toString()));
            ImageView D = new ImageView(new Image(new File("pictures/" + quesList.get(activeQ - 1).getChoice(3)).toURI().toString()));
            A.setFitHeight(150);
            A.setPreserveRatio(true);
            B.setFitHeight(150);
            B.setPreserveRatio(true);
            C.setFitHeight(150);
            C.setPreserveRatio(true);
            D.setFitHeight(150);
            D.setPreserveRatio(true);

            radChoice1.setGraphic(A);
            labA.setLayoutY(150);
            radChoice1.setLayoutY(100);
            radChoice2.setGraphic(B);
            labB.setLayoutX(400);
            labB.setLayoutY(150);
            radChoice2.setLayoutX(400);
            radChoice2.setLayoutY(100);
            radChoice3.setGraphic(C);
            labC.setLayoutY(325);
            radChoice3.setLayoutY(275);
            radChoice4.setGraphic(D);
            labD.setLayoutX(400);
            labD.setLayoutY(325);
            radChoice4.setLayoutX(400);
            radChoice4.setLayoutY(275);

        }

        radChoice1.setSelected(quesList.get(activeQ - 1).getSelected(0));
        radChoice2.setSelected(quesList.get(activeQ - 1).getSelected(1));
        radChoice3.setSelected(quesList.get(activeQ - 1).getSelected(2));
        radChoice4.setSelected(quesList.get(activeQ - 1).getSelected(3));

    }

    public void readFromFile() {

        Scanner sfile;
        int type;
        char answer;
        String theQues;
        String[] choices = new String[4];
        String quesPic;
        Question ques;

        try {

            sfile = new Scanner(myf);

            String aLine = sfile.nextLine();
            Scanner sline = new Scanner(aLine);
            totQues = Integer.parseInt(sline.next());

            for (int k = 1; k <= totQues; k++) {

                aLine = sfile.nextLine();
                sline = new Scanner(aLine);
                sline.useDelimiter(":");
                type = Integer.parseInt(sline.next());
                answer = sline.next().charAt(0);
                theQues = sline.next();
                quesPic = "";

                if (type == 2) {

                    quesPic = sline.next();
                }

                choices[0] = sline.next();
                choices[1] = sline.next();
                choices[2] = sline.next();
                choices[3] = sline.next();

                sline.close();

                ques = new Question(type, answer, theQues, choices, quesPic);

                quesList.add(ques);

            }

            sfile.close();

        } catch (FileNotFoundException e) {

            System.out.println("File to read " + myf + " not found!");

        }

    }

    public static void main(String args[]) {

        Application.launch(args);

    }

    public void saveToFile() {
        try {
            PrintWriter pw = new PrintWriter(new FileWriter(finalresults, true));
            pw.println();
            pw.print(name + ":");
            for (int i = 0; i < answers.length; i++) {
                pw.print(answers[i] + ":");
            }

            pw.close();

        } catch (IOException e) {
            System.out.println();
        }
    }

    public void onTimer(boolean bool) {
        lbTime = new Label("");
        if (bool) {
            String timetime = "";
            timeSecond = startTime;
            timeSecondRtg1 = startTimeRtg1;
            timeSecondRtg2 = startTimeRtg2;

            lbTime.setText(timeSecond.toString());
            lbTime.setTextFill(Color.BLACK);

            lbTime.setLayoutX(450);
            lbTime.setLayoutY(60);

            mainPane.getChildren().addAll(lbTime);

            if (timeline != null) {
                timeline.stop();
            }
            timeline = new Timeline();
            timeline.setCycleCount(Timeline.INDEFINITE);
            timeline.getKeyFrames().add(
                    new KeyFrame(Duration.millis(1),
                            new EventHandler() {
                                @Override
                                public void handle(Event event) {
                                    timeSecondRtg2--;

                                    if (timeSecondRtg2 <= 0) {
                                        timeSecondRtg1--;
                                    }
                                    if (timeSecondRtg1 <= 0) {
                                        timeSecond--;
                                    }

                                    // update timerLabel
                                    lbTime.setText("0" + timeSecond + " : " + timeSecondRtg1
                                    );

                                    if (timeSecondRtg1 <= 0) {
                                        timeSecondRtg1 = 59;
                                    }
                                    if (timeSecondRtg2 <= 0) {
                                        timeSecondRtg2 = 1000;
                                    }
                                    if (timeSecond <= 0) {
                                        timeline.stop();
                                    }
                                }
                            }));
            timeline.playFromStart();
        }
        lbTime.setVisible(true);

    }

}

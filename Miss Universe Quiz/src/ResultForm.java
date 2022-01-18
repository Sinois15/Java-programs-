
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.collections.FXCollections;
import javafx.scene.media.*;
import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;
import javafx.collections.ObservableList;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.media.MediaPlayer.Status;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class ResultForm extends Stage {

    private Image icon;
    private Scene rf;
    private Pane p;
    private Button btnResults, btnDone;
    private String fName;
    private String answers[] = new String[25];
    private String results[] = new String[25];
    private Finalist cFinalist = new Finalist();
    private FinalistList fList = new FinalistList();
    private ComboBox finalistList;
    private File fScore = new File("./data", "score.txt");
    private File finalistResult = new File("./data", "finalresult.txt");
    private Image pic;
    private ImageView image;
    private File answerFile = new File("./data/answers.txt");
    private Label finalResult[] = new Label[25];
    private Label notDone;
    private WelcomeForm wf;
    private String cPic;
    private Label resultHeader = new Label("");
    private Label resultFooter = new Label("");
    private Label resultScore = new Label("");

    public ResultForm() {


        Label fName = new Label("Select Candidate");
        fName.setLayoutX(30);
        fName.setLayoutY(25);

//creating the drop down list to select names
        finalistList = new ComboBox(FXCollections.observableArrayList(fList.getNames()));
        finalistList.setPromptText("Finalist Names");
        finalistList.setLayoutX(150);
        finalistList.setLayoutY(25);

        Label finalResultLabel = new Label("R E S U L T: ");
        finalResultLabel.setLayoutX(200);
        finalResultLabel.setLayoutY(60);

        resultHeader.setLayoutX(200);
        resultHeader.setLayoutY(70);

        resultFooter.setLayoutX(200);
        resultFooter.setLayoutY(630);

        resultScore.setLayoutX(450);
        resultScore.setLayoutY(650);

        btnResults = new Button("View Results");
        btnResults.setLayoutX(40);
        btnResults.setLayoutY(300);
        btnResults.setOnAction(e -> {
            if (finalistList.getSelectionModel().isEmpty()) {
                resultHeader.setText("\n\nPlease Select a Candidate");
                resultHeader.setFont(Font.font("consolas", 15));
                resultHeader.setTextFill(Color.CORAL);
            } else {
                displayResults();
            }
                
        });

        p = new Pane();

        p.getChildren().add(fName);
        p.getChildren().add(finalistList);
        p.getChildren().add(btnResults);
        p.getChildren().add(finalResultLabel);
        p.getChildren().add(resultHeader);
        p.getChildren().add(resultFooter);
        p.getChildren().add(resultScore);

        //creating labels for each result
        for (int i = 0; i < 25; i++) {
            finalResult[i] = new Label();
            p.getChildren().add(finalResult[i]);
        }

        //setting the name of the current candidate
        finalistList.setOnAction(e -> {
            //erase text when selecting new candidate
            notDone.setText("");
            resultHeader.setText("");
            resultFooter.setText("");
            resultScore.setText("");
            for (int i = 0; i < 25; i++) {
                finalResult[i].setText("");

            }
            cFinalist.setName(finalistList.getValue().toString());

            for (int i = 0; i < fList.getFinalists().size(); i++) {
                if (finalistList.getValue().toString().equals(fList.getFinalists().get(i).getName())) {
                    cFinalist.setPic(fList.getFinalists().get(i).getPic());
                }
            }
            try {
                pic = new Image(new FileInputStream(cFinalist.getPic()));
                image = new ImageView(pic);
                image.setFitHeight(170);
                image.setFitWidth(140);
                image.setLayoutX(40);
                image.setLayoutY(125);
                p.getChildren().add(image);
            } catch (FileNotFoundException fe) {
                System.out.println("candidate pic not found");
            }
        });

        notDone = new Label();
        notDone.setLayoutX(200);
        notDone.setLayoutY(80);
        notDone.setTextFill(Color.RED);

        btnDone = new Button("Done");
        btnDone.setLayoutX(40);
        btnDone.setLayoutY(330);
        btnDone.setOnAction(e -> {
            this.hide();
        });

        p.getChildren().add(notDone);
        p.getChildren().add(btnDone);

        rf = new Scene(p, 1000, 700);
        this.setScene(rf);
        this.setTitle("Result Form");
        try {
            icon = new Image(new FileInputStream("./pictures/logo.png"));
            this.getIcons().add(icon);
        } catch (FileNotFoundException e) {
            System.out.println("ERROR: Unable to find logo.png");
        }
        this.show();
    }

    public void initResults() {
        Scanner sfile;
        results[0] = "";
        try {
            sfile = new Scanner(finalistResult);
            while (sfile.hasNextLine()) {
                String aLine = sfile.nextLine();
                Scanner sline = new Scanner(aLine);
                sline.useDelimiter(":");
                while (sline.hasNext()) {
                    fName = sline.next();
                    if (fName.equals(cFinalist.getName())) {
                        cPic = cFinalist.getPic();
                        for (int i = 0; i < 25; i++) {
                            results[i] = sline.next();
                        }
                    }

                }
                sline.close();
            }
            sfile.close();
        } catch (FileNotFoundException e) {
            System.out.println("results not found");
        }

    }

    public void initAnswers() {
        Scanner sfile;
        try {
            sfile = new Scanner(answerFile);
            while (sfile.hasNextLine()) {
                String aLine = sfile.nextLine();
                Scanner sline = new Scanner(aLine);
                sline.useDelimiter(":");
                while (sline.hasNext()) {
                    for (int i = 0; i < 25; i++) {
                        answers[i] = sline.next();
                    }
                }
                sline.close();
            }
            sfile.close();
        } catch (FileNotFoundException e) {
            System.out.println("answers not found");
        }

    }

    public void displayResults() {

        int x = 200;
        int y = 120;
        int right = 0;
        int score = 0;
        String status;
        Integer num;
        String res;
        String ans;
        initResults();
        initAnswers();

        try {
            if (results[0].isEmpty()) {
                resultHeader.setText("\n\nThis participant has not yet taken the quiz!");
                resultHeader.setFont(Font.font("consolas", 15));
                resultHeader.setTextFill(Color.RED);
            } else {
                for (int i = 0; i < 25; i++) {
                    if (results[i].equals(answers[i])) {
                        status = "Correct";
                        right++;
                    } else {
                        status = "Wrong";
                    }
                    num = i + 1;
                    res = results[i];
                    ans = answers[i];

                    String output = String.format("%-5s%-5s%-5s%-35s%-5s%-30s%-5s%-10s%s\n", "||", num, "||", res, "||", ans, "||", status, "||");
                    String header = "======================================================================================================\n"
                            + String.format("%-5s%-5s%-5s%-35s%-5s%-30s%-5s%-10s%s\n", "||", "No.", "||", "Your Answer", "||", "Correct Answer", "||", "Result", "||"
                                    + "\n======================================================================================================");

                    resultHeader.setText("\n" + header);
                    resultHeader.setFont(Font.font("consolas", 12));
                    resultHeader.setTextFill(Color.DARKSLATEBLUE);

                    finalResult[i].setText("\n" + output);
                    finalResult[i].setFont(Font.font("consolas", 12));
                    finalResult[i].setLayoutX(x);
                    finalResult[i].setLayoutY(y);
                    y += 20;

                    resultFooter.setText("======================================================================================================");
                    resultFooter.setFont(Font.font("consolas", 12));
                    resultFooter.setTextFill(Color.DARKSLATEBLUE);
                }

                score = right * 4;
                resultScore.setText("Your Score: " + score + "%");
                resultScore.setFont(Font.font("consolas", 18));
                resultScore.setTextFill(Color.DARKRED);

            }

            saveToFile(finalistList.getValue().toString(), score, cPic);

        } catch (NullPointerException npe) {
        }
    }

    public void saveToFile(String name, int score, String pic) {
        try {
            PrintWriter pw = new PrintWriter(new FileWriter(fScore, true));
            pw.println();
            pw.print(name + ":");
            pw.print(score + ":");
            pw.print(pic);
            pw.close();
        } catch (IOException e) {
            System.out.println("whoops");
        }
    }

    public void showStage() {
        this.show();
    }
    //method to initialise overservable list to be used for the table view
       /*public ObservableList<Result> initResults(){
       ObservableList<Result> dResults = FXCollections.observableArrayList();
       String status;
       Integer num;
       String res;
       String ans;
       for (int i = 0; i<25; i++){
           if(results[i].equals(answers[i])){
               status = "Correct";
           }
           else{
               status = "Wrong";
           }
           num = i+1;
           res = results[i];
           ans = answers[i];
           dResults.add(new Result(num.toString(), res, ans, status));
           System.out.println(dResults.get(i).getqNum());
           
       }
       return dResults;
   }*/
    
    //tableview code which wont work((╬◣﹏◢))
   /*public void displayResults(){
         getResults();
         getAnswers();
         
         
         
         
         TableColumn<String, Result> qNum = new TableColumn<>("question number");
         TableColumn<String, Result> result = new TableColumn<>("Candidate answer");
         TableColumn<String, Result> Answers = new TableColumn<>("Correct answer");
         TableColumn<String, Result> status = new TableColumn<>("status");

         qNum.setCellValueFactory(new PropertyValueFactory<>("qnum"));
         result.setCellValueFactory(new PropertyValueFactory<>("fans"));
         Answers.setCellValueFactory(new PropertyValueFactory<>("cans"));
         status.setCellValueFactory(new PropertyValueFactory<>("status"));
         
         TableView resultTable = new TableView();
         resultTable.setMaxSize(750,400);
         resultTable.setLayoutX(200);
         resultTable.setLayoutY(75);
         
         resultTable.getColumns().addAll(qNum, result, Answers, status);
         resultTable.setItems(initResults());
         
         p.getChildren().add(resultTable);
         
         
        
   }*/


}

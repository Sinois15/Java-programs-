
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.scene.paint.Color;

public class WinnerForm extends Stage {

    private ImageView wImage, background;
    private Image pic, back, icon;
    private String wScore, wPic;
    private Button btnDone;
    private Pane p;
    private Scene wnf;
    private ResultForm rf;
    private Finalist winner;
    private File fScore = new File("./data", "score.txt");
    private ArrayList<Finalist> finalists = new ArrayList<>();
    private FinalistList fList = new FinalistList();

    public WinnerForm() {

        initFinalists();
        getWinner();

        Label winner = new Label("\\(★ω★)/ WINNER \\(★ω★)/");
        winner.setLayoutX(165);
        winner.setLayoutY(215);
        winner.setFont(Font.font("Algerian", 20));
        winner.setTextFill(Color.DARKSLATEBLUE);

        Label scoreLab = new Label("SCORE: ");
        scoreLab.setLayoutX(220);
        scoreLab.setLayoutY(520);
        scoreLab.setFont(Font.font("Algerian", 20));

        Label score = new Label(wScore + "%");
        score.setLayoutX(300);
        score.setLayoutY(520);
        score.setFont(Font.font("Algerian", 20));
        //setting a background image
        try {
            back = new Image(new FileInputStream("./pictures/winnerback.jpg"));
            background = new ImageView(back);
            background.setFitHeight(600);
            background.setFitWidth(600);
        } catch (FileNotFoundException be) {
            System.out.println("background image not found");
        }

        try {
            pic = new Image(new FileInputStream(wPic));
            wImage = new ImageView(pic);
            wImage.setFitHeight(250);
            wImage.setPreserveRatio(true);
            wImage.setLayoutX(200);
            wImage.setLayoutY(240);

        } catch (FileNotFoundException fe) {
            System.out.println("candidate pic not found");
        }

        btnDone = new Button("Done");
        btnDone.setLayoutX(270);
        btnDone.setLayoutY(550);
        btnDone.setOnAction(e -> {
            System.exit(0);

        });

        p = new Pane();
        p.getChildren().add(background);
        p.getChildren().add(winner);
        p.getChildren().add(wImage);
        p.getChildren().add(scoreLab);
        p.getChildren().add(score);
        p.getChildren().add(btnDone);
        wnf = new Scene(p, 600, 600);
        this.setScene(wnf);
        this.setTitle("Winner Form");

        try {
            icon = new Image(new FileInputStream("./pictures/logo.png"));
            this.getIcons().add(icon);
        } catch (FileNotFoundException e) {
            System.out.println("ERROR: Unable to find logo.png");
        }
        this.show();

    }

    public void getWinner() {
        winner = new Finalist();
        double score = 0;
        for (int i = 0; i < finalists.size(); i++) {
            if (finalists.get(i).getScore() > score) {
                score = finalists.get(i).getScore();
                wPic = finalists.get(i).getPic();
                System.out.println(finalists.get(i).getScore());
            }
        }
        wScore = Double.toString(score);

    }

    public void initFinalists() {
        Scanner sfile;
        String name;
        String score;
        String pic;
        try {
            sfile = new Scanner(fScore);
            while (sfile.hasNextLine()) {
                String aLine = sfile.nextLine();
                Scanner sline = new Scanner(aLine);
                sline.useDelimiter(":");
                while (sline.hasNext()) {
                    name = sline.next();
                    score = sline.next();
                    pic = sline.next();
                    finalists.add(new Finalist(name, Integer.parseInt(score), pic));
                }

                sline.close();
            }
            sfile.close();
        } catch (FileNotFoundException e) {
            System.out.println("answers not found");
        }
    }

    public void showStage() {
        this.show();
    }
}


import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.collections.FXCollections;
import javafx.scene.media.*;
import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.media.MediaPlayer.Status;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class WelcomeForm extends Stage {

    private Scene wf;
    private Pane p;
    private PasswordField pBox;
    private Button btnLogin, btnMute, btnExit, btnWinner;
    private String countries[] = {"Solomon Islands", "South Sudan", "Turkmenistan", "Slovenia", "Slovakia"};
    private Finalist cFinalist = new Finalist();
    private FinalistList fList = new FinalistList();
    ;
    private ComboBox countryList, finalistList;
    private Media media;
    private MediaPlayer mediaPlayer;
    private boolean finished = false, isCandidate = false, goToResults = false, seeWinner = false;
    private Status status = Status.STOPPED;
    private String anthem;
    private File finalistsData = new File("./data", "finalists.txt");
    private Image icon, pic, mute, unmute, back;
    private ImageView image, soundBtn, background;
    private Label error;

    public WelcomeForm() {
        //initialising the lists to be used for the comboboxes

        //creating the drop down list to select names
        Label fName = new Label("Select your name");
        fName.setLayoutX(30);
        fName.setLayoutY(25);
        fName.setTextFill(Color.DARKGRAY);
        finalistList = new ComboBox(FXCollections.observableArrayList(fList.getNames()));
        finalistList.setPromptText("Finalist Names");
        finalistList.setLayoutX(150);
        finalistList.setLayoutY(25);

        //setting the name of the current candidate
        finalistList.setOnAction(e -> {
            cFinalist.setName(finalistList.getValue().toString());

            for (int i = 0; i < fList.getFinalists().size(); i++) {
                if (finalistList.getValue().toString().equals(fList.getFinalists().get(i).getName())) {
                    cFinalist.setPic(fList.getFinalists().get(i).getPic());
                    cFinalist.setFlag(fList.getFinalists().get(i).getFlag());
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

        //creating textfield for entering password
        Label password = new Label("Enter Password ");
        password.setLayoutX(30);
        password.setLayoutY(50);
        password.setTextFill(Color.DARKGRAY);
        pBox = new PasswordField();
        pBox.setLayoutX(150);
        pBox.setLayoutY(50);

        ////creating the drop down list to select country
        Label country = new Label("Select Country ");
        country.setLayoutX(30);
        country.setLayoutY(75);
        country.setTextFill(Color.DARKGRAY);
        countryList = new ComboBox(FXCollections.observableArrayList(countries));
        countryList.setPromptText("Countries");
        countryList.setLayoutX(150);
        countryList.setLayoutY(75);

        //code for playing the anthem when a country is selected
        countryList.setOnAction(e -> {

            //setting the country of the current candidate
            cFinalist.setCountry(countryList.getValue().toString());
            //switch case to select anthem
            switch (countryList.getValue().toString()) {
                case "Solomon Islands":
                    anthem = "./audio/Solomon Islands National Anthem.mp3";
                    break;
                case "South Sudan":
                    anthem = "./audio/South Sudan National Anthem.mp3";
                    break;
                case "Turkmenistan":
                    anthem = "./audio/Turkmenistan National Anthem.mp3";
                    break;
                case "Slovenia":
                    anthem = "./audio/Slovenia National Anthem.mp3";
                    break;
                case "Slovakia":
                    anthem = "./audio/Slovak National Anthem.mp3";
                    break;
            }
            //setting up the mediaplayer to play the anthem
            switch (status) {
                case STOPPED:
                    media = new Media(new File(anthem).toURI().toString());
                    mediaPlayer = new MediaPlayer(media);
                    mediaPlayer.play();
                    status = Status.PLAYING;
                    break;
                case PLAYING:
                    mediaPlayer.stop();
                    media = new Media(new File(anthem).toURI().toString());
                    mediaPlayer = new MediaPlayer(media);
                    mediaPlayer.play();
                    status = Status.PLAYING;
                    break;
            }

        });

        //label for displaying error messages when info entered is missing or incorrect
        error = new Label();
        error.setLayoutX(190);
        error.setLayoutY(125);
        error.setTextFill(Color.RED);

        //button to mute music
        try {
            mute = new Image(new FileInputStream("./pictures/Mute.jpg"));
            unmute = new Image(new FileInputStream("./pictures/sound.jpg"));
        } catch (FileNotFoundException m) {
            System.out.println("mute button image not found");
        }
        soundBtn = new ImageView(mute);
        soundBtn.setFitHeight(20);
        soundBtn.setFitWidth(20);
        btnMute = new Button();
        btnMute.setShape(new Circle(2.5));
        btnMute.setMaxSize(5, 5);
        btnMute.setGraphic(soundBtn);
        btnMute.setLayoutX(400);
        btnMute.setLayoutY(10);

        //defining what btnMute does
        btnMute.setOnAction(e -> {
            try {
                if (mediaPlayer.isMute()) {
                    soundBtn.setImage(mute);
                    mediaPlayer.setVolume(1.0);
                    mediaPlayer.setMute(false);
                } else {
                    soundBtn.setImage(unmute);
                    mediaPlayer.setVolume(0);
                    mediaPlayer.setMute(true);
                }
            } catch (Exception ie) {
            }
        });

        //button to login and proceed to test
        btnLogin = new Button("Login");
        btnLogin.setLayoutX(350);
        btnLogin.setLayoutY(200);

        //defining what is checked and done when the login button is pressed
        btnLogin.setOnAction(e -> {
            checkCredentials();
        });

        btnWinner = new Button("See Winner");
        btnWinner.setLayoutX(350);
        btnWinner.setLayoutY(230);
        btnWinner.setOnAction(e -> {
            seeWinner = true;
            checkCredentials();
        });

        btnExit = new Button("Exit");
        btnExit.setLayoutX(350);
        btnExit.setLayoutY(260);
        btnExit.setOnAction(e -> {
            System.exit(0);

        });

        //setting a background image
        try {
            back = new Image(new FileInputStream("./pictures/background.jpg"));
            background = new ImageView(back);
            background.setFitHeight(400);
            background.setFitWidth(450);
        } catch (FileNotFoundException be) {
            System.out.println("background image not found");
        }

        p = new Pane();
        p.getChildren().add(background);
        p.getChildren().add(fName);
        p.getChildren().add(finalistList);
        p.getChildren().add(password);
        p.getChildren().add(pBox);
        p.getChildren().add(country);
        p.getChildren().add(countryList);
        p.getChildren().add(btnMute);
        p.getChildren().add(btnLogin);
        p.getChildren().add(btnExit);
        p.getChildren().add(btnWinner);
        p.getChildren().add(error);

        wf = new Scene(p, 450, 400);
        this.setScene(wf);
        this.setTitle("Login");
        try {
            icon = new Image(new FileInputStream("./pictures/logo.png"));
            this.getIcons().add(icon);
        } catch (FileNotFoundException e) {
            System.out.println("ERROR: Unable to find logo.png");
        }
        this.show();
    }

    public void showStage() {
        this.show();
    }

    public void checkCredentials() {
        //declaring and initialising booleans to check for errors
        boolean nameEmpty = finalistList.getSelectionModel().isEmpty();
        boolean noPassword = pBox.getText().equals("");
        boolean countryEmpty = countryList.getSelectionModel().isEmpty();
        boolean allEntered = false;

        //checking if everything has been selected and entered
        if (!nameEmpty && !noPassword && !countryEmpty) {
            allEntered = true;
        } else {
            //error message if any info is missing
            error.setText("Please enter your credentials! (＃`Д´)");
        }
        if (allEntered) {
            for (int i = 0; i < fList.getFinalists().size(); i++) {
                //checking if the password entered matches that of the name selected
                if (finalistList.getValue().equals(fList.getFinalists().get(i).getName())) {
                    if (pBox.getText().equals(fList.getFinalists().get(i).getPassword())) {
                        isCandidate = true;
                        error.setText("");
                        try {
                            mediaPlayer.stop();
                        } catch (NullPointerException npe) {
                        }
                        //closing the welcome form
                        this.hide();
                    } else {
                        error.setText("Incorrect name or password entered! Try again \n(＃`Д´)");
                        error.setTextFill(Color.RED);
                    }
                }

            }
        }
    }

    public String getCFinalistName() {
        return cFinalist.getName();
    }

    public String getCFinalistFlag() {
        return cFinalist.getFlag();
    }

    public Boolean goWinner() {
        return seeWinner;
    }

}

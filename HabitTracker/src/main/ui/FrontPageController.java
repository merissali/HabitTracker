package ui;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;


public class FrontPageController {

    private OtherPagesController otherPagesController;
    String musicFile = "Music.mp3";
//    Media sound = new Media(new File(musicFile).toURI().toString());
//    MediaPlayer mediaPlayer = new MediaPlayer(sound);

    @FXML
    public Label habitTracker;

    @FXML
    public Label dailyHabits;

    @FXML
    public Label question;

    @FXML
    public Button numberOne;

    @FXML
    public Button numberTwo;

    @FXML
    public Button numberThree;

    @FXML
    public Button numberFour;

    @FXML
    public Button numberFive;

    @FXML
    public Button numberSix;

    @FXML
    public Button numberSeven;

    @FXML
    public Button soundButton;

    // EFFECTS: displays the AddNew scene
    @FXML
    public void viewAddNew() throws IOException {
        System.out.println("viewing add new page");
        Parent windowAddNew;
        windowAddNew = FXMLLoader.load(getClass().getResource("AddNew.fxml"));
        Stage mainStage = Gui.parentWindow;
        mainStage.getScene().setRoot(windowAddNew);
    }

    // EFFECTS: displays the ViewCategory scene
    @FXML
    public void viewViewCategory() throws IOException {
        System.out.println("viewing add new page");
        Parent windowViewCategory;
        windowViewCategory = FXMLLoader.load(getClass().getResource("ViewCategory.fxml"));
        Stage mainStage = Gui.parentWindow;
        mainStage.getScene().setRoot(windowViewCategory);
    }

    // EFFECTS: displays the CheckOff scene
    @FXML
    public void viewCheckOff() throws IOException {
        System.out.println("viewing check off page");
        Parent windowCheckOff;
        windowCheckOff = FXMLLoader.load(getClass().getResource("CheckOff.fxml"));
        Stage mainStage = Gui.parentWindow;
        mainStage.getScene().setRoot(windowCheckOff);
    }

    // EFFECTS: displays the ViewDaily scene
    @FXML
    public void viewViewDaily() throws IOException {
        System.out.println("viewing check off page");
        Parent windowViewDaily;
        windowViewDaily = FXMLLoader.load(getClass().getResource("ViewDaily.fxml"));
        Stage mainStage = Gui.parentWindow;
        mainStage.getScene().setRoot(windowViewDaily);
    }

    // EFFECTS: displays the ViewRelated scene
    @FXML
    public void viewRelatedHabits() throws IOException {
        System.out.println("viewing check off page");
        Parent windowViewRelated;
        windowViewRelated = FXMLLoader.load(getClass().getResource("ViewRelated.fxml"));
        Stage mainStage = Gui.parentWindow;
        mainStage.getScene().setRoot(windowViewRelated);
    }

    public FrontPageController() {
    }
//
//    @FXML
//    public void playMusic() {
//        mediaPlayer.play();
//    }
}

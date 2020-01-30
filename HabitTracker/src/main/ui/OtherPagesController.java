package ui;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;
import model.habit.Category;
import model.habit.Habit;
import model.habit.HabitList;
import model.habit.HabitSorter;
import network.ReadWebPage;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;


public class OtherPagesController {

    ReadWebPage readWebPage = new ReadWebPage();
    private FrontPageController frontPageController;
    HabitSorter habitSorter = new HabitSorter();
    HabitList habitList = new HabitList();
    Category category;
    //    FileOutputStream outputFile = new FileOutputStream("habitListOutput.txt");
//    FileInputStream inputFile = new FileInputStream("habitListOutput.txt");
//    FileOutputStream habitSorterOutput = new FileOutputStream("habitSorterOutput.txt");
//    FileInputStream habitSorterInput = new FileInputStream("habitSorterOutput.txt");
    File file = new File("src/uwu.jpg");
    Image image = new Image(file.toURI().toString());

    @FXML
    public TextArea inputBox;

    @FXML
    public Button backButton;

    @FXML
    public Button backButtonInViewDaily;

    @FXML
    public Button enter;

    @FXML
    public TextArea checkHabitInput;

    @FXML
    public Button enterCheckHabitInput;

    @FXML
    public Label dailyHabits;

    @FXML
    public ImageView dog;

    @FXML
    public void setPromptText() {
        inputBox.setPromptText("Please enter category name");
    }

    // EFFECTS: displays Front Page
    @FXML
    public void viewFrontPage() throws IOException {
        System.out.println("viewing Front page");
        Parent windowFrontPage;
        windowFrontPage = FXMLLoader.load(getClass().getResource("FrontPage.fxml"));
        Stage mainStage = Gui.parentWindow;
        mainStage.getScene().setRoot(windowFrontPage);
    }

    // EFFECTS: displays KeepUpGoodWork Page
    @FXML
    public void viewKeepUpGoodWork() throws IOException {
        System.out.println("viewing KeepUpGoodWork page");
        Parent windowKeepUpGoodWork;
        windowKeepUpGoodWork = FXMLLoader.load(getClass().getResource("KeepUpGoodWork.fxml"));
        Stage mainStage = Gui.parentWindow;
        mainStage.getScene().setRoot(windowKeepUpGoodWork);
    }

    // EFFECTS: creates a new category with input text
    @FXML
    public void submitCategory() {
        String categoryString = inputBox.getText();
        category = new Category(categoryString);
        habitSorter.addHabitRelation(category);
        changeInputTextToHabitName();
        System.out.println("Category submitted");
        inputBox.setText("");
    }

    @FXML
    public void changeInputTextToHabitName() {
        inputBox.setPromptText("Category submitted! Now please enter habit name");
    }

    // EFFECTS: creates new habit under specified category
    @FXML
    public void submitHabit() throws IOException {
        String habitString = inputBox.getText();
        Habit habit = new Habit(habitString, readWebPage);
        habitSorter.addHabitRelation(category, habit);
        habitList.addHabit(habit);
        habitList.save();
//        habitSorter.save();
        System.out.println("Habit submitted");
        inputBox.setText("");
    }

    // EFFECTS: checks off a habit
    @FXML
    public void checkOff() throws IOException {
        String checkHabit = checkHabitInput.getText();
        habitList.searchForHabit(checkHabit).markDone();
        checkHabitInput.setText("");
        checkHabitInput.setPromptText("Habit checked off!");
        System.out.println("Habit checked off!");
        viewKeepUpGoodWork();
    }

    // EFFECTS: displays the list of habits
    @FXML
    public void displayHabits() {
        dailyHabits.setText("test");
        dailyHabits.setText(habitList.print());
        habitSorter.printAll();
    }



}

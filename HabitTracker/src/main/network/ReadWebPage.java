package network;

import model.habit.Habit;
import model.habit.HabitList;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Observable;
import java.util.Observer;
//import java.util.Observer;

public class ReadWebPage implements Observer, Serializable {
    // concrete observer
    // generate random dog image for every habit completed (for motivation! hehe)
    // https://random.dog/woof.json
    BufferedReader br;

    public ReadWebPage() {
        br = null;
    }

    // EFFECTS: reads the web page
    public void readWebPage() throws MalformedURLException, IOException {
        try {
            String theURL = "https://random.dog/woof.json"; //this can point to any URL
            URL url = new URL(theURL);
            br = new BufferedReader(new InputStreamReader(url.openStream()));

            String line;

            StringBuilder sb = new StringBuilder();

            while ((line = br.readLine()) != null) {

                sb.append(line);
                sb.append(System.lineSeparator());
            }

            System.out.println(sb);
        } finally {

            if (br != null) {
                br.close();
            }
        }
    }

    // EFFECTS: update observable and print out URL to a randombized picture of dog
    public void update(Observable o, Object arg) {
        Habit habit = (Habit) o;
        System.out.println("Good job on completing a habit! Here's a dog :)");
        try {
            readWebPage();
        } catch (IOException e) {
            System.out.println("URL invalid");
            e.printStackTrace();
        }
    }

}

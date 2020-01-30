package model.habit;

import java.io.FileInputStream;
import java.io.IOException;

public interface Loadable {
    public HabitList load(FileInputStream fileInStr) throws IOException, ClassNotFoundException;
}

package model.habit;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public interface Saveable {

    public void save() throws IOException;
}

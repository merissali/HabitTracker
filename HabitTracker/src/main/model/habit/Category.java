package model.habit;

import java.io.Serializable;

public class Category implements Serializable {
    String categoryName;

    public Category(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getName() {
        return categoryName;
    }

}

package pl.mareksowa.models.foods;

import java.util.List;

public interface IMainCourseMenuCreator {
    //methods help indicate 'class-names', this allow to creating lots of class without interrupt main program
    //(program is open for extensions without changing current code;)
    List<Food> createMainCourseMenu();
    List<Food> showMainCourseMenu();
}

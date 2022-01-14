module pl.edu.student.tgargula.fuzzify {
    requires javafx.controls;
    requires javafx.fxml;
    requires jFuzzyLogic;


    opens pl.edu.student.tgargula.fuzzify to javafx.fxml;
    exports pl.edu.student.tgargula.fuzzify;
}
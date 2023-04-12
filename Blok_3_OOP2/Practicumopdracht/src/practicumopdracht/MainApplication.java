package practicumopdracht;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import practicumopdracht.controllers.Controller;
import practicumopdracht.controllers.WorkoutController;
import practicumopdracht.data.*;
import java.io.File;

public class MainApplication extends Application {

    private static final String TITLE = String.format("Practicumopdracht OOP2 - %s", Main.studentNaam);
    private static final int WIDTH = 640;
    private static final int HEIGHT = 480;

    private static Stage stage;
    private static ExerciseDAO exerciseDAO;
    private static WorkoutDAO workoutDAO;

    public MainApplication() {
        stage = new Stage();
        workoutDAO = new BinaryWorkoutDAO();
        exerciseDAO = new ObjectExerciseDAO();
    }

    @Override
    public void start(Stage stage) {
        if(!Main.launchedFromMain) {
            System.err.println("Je moet deze applicatie opstarten vanuit de Main-class, niet de MainApplication-class!");
            System.exit(1337);

            return;
        }

        MainApplication.stage.setTitle(TITLE);
        MainApplication.stage.setResizable(false);

        switchController(new WorkoutController());
    }

    public static void switchController(Controller controller) {
        File styles = new File("src/practicumopdracht/assets/style.css");

        stage.setScene(new Scene(controller.getView().getRoot(), WIDTH, HEIGHT));
        stage.getScene().getStylesheets().add("file:///" + styles.getAbsolutePath().replace("\\", "/"));
        stage.show();
    }

    public static WorkoutDAO getWorkoutDAO() {
        return workoutDAO;
    }

    public static ExerciseDAO getExerciseDAO() {
        return exerciseDAO;
    }
}

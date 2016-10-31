package loginmaterial;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class LoginMaterial extends Application {

    public static Stage window;

    @Override
    public void start(Stage window) {
        LoginMaterial.window = window;
        LoginMaterial.window.setTitle("Demo");
        LoginMaterial.window.setScene(new Login().login());
//        LoginMaterial.window.initStyle(StageStyle.TRANSPARENT);
        
        LoginMaterial.window.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}

package loginmaterial;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXRadioButton;
import com.jfoenix.controls.JFXTextField;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;
import javafx.stage.Screen;

public class Login {

    public double SceneX, SceneY;

    private static final double WIDTH = 250;
    private static final double HEIGHT = 400;

    Image image;
    ImageView myImage;
    Label title, forgotPassword, lblnopassword;
    JFXTextField username;
    JFXPasswordField password;
    JFXButton sigin, signup, profPic;
    JFXRadioButton rem;

    private static String primaryColor = "51BFA4";
    private static String primaryFieldBackgroundColor = "EBE6E2";
    private static String background = "#e0e0e0";

    public Scene login() {
        StackPane root = new StackPane(this.pane());
        root.setPadding(new Insets(20, 100, 20, 100));
        Scene login = new Scene(root, 600, 620);
//        login.setFill(Color.TRANSPARENT);
        login.getStylesheets().add(getClass().getResource("signlogin.css").toExternalForm());
        return login;
    }

    private StackPane pane() {
        StackPane pane = new StackPane();

        pane.setOnMousePressed(event -> {
            this.SceneX = event.getSceneX();
            this.SceneY = event.getSceneY();
        });

        pane.setOnMouseDragged(event -> {
            LoginMaterial.window.setX(event.getScreenX() - this.SceneX);
            LoginMaterial.window.setY(event.getScreenY() - this.SceneY);
        });

        pane.getChildren().add(trialLayout());
        pane.setId("pane");
        return pane;
    }

    private VBox trialLayout() {
        VBox trial = new VBox();
        trial.setMaxSize(WIDTH, HEIGHT);
        trial.getChildren().addAll(layout());
        return trial;
    }

    private VBox layout() {
        VBox layout = new VBox(25);
        title = new Label("Login");
        title.setId("title");
        title.setPadding(new Insets(0, 0, 0, 75));
        Image myImage = new Image(this.getClass().getResource("preview1.jpg").toExternalForm());

        ImageView myImageView = new ImageView(myImage);
        myImageView.setFitHeight(100);
        myImageView.setFitWidth(100);
        myImageView.setId("myImageView");

        Circle c = new Circle(myImageView.getFitWidth() / 2, myImageView.getFitHeight() / 2, 50);
        myImageView.setClip(c);
        VBox.setMargin(myImageView, new Insets(0, 0, 10, 75));

        username = new JFXTextField();
        username.setPromptText("Username");
        username.setFocusColor(Paint.valueOf(primaryColor));
        username.setId("username");
        username.setLabelFloat(true);
        username.setUnFocusColor(Paint.valueOf(primaryColor));

        password = new JFXPasswordField();
        password.setPromptText("Password");
        password.setFocusColor(Paint.valueOf(primaryColor));
        password.setLabelFloat(true);
        password.setUnFocusColor(Paint.valueOf(primaryColor));

        rem = new JFXRadioButton();
        rem.setText("Remember me?");

        VBox vBox = new VBox(10);
        sigin = new JFXButton();
        sigin.setText("Sign in");
        sigin.setMinWidth(WIDTH);
        sigin.setId("sigin");
        sigin.setOnAction(__ -> {
            LoginMaterial.window.setScene(new DashBoard().dashBoard());
            LoginMaterial.window.setResizable(false);

            Rectangle2D rect = Screen.getPrimary().getVisualBounds();
            double pos = (rect.getWidth() / 2) - (LoginMaterial.window.getScene().getWidth() / 2);

            LoginMaterial.window.setX(pos);
        });

        forgotPassword = new Label();
        forgotPassword.setId("forgotPassword");
        forgotPassword.setText("Forgot your password?");
        forgotPassword.setAlignment(Pos.CENTER);
        forgotPassword.setPadding(new Insets(0, 0, 0, 75));

        vBox.getChildren().addAll(sigin, forgotPassword);

        HBox hBox = new HBox(50);
        lblnopassword = new Label("Don't have an account?");
        signup = new JFXButton("Sign up");
        signup.setId("signup");
        signup.setOnAction(__ -> {
            LoginMaterial.window.setScene(new Signup().signup());
        });
//        signup.setPadding(new Insets(0,0,0,25));
        hBox.getChildren().addAll(lblnopassword, signup);

        layout.getChildren().addAll(myImageView, username, password, rem, vBox, hBox);
        return layout;
    }
}

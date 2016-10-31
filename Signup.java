package loginmaterial;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXRippler;
import com.jfoenix.controls.JFXTextField;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;

public class Signup {

    private double SceneX, SceneY;

    private static final double WIDTH = 250;
    private static final double HEIGHT = 400;

    private static final String PRIMARYCOLOR = "#4FD2C2";

    Label lblfullName, lblemail, lblusername, lblpassword, lbldob, lblalreadypass, lblsignin;
    JFXTextField fullName, username, email;
    JFXPasswordField password;
    JFXButton create, addProfPic;
    JFXDatePicker dob;

    Image img = new Image(this.getClass().getResource("preview2.jpg").toExternalForm());
    ImageView myImageView, plusImageView;

    Image plus = new Image(this.getClass().getResource("pluspreview1.png").toExternalForm());

    public Scene signup() {
        StackPane root = new StackPane(this.pane());
        root.setPadding(new Insets(20, 100, 20, 100));
        Scene signup = new Scene(root, 600, 620);
        signup.getStylesheets().add(this.getClass().getResource("signuplogin.css").toExternalForm());
        signup.setFill(null);
        return signup;
    }

    private StackPane pane() {
        StackPane pane = new StackPane();

        pane.setOnMousePressed(__ -> {
            this.SceneX = __.getSceneX();
            this.SceneY = __.getSceneY();
        });

        pane.setOnMouseDragged(__ -> {
            LoginMaterial.window.setX(__.getScreenX() - this.SceneX);
            LoginMaterial.window.setY(__.getScreenY() - this.SceneY);
        });

        pane.setId("pane");
        pane.getChildren().addAll(sizedLayout());
        return pane;
    }

    private VBox sizedLayout() {
        VBox sizedLayout = new VBox();
        sizedLayout.setMaxSize(WIDTH, HEIGHT);
        sizedLayout.getChildren().addAll(layout());
        return sizedLayout;
    }

    private VBox layout() {
        VBox layout = new VBox(5);

        StackPane pane = new StackPane();

        addProfPic = new JFXButton();
        addProfPic.setId("addprofpic");
        addProfPic.setOnAction(__ -> {
            LoginMaterial.window.setIconified(true);
        });
        StackPane.setMargin(addProfPic, new Insets(0, 0, 52, 100));
        plusImageView = new ImageView(plus);
        plusImageView.setFitHeight(25);
        plusImageView.setFitWidth(25);
        addProfPic.setGraphic(plusImageView);

        myImageView = new ImageView(img);
        myImageView.setFitHeight(100);
        myImageView.setFitWidth(100);
        Circle c = new Circle(myImageView.getFitWidth() / 2, myImageView.getFitHeight() / 2, 50);
        myImageView.setClip(c);
        VBox.setMargin(myImageView, new Insets(0, 0, 10, 75));

        pane.getChildren().addAll(myImageView, addProfPic);

        lblfullName = new Label("FULL NAME");
        lblfullName.setId("lblfullName");

        fullName = new JFXTextField();
        fullName.setFocusColor(Paint.valueOf(PRIMARYCOLOR));
        fullName.setUnFocusColor(Paint.valueOf(PRIMARYCOLOR));

        lblusername = new Label("USERNAME");
        lblusername.setId("lblusername");

        username = new JFXTextField();
        username.setFocusColor(Paint.valueOf(PRIMARYCOLOR));
        username.setUnFocusColor(Paint.valueOf(PRIMARYCOLOR));

        lblemail = new Label("EMAIL");
        lblemail.setId("lblemail");

        email = new JFXTextField();
        email.setFocusColor(Paint.valueOf(PRIMARYCOLOR));
        email.setUnFocusColor(Paint.valueOf(PRIMARYCOLOR));

        lblpassword = new Label("PASSWORD");
        lblpassword.setId("lblpassword");

        password = new JFXPasswordField();
        password.setFocusColor(Paint.valueOf(PRIMARYCOLOR));
        password.setUnFocusColor(Paint.valueOf(PRIMARYCOLOR));

        lbldob = new Label("BIRTHDAY");
        lbldob.setId("lbldob");

        dob = new JFXDatePicker();
        dob.setMinWidth(WIDTH);
        dob.setDefaultColor(Paint.valueOf(PRIMARYCOLOR));

        create = new JFXButton("Create");
        create.setId("btncreate");
        create.setMinWidth(WIDTH);
        create.setMinHeight(50);
        VBox.setMargin(create, new Insets(5, 0, 5, 0));

        HBox hBox = new HBox(20);
        lblalreadypass = new Label("ALREADY HAVE AN ACCOUNT");
        lblalreadypass.setId("lblalreadypass");

        lblsignin = new Label("SIGN IN");
        lblsignin.setId("lblsignin");
        lblsignin.setOnMouseClicked(__ -> {
            LoginMaterial.window.setScene(new Login().login());
        });
        JFXRippler ripple = new JFXRippler(lblsignin);
        hBox.getChildren().addAll(lblalreadypass, ripple);

        layout.getChildren().addAll(pane,
                lblfullName, fullName,
                lblusername, username, lblemail,
                email, lblpassword, password, lbldob, dob,
                create, hBox);
        return layout;
    }
    
}

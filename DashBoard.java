package loginmaterial;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDrawer;
import com.jfoenix.controls.JFXHamburger;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.transitions.hamburger.HamburgerBackArrowBasicTransition;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;

public class DashBoard {

    private static final double WIDTH = 1000;
    private static final double HEIGHT = 500;

    Image img = new Image(this.getClass().getResource("preview2.jpg").toExternalForm());
    ImageView myImageView, dshBoard, msg, brwser, localAct;

    JFXHamburger menuham;
    JFXButton plusJrny;
    JFXTextField search;
    JFXDrawer myMenuDrawer;

    private static final String FOCUS_COLOR = "#34B8CD";

    public Scene dashBoard() {
        StackPane root = new StackPane(this.pane());
        root.setPadding(new Insets(20, 60, 20, 60));
        Scene dashboard = new Scene(root, 1200, 600);
        dashboard.getStylesheets().add(this.getClass().getResource("dashboard.css").toExternalForm());
        return dashboard;
    }

    private StackPane pane() {
        StackPane pane = new StackPane();
        pane.setId("pane");
        pane.getChildren().addAll(sizedLayout());
        return pane;
    }

    private BorderPane sizedLayout() {
        BorderPane layout = new BorderPane();
        layout.setMaxSize(WIDTH, HEIGHT);
        layout.getChildren().addAll(layout());
        return layout;
    }

    private BorderPane layout() {
        BorderPane layout = new BorderPane();

        HBox topBelow = new HBox();
        topBelow.setPadding(new Insets(0));
        topBelow.setMinSize(WIDTH, 100);
        topBelow.setId("topBelow");

        VBox allTop = new VBox(0);
        allTop.getChildren().addAll(topSection(), topBelow);
        layout.setTop(allTop);

//        WorldWideWebNow
        layout.setLeft(leftMenu());

        layout.setCenter(centerContent());

        return layout;
    }

    private BorderPane topSection() {
        BorderPane topPane = new BorderPane();
        topPane.setMinWidth(WIDTH);
        myImageView = new ImageView(img);
        myImageView.setFitHeight(40);
        myImageView.setFitWidth(40);
        Circle c = new Circle(myImageView.getFitWidth() / 2, myImageView.getFitHeight() / 2, 20);
        myImageView.setClip(c);
        BorderPane.setMargin(myImageView, new Insets(0, 10, 0, 0));
        topPane.setRight(myImageView);

        HBox topCenter = new HBox(80);
        BorderPane.setMargin(topCenter, new Insets(10, 0, 0, 0));
        plusJrny = new JFXButton("+ New Journey");
        plusJrny.setId("plusJrny");
        HBox.setMargin(plusJrny, new Insets(0, 10, 0, 0));

        search = new JFXTextField();
        search.setPromptText("Search Journey");
        search.setId("search");
        search.setFocusColor(Paint.valueOf(FOCUS_COLOR));
        search.setMinWidth(100);
        search.setFocusTraversable(false);
        search.setPadding(new Insets(0, 0, 0, 30));
        Region region = new Region();
        region.setPrefWidth(200);
        HBox.setHgrow(region, Priority.ALWAYS);

        HBox.setMargin(plusJrny, new Insets(0, 25, 0, 0));
        topCenter.getChildren().addAll(region, search, plusJrny);
        topCenter.setId("topCenter");

//        BorderPane.setMargin(topCenter, new Insets(0, 0, 0, 200));
        topPane.setCenter(topCenter);

        HBox topLeft = new HBox(50);
        menuham = new JFXHamburger();
        topLeft.setId("topLeft");
//        HBox.setMargin(menuham, new Insets(0, 0, 0, 10));
        Label journeys = new Label("Journey (15)");
        HBox.setMargin(journeys, new Insets(15, 0, 0, 0));
        topLeft.getChildren().addAll(menuham, journeys);

        topPane.setLeft(topLeft);

        return topPane;
    }

    private VBox drawerContent() {
        VBox content = new VBox(25);
        myImageView = new ImageView(img);

        dshBoard = new ImageView(new Image(this.getClass().getResource("ic_dashboard_black_48dp_1x.png").toExternalForm()));
        JFXButton btndshBoard = new JFXButton();
        btndshBoard.setId("btndshBoard");
        btndshBoard.setGraphic(dshBoard);
        btndshBoard.setPadding(new Insets(0));

        msg = new ImageView(new Image(this.getClass().getResource("ic_message_black_48dp_1x.png").toExternalForm()));
        JFXButton btnmsg = new JFXButton();
        btnmsg.setId("btndshBoard");
        btnmsg.setGraphic(msg);
        btnmsg.setPadding(new Insets(0));

        brwser = new ImageView(new Image(this.getClass().getResource("ic_open_in_browser_black_48dp_1x.png").toExternalForm()));
        JFXButton btnbrwser = new JFXButton();
        btnbrwser.setId("btndshBoard");
        btnbrwser.setGraphic(brwser);
        btnbrwser.setPadding(new Insets(0));

        localAct = new ImageView(new Image(this.getClass().getResource("ic_local_activity_black_48dp_1x.png").toExternalForm()));
        JFXButton btnlocalAct = new JFXButton();
        btnlocalAct.setId("btndshBoard");
        btnlocalAct.setGraphic(localAct);
        btnlocalAct.setPadding(new Insets(0));

        content.getChildren().addAll(btndshBoard, btnmsg, btnbrwser, btnlocalAct);
        return content;
    }

    private VBox leftMenu() {
        VBox leftMenu = new VBox();
        leftMenu.setMinWidth(0);

        myMenuDrawer = new JFXDrawer();
        myMenuDrawer.setSidePane(drawerContent());
        myMenuDrawer.setDefaultDrawerSize(50);

        HamburgerBackArrowBasicTransition trans = new HamburgerBackArrowBasicTransition(menuham);
        trans.setRate(-1);
        menuham.addEventHandler(MouseEvent.MOUSE_PRESSED, __ -> {
            trans.setRate(trans.getRate() * -1);
            trans.play();
            if (myMenuDrawer.isShown()) {
                myMenuDrawer.close();
            } else {
                myMenuDrawer.open();
            }
        });

        leftMenu.getChildren().addAll(myMenuDrawer);
        return leftMenu;
    }

    private BorderPane centerContent() {
        BorderPane centercontent = new BorderPane();
        centercontent.setPadding(new Insets(0, 0, 10, 0));

        VBox leftSpace = new VBox();
        leftSpace.setMinWidth(200);
        centercontent.setLeft(leftSpace);

        VBox leftcard = new VBox();
        leftcard.setMaxSize(200, 400);
        leftcard.setMinSize(200, 400);
        leftcard.setId("card");
        leftcard.getChildren().add(leftCardContent());

        VBox centercard = new VBox();
        centercard.setMaxSize(200, 400);
        centercard.setMinSize(200, 400);
        centercard.setId("card");
        centercard.getChildren().add(centerCardContent());

        VBox rightcard = new VBox();
        rightcard.setMaxSize(200, 400);
        rightcard.setMinSize(200, 400);
        rightcard.setId("card");
        rightcard.getChildren().add(rightCardContent());

        HBox cards = new HBox(50);
        cards.getChildren().addAll(leftcard, centercard, rightcard);

        centercontent.setCenter(cards);

        return centercontent;
    }

    private VBox leftCardContent() {
        VBox content = new VBox(10);
        content.setId("leftCardContent");

        StackPane mvrtProf = new StackPane();
        VBox.setMargin(mvrtProf, new Insets(20, 0, 0, 0));
        ImageView moreVert = new ImageView(new Image(this.getClass().getResource("ic_more_vert_black_48dp_1x.png").toExternalForm()));
        moreVert.setFitHeight(25);
        moreVert.setFitWidth(25);
        StackPane.setAlignment(moreVert, Pos.TOP_RIGHT);

        ImageView profPic = new ImageView(new Image(this.getClass().getResource("preview2.jpg").toExternalForm()));
        profPic.setFitHeight(100);
        profPic.setFitWidth(100);
        Circle c = new Circle(profPic.getFitWidth() / 2, profPic.getFitHeight() / 2, 50);
        profPic.setClip(c);
        VBox.setMargin(profPic, new Insets(0, 0, 0, 50));

        mvrtProf.getChildren().addAll(profPic, moreVert);

        StackPane labels = new StackPane();
        Label placeName = new Label("FARM HILL");
        placeName.setId("placename");
        StackPane.setAlignment(placeName, Pos.CENTER);

        Label descrip = new Label("Nice place to relax all your thoughts ...");
        descrip.setPadding(new Insets(5));
        descrip.setId("descrip");
        StackPane.setMargin(descrip, new Insets(50, 0, 0, 0));
        StackPane.setAlignment(descrip, Pos.CENTER);
        labels.getChildren().addAll(placeName, descrip);

        HBox friends = new HBox(10);
        StackPane friendStack = new StackPane();
        friendStack.setId("friendStack");
        friends.setPadding(new Insets(5));
        ImageView p1 = new ImageView(new Image(this.getClass().getResource("preview7.jpg").toExternalForm()));
        p1.setId("pics");
        p1.setFitHeight(40);
        p1.setFitWidth(40);
        p1.setClip(new Circle(20, 20, 20));
        ImageView p2 = new ImageView(new Image(this.getClass().getResource("preview12.jpg").toExternalForm()));
        p2.setId("pics");
        p2.setFitHeight(40);
        p2.setFitWidth(40);
        p2.setClip(new Circle(20, 20, 20));
        ImageView p3 = new ImageView(new Image(this.getClass().getResource("preview10.jpg").toExternalForm()));
        p3.setId("pics");
        p3.setFitHeight(40);
        p3.setFitWidth(40);
        p3.setClip(new Circle(20, 20, 20));

        JFXButton btnmore = new JFXButton("8");
        btnmore.setId("btnmore");

        friends.getChildren().addAll(p1, p2, p3, btnmore);
        StackPane.setAlignment(friends, Pos.CENTER);
        friendStack.getChildren().addAll(friends);

        Separator s = new Separator();
        s.setOrientation(Orientation.HORIZONTAL);
        VBox.setMargin(s, new Insets(0, 5, 0, 5));

        double size = 25;

        HBox tasks = new HBox(20);
        StackPane taskStack = new StackPane();
        VBox vBox1 = new VBox(10);
        ImageView schedule = new ImageView(new Image(this.getClass().getResource("ic_schedule_black_48dp_1x.png").toExternalForm()));
        schedule.setFitHeight(size);
        schedule.setFitWidth(size);
        VBox.setMargin(schedule, new Insets(0, 0, 0, 20));
        Label dt1 = new Label("25 OCT 2016");
        vBox1.getChildren().addAll(schedule, dt1);

        VBox vBox2 = new VBox(10);
        ImageView flag = new ImageView(new Image(this.getClass().getResource("ic_flag_black_48dp_1x.png").toExternalForm()));
        flag.setFitHeight(size);
        flag.setFitWidth(size);
        VBox.setMargin(flag, new Insets(0, 0, 0, 20));
        Label dt2 = new Label("FARM HILL");
        vBox2.getChildren().addAll(flag, dt2);

        Separator s1 = new Separator();
        s1.setOrientation(Orientation.VERTICAL);
        HBox.setMargin(s1, new Insets(5, 0, 5, 0));

        tasks.getChildren().addAll(vBox1, s1, vBox2);
        StackPane.setAlignment(tasks, Pos.CENTER);
        taskStack.getChildren().add(tasks);
        VBox.setMargin(taskStack, new Insets(10));

        content.getChildren().addAll(mvrtProf, labels, friendStack, s, taskStack);
        return content;
    }

    private VBox rightCardContent() {
        VBox content = new VBox(10);
        content.setId("leftCardContent");

        StackPane mvrtProf = new StackPane();
        VBox.setMargin(mvrtProf, new Insets(20, 0, 0, 0));
        ImageView moreVert = new ImageView(new Image(this.getClass().getResource("ic_more_vert_black_48dp_1x.png").toExternalForm()));
        moreVert.setFitHeight(25);
        moreVert.setFitWidth(25);
        StackPane.setAlignment(moreVert, Pos.TOP_RIGHT);

        ImageView profPic = new ImageView(new Image(this.getClass().getResource("preview12.jpg").toExternalForm()));
        profPic.setFitHeight(100);
        profPic.setFitWidth(100);
        Circle c = new Circle(profPic.getFitWidth() / 2, profPic.getFitHeight() / 2, 50);
        profPic.setClip(c);
        VBox.setMargin(profPic, new Insets(0, 0, 0, 50));

        mvrtProf.getChildren().addAll(profPic, moreVert);

        StackPane labels = new StackPane();
        Label placeName = new Label("FARM HILL");
        placeName.setId("placename");
        StackPane.setAlignment(placeName, Pos.CENTER);

        Label descrip = new Label("Nice place to relax all your thoughts ...");
        descrip.setPadding(new Insets(5));
        descrip.setId("descrip");
        StackPane.setMargin(descrip, new Insets(50, 0, 0, 0));
        StackPane.setAlignment(descrip, Pos.CENTER);
        labels.getChildren().addAll(placeName, descrip);

        HBox friends = new HBox(10);
        StackPane friendStack = new StackPane();
        friendStack.setId("friendStack");
        friends.setPadding(new Insets(5));
        ImageView p1 = new ImageView(new Image(this.getClass().getResource("preview9.jpg").toExternalForm()));
        p1.setId("pics");
        p1.setFitHeight(40);
        p1.setFitWidth(40);
        p1.setClip(new Circle(20, 20, 20));
        ImageView p2 = new ImageView(new Image(this.getClass().getResource("preview3.jpg").toExternalForm()));
        p2.setId("pics");
        p2.setFitHeight(40);
        p2.setFitWidth(40);
        p2.setClip(new Circle(20, 20, 20));
        ImageView p3 = new ImageView(new Image(this.getClass().getResource("preview11.jpg").toExternalForm()));
        p3.setId("pics");
        p3.setFitHeight(40);
        p3.setFitWidth(40);
        p3.setClip(new Circle(20, 20, 20));

        JFXButton btnmore = new JFXButton("5");
        btnmore.setId("btnmore");

        friends.getChildren().addAll(p1, p2, p3, btnmore);
        StackPane.setAlignment(friends, Pos.CENTER);
        friendStack.getChildren().addAll(friends);

        Separator s = new Separator();
        s.setOrientation(Orientation.HORIZONTAL);
        VBox.setMargin(s, new Insets(0, 5, 0, 5));

        double size = 25;

        HBox tasks = new HBox(20);
        StackPane taskStack = new StackPane();
        VBox vBox1 = new VBox(10);
        ImageView schedule = new ImageView(new Image(this.getClass().getResource("ic_schedule_black_48dp_1x.png").toExternalForm()));
        schedule.setFitHeight(size);
        schedule.setFitWidth(size);
        VBox.setMargin(schedule, new Insets(0, 0, 0, 20));
        Label dt1 = new Label("25 OCT 2016");
        vBox1.getChildren().addAll(schedule, dt1);

        VBox vBox2 = new VBox(10);
        ImageView flag = new ImageView(new Image(this.getClass().getResource("ic_flag_black_48dp_1x.png").toExternalForm()));
        flag.setFitHeight(size);
        flag.setFitWidth(size);
        VBox.setMargin(flag, new Insets(0, 0, 0, 20));
        Label dt2 = new Label("FARM HILL");
        vBox2.getChildren().addAll(flag, dt2);

        Separator s1 = new Separator();
        s1.setOrientation(Orientation.VERTICAL);
        HBox.setMargin(s1, new Insets(5, 0, 5, 0));

        tasks.getChildren().addAll(vBox1, s1, vBox2);
        StackPane.setAlignment(tasks, Pos.CENTER);
        taskStack.getChildren().add(tasks);
        VBox.setMargin(taskStack, new Insets(10));

        content.getChildren().addAll(mvrtProf, labels, friendStack, s, taskStack);
        return content;
    }

    private VBox centerCardContent() {
        VBox content = new VBox(10);
        content.setId("leftCardContent");

        StackPane mvrtProf = new StackPane();
        VBox.setMargin(mvrtProf, new Insets(20, 0, 0, 0));
        ImageView moreVert = new ImageView(new Image(this.getClass().getResource("ic_more_vert_black_48dp_1x.png").toExternalForm()));
        moreVert.setFitHeight(25);
        moreVert.setFitWidth(25);
        StackPane.setAlignment(moreVert, Pos.TOP_RIGHT);

        ImageView profPic = new ImageView(new Image(this.getClass().getResource("preview1.jpg").toExternalForm()));
        profPic.setFitHeight(100);
        profPic.setFitWidth(100);
        Circle c = new Circle(profPic.getFitWidth() / 2, profPic.getFitHeight() / 2, 50);
        profPic.setClip(c);
        VBox.setMargin(profPic, new Insets(0, 0, 0, 50));

        mvrtProf.getChildren().addAll(profPic, moreVert);

        StackPane labels = new StackPane();
        Label placeName = new Label("FARM HILL");
        placeName.setId("placename");
        StackPane.setAlignment(placeName, Pos.CENTER);

        Label descrip = new Label("Nice place to relax all your thoughts ...");
        descrip.setPadding(new Insets(5));
        descrip.setId("descrip");
        StackPane.setMargin(descrip, new Insets(50, 0, 0, 0));
        StackPane.setAlignment(descrip, Pos.CENTER);
        labels.getChildren().addAll(placeName, descrip);

        HBox friends = new HBox(10);
        StackPane friendStack = new StackPane();
        friendStack.setId("friendStack");
        friends.setPadding(new Insets(5));
        ImageView p1 = new ImageView(new Image(this.getClass().getResource("preview12.jpg").toExternalForm()));
        p1.setId("pics");
        p1.setFitHeight(40);
        p1.setFitWidth(40);
        p1.setClip(new Circle(20, 20, 20));
        ImageView p2 = new ImageView(new Image(this.getClass().getResource("preview11.jpg").toExternalForm()));
        p2.setId("pics");
        p2.setFitHeight(40);
        p2.setFitWidth(40);
        p2.setClip(new Circle(20, 20, 20));
        ImageView p3 = new ImageView(new Image(this.getClass().getResource("preview9.jpg").toExternalForm()));
        p3.setId("pics");
        p3.setFitHeight(40);
        p3.setFitWidth(40);
        p3.setClip(new Circle(20, 20, 20));

        JFXButton btnmore = new JFXButton("3");
        btnmore.setId("btnmore");

        friends.getChildren().addAll(p1, p2, p3, btnmore);
        StackPane.setAlignment(friends, Pos.CENTER);
        friendStack.getChildren().addAll(friends);

        Separator s = new Separator();
        s.setOrientation(Orientation.HORIZONTAL);
        VBox.setMargin(s, new Insets(0, 5, 0, 5));

        double size = 25;

        HBox tasks = new HBox(20);
        StackPane taskStack = new StackPane();
        VBox vBox1 = new VBox(10);
        ImageView schedule = new ImageView(new Image(this.getClass().getResource("ic_schedule_black_48dp_1x.png").toExternalForm()));
        schedule.setFitHeight(size);
        schedule.setFitWidth(size);
        VBox.setMargin(schedule, new Insets(0, 0, 0, 20));
        Label dt1 = new Label("25 OCT 2016");
        vBox1.getChildren().addAll(schedule, dt1);

        VBox vBox2 = new VBox(10);
        ImageView flag = new ImageView(new Image(this.getClass().getResource("ic_flag_black_48dp_1x.png").toExternalForm()));
        flag.setFitHeight(size);
        flag.setFitWidth(size);
        VBox.setMargin(flag, new Insets(0, 0, 0, 20));
        Label dt2 = new Label("FARM HILL");
        vBox2.getChildren().addAll(flag, dt2);

        Separator s1 = new Separator();
        s1.setOrientation(Orientation.VERTICAL);
        HBox.setMargin(s1, new Insets(5, 0, 5, 0));

        tasks.getChildren().addAll(vBox1, s1, vBox2);
        StackPane.setAlignment(tasks, Pos.CENTER);
        taskStack.getChildren().add(tasks);
        VBox.setMargin(taskStack, new Insets(10));

        content.getChildren().addAll(mvrtProf, labels, friendStack, s, taskStack);
        return content;
    }
}

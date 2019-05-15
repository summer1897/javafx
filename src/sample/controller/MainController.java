package sample.controller;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.SplitPane;
import javafx.scene.control.ToolBar;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import sample.DataReader;

import java.io.InputStream;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * @ClassName MainController
 * @Author solstice
 * @Date 19/5/13 21:10
 * @Version 1.0.0
 * @Description
 **/
public class MainController implements Initializable {

    @FXML
    private FlowPane flowPane;
    @FXML
    private FlowPane rightFlowPane;
    @FXML
    private SplitPane splitPane;
    @FXML
    private SplitPane splitPane1;
    @FXML
    private ListView listView1;
    @FXML
    private ListView listView2;

    @FXML
    private ToolBar toolBar;
    @FXML
    private ToolBar toolBar2;
    @FXML
    private AnchorPane anchorPane1;
    @FXML
    private AnchorPane anchorPane2;
    @FXML
    private AnchorPane anchorPane3;

    /**
     * Buttons
     */
    @FXML
    private Button newBtn;
    @FXML
    private Button saveBtn;
    @FXML
    private Button loadBtn;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        toolBar.prefWidthProperty().bind(flowPane.widthProperty());
        splitPane.prefWidthProperty().bind(flowPane.widthProperty());
        splitPane1.prefWidthProperty().bind(flowPane.widthProperty());

        anchorPane1.prefWidthProperty().bind(splitPane.widthProperty());
        anchorPane2.prefWidthProperty().bind(splitPane.widthProperty());
        rightFlowPane.prefWidthProperty().bind(anchorPane2.widthProperty());
        toolBar2.prefWidthProperty().bind(rightFlowPane.widthProperty());
        listView1.prefWidthProperty().bind(rightFlowPane.widthProperty());

        listView2.prefWidthProperty().bind(anchorPane3.widthProperty());
        // draw picture
        draw();
        buttonBinding();
    }

    public void draw() {
        Canvas canvas = new Canvas(1000, 1000);

        GraphicsContext gc = canvas.getGraphicsContext2D();

        gc.setLineWidth(2.0);
        gc.setFill(Color.RED);

        gc.strokeRoundRect(10, 10, 50, 50, 10, 10);

        gc.fillOval(70, 10, 50, 20);

        gc.strokeText("Hello Canvas", 100, 100);

        anchorPane1.getChildren().add(canvas);
    }

    private void buttonBinding() {
        loadBtn.setOnAction((event) -> {
            try {
                String path = "/Users/solstice/git-workspace/javafxTrip/src/positions.txt";
//                InputStream is = MainController.class.getResourceAsStream("positions.txt");
//                System.out.println(is);
                DataReader dataReader = new DataReader(path);
                System.out.println(dataReader.getPositions());
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }


}

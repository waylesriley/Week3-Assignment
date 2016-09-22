package wriley_week3;

/**
 * @Course: SDEV 450 ~ Java Programming III
 * @Author Name: Riley Laptop
 * @Assignment Name: wriley_week3
 * @Date: Sep 16, 2016
 * @Description: Creates JavaFX GUI to enter key (name) and values (age) into
 * HashMap.
 */

//Imports
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

//Begin Class WRiley_Week3
public class WRiley_Week3 extends Application {

    //declarations
    Label lblName = new Label("Name:");
    TextField txtName = new TextField();
    Label lblAge = new Label("Age:");
    TextField txtAge = new TextField();
    TextArea taResult = new TextArea();
    TextArea taAction = new TextArea();

    //Instiantiate subclasses    
    ErrorHandler alert = new ErrorHandler();
    MyMap<String, Integer> map = new MyHashMap();

    //declare buttons    
    Button btnEnter = new Button("Enter");
    Button btnFind = new Button("Find");
    Button btnRemove = new Button("Remove");
    Button btnClear = new Button("Clear");
    Button btnExit = new Button("Exit");

    @Override
    public void start(Stage primaryStage) throws Exception {

        //Declare borderpane
        BorderPane bPane = new BorderPane();
        bPane.setPadding(new Insets(5, 5, 5, 5));

        /* Add panes to appropriate region */
        bPane.setRight(getVBoxRight());
        bPane.setLeft(getVBox());

        // Create a scene and place it in the stage
        Scene scene = new Scene(bPane, 490, 300);
        primaryStage.setTitle("Hash Maps"); // Set the stage title
        primaryStage.setScene(scene); // Place the scene in the stage
        primaryStage.show(); // Display the stage

        //focus on open file button
        txtName.requestFocus();
    }

    /**
     * VBOX set in left pane holds set integer label and image.
     *
     * @return
     */
    private VBox getVBox() {
        VBox vBox = new VBox(5);
        vBox.setAlignment(Pos.CENTER_LEFT);
        vBox.setPadding(new Insets(5, 10, 5, 5));
        vBox.setStyle(" -fx-border-color: Maroon; -fx-border-width: 1px;");

        //gridpane
        GridPane leftgPane = new GridPane();
        leftgPane.setAlignment(Pos.CENTER);
        leftgPane.setHgap(5);
        leftgPane.setVgap(5);
        leftgPane.add(lblName, 0, 0);
        GridPane.setConstraints(lblName, 0, 0, 8, 1);
        leftgPane.add(txtName, 8, 0);
        GridPane.setConstraints(txtName, 8, 0, 16, 1);
        leftgPane.add(lblAge, 24, 0);
        GridPane.setConstraints(lblAge, 24, 0, 4, 1);
        leftgPane.add(txtAge, 28, 0);
        GridPane.setConstraints(txtAge, 28, 0, 5, 1);

        //button size
        btnEnter.setMinSize(70, 25);//set min button size
        btnFind.setMinSize(70, 25);//set min button size
        btnRemove.setMinSize(70, 25);//set min button size
        btnClear.setMinSize(70, 25);//set min button size
        btnExit.setMinSize(70, 25);//set min button size

        //TextArea to hold file path
        taAction.setPrefColumnCount(5);
        taAction.setPrefRowCount(11);
        taAction.setEditable(false);
        taAction.setWrapText(true);
        vBox.setPrefSize(237, 300);
        vBox.getChildren().addAll(leftgPane, getTop(), getBottom(), taAction);
        return vBox;
    }

    /**
     * HBox to hold buttons at bottom of pane
     *
     * @return
     */
    private HBox getTop() {
        /*Set vBox attributes */
        HBox hBox = new HBox(5);
        hBox.setAlignment(Pos.CENTER_LEFT);
        hBox.getChildren().addAll(btnEnter, btnFind, btnRemove);//add buttons

        /**
         * Action event for Enter button to add Name and age. Calls printResult
         * method
         *
         */
        btnEnter.setOnAction(
                (ActionEvent e) -> {
                    boolean blankName = txtName.getText().matches("");
                    boolean blankAge = txtAge.getText().matches("");
                    if (blankName == true) {
                        alert.blankName();
                    } else if (txtAge.getText().matches("^[0-9]*$") && blankAge == false) {
                        map.put(txtName.getText(), Integer.parseInt(txtAge.getText()));
                        taAction.setText((txtName.getText()) + " was entered into"
                                + " the table");
                        printResult();
                        txtName.requestFocus();
                        txtName.clear();
                        txtAge.clear();
                    } else {
                        alert.invalidAge();
                        txtAge.clear();
                        txtAge.requestFocus();
                    }

                });

        /**
         * Action event for Find button to find key in map
         */
        btnFind.setOnAction(
                (ActionEvent e) -> {
                    if (map.isEmpty()) {
                        alert.empty();
                    } else if (map.containsKey(txtName.getText())) {
                        taAction.setText((txtName.getText()) + " is "
                                + map.get(txtName.getText()) + " years old");
                    } else {
                        alert.missing();
                    }
                    txtName.requestFocus();
                    txtName.clear();
                    txtAge.clear();
                });

        /**
         * Button to remove key from map
         *
         */
        btnRemove.setOnAction(
                (ActionEvent e) -> {
                    if (map.isEmpty()) {
                        alert.empty();
                    } else if (map.containsKey(txtName.getText())) {
                        map.remove(txtName.getText());
                        taAction.setText(txtName.getText() + " was removed from the table");
                        printResult();
                    } else {
                        alert.missing();
                    }
                    txtName.requestFocus();
                    txtName.clear();
                    txtAge.clear();
                });
        return hBox;
    }

    /**
     * HBox to hold clear and exit buttons
     *
     * @return
     */
    private HBox getBottom() {
        /*Set vBox attributes */
        HBox hBox = new HBox(5);
        hBox.setAlignment(Pos.CENTER_LEFT);
        hBox.getChildren().addAll(btnClear, btnExit);//add buttons

        /**
         * inner class ActionEVents clears GUI fields and map
         *
         */
        btnClear.setOnAction(
                (ActionEvent e) -> {
                    txtName.clear();//clears textfield
                    txtAge.clear();
                    taResult.clear();//clears textarea  
                    taAction.clear();
                    txtName.requestFocus();
                    map.clear();
                    System.out.println("Is HashMap empty? " + map.isEmpty());
                    taAction.setText("The HashMap is now empty");
                });

        /**
         * inner class ActionEVents for exit
         *
         */
        btnExit.setOnAction(
                (ActionEvent e) -> {
                    System.exit(0);
                });
        return hBox;
    }

    /**
     * Add textarea to right border pane
     */
    private VBox getVBoxRight() {
        VBox vBox = new VBox(5);
        vBox.setAlignment(Pos.CENTER);
        vBox.setPadding(new Insets(5, 5, 5, 5));
        vBox.setStyle(" -fx-border-color: Maroon; -fx-border-width: 1px;");
        taResult.setPrefColumnCount(15);
        taResult.setPrefRowCount(16);
        taResult.setEditable(false);
        taResult.setWrapText(true);
        vBox.setPrefSize(237, 300);
        vBox.getChildren().add(taResult);//Text Result area
        return vBox;
    }

    /**
     * Print name key and age value to results text area Source - Champlain
     * College Java II code snippets
     */
    private void printResult() {
        System.out.println("Entries in map: " + map);
        taResult.clear();
        //Used thits code from Week08 code snippets
        map.entrySet().forEach((entry) -> {
            String key = entry.getKey();
            int value = entry.getValue();
            taResult.appendText(key + " is " + value + " years old\n");
        });
    }
} //End Class WRiley_Week3

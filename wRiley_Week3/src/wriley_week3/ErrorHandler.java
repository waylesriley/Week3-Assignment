package wriley_week3;

import javafx.scene.control.Alert;

/** 
 * @Course: SDEV 450 ~ Java Programming III
 * @Author Name: Riley Laptop
 * @Assignment Name: wriley_week3
 * @Date: Sep 16, 2016
 * @Subclass ErrorHandler Description: Error handler subclass that supplies
 * alerts for input validation of name, age and empty HashMap.
 */

//Imports

//Begin Subclass ErrorHandler
public class ErrorHandler {
    
       /**
     * Alert if key not found in map
     */
    public void missing() {

        Alert blank = new Alert(Alert.AlertType.WARNING);

        blank.setTitle("Warning");
        blank.setHeaderText("Not Found in Map");
        blank.setContentText("Enter a Key found in Map");
        blank.showAndWait();
    }
    
        /**
     * Alert if key field is blank
     */
    public void blankName() {

        Alert blank = new Alert(Alert.AlertType.WARNING);

        blank.setTitle("Warning");
        blank.setHeaderText("Missing Name");
        blank.setContentText("Enter a name in Name field");
        blank.showAndWait();
    }
    
    /**
     * Alert if age field is invalid
     */
    public void invalidAge() {

        Alert blank = new Alert(Alert.AlertType.WARNING);

        blank.setTitle("Warning");
        blank.setHeaderText("Invalid Age");
        blank.setContentText("Enter an integer in age field");
        blank.showAndWait();
    }
    
        /**
         * ALert for empty HashMap
         */
        public void empty() {

        Alert blank = new Alert(Alert.AlertType.WARNING);

        blank.setTitle("Warning");
        blank.setHeaderText("Empty HashMap");
        blank.setContentText("Enter a name and age followed by Enter button");
        blank.showAndWait();
    }

} //End Subclass ErrorHandler
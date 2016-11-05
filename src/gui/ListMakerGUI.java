package gui;

import java.io.IOException;

import javafx.application.Application;
import javafx.event.*;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.*;
import javafx.scene.layout.*;
import javafx.scene.text.*;
import javafx.stage.Stage;

public class ListMakerGUI extends Application {
	private final int WINDOW_WIDTH = 500;
	private final int WINDOW_HEIGHT = 500;
	GridPane gridPane = new GridPane();
	VBox pane = new VBox(10);
	private Scene scene = new Scene(gridPane, WINDOW_WIDTH, WINDOW_HEIGHT);
	private TextField textField1 = new TextField();
	private TextField textField2 = new TextField();
	private Button button1 = new Button("Output");
	private static ListMaker list = new ListMaker();
	private Label text1 = new Label("Make a List!");
	private Label text2 = new Label("...");
	private Label text3 = new Label("...");
	@Override
	public void start(Stage primaryStage) throws IOException {
        textField1.setPrefWidth(WINDOW_WIDTH / 2);
        textField2.setPrefWidth(WINDOW_WIDTH / 2);
        button1.setPrefWidth(WINDOW_WIDTH / 4);
        
        textField1.setPromptText("Item Name...");
        textField2.setPromptText("Amount...");
        
        gridPane.setAlignment(Pos.CENTER);
        pane.setAlignment(Pos.CENTER);
        
        text1.setAlignment(Pos.TOP_CENTER);
        text1.setFont(new Font("Arial", 24));
        text2.setAlignment(Pos.TOP_CENTER);
        text2.setFont(new Font("Arial", 18));
        text3.setAlignment(Pos.TOP_CENTER);
        text3.setFont(new Font("Arial", 18));
        
        textField2.setOnKeyReleased(new EventHandler<KeyEvent>(){
			@Override
			public void handle(KeyEvent event) {
				if (event.getCode() == (KeyCode.ENTER)){
					String name = textField1.getText();
		    		int amount = Integer.parseInt(textField2.getText());
		    		Item item = new Item(name, amount);
		    		if(!name.equals(""))
		    			list.addItem(item);
		    		int index = list.contains(item);
		    		text2.setText("Items: " + list.getSize() +  "");
		    		text3.setText(list.get(index).toString());
		    		text3.setAlignment(Pos.CENTER);
		    		resetTextField();
				}
			}
    	});
        
        button1.setOnAction(new EventHandler<ActionEvent>(){
        	@Override
			public void handle(ActionEvent event){
	    		try {
					list.writeFile();
					text2.setText("Complete...");
					text3.setText("List cleared...");
					list = new ListMaker();
				} catch (IOException e) {
					e.printStackTrace();
				}
        	}
    	});
       
        pane.getChildren().addAll(text1, textField1, textField2, button1, text2, text3);
        gridPane.getChildren().addAll(pane);
        
        text1.requestFocus();
        primaryStage.setTitle("List Maker");
        primaryStage.setScene(scene);
        primaryStage.show();
	}
	
	public void resetTextField(){
		textField1.clear();
		textField2.clear();
		textField1.setPromptText("Item name...");
		textField2.setPromptText("Amount...");
		textField1.requestFocus();
	}

	public static void main(String[] args) {
		launch(args);
	}
}

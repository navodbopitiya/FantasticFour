package view;
	
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;


public class MainMenuView extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			GridPane grid = new GridPane();
			grid.setAlignment(Pos.CENTER);
			grid.setHgap(10);
			grid.setVgap(10);
			grid.setPadding(new Insets(25,25,25,25));
			
			Text scenetitle = new Text("Main Menu");
			scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
			grid.add(scenetitle, 0, 0, 2, 1);
			
			Label playerOneLabel = new Label("Player One Name");
			grid.add(playerOneLabel, 0, 1);
			
			TextField playerOneTextField = new TextField();
			grid.add(playerOneTextField, 1, 1);
			
			Label playerTwoLabel = new Label("Player Two Name");
			grid.add(playerTwoLabel, 0, 2);
			
			TextField playerTwoTextField = new TextField();
			grid.add(playerTwoTextField, 1, 2);
			
			Label timerText = new Label("Round Time");
			grid.add(timerText, 0, 3);
			
			TextField timerTextField = new TextField();
			grid.add(timerTextField, 1, 3);
			
			Button btn =  new Button("Play Game");
			HBox hbBtn = new HBox(10);
			hbBtn.setAlignment(Pos.BOTTOM_RIGHT);
			hbBtn.getChildren().add(btn);
			grid.add(hbBtn, 1, 4);
			
			
			Scene scene = new Scene(grid,400,275);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	 @Override
	   public void init()
	   {
	      System.out.printf("init() called on thread %s%n", 
	                        Thread.currentThread());
	   }
}

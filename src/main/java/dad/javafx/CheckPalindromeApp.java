package dad.javafx;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class CheckPalindromeApp extends Application {

	private TextField palindromoText;
	private Button comprobarButton;
	private Label resultadoLabel;
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		
		palindromoText = new TextField();
		palindromoText.setPromptText("Introduce un texto");
		palindromoText.setMaxWidth(300);
		
		comprobarButton = new Button("Comprobar");
		comprobarButton.setDefaultButton(true);
		comprobarButton.setOnAction(e -> onComprobarButtonAction(e));
		
		resultadoLabel = new Label();
		VBox root = new VBox();
		root.setSpacing(10);
		root.setAlignment(Pos.CENTER);
		root.getChildren().addAll(palindromoText, comprobarButton, resultadoLabel);
		
		Scene scene = new Scene(root, 420, 200);
		
		primaryStage.setTitle("Comprobador de palíndromos");
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	private void onComprobarButtonAction(ActionEvent e) {
		String texto = palindromoText.getText().replace(" ", "");
		String palindromo = "";
	    for (int x = texto.length() - 1; x >= 0 ; x--){
	        palindromo += texto.charAt(x);
	    }
	    if (palindromo.equals(texto)) {
	    	resultadoLabel.setText("Es palíndromo");
	    	resultadoLabel.setStyle("-fx-text-fill: green; -fx-font: bold 16 consolas;");
	    } else {
	    	resultadoLabel.setText("NO es palíndromo");
	    	resultadoLabel.setStyle("-fx-text-fill: red; -fx-font: bold 16 consolas;");
	    }
	}

	public static void main(String[] args) {
		launch();
	}

}

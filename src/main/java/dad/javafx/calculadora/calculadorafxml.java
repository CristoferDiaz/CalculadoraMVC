package dad.javafx.calculadora;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class calculadorafxml extends Application implements Initializable {

	private boolean puesto = false;
	private String operacion;
	private double value;

	@FXML
	private GridPane root;
	@FXML
	private TextField valorText;
	@FXML
	private Button unoButton, dosButton, tresButton, ceButton, cButton, cuatroButton, cincoButton, seisButton,
			multiButton, divButton, sieteButton, ochoButton, nueveButton, menosButton, puntoButton, masButton,
			igualButton, ceroButton;

	public calculadorafxml() throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/FXML/CalculadoraView.fxml"));
		loader.setController(this);
		loader.load();
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {

	}

	@Override
	public void start(Stage primaryStage) throws Exception {

		valorText.setPromptText("0.0");

		ceroButton.setOnAction(e -> ceroButtonAction(e));
		unoButton.setOnAction(e -> unoButtonAction(e));
		dosButton.setOnAction(e -> dosButtonAction(e));
		tresButton.setOnAction(e -> tresButtonAction(e));
		cuatroButton.setOnAction(e -> cuatroButtonAction(e));
		cincoButton.setOnAction(e -> cincoButtonAction(e));
		seisButton.setOnAction(e -> seisButtonAction(e));
		sieteButton.setOnAction(e -> sieteButtonAction(e));
		ochoButton.setOnAction(e -> ochoButtonAction(e));
		nueveButton.setOnAction(e -> nueveButtonAction(e));
		ceButton.setOnAction(e -> ceButtonAction(e));
		cButton.setOnAction(e -> cButtonAction(e));
		puntoButton.setOnAction(e -> puntoButtonAction(e));
		masButton.setOnAction(e -> sumaButtonAction(e));
		menosButton.setOnAction(e -> restaButtonAction(e));
		multiButton.setOnAction(e -> multiplicacionButtonAction(e));
		divButton.setOnAction(e -> divisionButtonAction(e));
		igualButton.setOnAction(e -> igualButtonAction(e));

		Scene scene = new Scene(root, 700, 400);

		primaryStage.setTitle("Calculadora");
		primaryStage.setScene(scene);
		primaryStage.show();

	}

	private void ceroButtonAction(ActionEvent e) {
		if (valorText.getText().isEmpty()) {
			valorText.setText("0");
		} else {
			valorText.setText(valorText.getText() + "0");
		}
	}

	private void unoButtonAction(ActionEvent e) {
		if (valorText.getText().isEmpty()) {
			valorText.setText("1");
		} else {
			valorText.setText(valorText.getText() + "1");
		}
	}

	private void dosButtonAction(ActionEvent e) {
		if (valorText.getText().isEmpty()) {
			valorText.setText("2");
		} else {
			valorText.setText(valorText.getText() + "2");
		}
	}

	private void tresButtonAction(ActionEvent e) {
		if (valorText.getText().isEmpty()) {
			valorText.setText("3");
		} else {
			valorText.setText(valorText.getText() + "3");
		}
	}

	private void cuatroButtonAction(ActionEvent e) {
		if (valorText.getText().isEmpty()) {
			valorText.setText("4");
		} else {
			valorText.setText(valorText.getText() + "4");
		}
	}

	private void cincoButtonAction(ActionEvent e) {
		if (valorText.getText().isEmpty()) {
			valorText.setText("5");
		} else {
			valorText.setText(valorText.getText() + "5");
		}
	}

	private void seisButtonAction(ActionEvent e) {
		if (valorText.getText().isEmpty()) {
			valorText.setText("6");
		} else {
			valorText.setText(valorText.getText() + "6");
		}
	}

	private void sieteButtonAction(ActionEvent e) {
		if (valorText.getText().isEmpty()) {
			valorText.setText("7");
		} else {
			valorText.setText(valorText.getText() + "7");
		}
	}

	private void ochoButtonAction(ActionEvent e) {
		if (valorText.getText().isEmpty()) {
			valorText.setText("8");
		} else {
			valorText.setText(valorText.getText() + "8");
		}
	}

	private void nueveButtonAction(ActionEvent e) {
		if (valorText.getText().isEmpty()) {
			valorText.setText("9");
		} else {
			valorText.setText(valorText.getText() + "9");
		}
	}

	private void ceButtonAction(ActionEvent e) {
		valorText.setText("");
		puesto = false;
		value = 0;
		operacion = null;
		valorText.setPromptText("0.0");
	}

	private void cButtonAction(ActionEvent e) {
		try {
			String nuevo = valorText.getText();
			nuevo = nuevo.substring(0, nuevo.length() - 1);
			valorText.setText(nuevo);
		} catch (java.lang.StringIndexOutOfBoundsException e1) {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setHeaderText("Fallo al borrar");
			alert.setContentText("No borres un elemento vacio");
			alert.showAndWait();
		}
	}

	private void puntoButtonAction(ActionEvent e) {
		if (puesto == false) {
			if (valorText.getText().isEmpty()) {
				valorText.setText("0.");
			} else {
				valorText.setText(valorText.getText() + ".");
			}
			puesto = true;
		}
	}

	private void sumaButtonAction(ActionEvent e) {
		if (!valorText.getText().isEmpty()) {
			operacion = "suma";
			value = Double.parseDouble(valorText.getText());
			valorText.setPromptText("+");
			valorText.setText("");
			puesto = false;
		}

	}

	private void restaButtonAction(ActionEvent e) {
		if (!valorText.getText().isEmpty()) {
			operacion = "resta";
			value = Double.parseDouble(valorText.getText());
			valorText.setPromptText("-");
			valorText.setText("");
			puesto = false;
		}

	}

	private void multiplicacionButtonAction(ActionEvent e) {
		if (!valorText.getText().isEmpty()) {
			operacion = "multi";
			value = Double.parseDouble(valorText.getText());
			valorText.setPromptText("*");
			valorText.setText("");
			puesto = false;
		}

	}

	private void divisionButtonAction(ActionEvent e) {
		if (!valorText.getText().isEmpty()) {
			operacion = "divi";
			value = Double.parseDouble(valorText.getText());
			valorText.setPromptText("/");
			valorText.setText("");
			puesto = false;
		}

	}

	private void igualButtonAction(ActionEvent e) {
		try {
		double segundo = Double.parseDouble(valorText.getText());
		double resultado;

			switch (operacion) {
			case "suma":
				resultado = value + segundo;
				valorText.setText(String.valueOf(resultado));
				break;
			case "resta":
				resultado = value - segundo;
				valorText.setText(String.valueOf(resultado));
				break;
			case "multi":
				resultado = value * segundo;
				valorText.setText(String.valueOf(resultado));
				break;
			case "divi":
				resultado = value / segundo;
				valorText.setText(String.valueOf(resultado));
				break;

			}
			puesto = true;
		} catch ( java.lang.NumberFormatException e1) {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setHeaderText("Fallo al operar");
			alert.setContentText("No se puede operar sin elementos");
			alert.showAndWait();
		}
	}

	public static void main(String[] args) {
		launch(args);

	}

}

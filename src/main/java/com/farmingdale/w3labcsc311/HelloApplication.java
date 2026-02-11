package com.farmingdale.w3labcsc311;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.scene.control.Button;

import java.awt.*;
import java.io.IOException;

public class HelloApplication extends Application {



    @Override
    public void start(Stage stage) throws IOException {
        //FXML
//        FXMLLoader loader = new FXMLLoader(getClass().getResource("hello-view.fxml"));
//        Scene scene = new Scene(loader.load());
//        stage.setScene(scene);
//        stage.setTitle("Loan Calculator");
//        stage.show();
////Java
    GridPane gridpane =  new GridPane();
    gridpane.setId("Loan Calculator");
    gridpane.setPadding(new Insets(10, 10, 10, 20));
    gridpane.setVgap(5);

    //Annual Interest Rate
    Label label1 = new Label("Annual Interest Rate: ");
    GridPane.setConstraints(label1, 0, 0);
    TextField AIR = new TextField();
    GridPane.setConstraints(AIR, 1, 0);

    //Number Of Years
    Label label2 = new Label("Number Of Years: ");
    GridPane.setConstraints(label2, 0, 1);
    TextField NOY = new TextField();
    GridPane.setConstraints(NOY, 1, 1);

    //Loan Amount
    Label label3 = new Label("Loan Amount: ");
    GridPane.setConstraints(label3, 0, 2);
    TextField LA = new TextField();
    GridPane.setConstraints(LA, 1, 2);

    //Monthly Payment
    Label label4 = new Label("Monthly Payment: ");
    GridPane.setConstraints(label4, 0, 3);
    TextField MP = new TextField();
    MP.setEditable(false);
    GridPane.setConstraints(MP, 1, 3);
    //Total Payment
    Label label5 = new Label("Total Payment: ");
    GridPane.setConstraints(label5, 0, 4);
    TextField TP = new TextField();
    TP.setEditable(false);
    GridPane.setConstraints(TP, 1, 4);

    //Button
    Button btn = new Button("Calculate");
    btn.setOnAction(e -> {
        try {
            //Loan calculations
            double annualInterestRate = Double.parseDouble(AIR.getText());
            int numberOfYears = Integer.parseInt(NOY.getText());
            double loanAmount = Double.parseDouble(LA.getText());

            double monthlyInterestRate = annualInterestRate / 1200;
            double monthlyPayment = loanAmount * monthlyInterestRate /
                    (1 - Math.pow(1 + monthlyInterestRate, -numberOfYears * 12));
            double totalPayment = monthlyPayment * numberOfYears * 12;

            //Loan result formatting
            MP.setText(String.format("$" + "%.2f" , monthlyPayment));
            TP.setText(String.format("$" + "%.2f", totalPayment));
        } catch (NumberFormatException ex) {

            MP.setText("Invalid input");
            TP.setText("Invalid input");
        }
    });


    GridPane.setConstraints(btn, 1, 5);
    GridPane.setHalignment(btn, HPos.RIGHT);

    //Set gridpane children
    gridpane.getChildren().addAll(label1, AIR, label2, NOY, label3, LA, label4, MP, label5, TP, btn);

    //Scene and stage
    Scene scene = new Scene(gridpane, 350, 200);
    scene.getStylesheets().add(getClass().getResource("/myStyle.css").toExternalForm());
    stage.setTitle("Loan Calculator");
    stage.setScene(scene);
    stage.show();
    }



}

package sample;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

    /*
    IIT Number: 20191020
    UOW Number: w1789995
    */

public class Main extends Application {
    public static String enterNumber;

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Financial Calculator");

        Button mortgageCalculator = new Button(" MORTGAGE CALCULATOR");
        Button financeCalculator = new Button("  FINANCE CALCULATOR ");
        Button autoLoanCalculator = new Button("AUTO LOAN CALCULATOR");
        Button compoundInterest = new Button(" COMPOUND SAVING CALCULATOR ");
        Button helpButton = new Button("HELP");
        Button exitButton = new Button("EXIT");

        /*
         * Creating Button for the keyboard
         */

        //initialize buttons
        Button btn0 = new Button("0");
        Button btn1 = new Button("1");
        Button btn2 = new Button("2");
        Button btn3 = new Button("3");
        Button btn4 = new Button("4");
        Button btn5 = new Button("5");
        Button btn6 = new Button("6");
        Button btn7 = new Button("7");
        Button btn8 = new Button("8");
        Button btn9 = new Button("9");
        Button del = new Button("DL");
        Button decimalPoint = new Button(".");


        /*
            Creating back Button and the event handler
         */

        Button backBtn = new Button("BACK");
        backBtn.getStylesheets().add("stagesButton.css");
        backBtn.setOnAction(event -> {
            Stage backBtnWindow = (Stage) backBtn.getScene().getWindow();
            backBtnWindow.close();

            primaryStage.show();
        });


        Image img = new Image("file:Financial.png");
        ImageView iV = new ImageView();
        iV.setImage(img);


        Pane rootForMainWindow = new Pane();
        rootForMainWindow.getChildren().add(iV);
        rootForMainWindow.getStylesheets().add("MainPage.css");

        /*
        Mortgage Calculator button ------------------------------------------------------------------------------------------------------------------
         */
        rootForMainWindow.getChildren().add(mortgageCalculator);
        mortgageCalculator.setLayoutY(240);
        mortgageCalculator.setLayoutX(265);
        mortgageCalculator.setOnAction(event -> {
            Stage mainWindow = (Stage) mortgageCalculator.getScene().getWindow();
            mainWindow.close();

            Image imgForMortgage = new Image("file:Mortgage.png");
            ImageView iVForMortgage = new ImageView();
            iVForMortgage.setImage(imgForMortgage);

            Stage mortgageStage = new Stage();
            mortgageStage.setTitle("Mortgage Calculator");

            Label lblForHomeValue = new Label("Home Value");
            TextField txtForHomeValue = new TextField();

            Label lblForDownPayment = new Label("Down Payment");
            TextField txtForDownPayment = new TextField();

            Label lblForLoanTerm = new Label("Mortgage Term (Years)");
            TextField txtForLoanTerm = new TextField();

            Label lblForInterestRate = new Label("Interest Rate (Years)");
            TextField txtForInterestRate = new TextField();

            Button mortgageCalculatorButton = new Button("Calculate");

            Label mortgageOutput = new Label();

            Pane rootForMortgageWindow = new Pane();
            rootForMortgageWindow.getChildren().add(iVForMortgage);
            rootForMortgageWindow.getStylesheets().add("lables.css");


            // -----------------------------------
            final Scene sceneForMortgageCalculator = new Scene(rootForMortgageWindow, 700, 500);
            // -----------------------------------

            TextField[] textFieldArray = { txtForHomeValue, txtForDownPayment, txtForLoanTerm, txtForInterestRate };
            List<String> textFieldValues = new ArrayList<>();

            try {
                try (BufferedReader bufferRenderForMortgage = new BufferedReader(new FileReader("mortgage.txt"))) {
                    String OutputValueForMortgageTextFeilds;
                    while ((OutputValueForMortgageTextFeilds = bufferRenderForMortgage.readLine()) != null){

                        textFieldValues.add(OutputValueForMortgageTextFeilds);

                    }
                    for (int j = 0; j < textFieldValues.size(); j++){
                        try {
                            textFieldArray[j].setText(textFieldValues.get(j));
                        }catch (IndexOutOfBoundsException e){
                            e.printStackTrace();
                        }

                    }
                    for (String textFieldValue : textFieldValues) {
                        System.out.println(textFieldValue);
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }


         /*
        adding keyboard to root pane
         */

            // creating first row //
            rootForMortgageWindow.getChildren().add(btn7);
            btn7.setLayoutY(130);
            btn7.setLayoutX(450);
            btn7.setPrefSize(50, 50);
            btn7.getStylesheets().add("keyboard.css");
            btn7.setFocusTraversable(false);
            btn7.setOnAction(eventE -> {
                Node sceneSelector = sceneForMortgageCalculator.getFocusOwner();
                if (sceneSelector instanceof TextInputControl) {
                    enterNumber = btn7.getText();
                    //txtCapital.setText(enterNumber);
                    ((TextInputControl) sceneSelector).replaceSelection(enterNumber);
                }
            });

            rootForMortgageWindow.getChildren().add(btn8);
            btn8.setLayoutY(130);
            btn8.setLayoutX(510);
            btn8.setPrefSize(50, 50);
            btn8.getStylesheets().add("keyboard.css");
            btn8.setFocusTraversable(false);
            btn8.setOnAction(eventE -> {
                Node sceneSelector = sceneForMortgageCalculator.getFocusOwner();
                if (sceneSelector instanceof TextInputControl) {
                    enterNumber = btn8.getText();
                    //txtCapital.setText(enterNumber);
                    ((TextInputControl) sceneSelector).replaceSelection(enterNumber);
                }
            });

            rootForMortgageWindow.getChildren().add(btn9);
            btn9.setLayoutY(130);
            btn9.setLayoutX(570);
            btn9.setPrefSize(50, 50);
            btn9.getStylesheets().add("keyboard.css");
            btn9.setFocusTraversable(false);
            btn9.setOnAction(eventE -> {
                Node sceneSelector = sceneForMortgageCalculator.getFocusOwner();
                if (sceneSelector instanceof TextInputControl) {
                    enterNumber = btn9.getText();
                    //txtCapital.setText(enterNumber);
                    ((TextInputControl) sceneSelector).replaceSelection(enterNumber);
                }
            });

            // Creating second row //

            rootForMortgageWindow.getChildren().add(btn4);
            btn4.setLayoutY(190);
            btn4.setLayoutX(450);
            btn4.setPrefSize(50, 50);
            btn4.getStylesheets().add("keyboard.css");
            btn4.setFocusTraversable(false);
            btn4.setOnAction(eventE -> {
                Node sceneSelector = sceneForMortgageCalculator.getFocusOwner();
                if (sceneSelector instanceof TextInputControl) {
                    enterNumber = btn4.getText();
                    //txtCapital.setText(enterNumber);
                    ((TextInputControl) sceneSelector).replaceSelection(enterNumber);
                }
            });

            rootForMortgageWindow.getChildren().add(btn5);
            btn5.setLayoutY(190);
            btn5.setLayoutX(510);
            btn5.setPrefSize(50, 50);
            btn5.getStylesheets().add("keyboard.css");
            btn5.setFocusTraversable(false);
            btn5.setOnAction(eventE -> {
                Node sceneSelector = sceneForMortgageCalculator.getFocusOwner();
                if (sceneSelector instanceof TextInputControl) {
                    enterNumber = btn5.getText();
                    //txtCapital.setText(enterNumber);
                    ((TextInputControl) sceneSelector).replaceSelection(enterNumber);
                }
            });

            rootForMortgageWindow.getChildren().add(btn6);
            btn6.setLayoutY(190);
            btn6.setLayoutX(570);
            btn6.setPrefSize(50, 50);
            btn6.getStylesheets().add("keyboard.css");
            btn6.setFocusTraversable(false);
            btn6.setOnAction(eventE -> {
                Node sceneSelector = sceneForMortgageCalculator.getFocusOwner();
                if (sceneSelector instanceof TextInputControl) {
                    enterNumber = btn6.getText();
                    //txtCapital.setText(enterNumber);
                    ((TextInputControl) sceneSelector).replaceSelection(enterNumber);
                }
            });

            // Creating third row //

            rootForMortgageWindow.getChildren().add(btn1);
            btn1.setLayoutY(250);
            btn1.setLayoutX(450);
            btn1.setPrefSize(50, 50);
            btn1.getStylesheets().add("keyboard.css");
            btn1.setFocusTraversable(false);
            btn1.setOnAction(eventE -> {
                Node sceneSelector = sceneForMortgageCalculator.getFocusOwner();
                if (sceneSelector instanceof TextInputControl) {
                    enterNumber = btn1.getText();
                    //txtCapital.setText(enterNumber);
                    ((TextInputControl) sceneSelector).replaceSelection(enterNumber);
                }
            });

            rootForMortgageWindow.getChildren().add(btn2);
            btn2.setLayoutY(250);
            btn2.setLayoutX(510);
            btn2.setPrefSize(50, 50);
            btn2.getStylesheets().add("keyboard.css");
            btn2.setFocusTraversable(false);
            btn2.setOnAction(eventE -> {
                Node sceneSelector = sceneForMortgageCalculator.getFocusOwner();
                if (sceneSelector instanceof TextInputControl) {
                    enterNumber = btn2.getText();
                    //txtCapital.setText(enterNumber);
                    ((TextInputControl) sceneSelector).replaceSelection(enterNumber);
                }
            });

            rootForMortgageWindow.getChildren().add(btn3);
            btn3.setLayoutY(250);
            btn3.setLayoutX(570);
            btn3.setPrefSize(50, 50);
            btn3.getStylesheets().add("keyboard.css");
            btn3.setFocusTraversable(false);
            btn3.setOnAction(eventE -> {
                Node sceneSelector = sceneForMortgageCalculator.getFocusOwner();
                if (sceneSelector instanceof TextInputControl) {
                    enterNumber = btn3.getText();
                    //txtCapital.setText(enterNumber);
                    ((TextInputControl) sceneSelector).replaceSelection(enterNumber);
                }
            });

            // creating a fifth row //
            rootForMortgageWindow.getChildren().add(btn0);
            btn0.setLayoutY(310);
            btn0.setLayoutX(450);
            btn0.setPrefSize(50, 50);
            btn0.getStylesheets().add("keyboard.css");
            btn0.setFocusTraversable(false);
            btn0.setOnAction(eventE -> {
                Node sceneSelector = sceneForMortgageCalculator.getFocusOwner();
                if (sceneSelector instanceof TextInputControl) {
                    enterNumber = btn0.getText();
                    //txtCapital.setText(enterNumber);
                    ((TextInputControl) sceneSelector).replaceSelection(enterNumber);
                }
            });

            rootForMortgageWindow.getChildren().add(decimalPoint);
            decimalPoint.setLayoutY(310);
            decimalPoint.setLayoutX(510);
            decimalPoint.setPrefSize(50, 50);
            decimalPoint.getStylesheets().add("keyboard.css");
            decimalPoint.setFocusTraversable(false);
            decimalPoint.setOnAction(eventE -> {
                Node sceneSelector = sceneForMortgageCalculator.getFocusOwner();
                if (sceneSelector instanceof TextInputControl) {
                    enterNumber = decimalPoint.getText();
                    String checkDecimal = ((TextInputControl) sceneSelector).getText();
                    if (checkDecimal.indexOf('.') == -1) {
                        ((TextInputControl) sceneSelector).replaceSelection(enterNumber);
                    } else {
                        ((TextInputControl) sceneSelector).replaceSelection("");
                    }

                }
            });

            rootForMortgageWindow.getChildren().add(del);
            del.setLayoutY(310);
            del.setLayoutX(570);
            del.setPrefSize(50, 50);
            del.getStylesheets().add("keyboard.css");
            del.setFocusTraversable(false);
            del.setOnAction(eventE -> {
                Node sceneSelector = sceneForMortgageCalculator.getFocusOwner();
                if (sceneSelector instanceof TextInputControl) {
                    if (((TextInputControl) sceneSelector).getLength() > 0) {
                        ((TextInputControl) sceneSelector).setText(((TextInputControl) sceneSelector).getText(0, ((TextInputControl) sceneSelector).getText().length() - 1));
                    }
                }

            });


            rootForMortgageWindow.getChildren().add(lblForHomeValue);
            lblForHomeValue.setLayoutY(130);
            lblForHomeValue.setLayoutX(50);

            rootForMortgageWindow.getChildren().add(txtForHomeValue);
            txtForHomeValue.setLayoutY(130);
            txtForHomeValue.setLayoutX(190);

            rootForMortgageWindow.getChildren().add(lblForDownPayment);
            lblForDownPayment.setLayoutY(190);
            lblForDownPayment.setLayoutX(50);

            rootForMortgageWindow.getChildren().add(txtForDownPayment);
            txtForDownPayment.setLayoutY(190);
            txtForDownPayment.setLayoutX(190);

            rootForMortgageWindow.getChildren().add(lblForLoanTerm);
            lblForLoanTerm.setLayoutY(250);
            lblForLoanTerm.setLayoutX(50);

            rootForMortgageWindow.getChildren().add(txtForLoanTerm);
            txtForLoanTerm.setLayoutY(250);
            txtForLoanTerm.setLayoutX(190);

            rootForMortgageWindow.getChildren().add(lblForInterestRate);
            lblForInterestRate.setLayoutY(310);
            lblForInterestRate.setLayoutX(50);

            rootForMortgageWindow.getChildren().add(txtForInterestRate);
            txtForInterestRate.setLayoutY(310);
            txtForInterestRate.setLayoutX(190);

            rootForMortgageWindow.getChildren().add(mortgageCalculatorButton);
            mortgageCalculatorButton.setLayoutY(370);
            mortgageCalculatorButton.setLayoutX(190);
            mortgageCalculatorButton.getStylesheets().add("stagesButton.css");
            mortgageCalculatorButton.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    // add all text fields to an array
                    TextField[] textFieldNames = { txtForHomeValue, txtForDownPayment, txtForLoanTerm, txtForInterestRate};
                    int countOfEmptyTextField = 0;
                    //file handling


                    // loop each and evey item in this array and check weather its empty or not
                    for (TextField textFieldName : textFieldNames) {
                        if (textFieldName.getText().equals("")) {
                            countOfEmptyTextField += 1;
                        }
                    }
                    // if count of empty text field are 0 or above than to zero print error
                    if (countOfEmptyTextField != 0) {
                        mortgageOutput.setText("Error! Please Provide Valid Information or Read the Help View.");

                    }else {
                        try {
                            double interestRate = Double.parseDouble(txtForInterestRate.getText());
                            double downPayment = Double.parseDouble(txtForDownPayment.getText());
                            double homeValue = Double.parseDouble(txtForHomeValue.getText());
                            double loanTerm = Double.parseDouble(txtForLoanTerm.getText());
                            //calculations
                            double afterValue = homeValue - downPayment;
                            double years = 12 * loanTerm;
                            double monthlyPay = afterValue * (interestRate/12/100) * Math.pow(((interestRate/12/100) +1), years)/ (Math.pow(((interestRate/12/100) +1), years) -1);
                            mortgageOutput.setText("Monthly Pay $" + Math.round(monthlyPay * 100.0)/100.0);

                            //saving data to file
                            FileOutputStream mortgageWriter = null;
                            try {
                                mortgageWriter = new FileOutputStream("mortgage.txt");
                            } catch (FileNotFoundException e) {
                                e.printStackTrace();
                            }

                            assert mortgageWriter != null;
                            BufferedWriter mortgageBuffer = new BufferedWriter(new OutputStreamWriter(mortgageWriter));

                            for (TextField textFieldName : textFieldNames) {
                                try {
                                    mortgageBuffer.write(textFieldName.getText());
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }
                                try {
                                    mortgageBuffer.newLine();
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }
                            }

                            try {
                                mortgageBuffer.close();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }

                        }catch (NumberFormatException e){
                            mortgageOutput.setText("Please enter valid number.");
                        }

                    }

                }
            });

            rootForMortgageWindow.getChildren().add(backBtn);
            backBtn.setLayoutY(370);
            backBtn.setLayoutX(120);

            rootForMortgageWindow.getChildren().add(mortgageOutput);
            mortgageOutput.setLayoutY(420);
            mortgageOutput.setLayoutX(130);
            mortgageOutput.setFont(Font.font("Calibre", FontWeight.BOLD, 13));

            mortgageStage.setScene(sceneForMortgageCalculator);
            mortgageStage.setResizable(false);
            mortgageStage.show();

        });

        /*
        Finance Calculator button ----------------------------------------------------------------------------------------------------
         */
        rootForMainWindow.getChildren().add(financeCalculator);
        financeCalculator.setLayoutY(300);
        financeCalculator.setLayoutX(270);
        financeCalculator.setOnAction(event -> {
            Stage mainWindow = (Stage) financeCalculator.getScene().getWindow();
            mainWindow.close();

            Stage financeStage = new Stage();
            financeStage.setTitle("Finance Calculator");

            Image imgForFinance = new Image("file:Finance.png");
            ImageView iVForFinance = new ImageView();
            iVForFinance.setImage(imgForFinance);

            /*
            define element
             */

            Label lblFutureValue = new Label("Future Value");
            lblFutureValue.setTextAlignment(TextAlignment.LEFT);
            TextField txtFutureValue = new TextField();


            Label lblStartPrincipal = new Label("Present Value");
            lblStartPrincipal.setTextAlignment(TextAlignment.LEFT);
            TextField txtStartPrincipal = new TextField();

            Label lblInterest = new Label("Annual Interest");
            lblInterest.setTextAlignment(TextAlignment.LEFT);
            TextField txtInterest = new TextField();

            Label lblTTime = new Label("Time in years");
            lblTTime.setTextAlignment(TextAlignment.LEFT);
            TextField txtTime = new TextField();

            Button financeCalculateButton = new Button("Calculate");

            Label finalOutputTextForFinance = new Label();

            /*
            adding element to the left pane
             */
            Pane rootForFinanceWindow = new Pane();
            rootForFinanceWindow.getChildren().add(iVForFinance);
            rootForFinanceWindow.getStylesheets().add("lables.css");

            // -----------------------------------
            final Scene sceneForFinanceCalculator = new Scene(rootForFinanceWindow, 700, 500);
            // -----------------------------------

            TextField[] textFieldArray = {  txtFutureValue, txtStartPrincipal, txtInterest,  txtTime  };
            List<String> textFieldValues = new ArrayList<>();

            try {
                try (BufferedReader bufferRenderForMortgage = new BufferedReader(new FileReader("finance.txt"))) {
                    String OutputValueForMortgageTextFeilds;
                    while ((OutputValueForMortgageTextFeilds = bufferRenderForMortgage.readLine()) != null){

                        textFieldValues.add(OutputValueForMortgageTextFeilds);

                    }
                    for (int j = 0; j < textFieldValues.size(); j++){
                        try {
                            textFieldArray[j].setText(textFieldValues.get(j));
                        }catch (IndexOutOfBoundsException e){
                            e.printStackTrace();
                        }

                    }
                    for (String textFieldValue : textFieldValues) {
                        System.out.println(textFieldValue);
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
             /*
            adding keyboard to root pane
             */

            // creating first row //
            rootForFinanceWindow.getChildren().add(btn7);
            btn7.setLayoutY(140);
            btn7.setLayoutX(450);
            btn7.setPrefSize(50, 50);
            btn7.getStylesheets().add("keyboard.css");
            btn7.setFocusTraversable(false);
            btn7.setOnAction(eventE -> {
                Node sceneSelector = sceneForFinanceCalculator.getFocusOwner();
                if (sceneSelector instanceof TextInputControl) {
                    enterNumber = btn7.getText();
                    //txtCapital.setText(enterNumber);
                    ((TextInputControl) sceneSelector).replaceSelection(enterNumber);
                }
            });

            rootForFinanceWindow.getChildren().add(btn8);
            btn8.setLayoutY(140);
            btn8.setLayoutX(510);
            btn8.setPrefSize(50, 50);
            btn8.getStylesheets().add("keyboard.css");
            btn8.setFocusTraversable(false);
            btn8.setOnAction(eventE -> {
                Node sceneSelector = sceneForFinanceCalculator.getFocusOwner();
                if (sceneSelector instanceof TextInputControl) {
                    enterNumber = btn8.getText();
                    //txtCapital.setText(enterNumber);
                    ((TextInputControl) sceneSelector).replaceSelection(enterNumber);
                }
            });

            rootForFinanceWindow.getChildren().add(btn9);
            btn9.setLayoutY(140);
            btn9.setLayoutX(570);
            btn9.setPrefSize(50, 50);
            btn9.getStylesheets().add("keyboard.css");
            btn9.setFocusTraversable(false);
            btn9.setOnAction(eventE -> {
                Node sceneSelector = sceneForFinanceCalculator.getFocusOwner();
                if (sceneSelector instanceof TextInputControl) {
                    enterNumber = btn9.getText();
                    //txtCapital.setText(enterNumber);
                    ((TextInputControl) sceneSelector).replaceSelection(enterNumber);
                }
            });

            // Creating second row //

            rootForFinanceWindow.getChildren().add(btn4);
            btn4.setLayoutY(200);
            btn4.setLayoutX(450);
            btn4.setPrefSize(50, 50);
            btn4.getStylesheets().add("keyboard.css");
            btn4.setFocusTraversable(false);
            btn4.setOnAction(eventE -> {
                Node sceneSelector = sceneForFinanceCalculator.getFocusOwner();
                if (sceneSelector instanceof TextInputControl) {
                    enterNumber = btn4.getText();
                    //txtCapital.setText(enterNumber);
                    ((TextInputControl) sceneSelector).replaceSelection(enterNumber);
                }
            });

            rootForFinanceWindow.getChildren().add(btn5);
            btn5.setLayoutY(200);
            btn5.setLayoutX(510);
            btn5.setPrefSize(50, 50);
            btn5.getStylesheets().add("keyboard.css");
            btn5.setFocusTraversable(false);
            btn5.setOnAction(eventE -> {
                Node sceneSelector = sceneForFinanceCalculator.getFocusOwner();
                if (sceneSelector instanceof TextInputControl) {
                    enterNumber = btn5.getText();
                    //txtCapital.setText(enterNumber);
                    ((TextInputControl) sceneSelector).replaceSelection(enterNumber);
                }
            });

            rootForFinanceWindow.getChildren().add(btn6);
            btn6.setLayoutY(200);
            btn6.setLayoutX(570);
            btn6.setPrefSize(50, 50);
            btn6.getStylesheets().add("keyboard.css");
            btn6.setFocusTraversable(false);
            btn6.setOnAction(eventE -> {
                Node sceneSelector = sceneForFinanceCalculator.getFocusOwner();
                if (sceneSelector instanceof TextInputControl) {
                    enterNumber = btn6.getText();
                    //txtCapital.setText(enterNumber);
                    ((TextInputControl) sceneSelector).replaceSelection(enterNumber);
                }
            });

            // Creating third row //

            rootForFinanceWindow.getChildren().add(btn1);
            btn1.setLayoutY(260);
            btn1.setLayoutX(450);
            btn1.setPrefSize(50, 50);
            btn1.getStylesheets().add("keyboard.css");
            btn1.setFocusTraversable(false);
            btn1.setOnAction(eventE -> {
                Node sceneSelector = sceneForFinanceCalculator.getFocusOwner();
                if (sceneSelector instanceof TextInputControl) {
                    enterNumber = btn1.getText();
                    //txtCapital.setText(enterNumber);
                    ((TextInputControl) sceneSelector).replaceSelection(enterNumber);
                }
            });

            rootForFinanceWindow.getChildren().add(btn2);
            btn2.setLayoutY(260);
            btn2.setLayoutX(510);
            btn2.setPrefSize(50, 50);
            btn2.getStylesheets().add("keyboard.css");
            btn2.setFocusTraversable(false);
            btn2.setOnAction(eventE -> {
                Node sceneSelector = sceneForFinanceCalculator.getFocusOwner();
                if (sceneSelector instanceof TextInputControl) {
                    enterNumber = btn2.getText();
                    //txtCapital.setText(enterNumber);
                    ((TextInputControl) sceneSelector).replaceSelection(enterNumber);
                }
            });

            rootForFinanceWindow.getChildren().add(btn3);
            btn3.setLayoutY(260);
            btn3.setLayoutX(570);
            btn3.setPrefSize(50, 50);
            btn3.getStylesheets().add("keyboard.css");
            btn3.setFocusTraversable(false);
            btn3.setOnAction(eventE -> {
                Node sceneSelector = sceneForFinanceCalculator.getFocusOwner();
                if (sceneSelector instanceof TextInputControl) {
                    enterNumber = btn3.getText();
                    //txtCapital.setText(enterNumber);
                    ((TextInputControl) sceneSelector).replaceSelection(enterNumber);
                }
            });

            // creating a fifth row //
            rootForFinanceWindow.getChildren().add(btn0);
            btn0.setLayoutY(320);
            btn0.setLayoutX(450);
            btn0.setPrefSize(50, 50);
            btn0.getStylesheets().add("keyboard.css");
            btn0.setFocusTraversable(false);
            btn0.setOnAction(eventE -> {
                Node sceneSelector = sceneForFinanceCalculator.getFocusOwner();
                if (sceneSelector instanceof TextInputControl) {
                    enterNumber = btn0.getText();
                    //txtCapital.setText(enterNumber);
                    ((TextInputControl) sceneSelector).replaceSelection(enterNumber);
                }
            });

            rootForFinanceWindow.getChildren().add(decimalPoint);
            decimalPoint.setLayoutY(320);
            decimalPoint.setLayoutX(510);
            decimalPoint.setPrefSize(50, 50);
            decimalPoint.getStylesheets().add("keyboard.css");
            decimalPoint.setFocusTraversable(false);
            decimalPoint.setOnAction(eventE -> {
                Node sceneSelector = sceneForFinanceCalculator.getFocusOwner();
                if (sceneSelector instanceof TextInputControl) {
                    enterNumber = decimalPoint.getText();
                    String checkDecimal = ((TextInputControl) sceneSelector).getText();
                    if (checkDecimal.indexOf('.') == -1) {
                        ((TextInputControl) sceneSelector).replaceSelection(enterNumber);
                    } else {
                        ((TextInputControl) sceneSelector).replaceSelection("");
                    }

                }
            });

            rootForFinanceWindow.getChildren().add(del);
            del.setLayoutY(320);
            del.setLayoutX(570);
            del.setPrefSize(50, 50);
            del.getStylesheets().add("keyboard.css");
            del.setFocusTraversable(false);
            del.setOnAction(eventE -> {
                Node sceneSelector = sceneForFinanceCalculator.getFocusOwner();
                if (sceneSelector instanceof TextInputControl) {
                    if (((TextInputControl) sceneSelector).getLength() > 0) {
                        ((TextInputControl) sceneSelector).setText(((TextInputControl) sceneSelector).getText(0, ((TextInputControl) sceneSelector).getText().length() - 1));
                    }
                }

            });


            rootForFinanceWindow.getChildren().add(backBtn);
            backBtn.setLayoutY(370);
            backBtn.setLayoutX(120);


            rootForFinanceWindow.getChildren().add(lblFutureValue);
            lblFutureValue.setLayoutY(140);
            lblFutureValue.setLayoutX(50);

            rootForFinanceWindow.getChildren().add(txtFutureValue);
            txtFutureValue.setLayoutY(140);
            txtFutureValue.setLayoutX(190);

            //second row
            rootForFinanceWindow.getChildren().add(lblStartPrincipal);
            lblStartPrincipal.setLayoutY(200);
            lblStartPrincipal.setLayoutX(50);

            rootForFinanceWindow.getChildren().add(txtStartPrincipal);
            txtStartPrincipal.setLayoutY(200);
            txtStartPrincipal.setLayoutX(190);

            //third row
            rootForFinanceWindow.getChildren().add(lblInterest);
            lblInterest.setLayoutY(260);
            lblInterest.setLayoutX(50);

            rootForFinanceWindow.getChildren().add(txtInterest);
            txtInterest.setLayoutY(260);
            txtInterest.setLayoutX(190);

            //fourth row
            rootForFinanceWindow.getChildren().add(lblTTime);
            lblTTime.setLayoutY(320);
            lblTTime.setLayoutX(50);

            rootForFinanceWindow.getChildren().add(txtTime);
            txtTime.setLayoutY(320);
            txtTime.setLayoutX(190);

            rootForFinanceWindow.getChildren().add(finalOutputTextForFinance);
            finalOutputTextForFinance.setLayoutY(430);
            finalOutputTextForFinance.setLayoutX(130);
            finalOutputTextForFinance.setFont(Font.font("Calibre", FontWeight.BOLD, 13));

            rootForFinanceWindow.getChildren().add(financeCalculateButton);
            financeCalculateButton.setLayoutY(370);
            financeCalculateButton.setLayoutX(190);
            financeCalculateButton.getStylesheets().add("stagesButton.css");

            /*
             * create functionality for finance calculator
             */

            financeCalculateButton.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    // add all text fields to an array
                    TextField[] textFieldNames = {txtFutureValue, txtStartPrincipal, txtInterest, txtTime};
                    int countOfEmptyTextField = 0;

                    // loop each and evey item in this array and check weather its empty or not
                    for (TextField textFieldName : textFieldNames) {
                        if (textFieldName.getText().equals("")) {
                            countOfEmptyTextField += 1;
                        }
                    }
                    // if count of empty text field are 0 or above than to zero print error
                    if (countOfEmptyTextField >= 2 || countOfEmptyTextField == 0) {

                        finalOutputTextForFinance.setText("Error! Please Provide Valid Information or Read the Help View.");
                        // if not we check for empty text fields and start the calculation
                    } else if (txtFutureValue.getText().equals("")) {
                        //inputs for calculate future value
                        try {
                            double interestForFinance = Double.parseDouble(txtInterest.getText());
                            double startPrincipalForFinance = Double.parseDouble(txtStartPrincipal.getText());
                            double timeForFinance = Double.parseDouble(txtTime.getText());
                            //calculation
                            double powerOfFV = 12 * timeForFinance;
                            double baseOfFV = 1 + ((interestForFinance / 100) / 12);
                            double FVOutput = Math.round(Math.pow(baseOfFV, powerOfFV) * startPrincipalForFinance * 100.0) / 100.0;
                            finalOutputTextForFinance.setText("Future Value $" + FVOutput);
                            txtFutureValue.setText(String.valueOf(FVOutput));
                            //saving data to file
                            FileOutputStream mortgageWriter = null;
                            try {
                                mortgageWriter = new FileOutputStream("finance.txt");
                            } catch (FileNotFoundException e) {
                                e.printStackTrace();
                            }

                            assert mortgageWriter != null;
                            BufferedWriter mortgageBuffer = new BufferedWriter(new OutputStreamWriter(mortgageWriter));

                            for (TextField textFieldName : textFieldNames) {
                                try {
                                    mortgageBuffer.write(textFieldName.getText());
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }
                                try {
                                    mortgageBuffer.newLine();
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }
                            }

                            try {
                                mortgageBuffer.close();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }

                        }catch (NumberFormatException e){
                            finalOutputTextForFinance.setText("Please enter valid number.");
                        }
                    }else if (txtStartPrincipal.getText().equals("")) {
                        //inputs for calculate future value
                        try {
                            double interestForFinance = Double.parseDouble(txtInterest.getText());
                            double futureValueForFinance = Double.parseDouble(txtFutureValue.getText());
                            double timeForFinance = Double.parseDouble(txtTime.getText());
                            //calculation
                            double powerOfFV = 12 * timeForFinance;
                            double baseOfFV = 1 + ((interestForFinance / 100) / 12);
                            double SPOutput = Math.round(futureValueForFinance / Math.pow(baseOfFV, powerOfFV) * 100.0) / 100.0;
                            finalOutputTextForFinance.setText("Start Principal Value $" + SPOutput);
                            txtStartPrincipal.setText(String.valueOf(SPOutput));
                            //saving data to file
                            FileOutputStream mortgageWriter = null;
                            try {
                                mortgageWriter = new FileOutputStream("finance.txt");
                            } catch (FileNotFoundException e) {
                                e.printStackTrace();
                            }

                            assert mortgageWriter != null;
                            BufferedWriter mortgageBuffer = new BufferedWriter(new OutputStreamWriter(mortgageWriter));

                            for (TextField textFieldName : textFieldNames) {
                                try {
                                    mortgageBuffer.write(textFieldName.getText());
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }
                                try {
                                    mortgageBuffer.newLine();
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }
                            }

                            try {
                                mortgageBuffer.close();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }

                        }catch (NumberFormatException e){
                            finalOutputTextForFinance.setText("Please enter valid number.");
                        }

                    } else if (txtInterest.getText().equals("")) {
                        //inputs for calculate future value
                        try {
                            double startPrincipalForFinance = Double.parseDouble(txtStartPrincipal.getText());
                            double futureValueForFinance = Double.parseDouble(txtFutureValue.getText());
                            double timeForFinance = Double.parseDouble(txtTime.getText());
                            //calculation
                            double powerOfIntreset = 1 / (12 * timeForFinance);
                            double divisionForInterest = futureValueForFinance / startPrincipalForFinance;
                            double INOutput = Math.round((((Math.pow(divisionForInterest, powerOfIntreset) - 1) * 12) * 100) * 100.0) / 100.0;
                            finalOutputTextForFinance.setText("Interest Value " + INOutput + "%");
                            txtInterest.setText(String.valueOf(INOutput));
                            //saving data to file
                            FileOutputStream mortgageWriter = null;
                            try {
                                mortgageWriter = new FileOutputStream("finance.txt");
                            } catch (FileNotFoundException e) {
                                e.printStackTrace();
                            }

                            assert mortgageWriter != null;
                            BufferedWriter mortgageBuffer = new BufferedWriter(new OutputStreamWriter(mortgageWriter));

                            for (TextField textFieldName : textFieldNames) {
                                try {
                                    mortgageBuffer.write(textFieldName.getText());
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }
                                try {
                                    mortgageBuffer.newLine();
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }
                            }

                            try {
                                mortgageBuffer.close();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }

                        }catch (NumberFormatException e){
                            finalOutputTextForFinance.setText("Please enter valid number format or read help view");
                        }

                    } else if (txtTime.getText().equals("")) {
                        //inputs for calculate future value
                        try {
                            double interestForFinance = Double.parseDouble(txtInterest.getText());
                            double startPrincipalForFinance = Double.parseDouble(txtStartPrincipal.getText());
                            double futureValueForFinance = Double.parseDouble(txtFutureValue.getText());
                            //calculations
                            double divisionForTime = futureValueForFinance / startPrincipalForFinance;
                            double logOfTime = 1 + ((interestForFinance / 100) / 12);
                            double upperPart = Math.log(divisionForTime);
                            double lowerPart = Math.log(logOfTime) * 12;
                            double timeOutput = Math.round((upperPart / lowerPart) * 100.0) / 100.0;
                            finalOutputTextForFinance.setText("Time in Years " + timeOutput);
                            txtTime.setText(String.valueOf(timeOutput));

                            //saving data to file
                            FileOutputStream mortgageWriter = null;
                            try {
                                mortgageWriter = new FileOutputStream("finance.txt");
                            } catch (FileNotFoundException e) {
                                e.printStackTrace();
                            }

                            assert mortgageWriter != null;
                            BufferedWriter mortgageBuffer = new BufferedWriter(new OutputStreamWriter(mortgageWriter));

                            for (TextField textFieldName : textFieldNames) {
                                try {
                                    mortgageBuffer.write(textFieldName.getText());
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }
                                try {
                                    mortgageBuffer.newLine();
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }
                            }

                            try {
                                mortgageBuffer.close();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }

                        }catch (NumberFormatException e){
                            finalOutputTextForFinance.setText("Please enter valid number format or read help view");
                        }

                    }
                }
            });


            financeStage.setScene(sceneForFinanceCalculator);
            financeStage.setResizable(false);
            financeStage.show();
        });

        /*
        Auto Loan Calculator button ---------------------------------------------------------------------------------------------------------------
         */
        rootForMainWindow.getChildren().add(autoLoanCalculator);
        autoLoanCalculator.setLayoutY(360);
        autoLoanCalculator.setLayoutX(265);

        autoLoanCalculator.setOnAction(event -> {
            Stage mainWindow = (Stage) autoLoanCalculator.getScene().getWindow();
            mainWindow.close();

            Stage autoLoanStage = new Stage();
            autoLoanStage.setTitle("Auto Loan Calculator");

            Image imgForAutoLoan = new Image("file:autoLoan.png");
            ImageView iVForAutoLoan = new ImageView();
            iVForAutoLoan.setImage(imgForAutoLoan);

            /*
            define element
             */

            Label lblDownPayment = new Label("Down Payment");

            TextField txtDownPayment = new TextField();

            Label lblLoanTerm = new Label("Loan Term");

            TextField txtLoanTerm = new TextField();

            Label lblInterestRate = new Label("Interest Rate");

            TextField txtInterestRate = new TextField();

            Label lblLoanAmount = new Label("Loan Amount");

            TextField txtLoanAmount = new TextField();

            Button autoLoanCalButton = new Button("Calculate");

            Label finalOutputTextForAutoLoan = new Label();

            /*
            adding element to the left pane
             */
            Pane rootForAutoLoanWindow = new Pane();
            rootForAutoLoanWindow.getChildren().add(iVForAutoLoan);
            rootForAutoLoanWindow.getStylesheets().add("lables.css");

            // -----------------------------------
            final Scene sceneForAutoLoanCalculator = new Scene(rootForAutoLoanWindow, 700, 500);
            // -----------------------------------
            TextField[] textFieldArray = { txtDownPayment, txtLoanTerm, txtInterestRate, txtLoanAmount  };
            List<String> textFieldValues = new ArrayList<>();

            try {
                try (BufferedReader bufferRenderForMortgage = new BufferedReader(new FileReader("autoLoan.txt"))) {
                    String OutputValueForMortgageTextFeilds;
                    while ((OutputValueForMortgageTextFeilds = bufferRenderForMortgage.readLine()) != null){

                        textFieldValues.add(OutputValueForMortgageTextFeilds);

                    }
                    for (int j = 0; j < textFieldValues.size(); j++){
                        try {
                            textFieldArray[j].setText(textFieldValues.get(j));
                        }catch (IndexOutOfBoundsException e){
                            e.printStackTrace();
                        }

                    }
                    for (String textFieldValue : textFieldValues) {
                        System.out.println(textFieldValue);
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            /*
            adding keyboard to root pane
             */

            // creating first row //
            rootForAutoLoanWindow.getChildren().add(btn7);
            btn7.setLayoutY(130);
            btn7.setLayoutX(450);
            btn7.setPrefSize(50, 50);
            btn7.getStylesheets().add("keyboard.css");
            btn7.setFocusTraversable(false);
            btn7.setOnAction(eventE -> {
                Node sceneSelector = sceneForAutoLoanCalculator.getFocusOwner();
                if (sceneSelector instanceof TextInputControl) {
                    enterNumber = btn7.getText();
                    //txtCapital.setText(enterNumber);
                    ((TextInputControl) sceneSelector).replaceSelection(enterNumber);
                }
            });

            rootForAutoLoanWindow.getChildren().add(btn8);
            btn8.setLayoutY(130);
            btn8.setLayoutX(510);
            btn8.setPrefSize(50, 50);
            btn8.getStylesheets().add("keyboard.css");
            btn8.setFocusTraversable(false);
            btn8.setOnAction(eventE -> {
                Node sceneSelector = sceneForAutoLoanCalculator.getFocusOwner();
                if (sceneSelector instanceof TextInputControl) {
                    enterNumber = btn8.getText();
                    //txtCapital.setText(enterNumber);
                    ((TextInputControl) sceneSelector).replaceSelection(enterNumber);
                }
            });

            rootForAutoLoanWindow.getChildren().add(btn9);
            btn9.setLayoutY(130);
            btn9.setLayoutX(570);
            btn9.setPrefSize(50, 50);
            btn9.getStylesheets().add("keyboard.css");
            btn9.setFocusTraversable(false);
            btn9.setOnAction(eventE -> {
                Node sceneSelector = sceneForAutoLoanCalculator.getFocusOwner();
                if (sceneSelector instanceof TextInputControl) {
                    enterNumber = btn9.getText();
                    //txtCapital.setText(enterNumber);
                    ((TextInputControl) sceneSelector).replaceSelection(enterNumber);
                }
            });

            // Creating second row //

            rootForAutoLoanWindow.getChildren().add(btn4);
            btn4.setLayoutY(190);
            btn4.setLayoutX(450);
            btn4.setPrefSize(50, 50);
            btn4.getStylesheets().add("keyboard.css");
            btn4.setFocusTraversable(false);
            btn4.setOnAction(eventE -> {
                Node sceneSelector = sceneForAutoLoanCalculator.getFocusOwner();
                if (sceneSelector instanceof TextInputControl) {
                    enterNumber = btn4.getText();
                    //txtCapital.setText(enterNumber);
                    ((TextInputControl) sceneSelector).replaceSelection(enterNumber);
                }
            });

            rootForAutoLoanWindow.getChildren().add(btn5);
            btn5.setLayoutY(190);
            btn5.setLayoutX(510);
            btn5.setPrefSize(50, 50);
            btn5.getStylesheets().add("keyboard.css");
            btn5.setFocusTraversable(false);
            btn5.setOnAction(eventE -> {
                Node sceneSelector = sceneForAutoLoanCalculator.getFocusOwner();
                if (sceneSelector instanceof TextInputControl) {
                    enterNumber = btn5.getText();
                    //txtCapital.setText(enterNumber);
                    ((TextInputControl) sceneSelector).replaceSelection(enterNumber);
                }
            });

            rootForAutoLoanWindow.getChildren().add(btn6);
            btn6.setLayoutY(190);
            btn6.setLayoutX(570);
            btn6.setPrefSize(50, 50);
            btn6.getStylesheets().add("keyboard.css");
            btn6.setFocusTraversable(false);
            btn6.setOnAction(eventE -> {
                Node sceneSelector = sceneForAutoLoanCalculator.getFocusOwner();
                if (sceneSelector instanceof TextInputControl) {
                    enterNumber = btn6.getText();
                    //txtCapital.setText(enterNumber);
                    ((TextInputControl) sceneSelector).replaceSelection(enterNumber);
                }
            });

            // Creating third row //

            rootForAutoLoanWindow.getChildren().add(btn1);
            btn1.setLayoutY(250);
            btn1.setLayoutX(450);
            btn1.setPrefSize(50, 50);
            btn1.getStylesheets().add("keyboard.css");
            btn1.setFocusTraversable(false);
            btn1.setOnAction(eventE -> {
                Node sceneSelector = sceneForAutoLoanCalculator.getFocusOwner();
                if (sceneSelector instanceof TextInputControl) {
                    enterNumber = btn1.getText();
                    //txtCapital.setText(enterNumber);
                    ((TextInputControl) sceneSelector).replaceSelection(enterNumber);
                }
            });

            rootForAutoLoanWindow.getChildren().add(btn2);
            btn2.setLayoutY(250);
            btn2.setLayoutX(510);
            btn2.setPrefSize(50, 50);
            btn2.getStylesheets().add("keyboard.css");
            btn2.setFocusTraversable(false);
            btn2.setOnAction(eventE -> {
                Node sceneSelector = sceneForAutoLoanCalculator.getFocusOwner();
                if (sceneSelector instanceof TextInputControl) {
                    enterNumber = btn2.getText();
                    //txtCapital.setText(enterNumber);
                    ((TextInputControl) sceneSelector).replaceSelection(enterNumber);
                }
            });

            rootForAutoLoanWindow.getChildren().add(btn3);
            btn3.setLayoutY(250);
            btn3.setLayoutX(570);
            btn3.setPrefSize(50, 50);
            btn3.getStylesheets().add("keyboard.css");
            btn3.setFocusTraversable(false);
            btn3.setOnAction(eventE -> {
                Node sceneSelector = sceneForAutoLoanCalculator.getFocusOwner();
                if (sceneSelector instanceof TextInputControl) {
                    enterNumber = btn3.getText();
                    //txtCapital.setText(enterNumber);
                    ((TextInputControl) sceneSelector).replaceSelection(enterNumber);
                }
            });

            // creating a fifth row //
            rootForAutoLoanWindow.getChildren().add(btn0);
            btn0.setLayoutY(310);
            btn0.setLayoutX(450);
            btn0.setPrefSize(50, 50);
            btn0.getStylesheets().add("keyboard.css");
            btn0.setFocusTraversable(false);
            btn0.setOnAction(eventE -> {
                Node sceneSelector = sceneForAutoLoanCalculator.getFocusOwner();
                if (sceneSelector instanceof TextInputControl) {
                    enterNumber = btn0.getText();
                    //txtCapital.setText(enterNumber);
                    ((TextInputControl) sceneSelector).replaceSelection(enterNumber);
                }
            });

            rootForAutoLoanWindow.getChildren().add(decimalPoint);
            decimalPoint.setLayoutY(310);
            decimalPoint.setLayoutX(510);
            decimalPoint.setPrefSize(50, 50);
            decimalPoint.getStylesheets().add("keyboard.css");
            decimalPoint.setFocusTraversable(false);
            decimalPoint.setOnAction(eventE -> {
                Node sceneSelector = sceneForAutoLoanCalculator.getFocusOwner();
                if (sceneSelector instanceof TextInputControl) {
                    enterNumber = decimalPoint.getText();
                    String checkDecimal = ((TextInputControl) sceneSelector).getText();
                    if (checkDecimal.indexOf('.') == -1) {
                        ((TextInputControl) sceneSelector).replaceSelection(enterNumber);
                    } else {
                        ((TextInputControl) sceneSelector).replaceSelection("");
                    }

                }
            });

            rootForAutoLoanWindow.getChildren().add(del);
            del.setLayoutY(310);
            del.setLayoutX(570);
            del.setPrefSize(50, 50);
            del.getStylesheets().add("keyboard.css");
            del.setFocusTraversable(false);
            del.setOnAction(eventE -> {
                Node sceneSelector = sceneForAutoLoanCalculator.getFocusOwner();
                if (sceneSelector instanceof TextInputControl) {
                    if (((TextInputControl) sceneSelector).getLength() > 0) {
                        ((TextInputControl) sceneSelector).setText(((TextInputControl) sceneSelector).getText(0, ((TextInputControl) sceneSelector).getText().length() - 1));
                    }
                }

            });

            rootForAutoLoanWindow.getChildren().add(backBtn);
            backBtn.setLayoutY(370);
            backBtn.setLayoutX(120);


            rootForAutoLoanWindow.getChildren().add(lblDownPayment);
            lblDownPayment.setLayoutY(130);
            lblDownPayment.setLayoutX(50);

            rootForAutoLoanWindow.getChildren().add(txtDownPayment);
            txtDownPayment.setLayoutY(130);
            txtDownPayment.setLayoutX(190);

            // first row
            rootForAutoLoanWindow.getChildren().add(lblLoanTerm);
            lblLoanTerm.setLayoutY(190);
            lblLoanTerm.setLayoutX(50);

            rootForAutoLoanWindow.getChildren().add(txtLoanTerm);
            txtLoanTerm.setLayoutY(190);
            txtLoanTerm.setLayoutX(190);

            //second row
            rootForAutoLoanWindow.getChildren().add(lblInterestRate);
            lblInterestRate.setLayoutY(250);
            lblInterestRate.setLayoutX(50);

            rootForAutoLoanWindow.getChildren().add(txtInterestRate);
            txtInterestRate.setLayoutY(250);
            txtInterestRate.setLayoutX(190);

            //third row
            rootForAutoLoanWindow.getChildren().add(lblLoanAmount);
            lblLoanAmount.setLayoutY(310);
            lblLoanAmount.setLayoutX(50);

            rootForAutoLoanWindow.getChildren().add(txtLoanAmount);
            txtLoanAmount.setLayoutY(310);
            txtLoanAmount.setLayoutX(190);

            rootForAutoLoanWindow.getChildren().add(autoLoanCalButton);
            autoLoanCalButton.setLayoutY(370);
            autoLoanCalButton.setLayoutX(190);
            autoLoanCalButton.getStylesheets().add("stagesButton.css");
            autoLoanCalButton.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    // add all text fields to an array
                    TextField[] textFieldNames = { txtDownPayment, txtLoanTerm, txtInterestRate, txtLoanAmount };
                    int countOfEmptyTextField = 0;

                    // loop each and evey item in this array and check weather its empty or not
                    for (TextField textFieldName : textFieldNames) {
                        if (textFieldName.getText().equals("")) {
                            countOfEmptyTextField += 1;
                        }
                    }
                    // if count of empty text field are 0 or above than to zero print error
                    if (countOfEmptyTextField != 0) {
                        finalOutputTextForAutoLoan.setText("Error! Please Provide Valid Information or Read the Help View.");

                    } else {
                        try {
                            double interestRate = Double.parseDouble(txtInterestRate.getText());
                            double downPayment = Double.parseDouble(txtDownPayment.getText());
                            double loanAmount = Double.parseDouble(txtLoanAmount.getText());
                            double loanTerm = Double.parseDouble(txtLoanTerm.getText());
                            //calculations
                            double afterValue = loanAmount - downPayment;
                            double years = 12 * loanTerm;
                            double monthlyPay = afterValue * (interestRate / 12 / 100) * Math.pow(((interestRate / 12 / 100) + 1), years) / (Math.pow(((interestRate / 12 / 100) + 1), years) - 1);
                            finalOutputTextForAutoLoan.setText("Monthly Pay $" + Math.round(monthlyPay * 100.0) / 100.0);

                            //saving data to file
                            FileOutputStream mortgageWriter = null;
                            try {
                                mortgageWriter = new FileOutputStream("autoLoan.txt");
                            } catch (FileNotFoundException e) {
                                e.printStackTrace();
                            }

                            assert mortgageWriter != null;
                            BufferedWriter mortgageBuffer = new BufferedWriter(new OutputStreamWriter(mortgageWriter));

                            for (TextField textFieldName : textFieldNames) {
                                try {
                                    mortgageBuffer.write(textFieldName.getText());
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }
                                try {
                                    mortgageBuffer.newLine();
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }
                            }

                            try {
                                mortgageBuffer.close();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }catch (NumberFormatException e){
                            finalOutputTextForAutoLoan.setText("Please enter valid number.");
                        }
                    }

                }
            });

            rootForAutoLoanWindow.getChildren().add(finalOutputTextForAutoLoan);
            finalOutputTextForAutoLoan.setLayoutY(430);
            finalOutputTextForAutoLoan.setLayoutX(130);
            finalOutputTextForAutoLoan.setFont(Font.font("Calibre", FontWeight.BOLD, 13));

            rootForAutoLoanWindow.setStyle("-fx-background-color: White");
            autoLoanStage.setScene(sceneForAutoLoanCalculator);
            autoLoanStage.setResizable(false);
            autoLoanStage.show();
        });

        /*
        Compound Interest button --------------------------------------------------------------------------------------------------------
         */
        rootForMainWindow.getChildren().add(compoundInterest);
        compoundInterest.setLayoutY(420);
        compoundInterest.setLayoutX(220);
        compoundInterest.setOnAction(event -> {
            Stage mainWindow = (Stage) compoundInterest.getScene().getWindow();
            mainWindow.close();

            Stage compoundStage = new Stage();
            compoundStage.setTitle("Compound Saving Calculator");

            Image imgForCompoudSaving = new Image("file:compoundSaving.png");
            ImageView iVForCompoundSaving = new ImageView();
            iVForCompoundSaving.setImage(imgForCompoudSaving);

            /*
            define element
             */

            Label lblFutureValueForCompound = new Label("Future Value");

            TextField txtFutureValueForCompound = new TextField();

            Label lblPresentValueForCompound = new Label("Monthly Payment");

            TextField txtPresentValueForCompound = new TextField();

            Label lblInterestRateForCompound = new Label("Annual Interest");

            TextField txtInterestRateForCompound = new TextField();

            Label lblTimeInYearsForCompound = new Label("Time in Years");

            TextField txtTimeInYearsForCompound = new TextField();


            Button compoundCalButton = new Button("Calculate");

            Label finalOutputTextForCompound = new Label();

            /*
            adding element to the left pane
             */
            Pane rootForCompoundWindow = new Pane();
            rootForCompoundWindow.getChildren().add(iVForCompoundSaving);
            rootForCompoundWindow.getStylesheets().add("lables.css");

            rootForCompoundWindow.getChildren().add(backBtn);
            backBtn.setLayoutY(360);
            backBtn.setLayoutX(120);

            // -----------------------------------
            final Scene sceneForCompoundCalculator = new Scene(rootForCompoundWindow, 700, 500);
            // -----------------------------------
            // saving data to file
            TextField[] textFieldArray = { txtFutureValueForCompound, txtPresentValueForCompound, txtInterestRateForCompound, txtTimeInYearsForCompound  };
            List<String> textFieldValues = new ArrayList<>();

            try {
                try (BufferedReader bufferRenderForMortgage = new BufferedReader(new FileReader("saving.txt"))) {
                    String OutputValueForMortgageTextFeilds;
                    while ((OutputValueForMortgageTextFeilds = bufferRenderForMortgage.readLine()) != null){

                        textFieldValues.add(OutputValueForMortgageTextFeilds);

                    }
                    for (int j = 0; j < textFieldValues.size(); j++){
                        try {
                            textFieldArray[j].setText(textFieldValues.get(j));
                        }catch (IndexOutOfBoundsException e){
                            e.printStackTrace();
                        }

                    }
                    for (String textFieldValue : textFieldValues) {
                        System.out.println(textFieldValue);
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

            /*
            adding keyboard to root pane
             */

            // creating first row //
            rootForCompoundWindow.getChildren().add(btn7);
            btn7.setLayoutY(120);
            btn7.setLayoutX(450);
            btn7.setPrefSize(50, 50);
            btn7.getStylesheets().add("keyboard.css");
            btn7.setFocusTraversable(false);
            btn7.setOnAction(eventE -> {
                Node sceneSelector = sceneForCompoundCalculator.getFocusOwner();
                if (sceneSelector instanceof TextInputControl) {
                    enterNumber = btn7.getText();
                    //txtCapital.setText(enterNumber);
                    ((TextInputControl) sceneSelector).replaceSelection(enterNumber);
                }
            });

            rootForCompoundWindow.getChildren().add(btn8);
            btn8.setLayoutY(120);
            btn8.setLayoutX(510);
            btn8.setPrefSize(50, 50);
            btn8.getStylesheets().add("keyboard.css");
            btn8.setFocusTraversable(false);
            btn8.setOnAction(eventE -> {
                Node sceneSelector = sceneForCompoundCalculator.getFocusOwner();
                if (sceneSelector instanceof TextInputControl) {
                    enterNumber = btn8.getText();
                    //txtCapital.setText(enterNumber);
                    ((TextInputControl) sceneSelector).replaceSelection(enterNumber);
                }
            });

            rootForCompoundWindow.getChildren().add(btn9);
            btn9.setLayoutY(120);
            btn9.setLayoutX(570);
            btn9.setPrefSize(50, 50);
            btn9.getStylesheets().add("keyboard.css");
            btn9.setFocusTraversable(false);
            btn9.setOnAction(eventE -> {
                Node sceneSelector = sceneForCompoundCalculator.getFocusOwner();
                if (sceneSelector instanceof TextInputControl) {
                    enterNumber = btn9.getText();
                    //txtCapital.setText(enterNumber);
                    ((TextInputControl) sceneSelector).replaceSelection(enterNumber);
                }
            });

            // Creating second row //

            rootForCompoundWindow.getChildren().add(btn4);
            btn4.setLayoutY(180);
            btn4.setLayoutX(450);
            btn4.setPrefSize(50, 50);
            btn4.getStylesheets().add("keyboard.css");
            btn4.setFocusTraversable(false);
            btn4.setOnAction(eventE -> {
                Node sceneSelector = sceneForCompoundCalculator.getFocusOwner();
                if (sceneSelector instanceof TextInputControl) {
                    enterNumber = btn4.getText();
                    //txtCapital.setText(enterNumber);
                    ((TextInputControl) sceneSelector).replaceSelection(enterNumber);
                }
            });

            rootForCompoundWindow.getChildren().add(btn5);
            btn5.setLayoutY(180);
            btn5.setLayoutX(510);
            btn5.setPrefSize(50, 50);
            btn5.getStylesheets().add("keyboard.css");
            btn5.setFocusTraversable(false);
            btn5.setOnAction(eventE -> {
                Node sceneSelector = sceneForCompoundCalculator.getFocusOwner();
                if (sceneSelector instanceof TextInputControl) {
                    enterNumber = btn5.getText();
                    //txtCapital.setText(enterNumber);
                    ((TextInputControl) sceneSelector).replaceSelection(enterNumber);
                }
            });

            rootForCompoundWindow.getChildren().add(btn6);
            btn6.setLayoutY(180);
            btn6.setLayoutX(570);
            btn6.setPrefSize(50, 50);
            btn6.getStylesheets().add("keyboard.css");
            btn6.setFocusTraversable(false);
            btn6.setOnAction(eventE -> {
                Node sceneSelector = sceneForCompoundCalculator.getFocusOwner();
                if (sceneSelector instanceof TextInputControl) {
                    enterNumber = btn6.getText();
                    //txtCapital.setText(enterNumber);
                    ((TextInputControl) sceneSelector).replaceSelection(enterNumber);
                }
            });

            // Creating third row //

            rootForCompoundWindow.getChildren().add(btn1);
            btn1.setLayoutY(240);
            btn1.setLayoutX(450);
            btn1.setPrefSize(50, 50);
            btn1.getStylesheets().add("keyboard.css");
            btn1.setFocusTraversable(false);
            btn1.setOnAction(eventE -> {
                Node sceneSelector = sceneForCompoundCalculator.getFocusOwner();
                if (sceneSelector instanceof TextInputControl) {
                    enterNumber = btn1.getText();
                    //txtCapital.setText(enterNumber);
                    ((TextInputControl) sceneSelector).replaceSelection(enterNumber);
                }
            });

            rootForCompoundWindow.getChildren().add(btn2);
            btn2.setLayoutY(240);
            btn2.setLayoutX(510);
            btn2.setPrefSize(50, 50);
            btn2.getStylesheets().add("keyboard.css");
            btn2.setFocusTraversable(false);
            btn2.setOnAction(eventE -> {
                Node sceneSelector = sceneForCompoundCalculator.getFocusOwner();
                if (sceneSelector instanceof TextInputControl) {
                    enterNumber = btn2.getText();
                    //txtCapital.setText(enterNumber);
                    ((TextInputControl) sceneSelector).replaceSelection(enterNumber);
                }
            });

            rootForCompoundWindow.getChildren().add(btn3);
            btn3.setLayoutY(240);
            btn3.setLayoutX(570);
            btn3.setPrefSize(50, 50);
            btn3.getStylesheets().add("keyboard.css");
            btn3.setFocusTraversable(false);
            btn3.setOnAction(eventE -> {
                Node sceneSelector = sceneForCompoundCalculator.getFocusOwner();
                if (sceneSelector instanceof TextInputControl) {
                    enterNumber = btn3.getText();
                    //txtCapital.setText(enterNumber);
                    ((TextInputControl) sceneSelector).replaceSelection(enterNumber);
                }
            });

            // creating a fifth row //
            rootForCompoundWindow.getChildren().add(btn0);
            btn0.setLayoutY(300);
            btn0.setLayoutX(450);
            btn0.setPrefSize(50, 50);
            btn0.getStylesheets().add("keyboard.css");
            btn0.setFocusTraversable(false);
            btn0.setOnAction(eventE -> {
                Node sceneSelector = sceneForCompoundCalculator.getFocusOwner();
                if (sceneSelector instanceof TextInputControl) {
                    enterNumber = btn0.getText();
                    //txtCapital.setText(enterNumber);
                    ((TextInputControl) sceneSelector).replaceSelection(enterNumber);
                }
            });

            rootForCompoundWindow.getChildren().add(decimalPoint);
            decimalPoint.setLayoutY(300);
            decimalPoint.setLayoutX(510);
            decimalPoint.setPrefSize(50, 50);
            decimalPoint.getStylesheets().add("keyboard.css");
            decimalPoint.setFocusTraversable(false);
            decimalPoint.setOnAction(eventE -> {
                Node sceneSelector = sceneForCompoundCalculator.getFocusOwner();
                if (sceneSelector instanceof TextInputControl) {
                    enterNumber = decimalPoint.getText();
                    String checkDecimal = ((TextInputControl) sceneSelector).getText();
                    if (checkDecimal.indexOf('.') == -1) {
                        ((TextInputControl) sceneSelector).replaceSelection(enterNumber);
                    } else {
                        ((TextInputControl) sceneSelector).replaceSelection("");
                    }

                }
            });

            rootForCompoundWindow.getChildren().add(del);
            del.setLayoutY(300);
            del.setLayoutX(570);
            del.setPrefSize(50, 50);
            del.getStylesheets().add("keyboard.css");
            del.setFocusTraversable(false);
            del.setOnAction(eventE -> {
                Node sceneSelector = sceneForCompoundCalculator.getFocusOwner();
                if (sceneSelector instanceof TextInputControl) {
                    if (((TextInputControl) sceneSelector).getLength() > 0) {
                        ((TextInputControl) sceneSelector).setText(((TextInputControl) sceneSelector).getText(0, ((TextInputControl) sceneSelector).getText().length() - 1));
                    }
                }

            });

            rootForCompoundWindow.getChildren().add(lblFutureValueForCompound);
            lblFutureValueForCompound.setLayoutY(120);
            lblFutureValueForCompound.setLayoutX(50);

            rootForCompoundWindow.getChildren().add(txtFutureValueForCompound);
            txtFutureValueForCompound.setLayoutY(120);
            txtFutureValueForCompound.setLayoutX(190);

            // first row
            rootForCompoundWindow.getChildren().add(lblPresentValueForCompound);
            lblPresentValueForCompound.setLayoutY(180);
            lblPresentValueForCompound.setLayoutX(50);

            rootForCompoundWindow.getChildren().add(txtPresentValueForCompound);
            txtPresentValueForCompound.setLayoutY(180);
            txtPresentValueForCompound.setLayoutX(190);

            //second row
            rootForCompoundWindow.getChildren().add(lblInterestRateForCompound);
            lblInterestRateForCompound.setLayoutY(240);
            lblInterestRateForCompound.setLayoutX(50);

            rootForCompoundWindow.getChildren().add(txtInterestRateForCompound);
            txtInterestRateForCompound.setLayoutY(240);
            txtInterestRateForCompound.setLayoutX(190);

            //third row
            rootForCompoundWindow.getChildren().add(lblTimeInYearsForCompound);
            lblTimeInYearsForCompound.setLayoutY(300);
            lblTimeInYearsForCompound.setLayoutX(50);

            rootForCompoundWindow.getChildren().add(txtTimeInYearsForCompound);
            txtTimeInYearsForCompound.setLayoutY(300);
            txtTimeInYearsForCompound.setLayoutX(190);

            rootForCompoundWindow.getChildren().add(compoundCalButton);
            compoundCalButton.setLayoutY(360);
            compoundCalButton.setLayoutX(190);
            compoundCalButton.getStylesheets().add("stagesButton.css");
            compoundCalButton.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    // add all text fields to an array
                    TextField[] textFieldNames = {txtFutureValueForCompound, txtPresentValueForCompound, txtInterestRateForCompound, txtTimeInYearsForCompound};
                    int countOfEmptyTextField = 0;

                    // loop each and evey item in this array and check weather its empty or not
                    for (TextField textFieldName : textFieldNames) {
                       if (textFieldName.getText().equals("")) {
                            countOfEmptyTextField += 1;
                        }
                    }
                    // if count of empty text field are 0 or above than to zero print error
                    if (countOfEmptyTextField >= 2 || countOfEmptyTextField == 0) {
                        finalOutputTextForCompound.setText("Error! Please Provide Valid Information or Read the Help View.");
                    } else if(txtFutureValueForCompound.getText().equals("")){
                        try {
                            double interestRateValue = Double.parseDouble(txtInterestRateForCompound.getText());
                            double monthlyPaymentValue = Double.parseDouble(txtPresentValueForCompound.getText());
                            double timeInYearsValue = Double.parseDouble(txtTimeInYearsForCompound.getText());
                            //calculations
                            double upperPart = Math.pow((1 + (interestRateValue / 100) / 12), 12 * timeInYearsValue) - 1;
                            double lowerPart = ((interestRateValue / 100) / 12);
                            double futureValue = Math.round(monthlyPaymentValue * (upperPart / lowerPart) * 100.0) / 100.0;
                            finalOutputTextForCompound.setText("Future Value $" + futureValue);
                            txtFutureValueForCompound.setText(String.valueOf(futureValue));
                            //saving data to file
                            FileOutputStream mortgageWriter = null;
                            try {
                                mortgageWriter = new FileOutputStream("saving.txt");
                            } catch (FileNotFoundException e) {
                                e.printStackTrace();
                            }

                            assert mortgageWriter != null;
                            BufferedWriter mortgageBuffer = new BufferedWriter(new OutputStreamWriter(mortgageWriter));

                            for (TextField textFieldName : textFieldNames) {
                                try {
                                    mortgageBuffer.write(textFieldName.getText());
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }
                                try {
                                    mortgageBuffer.newLine();
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }
                            }

                            try {
                                mortgageBuffer.close();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }catch (NumberFormatException e){
                            finalOutputTextForCompound.setText("Please enter valid number.");
                        }
                    } else if (txtPresentValueForCompound.getText().equals("")){
                        try {
                            double interestRateValue = Double.parseDouble(txtInterestRateForCompound.getText());
                            double futureValue = Double.parseDouble(txtFutureValueForCompound.getText());
                            double timeInYearsValue = Double.parseDouble(txtTimeInYearsForCompound.getText());
                            //calculation
                            double upperPart = Math.pow((1 + (interestRateValue / 100) / 12), 12 * timeInYearsValue) - 1;
                            double lowerPart = ((interestRateValue / 100) / 12);
                            double mainLowerPart = upperPart / lowerPart;
                            double pmtValue = Math.round(futureValue / mainLowerPart * 100.0) / 100.0;
                            finalOutputTextForCompound.setText("Monthly Payment $" + pmtValue);
                            txtPresentValueForCompound.setText(String.valueOf(pmtValue));
                            //saving data to file
                            FileOutputStream mortgageWriter = null;
                            try {
                                mortgageWriter = new FileOutputStream("saving.txt");
                            } catch (FileNotFoundException e) {
                                e.printStackTrace();
                            }

                            assert mortgageWriter != null;
                            BufferedWriter mortgageBuffer = new BufferedWriter(new OutputStreamWriter(mortgageWriter));

                            for (TextField textFieldName : textFieldNames) {
                                try {
                                    mortgageBuffer.write(textFieldName.getText());
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }
                                try {
                                    mortgageBuffer.newLine();
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }
                            }

                            try {
                                mortgageBuffer.close();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }catch (NumberFormatException e){
                            finalOutputTextForCompound.setText("Please enter valid number.");
                        }
                    } else if (txtTimeInYearsForCompound.getText().equals("")){
                        finalOutputTextForCompound.setText("Error! Please fill time period.");
                    }else if (txtInterestRateForCompound.getText().equals("")){
                        finalOutputTextForCompound.setText("Error! Please fill Interest Rate.");
                    }



                    }
            });

            rootForCompoundWindow.getChildren().add(finalOutputTextForCompound);
            finalOutputTextForCompound.setLayoutY(420);
            finalOutputTextForCompound.setLayoutX(130);
            finalOutputTextForCompound.setFont(Font.font("Calibre", FontWeight.BOLD, 13));


            compoundStage.setScene(sceneForCompoundCalculator);
            compoundStage.setResizable(false);
            compoundStage.show();

        });

        rootForMainWindow.getChildren().add(helpButton);
        helpButton.setLayoutY(480);
        helpButton.setLayoutX(310);
        helpButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Stage helpStage = new Stage();

                //adding image
                Image img = new Image("file:helpView.png");
                ImageView iVhelp = new ImageView();
                iVhelp.setImage(img);

                String helpInformation = "1. Mortgage Calculator\n" +
                        "In the mortgage calculator, we need to fill up all the necessary information to get the\n" +
                        "correct output. after providing all necessary inputs, then click the calculate button to\n" +
                        "see the Monthly Payment.\n\n" +
                        "2. Finance Calculator\n" +
                        "The finance calculator is a saving calculator to determine the future value, present value,\n " +
                        "annual interest and years. if you need to find out each of these, keep it empty and click \n" +
                        "calculate button.\n\n" +
                        "3. Auto Loan Calculator\n" +
                        "Auto loan calculator also same like mortgage, the only difference, we can find out monthly\n" +
                        "loan payment instead of the mortgage payment. You need to fill all the information and \n click " +
                        "the calculate button\n\n" +
                        "4. Compound Saving Calculator\n" +
                        "in saving calculator you can get information like monthly payment and future value. all\n other" +
                        "information needs to be fill. if you want to get future value, leave it empty and click\n" +
                        "calculate button. ";


                Label lblForHelpView = new Label(helpInformation);
                Button exButton = new Button("EXIT");

                Pane rootHelp = new Pane();

                rootHelp.getChildren().add(iVhelp);
                rootHelp.getChildren().add(lblForHelpView);
                lblForHelpView.setLayoutY(110);
                lblForHelpView.setLayoutX(30);

                rootHelp.getChildren().add(exButton);
                exButton.setLayoutY(420);
                exButton.setLayoutX(220);
                exButton.getStylesheets().add("MainPage.css");
                exButton.setOnAction(eventEX -> {
                    Stage mainWindow = (Stage) exButton.getScene().getWindow();
                    mainWindow.close();
                });

                lblForHelpView.setStyle("-fx-font-family: 'Open Sans'; -fx-text-fill: white; -fx-font-size: 11px;");

                helpStage.setScene(new Scene(rootHelp,490,490));
                helpStage.setResizable(false);
                helpStage.show();
            }
        });

        rootForMainWindow.getChildren().add(exitButton);
        exitButton.setLayoutY(480);
        exitButton.setLayoutX(420);
        exitButton.setOnAction(event -> {
            Stage mainWindow = (Stage) exitButton.getScene().getWindow();
            mainWindow.close();
        });

        primaryStage.setScene(new Scene(rootForMainWindow, 790, 590));
        primaryStage.setResizable(false);
        primaryStage.show();

    }


    public static void main(String[] args) {
        launch(args);
    }


}

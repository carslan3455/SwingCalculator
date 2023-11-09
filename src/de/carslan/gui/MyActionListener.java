package de.carslan.gui;

import de.carslan.settings.AppTexts;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyActionListener implements ActionListener {

    //region Konstanten

    //endregion

    //region Attribute
    private SwingGuiCalculator gui;
    int ersteZahl = 0;
    int zweiteZahl = 0;
    int ergebnis = 0;
    //endregion

    //region Konstruktoren

    public MyActionListener(SwingGuiCalculator gui) {
        this.gui = gui;
    }

    //endregion

    //region Methoden
    @Override
    public void actionPerformed(ActionEvent actionEvent) {

        switch (actionEvent.getActionCommand()) {
            case AppTexts.OPERAND_ADD -> add();
            case AppTexts.OPERAND_SUBTRACT -> subtract();
            case AppTexts.OPERAND_MULTIPLY -> multiply();
            case AppTexts.OPERAND_DIVIDE -> divide();
//            case AppTexts.OPERAND_RECHNEN -> rechnen(ergebnis);
//            case AppTexts.OPERAND_CLOSE -> closeApplication();
            default -> System.out.println("\n!!! Ungültige Rechenart  !!!");

        }
    }

    private void add() {
        if (isBlank()) return;

        ersteZahl = Integer.parseInt(gui.getErsteZahl().getText());
        zweiteZahl = Integer.parseInt(gui.getZweiteZahl().getText());


        ergebnis = ersteZahl + zweiteZahl;
        gui.getLblOutput().setText(String.valueOf(ergebnis));


    }

    private boolean isBlank() {
        if (gui.getErsteZahl().getText().isBlank()) {
            gui.getLblOutput().setText(AppTexts.TXT_EMPTY_INPUT);
            return true;
        }else if (gui.getZweiteZahl().getText().isBlank()) {
            gui.getLblOutput().setText(AppTexts.TXT_EMPTY_INPUT);
            return true;
        }
        return false;
    }

    private void subtract() {
        if (isBlank()) return;
        ersteZahl = Integer.parseInt(gui.getErsteZahl().getText());
        zweiteZahl = Integer.parseInt(gui.getZweiteZahl().getText());


        ergebnis = ersteZahl - zweiteZahl;
        gui.getLblOutput().setText(String.valueOf(ergebnis));
    }

    private void multiply() {
        if (isBlank()) return;
        ersteZahl = Integer.parseInt(gui.getErsteZahl().getText());
        zweiteZahl = Integer.parseInt(gui.getZweiteZahl().getText());

        ergebnis = ersteZahl * zweiteZahl;
        gui.getLblOutput().setText(String.valueOf(ergebnis));

    }

    private void divide() {
        if (isBlank()) return;
        ersteZahl = Integer.parseInt(gui.getErsteZahl().getText());
        zweiteZahl = Integer.parseInt(gui.getZweiteZahl().getText());

        ergebnis = ersteZahl / zweiteZahl;
        gui.getLblOutput().setText(String.valueOf(ergebnis));
    }

    private void rechnen(int ergebnisInteger) {
        if (isBlank()) return;
        gui.getLblOutput().setText(String.valueOf(ergebnisInteger));
        setEmptyText();
    }
    private void setEmptyText() {
        gui.getErsteZahl().setText("");
        gui.getZweiteZahl().setText("");
    }

    private void closeApplication() {
        System.exit(0);
    }

    //endregion
}

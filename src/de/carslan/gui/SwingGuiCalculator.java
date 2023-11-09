package de.carslan.gui;

import de.carslan.settings.AppTexts;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.awt.*;

public class SwingGuiCalculator {
    //region Konstanten
    //endregion

    //region Attribute
    private static SwingGuiCalculator instance;

    private JFrame mainFrame;
    private JTextField ersteZahl;
    private JTextField zweiteZahl;
    private JButton btnAdd;
    private JButton btnSubtract;
    private JButton btnMultiple;
    private JButton btnDivide;
    private JButton btnRechnen;
    private JLabel lblErsteZahl;
    private JLabel lblZweiteZahl;
    private JLabel lblOutput;
    private JButton btnClose;
    //endregion

    //region Konstruktoren

    private SwingGuiCalculator() {
    }

    //endregion

    //region Methoden

    public static synchronized SwingGuiCalculator getInstance() {
        if (instance == null) instance = new SwingGuiCalculator();
        return instance;
    }

    public void start(){

        initializeGuiElements();
        showGuiElements();


    }

    private void initializeGuiElements() {
        mainFrame = new JFrame(AppTexts.TXT_APP_NAME);
        mainFrame.setSize(400, 400);
        mainFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        mainFrame.setLocation(300, 100);
        mainFrame.setLayout(null);

        Dimension textElementSize = new Dimension(75,50);
        Dimension elementSize = new Dimension(50,50);

        lblErsteZahl = new JLabel(AppTexts.TXT_ERSTE_ZAHL);
        lblErsteZahl.setSize(elementSize);
        lblErsteZahl.setLocation(50, 30);
        lblErsteZahl.setBorder(new BevelBorder(BevelBorder.LOWERED));

        lblZweiteZahl = new JLabel(AppTexts.TXT_ZWEITE_ZAHL);
        lblZweiteZahl.setSize(elementSize);
        lblZweiteZahl.setLocation(50, 90);
        lblZweiteZahl.setBorder(new BevelBorder(BevelBorder.LOWERED));

        ersteZahl = new JTextField();
        ersteZahl.setSize(textElementSize);
        ersteZahl.setLocation(150,30);

        zweiteZahl = new JTextField();
        zweiteZahl.setSize(textElementSize);
        zweiteZahl.setLocation(150,90);

        btnAdd = new JButton(AppTexts.OPERAND_ADD);
        btnAdd.setSize(elementSize);
        btnAdd.setLocation(50,200);

        btnSubtract = new JButton(AppTexts.OPERAND_SUBTRACT);
        btnSubtract.setSize(elementSize);
        btnSubtract.setLocation(100,200);

        btnMultiple = new JButton(AppTexts.OPERAND_MULTIPLY);
        btnMultiple.setSize(elementSize);
        btnMultiple.setLocation(150,200);

        btnDivide = new JButton(AppTexts.OPERAND_DIVIDE);
        btnDivide.setSize(elementSize);
        btnDivide.setLocation(200,200);


        btnRechnen = new JButton(AppTexts.OPERAND_RECHNEN);
        btnRechnen.setSize(textElementSize);
        btnRechnen.setLocation(150,300);

        //Ausgabelabel konfigurieren
        lblOutput = new JLabel(AppTexts.TXT_OUTPUT);
        lblOutput.setSize(100,50);
        lblOutput.setLocation(50, 300);
        lblOutput.setBorder(new BevelBorder(BevelBorder.LOWERED));

        btnClose = new JButton(AppTexts.OPERAND_CLOSE);
        btnClose.setSize(100,100);
        btnClose.setLocation(50,400);

        MyActionListener myActionListener = new MyActionListener(this); // this = instance
        btnAdd.addActionListener(myActionListener);
        btnSubtract.addActionListener(myActionListener);
        btnMultiple.addActionListener(myActionListener);
        btnDivide.addActionListener(myActionListener);
        btnRechnen.addActionListener(myActionListener);
        btnClose.addActionListener(myActionListener);

    }

    private void showGuiElements() {
        mainFrame.add(ersteZahl);
        mainFrame.add(zweiteZahl);
        mainFrame.add(btnAdd);
        mainFrame.add(btnSubtract);
        mainFrame.add(btnMultiple);
        mainFrame.add(btnDivide);
//        mainFrame.add(btnRechnen);
        mainFrame.add(lblErsteZahl);
        mainFrame.add(lblZweiteZahl);
        mainFrame.add(lblOutput);
//        mainFrame.add(btnClose);
        mainFrame.setVisible(true);
    }

    public JTextField getErsteZahl() {
        return ersteZahl;
    }

    public JTextField getZweiteZahl() {
        return zweiteZahl;
    }

    public JLabel getLblOutput() {
        return lblOutput;
    }
    //endregion
}

package ru.proletov.ckdmbd.models.views;

import ru.proletov.ckdmbd.controllers.SimpleGraphicEngine;
import ru.proletov.ckdmbd.models.investigations.AbstractInvestigation;
import ru.proletov.ckdmbd.models.investigations.CaInvestigation;
import ru.proletov.ckdmbd.models.investigations.PTHInvestigation;
import ru.proletov.ckdmbd.models.investigations.PhInvestigation;

import javax.swing.*;
import java.awt.*;

public class SimpleGraphicView extends JFrame {
    private JTextArea result;
    private JPanel windowContent;
    private JPanel workSpaceContent;
    private JLabel caLabel;
    private JComboBox<String> caBox;
    private JTextField caTextField;
    private JLabel phLabel;
    private JComboBox<String> phBox;
    private JTextField phTextField;
    private JLabel pthLabel;
    private JComboBox<String> pthBox;
    private JTextField pthTextField;
    private JButton generate;

    private BorderLayout bl;
    private GridBagLayout gbl;
    private GridBagConstraints constraints;

    public SimpleGraphicView() throws HeadlessException {
        super("CKD-MBD AI Recommendation Maker");

        SimpleGraphicEngine simpleGraphicEngine = new SimpleGraphicEngine(this);
        windowContent = new JPanel();

        bl = new BorderLayout();
        windowContent.setLayout(bl);

        result = new JTextArea(10, 40);
        result.setText("Current Recommendation:");

        windowContent.add(BorderLayout.NORTH, result);

        workSpaceContent = new JPanel();
        gbl = new GridBagLayout();
        constraints = new GridBagConstraints();
        workSpaceContent.setLayout(gbl);
        caLabel = new JLabel("Ca level: ");
        caBox = new JComboBox<>();
        for (AbstractInvestigation.UnitOfMeasurement currentUnit: CaInvestigation.validUnits) {
            caBox.addItem(currentUnit.toString());
        }
        caTextField = new JTextField(5);
        phLabel = new JLabel("Ph level: ");
        phBox = new JComboBox<>();
        for (AbstractInvestigation.UnitOfMeasurement currentUnit: PhInvestigation.validUnits) {
            phBox.addItem(currentUnit.toString());
        }
        phTextField = new JTextField(5);
        pthLabel = new JLabel("PTH level: ");
        pthBox = new JComboBox<>();
        for (AbstractInvestigation.UnitOfMeasurement currentUnit: PTHInvestigation.validUnits) {
            pthBox.addItem(currentUnit.toString());
        }
        pthTextField = new JTextField(5);
        generate = new JButton("Generate");
        generate.addActionListener(simpleGraphicEngine);

        addComponent(workSpaceContent, caLabel, 0, 0, 2, 1);
        addComponent(workSpaceContent, caTextField, 0, 2, 2, 1);
        addComponent(workSpaceContent, caBox, 0, 4, 2, 1);
        addComponent(workSpaceContent, phLabel, 1, 0, 2, 1);
        addComponent(workSpaceContent, phTextField, 1, 2, 2, 1);
        addComponent(workSpaceContent, phBox, 1, 4, 2, 1);
        addComponent(workSpaceContent, pthLabel, 2, 0, 2, 1);
        addComponent(workSpaceContent, pthTextField, 2, 2, 2, 1);
        addComponent(workSpaceContent, pthBox, 2, 4, 2, 1);
        addComponent(workSpaceContent, generate, 3, 2, 2, 1);

        windowContent.add(BorderLayout.CENTER, workSpaceContent);

        setContentPane(windowContent);
        setSize(320, 400);
        setLocationByPlatform(true);
        setVisible(true);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public JComboBox<String> getCaBox() {
        return caBox;
    }

    public String getCaTextField() {
        return caTextField.getText();
    }

    public JComboBox<String> getPhBox() {
        return phBox;
    }

    public String getPhTextField() {
        return phTextField.getText();
    }

    public JComboBox<String> getPthBox() {
        return pthBox;
    }

    public String getPthTextField() {
        return pthTextField.getText();
    }


    public void setResult(final String recommendation) {
        result.setText("Current Recommendation:" + recommendation);
    }

    private void addComponent(Container container, Component component
            , int row, int column, int width, int height) {
        //   	constraints.fill = GridBagConstraints.BOTH;
        constraints.anchor = GridBagConstraints.CENTER;
        constraints.weightx = 1.0;
        constraints.weighty = 1.0;
        constraints.gridx = column;
        constraints.gridy = row;
        constraints.gridheight = height;
        constraints.gridwidth = width;
        gbl.setConstraints(component, constraints);
        container.add(component);
    }

}

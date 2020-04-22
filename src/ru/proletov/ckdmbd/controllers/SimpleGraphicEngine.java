package ru.proletov.ckdmbd.controllers;

import ru.proletov.ckdmbd.models.PatientState;
import ru.proletov.ckdmbd.models.Recommendation;
import ru.proletov.ckdmbd.models.exceptions.InvalidUnitOfMeasureException;
import ru.proletov.ckdmbd.models.investigations.CaInvestigation;
import ru.proletov.ckdmbd.models.investigations.PTHInvestigation;
import ru.proletov.ckdmbd.models.investigations.PhInvestigation;
import ru.proletov.ckdmbd.models.views.SimpleGraphicView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SimpleGraphicEngine implements ActionListener {
    private SimpleGraphicView parent;
    private double caLevel;
    private double phLevel;
    private double pthLevel;
    Recommendation currentRecommendation;
    PatientState patientState;

    public SimpleGraphicEngine(final SimpleGraphicView parent) {
        this.parent = parent;
    }

    @Override
    public void actionPerformed(ActionEvent event) {

        String caImage = parent.getCaTextField().replace(",", ".");
        String phImage = parent.getPhTextField().replace(",", ".");
        String pthImage = parent.getPthTextField().replace(",", ".");
        try {
            caLevel = Double.parseDouble(caImage);
            phLevel = Double.parseDouble(phImage);
            pthLevel = Double.parseDouble(pthImage);
        } catch(NumberFormatException e) {
            JOptionPane.showConfirmDialog(null,
                    e.getLocalizedMessage(),
                    "Invalid format",
                    JOptionPane.PLAIN_MESSAGE);
        }

        RecommendationMaker recommendationMaker = new RecommendationMaker();
        try {
            this.patientState = new PatientState(new CaInvestigation(caLevel),
                    new PhInvestigation(phLevel),
                    new PTHInvestigation(pthLevel));
        } catch (InvalidUnitOfMeasureException e) {
            JOptionPane.showConfirmDialog(null,
                    e.getLocalizedMessage(),
                    "Invalid format",
                    JOptionPane.PLAIN_MESSAGE);
        }
        try {
            currentRecommendation = recommendationMaker.makeRecommendation(patientState);
        } catch (InvalidUnitOfMeasureException e) {
            JOptionPane.showConfirmDialog(null,
                    e.getLocalizedMessage(),
                    "Invalid format",
                    JOptionPane.PLAIN_MESSAGE);
        }

        parent.setResult(currentRecommendation.toString());

    }
}

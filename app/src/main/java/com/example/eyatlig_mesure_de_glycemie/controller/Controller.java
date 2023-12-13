package com.example.eyatlig_mesure_de_glycemie.controller;

import com.example.eyatlig_mesure_de_glycemie.model.Patient;

public final class Controller {
    private static Patient patient;
    private static Controller instance = null;

    private Controller() {
        super();
    }

    public void createPatient(int age, float value, boolean isFasting) {
        patient = new Patient(age, value, isFasting);
    }

    public static final Controller getInstance() {
        if (Controller.instance == null)
            Controller.instance = new Controller();
        return Controller.instance;
    }

    public String getResult() {
        return patient.getresult();
    }
}

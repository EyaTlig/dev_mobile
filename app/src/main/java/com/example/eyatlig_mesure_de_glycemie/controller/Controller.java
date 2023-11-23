package com.example.eyatlig_mesure_de_glycemie.controller;

import com.example.eyatlig_mesure_de_glycemie.model.Patient;

public final class Controller {
    private static Patient patient;
    //userAction view-->controller (1/2)
    private static Controller instance=null ;

    private Controller() {
           super()  ;
    }

    public void createPatient(int age, float valeur, boolean isfasting){
        //update controller -->model (2/2)
    patient= new Patient(age, valeur, isfasting);
}
public static final Controller getInstance(){
        if (Controller.instance==null)
            Controller.instance=new Controller();
        return Controller.instance;
}
// notify controller --> view (2/2)
public String getResult(){
    // notify model --> controller (2/2)
    return patient.getresult();
}

}
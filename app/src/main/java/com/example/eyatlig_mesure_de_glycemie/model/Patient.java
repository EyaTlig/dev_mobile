package com.example.eyatlig_mesure_de_glycemie.model;


public class Patient {
    int age;
    float value;
    boolean isfasting;
    private  String result;
    //notify model --> controler
    public String getresult()
    {

        return result;
    }
    //update controller --> view (1/2)
    public Patient(int age, float value, boolean isfasting){
        this.age=age;
        this.value=value;
        this.isfasting=isfasting;
        calculer();
    }
    private void calculer(){
        if(isfasting ){
                if(age>=10){
                    if(value<5.0)
                        result=("Le niveau de glycemie est tres bas ");
                    else if (value >=5.0 && value <=7.2)
                        result=("Le niveau de glycemie est normal ");
                    else result=("Le niveau de glycemie est elevé");
                    if(age >=6 && age <=12)
                        if(value<5.0) result=("Le niveau de glycemie est tres bas ");
                        else if (value>=5.0 && value<=10.5) result=("Le niveau de glycemie est normal ");
                        else result=("Le niveau de glycemie est elevé");
                    else if (value <5.5)  result=("Le niveau de glycemie est bas");
                    else if (value>=5.0 && value <=10.0) result=("Le niveau de glycemie est normal");
                    else result=("Le niveau de glycemie est elevé");
                }
            } else if (value<10.5) result=("Le niveau de glycemie est normal");
            else  result=("Le niveau de glycemie est élevé");

        }

    }


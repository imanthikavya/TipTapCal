package com.example.cal;

public class Cal {
    float tip;
    float bill;
    int person;



    public Cal(float newTip,float newBill, int newPerson) {
        setTip(newTip);
        setBill(newBill);
        setPerson(newPerson);
    }
    public float getTip() {
        return tip;
    }
    public float getBill() {
        return bill;
    }

    public int getPerson() {
        return person;
    }

    public void setBill(float newBill) {
        if (newBill>0)
            bill=newBill;
    }


    public void setTip(float newTip) {
        if (newTip>0)
            tip=newTip;
    }

    public void setPerson(int newPerson) {
        if(newPerson>0)
            person=newPerson;
    }

    public float tipAmount(){
        return bill*tip;
    }
    public float totalAmount(){
        return bill + tipAmount();
    }
    public float totalPerson(){
        return  ((bill + tipAmount()) / person);
    }

}

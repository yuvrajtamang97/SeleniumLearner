package AdvanceJava;

public class EncapsulationExample {

    public static void main(String[] args) {

        Vehical vehical = new Vehical();

        vehical.setCompany("Honda");
        vehical.setModel("XYZ");
        vehical.setRegistration("jhgjg67678t5");

        vehical.getCompany();

    }


}

class Vehical{

    final int id = 4755; //if we give the 'Final', then we can not change the value
                         //or we cannot use the setter for that.
    private String company;// and if private, then we can set the value by using the
                           // setter method.
    private String model;
    private String registration;

    public int getId() {
        return id;
    }

    public String getCompany() { //get help us to get the private variable
        return company;
    }

    public void setCompany(String company) {//set is for setting the value for the private variables
        this.company = company;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getRegistration() {
        return registration;
    }

    public void setRegistration(String registration) {
        this.registration = registration;
    }
}
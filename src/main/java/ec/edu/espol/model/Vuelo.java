package ec.edu.espol.model;


public class Vuelo {

    private Aeropuerto source;
    private Aeropuerto target;
    private double weight;


    
    public Vuelo(Aeropuerto source, Aeropuerto target, double weight) {
        this.source = source;
        this.target = target;
        this.weight = weight;
    }
    public Aeropuerto getSource() {
        return source;
    }
    public Aeropuerto getTarget() {
        return target;
    }
    public double getWeight() {
        return weight;
    }

    public void setSource(Aeropuerto source) {
        this.source = source;
    }
    public void setTarget(Aeropuerto target) {
        this.target = target;
    }
    public void setWeight(double weight) {
        this.weight = weight;
    }


    public String toString(){

        return "Vuelo("+source+ " → "+target+","+ weight+")";
        
    }

    

}

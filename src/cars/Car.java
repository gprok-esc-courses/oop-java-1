package cars;

public class Car {
    private String plateNo;
    private double km;
    private boolean rented;

    // Constructor overloading
    public Car() {
        this("N/A", 0);
    }

    // Constructor
    public Car(String plateNo, double km) {
        setPlateNo(plateNo);
        setKm(km);
        setRented(false);
    }

    public String getPlateNo() {
        return plateNo;
    }

    public void setPlateNo(String plateNo) {
        this.plateNo = plateNo;
    }

    public double getKm() {
        return km;
    }

    public void setKm(double km) {
        if(km > 0 && km > this.km) {
            this.km = km;
        }
    }

    public boolean isRented() {
        return rented;
    }

    public void setRented(boolean rented) {
        this.rented = rented;
    }

    @Override
    public String toString() {
        return "plateNo='" + plateNo + '\'' +
                ", km=" + km;
    }
}

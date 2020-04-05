import java.util.Scanner;

public class CellPhone {

    private Scanner keyboard = new Scanner(System.in);
    private long serialNum;
    private String brand; // always single word
    private int year;
    private double price;


    CellPhone(long serialNum, String brand, int year, double price) {
        this.serialNum = serialNum;
        this.brand = brand;
        this.year = year;
        this.price = price;
    }

    CellPhone(long value, CellPhone object) {
        this.price = object.price;
        this.year = object.year;
        this.brand = object.brand;
        this.serialNum = value;
    }

    public long getSerialNum() {
        return serialNum;
    }

    public String getBrand() {
        return brand;
    }

    public int getYear() {
        return year;
    }

    public double getPrice() {
        return price;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    //?? CLONE METHOD/////////////
    public CellPhone clone() throws CloneNotSupportedException {
        System.out.println("Please enter a serial number:");
        long serial = keyboard.nextLong();
        return new CellPhone(serial, this);

    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || this.getClass() != o.getClass()) {
            return false;
        }
        CellPhone cell = (CellPhone) o;
        return (cell.brand.equals(this.brand) && cell.price == this.price && cell.year == this.year);

    }

    public String toString() {
        return serialNum + ": " + brand + " " + price + " " + year;
    }


}

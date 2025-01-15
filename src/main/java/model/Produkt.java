package model;

public class Produkt implements Comparable {

    String name;
    int price;
    String herkunftsregion;

    public Produkt(String name, int price, String herkunftsregion) {
        this.name = name;
        this.price = price;
        this.herkunftsregion = herkunftsregion;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getHerkunftsregion() {
        return herkunftsregion;
    }

    public void setHerkunftsregion(String herkunftsregion) {
        this.herkunftsregion = herkunftsregion;
    }

    @Override
    public String toString() {
        return "Produkt{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", herkunftsregion='" + herkunftsregion + '\'' +
                '}';
    }

    @Override
    public int compareTo(Object o) {
        return this.getPrice() - ((Produkt) o).getPrice();
    }
}

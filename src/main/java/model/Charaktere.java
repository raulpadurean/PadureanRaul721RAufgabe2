package model;

import java.util.List;

public class Charaktere {
    int id;
    String name;
    String herkunftsort;
    List<Produkt> listeProdukte;

    public Charaktere(int id, String name, String herkunftsort, List<Produkt> listeProdukte) {
        this.id = id;
        this.name = name;
        this.herkunftsort = herkunftsort;
        this.listeProdukte = listeProdukte;
    }

    public Charaktere() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHerkunftsort() {
        return herkunftsort;
    }

    public void setHerkunftsort(String herkunftsort) {
        this.herkunftsort = herkunftsort;
    }

    public List<Produkt> getListeProdukte() {
        return listeProdukte;
    }

    public void setListeProdukte(List<Produkt> listeProdukte) {
        this.listeProdukte = listeProdukte;
    }

    @Override
    public String toString() {
        return "Charaktere{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", herkunftsort='" + herkunftsort + '\'' +
                ", listeProdukte=" + listeProdukte +
                '}';
    }

    public boolean richtigeHerkunftsort(String herkunftsort){
        for (Produkt p : this.listeProdukte) {
            if (p.getHerkunftsregion().equals(herkunftsort)) {
                return true;
            }
        }
        return false;
    }
}

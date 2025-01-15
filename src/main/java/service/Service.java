package service;

import model.Produkt;
import model.Charaktere;
import repository.Repository;


import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class Service {

    private Repository<Produkt> produktRepository;
    private Repository<Charaktere> charaktereRepository;

    public Service(Repository<Charaktere> kundeRepository, Repository<Produkt> produktRepository) {
        this.charaktereRepository = kundeRepository;
        this.produktRepository = produktRepository;
    }

    public List<Charaktere> alleCharaktereZuruckgeben() {
        return charaktereRepository.getAllElements();
    }

    public List<Produkt> alleProdukteZuruckgeben() {
        return produktRepository.getAllElements();
    }

    public void createAProdukt(String name,int preis, String jahreszeit){
        produktRepository.addElement(new Produkt(name,preis,jahreszeit));
    }

    public Produkt getProdukt(String name){
        int id = -1;
        for (Produkt p : produktRepository.getAllElements()) {
            if (p.getName().equals(name))
            {id = produktRepository.getAllElements().indexOf(p); break;}
        }
        return produktRepository.getElement(id);
    }

    public void updateProdukt(Produkt produkt){
        for (Produkt p : produktRepository.getAllElements()){
            if (p.getName().equals(produkt.getName())){
                int index = produktRepository.getAllElements().indexOf(p);
                p.setPrice(produkt.getPrice());
                p.setHerkunftsregion(produkt.getHerkunftsregion());
                produktRepository.updateElement(index,produkt);
                break;
            }
        }
    }

    public void deleteProdukt(String name){
        for (Produkt p : produktRepository.getAllElements()){
            if (p.getName().equals(name)){
                produktRepository.remove(p);
                break;
            }
        }
    }

    public void createACharaktere(String name, String ort){
        int id = -1;
        for (Charaktere k : charaktereRepository.getAllElements()){
            if (id < k.getId())
                id = k.getId();
        }
        id += 1;

        charaktereRepository.addElement(new Charaktere(id,name,ort,new ArrayList<>()));
    }

    public Charaktere getCharaktere(int id){
        for (Charaktere p : charaktereRepository.getAllElements()) {
            if (p.getId() == id)
                return p;
        }
        throw new RuntimeException("Charaktere nicht gefunden");
    }

    public void updateCharaktere(Charaktere charaktere){
        for (Charaktere p : charaktereRepository.getAllElements()){
            if (p.getId() == charaktere.getId()){
                int index = charaktereRepository.getAllElements().indexOf(p);
                p.setName(charaktere.getName());
                p.setHerkunftsort(charaktere.getHerkunftsort());
                charaktereRepository.updateElement(index,p);
                break;
            }
        }
    }

    public void deleteCharaktere(int id){
        for (Charaktere p : charaktereRepository.getAllElements()){
            if (p.getId() == id){
                charaktereRepository.remove(p);
                break;
            }
        }
    }


    public List<Charaktere> filterNachOrt(String ort){
        List<Charaktere> charaktereList = new ArrayList<>();
        charaktereList = charaktereRepository.getAllElements().stream().filter(charaktere -> ort.equals(charaktere.getHerkunftsort())).toList();

        return charaktereList;
    }

    public List<Charaktere> filterNachProduktHerkunftsort(String herkunftsort){
        List<Charaktere> charaktereList = new ArrayList<>();

        return charaktereRepository.getAllElements().stream().filter(charaktere -> charaktere.richtigeHerkunftsort(herkunftsort)).toList();
    }

    public List<Produkt> nachPreissortierteProdukteEinesCharakteren(int id,String sortierModus){
        Charaktere charaktere = new Charaktere();
        for (Charaktere p : charaktereRepository.getAllElements()){
            if (p.getId() == id){
                charaktere = p;
                break;
            }
        }

        List<Produkt> produktList = charaktere.getListeProdukte();

        produktList.sort(Produkt::compareTo);

        if (sortierModus.equals("aufsteigend "))
            return produktList;
        else
        {
            return produktList;

        }
    }
}


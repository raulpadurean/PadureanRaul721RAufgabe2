package controller;

import model.Charaktere;
import model.Produkt;
import service.Service;

import java.util.ArrayList;
import java.util.Scanner;

public class Controller {
    private final Service service;

    public Controller(Service service) {
        this.service = service;
    }

    public void alleProdukteAnschreiben(){
        for (Produkt produkt: service.alleProdukteZuruckgeben())
            System.out.println(produkt);
    }
    public void alleCharaktereAnschreiben(){
        for (Charaktere charaktere: service.alleCharaktereZuruckgeben())
            System.out.println(charaktere);
    }

    public void createProdukt(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Name: ");
        String name = sc.nextLine();
        System.out.println("Preis: ");
        int preis = sc.nextInt();
        sc.nextLine();
        System.out.println("Jahreszeit");
        String jahr = sc.nextLine();

        service.createAProdukt(name, preis, jahr);
    }

    public void showAProdukt(){
        System.out.println("Gebe den Namen des Produktes ein: ");
        Scanner sc = new Scanner(System.in);
        String name = sc.nextLine();
        Produkt produkt = service.getProdukt(name);
        System.out.println(produkt);
    }

    public void updateProduktValidate(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Name des Produktes, das geandert werden soll: ");
        String name = sc.nextLine();
        System.out.println("Preis: ");
        int preis = sc.nextInt();
        sc.nextLine();
        System.out.println("Jahreszeit:");
        String jahreszeit = sc.nextLine();

        service.updateProdukt(new Produkt(name, preis, jahreszeit));
    }

    public void deleteProdukt(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Name des Produktes, das geloescht werden soll: ");
        String name = sc.nextLine();
        service.deleteProdukt(name);
    }


    public void createCharaktere(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Name: ");
        String name = sc.nextLine();
        System.out.println("Ort: ");
        String ort = sc.nextLine();

        service.createACharaktere(name,ort);
    }

    public void showCharaktere(){
        for (Charaktere charaktere: service.alleCharaktereZuruckgeben())
            System.out.println(charaktere);

        System.out.println("ID des Charakteres:");
        Scanner sc = new Scanner(System.in);
        int id = sc.nextInt();
        sc.nextLine();
        System.out.println(service.getCharaktere(id));
    }

    public void updateCharaktereValidate(){
        Scanner sc = new Scanner(System.in);

        System.out.println("ID des Charakteres, das geandert werden soll: ");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.println("Neuer Name: ");
        String name = sc.nextLine();
        System.out.println("Neuer Ort: ");
        String ort = sc.nextLine();

        Charaktere charaktere = new Charaktere(id,name,ort,new ArrayList<>());
        service.updateCharaktere(charaktere);
    }

    public void deleteCharaktere(){
        Scanner sc = new Scanner(System.in);
        System.out.println("ID des Charakteren, der geloescht werden soll: ");
        int id = sc.nextInt();
        sc.nextLine();
        service.deleteCharaktere(id);
    }

    public void charakterenNachOrtFiltrieren(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Ort: ");
        String ort = sc.nextLine();
        for (Charaktere charaktere: service.filterNachOrt(ort))
            System.out.println(charaktere);
    }

    public void charakterenNachProduktjahreszeitFiltrieren(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Jahreszeit: ");
        String herkunftsort = sc.nextLine();

        for (Charaktere charaktere: service.filterNachProduktHerkunftsort(herkunftsort))
            System.out.println(charaktere);
    }

    public void produkteEinesCharakterenNachPreisSortieren(){
        Scanner sc = new Scanner(System.in);
        System.out.println("ID des Charakteren: ");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.println("Steigend/Fallend sortieren:");
        String modus = sc.nextLine();

        for (Produkt produkt: service.nachPreissortierteProdukteEinesCharakteren(id, modus))
            System.out.println(produkt);
    }
}


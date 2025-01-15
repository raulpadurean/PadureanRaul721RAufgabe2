package org.example;

import model.Charaktere;
import model.Produkt;
import controller.Controller;
import repository.Repository;
import service.Service;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Console {

    private Controller controller;

    public Console(Controller controller) {
        this.controller = controller;
    }
    public Console() {}

    public void setController(Controller controller) {this.controller = controller;}

    public void run() {
        Scanner sc = new Scanner(System.in);
        int option = -1;
        while (option != 0)
        {
            System.out.println("""
                    1. Alles anschreiben
                    2. Produkt CRUD
                    3. Charaktere CRUD
                    0. Exit""");

            option = sc.nextInt();
            sc.nextLine();

            switch (option) {
                case 1: {controller.alleCharaktereAnschreiben();
                    controller.alleProdukteAnschreiben();
                    break;}

                case 2: {
                    System.out.println("""
                            1. Neues Produkt hinzufugen
                            2. Alle Produkte sehen
                            3. Ein bestimmtes Produkt finden
                            4. Ein Produkt aktualisieren
                            5. Ein Produkt loschen
                            0. Exit""");
                    int crudOption = sc.nextInt();
                    sc.nextLine();
                    switch (crudOption) {
                        case 1: {controller.createProdukt(); break;}
                        case 2: {controller.alleProdukteAnschreiben(); break;}
                        case 3: {controller.showAProdukt(); break;}
                        case 4: {controller.updateProduktValidate(); break;}
                        case 5: {controller.deleteProdukt(); break;}
                        case 0:break;
                    }
                }

                case 3:
                {
                    System.out.println("""
                            1. Neuer Charaktere hinzufugen
                            2. Alle Charakteren sehen
                            3. Einen bestimmten Charakteren finden
                            4. Einen Charakteren aktualisieren
                            5. Einen Charakteren loschen
                            6. Charakteren nach Ort filtrieren
                            7. Charakteren finden, die ein Produkt in einer gegebenen Jahreszeit gekauft haben
                            8. Sortiere Produkte eines Charakteren nach Preis
                            0. Exit""");
                    int crudOption = sc.nextInt();
                    sc.nextLine();
                    switch (crudOption) {
                        case 1: {controller.createCharaktere(); break;}
                        case 2: {controller.alleCharaktereAnschreiben(); break;}
                        case 3: {controller.showCharaktere(); break;}
                        case 4: {controller.updateCharaktereValidate(); break;}
                        case 5: {controller.deleteCharaktere(); break;}
                        case 6: {controller.charakterenNachOrtFiltrieren(); break;}
                        case 7: {controller.charakterenNachProduktjahreszeitFiltrieren(); break;}
                        //case 8: {controller.produkteEinesCharakterenNachPreisSortieren(); break;}
                        case 0:break;
                    }
                }

                case 0: break;
            }
        }

    }

    public static void main(String[] args) {

        Repository<Produkt> produktRepository = new Repository<>();
        Repository<Charaktere> charaktereRepository = new Repository<>();

        Console console = new Console();
        console.initialiseData(charaktereRepository,produktRepository);

        Service service = new Service(charaktereRepository, produktRepository);
        Controller controller = new Controller(service);

        console = new Console(controller);
        console.run();
    }

    public void initialiseData(Repository<Charaktere> charaktereRepository, Repository<Produkt> produktRepository) {
        Produkt produkt1 = new Produkt("50kg Dumbbell",400,"Cluj");
        Produkt produkt2 = new Produkt("25kg Dumbbell",200,"Buzau");
        Produkt produkt3 = new Produkt("10kg Dumbbell",100,"Bucuresti");


        produktRepository.addElement(produkt1);
        produktRepository.addElement(produkt2);
        produktRepository.addElement(produkt3);


        List<Produkt> listeCharaktere1 = new ArrayList<>();
        listeCharaktere1.add(produkt1); listeCharaktere1.add(produkt3); listeCharaktere1.add(produkt1);
        Charaktere charaktere1 = new Charaktere(1,"Kevin","Lituanien",listeCharaktere1);

        List<Produkt> listeCharaktere2 = new ArrayList<>();
        listeCharaktere2.add(produkt2); listeCharaktere2.add(produkt2);
        Charaktere charaktere2 = new Charaktere(2,"Maria","Polen",listeCharaktere2);

        List<Produkt> listeCharaktere3 = new ArrayList<>();
        listeCharaktere3.add(produkt3); listeCharaktere3.add(produkt3);
        Charaktere charaktere3 = new Charaktere(3,"Markus","Amerika",listeCharaktere3);



        charaktereRepository.addElement(charaktere1);
        charaktereRepository.addElement(charaktere2);
        charaktereRepository.addElement(charaktere3);

    }
}

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import  java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class Main {
    public static void main(String[]args){
    ArrayList<String> monstruos = new ArrayList<String>();
    ArrayList<String> trampas = new ArrayList<String>();
    ArrayList<String> hechizos = new ArrayList<String>();
    ArrayList<String> monstruosDuelista = new ArrayList<String>();
    ArrayList<String> trampasDuelista = new ArrayList<String>();
    ArrayList<String> hechizosDuelista = new ArrayList<String>();

    BufferedReader in = null;
    try {
        in = new BufferedReader(new FileReader("C:\\Users\\Estuardo\\IdeaProjects\\H6Mapas\\src\\cards_desc.txt"));
    } catch (FileNotFoundException ex) {
        Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
    }
    String line = "";

    try {
        while ((line = in.readLine()) != null) {
            int i = line.indexOf('|');
            String carta = line.substring(0,i);
            String tipo = line.substring(i+1,line.length());
            if(tipo.contentEquals("Monstruo")){
                monstruos.add(carta);
            }
            if(tipo.contentEquals("Hechizo")){
                hechizos.add(carta);
            }
            if(tipo.contentEquals("Trampa")){
                trampas.add(carta);
            }

        }
    } catch (IOException ex) {
        Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
    }


    Scanner entrada = new Scanner(System.in);
    String implementacionSelecionada = "";  // Tipo de set que se desea utilizar

    System.out.println("Bienvenido:\n");
    System.out.println("Ingrese la implementacion MAP a utilizar (utilice las abreviaturas):");
    System.out.println("1) HashMap (HM) \n2) TreeMap (TM) \n3) LinkedHashMap (LHM)");
    if (entrada.hasNext()){
        implementacionSelecionada = entrada.nextLine();
    }

    // Crear conjuntos de developers
    Map<String,ArrayList> maletin =  Fabrica.getMap(implementacionSelecionada);  // Maletin con todas las cartas
    Map<String,ArrayList> deck =  Fabrica.getMap(implementacionSelecionada);  // Deck del usuario
    //Map<String,ArrayList> maletin = new HashMap<String,ArrayList>();
    //Map<String,ArrayList> deck = new HashMap<String,ArrayList>();

    maletin.put("Monstruo", monstruos);
    maletin.put("Hechizo", hechizos);
    maletin.put("Trampa", trampas);

    deck.put("Monstruo", monstruosDuelista);
    deck.put("Hechizo", hechizosDuelista);
    deck.put("Trampa", trampasDuelista);
    int select = -1;
    while(select != 0){
        //Try catch para evitar que el programa termine si hay un error
        try{
            System.out.println("1) Agregar carta al Deck  \n2) Saber el tipo de carta \n3) Ver que hay en tu deck \n4) Ver que hay en tu deck por tipo \n5) Mostrar todas las cartas \n6) Mostrar todas las cartas ordenadas por tipo \n0) Salir ");

            //Recoger una variable por consola
            select = Integer.parseInt(entrada.nextLine());

            //Ejemplo de switch case en Java
            switch(select){
                case 1:
                    System.out.println("Escriba el nombre de la carta que desea agregar: ");
                    String carta = entrada.nextLine();
                    Iterator<String> itr = monstruos.iterator();

                    if(monstruos.indexOf(carta) != -1){
                        monstruosDuelista.add(carta);
                        break;
                    }
                    if(hechizos.indexOf(carta) != -1){
                        hechizosDuelista.add(carta);
                        break;
                    }
                    if(trampas.indexOf(carta) != -1){
                        trampasDuelista.add(carta);
                        break;
                    }
                    System.out.println("Esa carta no esta en el maletin. Prueba de nuevo.");

                    break;
                case 2:
                    System.out.println("Escriba el nombre de la carta que desea conocer su tipo: ");
                    carta = entrada.next();
                    if(maletin.containsValue(carta)){
                        if(monstruos.contains(carta)){
                            System.out.println("Tipo: Monstruo");
                        }
                        if(hechizos.contains(carta)){
                            System.out.println("Tipo: Hechizo");
                        }
                        if(trampas.contains(carta)){
                            System.out.println("Tipo: Trampa");
                        }
                    }
                    else{
                        System.out.println("Esa carta no se encuentra en el maletin. Escribe bien el nombre.");
                    }
                    break;
                case 3:
                    System.out.println(deck.values());
                    break;
                case 4:
                    System.out.println("Monstruo");
                    System.out.println(monstruosDuelista);
                    System.out.println("Hechizo");
                    System.out.println(hechizosDuelista);
                    System.out.println("Trampa");
                    System.out.println(trampasDuelista);
                    break;

                case 5:
                    System.out.println(maletin.values());
                    break;

                case 6:
                    System.out.println("Monstruo");
                    System.out.println(monstruos);
                    System.out.println("Hechizo");
                    System.out.println(hechizos);
                    System.out.println("Trampa");
                    System.out.println(trampas);
                    break;
                case 0:
                    System.out.println("Adios!");
                    break;
            }

            System.out.println("\n"); //Mostrar un salto de línea en Java

        }catch(Exception e){
            System.out.println("Uoop! Error!");
        }



    }
}

}

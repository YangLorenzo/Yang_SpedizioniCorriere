import java.io.*;
import java.util.*;

public class Corriere {
    private static final String CLIENTI_PATH = ".\\Yang_SpedizioniCorriere\\clienti.bin";
    private static final String SPEDIZIONI_PATH = ".\\Yang_SpedizioniCorriere\\spedizioni.bin";

    // key: cliente     value: la lista di tutte le spedizioni che ha fatto
    private Map<Cliente, List<Spedizione>> clienti;
    // key: spedizione  value: il mittente e il destinatario
    private Map<Spedizione, Cliente[]> spedizioni;

    public Corriere() {
        this.clienti = new TreeMap<>();
        this.spedizioni = new HashMap<>();
    }

    public void nuovoCliente() {
        try {
            Cliente c = Input.creaCliente();
            if (clienti.containsKey(c))
                throw new IllegalArgumentException("\nil cliente gia' esiste\n");
            clienti.put(c, new LinkedList<>());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    public void nuovaSpedizione() {
        try {
            Spedizione s = Input.creaSpedizione();

            Cliente mittente = getCliente(Input.getCodiceFiscale("mittente"));
            Cliente destinatario = getCliente(Input.getCodiceFiscale("destinatario"));

            if (mittente == null)
                throw new IllegalArgumentException("mittente inserito non e' il nostro cliente\n");
            if (destinatario == null)
                throw new IllegalArgumentException("destinatario inserito non e' il nostro cliente\n");

            // aggiungo le informazioni della spedizione
            spedizioni.put(s, new Cliente[]{mittente, destinatario});
            // aggiungo la spedizione che ha fatto il cliente
            clienti.get(mittente).add(s);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    private Cliente getCliente(String codiceFiscale) {
        for (Cliente c : clienti.keySet()) {
            if (c.getCodiceFiscale().equals(codiceFiscale))
                return c;
        }
        return null;
    }

    public void stampa_tutteSpedizioni() {
        if (!spedizioni.isEmpty()) {
            for (Spedizione s : spedizioni.keySet()) {
                System.out.println("------------------------------");
                System.out.println(s);
                System.out.println("mittente:");
                System.out.println(spedizioni.get(s)[0]);
                System.out.println("destinatario:");
                System.out.println(spedizioni.get(s)[1]);
                System.out.println("------------------------------");
            }
        } else System.out.println("\nnessuna spedizione\n");
    }

    public void stampa_tuttiClienti() {
        if (!clienti.isEmpty()) {
            System.out.println("\nla lista dei clienti:");
            for (Cliente c : clienti.keySet())
                System.out.println("\n" + c);
            System.out.println();
        } else System.out.println("\nnessun cliente\n");
    }

    public void stampa_spedizioniDiCliente() {
        Cliente c = getCliente(Input.getCodiceFiscale("mittente"));
        if (!(clienti.get(c)).isEmpty()) {
            System.out.println("\nspedizioni che ha fatto:\n");
            for (Spedizione s : clienti.get(c))
                System.out.println(s);
            System.out.println();
        } else System.out.println("\nnon ha fatto nessuna spedizione\n");
    }

    public void carica() {
        try {

            File f_clienti = new File(CLIENTI_PATH);
            File f_spedizioni = new File(SPEDIZIONI_PATH);
            if (!f_clienti.exists() || !f_spedizioni.exists())
                return;

            // caricamento dati clienti
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(CLIENTI_PATH));
            this.clienti = (TreeMap<Cliente, List<Spedizione>>) ois.readObject();

            // caricamento dati spedizioni
            ois = new ObjectInputStream(new FileInputStream(SPEDIZIONI_PATH));
            this.spedizioni = (HashMap<Spedizione, Cliente[]>) ois.readObject();

            ois.close();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("\nErrore nella lettura da file\n");
        }
    }

    public void salva() {
        try {
            // salvataggio dei clienti
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(CLIENTI_PATH));
            oos.writeObject(this.clienti);

            // salvataggio delle spedizioni
            oos = new ObjectOutputStream(new FileOutputStream(SPEDIZIONI_PATH));
            oos.writeObject(this.spedizioni);

            oos.close();

            System.out.println("\ndati salvati\n");
        } catch (IOException e) {
            System.out.println("\nErrore nella scrittura del file\n");
        }
    }

}

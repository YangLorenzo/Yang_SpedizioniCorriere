import java.util.*;

public class Corriere {
    private static final String CLIENTI_PATH = ".\\clienti.bin";
    private static final String SPEDIZIONI_PATH = ".\\spedizioni.bin";

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
                throw new IllegalArgumentException("il cliente gia' esiste");
            clienti.put(c, new LinkedList<>());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    public void nuovaSpedizione() {
        try {
            Spedizione s = Input.creaSpedizione();
            if (spedizioni.containsKey(s)) throw new IllegalArgumentException("la spedizione gia' esiste'");

            Cliente mittente = getCliente(Input.getCodiceFiscale("mittente"));
            Cliente destinatario = getCliente(Input.getCodiceFiscale("destinatario"));

            if (mittente == null)
                throw new IllegalArgumentException("mittente inserito non e' il nostro cliente");
            if (destinatario == null)
                throw new IllegalArgumentException("destinatario inserito non e' il nostro cliente");

            spedizioni.put(s, new Cliente[]{mittente, destinatario});
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
        } else System.out.println("nessuna spedizione");
    }

//    public void stampa_spedizioneClient(String codice_cliente) {
//        Cliente c = getCliente(codice_cliente);
//        System.out.println(c + ":");
//        for (Spedizione s : clienti.get(c)) {
//            System.out.println(s);
//        }
//    }
}

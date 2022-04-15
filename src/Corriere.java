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

    public void nuovoCliente(Cliente c) {
        if (!clienti.containsKey(c)) {
            clienti.put(c, new LinkedList<>());
        }
    }

    public void nuovaSpedizione(Spedizione s, String codice_mittente, String codice_destinatario) {
        if (!spedizioni.containsKey(s)) {
            Cliente mittente = getCliente(codice_mittente);
            Cliente destinatario = getCliente(codice_destinatario);
            if (mittente != null && destinatario != null)
                spedizioni.put(s, new Cliente[]{mittente, destinatario});
        }
    }

    private Cliente getCliente(String codiceFiscale) {
        for (Cliente c : clienti.keySet()) {
            if (c.getCodiceFiscale().equals(codiceFiscale))
                return c;
        }
        return null;
    }

    public void stampa_spedizioni() {
        for (Spedizione s : spedizioni.keySet()) {
            System.out.println(s);
            System.out.println("mittente: " + spedizioni.get(s)[0]);
            System.out.println("destinatario: " + spedizioni.get(s)[1]);
            System.out.println("----------------------------------------");
        }
    }

    public void stampa_spedizion_cliente(String codice_cliente) {
        Cliente c = getCliente(codice_cliente);
        System.out.println(c + ":");
        for (Spedizione s : clienti.get(c)) {
            System.out.println(s);
        }
    }
}

import java.time.LocalDate;
import java.util.Scanner;

import static java.lang.System.out;

public class GestioneInput {
    private static final Scanner in = new Scanner(System.in);

    public static Cliente creaCliente() {
        out.print("codice fiscale: ");
        String codiceFiscale = in.next();
        out.print("denominazione: ");
        in.nextLine();
        String nome = in.nextLine();
        out.print("indirizzo: ");
        String indirizzo = in.nextLine();
        out.print("citta': ");
        String citta = in.next();
        out.print("telefono: ");
        String telefono = in.next();
        return new Cliente(codiceFiscale, nome, indirizzo, citta, telefono);
    }

    public static Spedizione creaSpedizione() {
        out.println("la descrizione della della spedizione: ");
        in.nextLine();
        String descrizione = in.nextLine();
        out.print("giorno: ");
        int giorno = in.nextInt();
        out.print("mese: ");
        int mese = in.nextInt();
        out.print("anno: ");
        int anno = in.nextInt();
        return new Spedizione(descrizione, LocalDate.of(anno, mese, giorno));
    }

}

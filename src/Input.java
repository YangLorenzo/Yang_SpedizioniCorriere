import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.Scanner;

import static java.lang.System.out;

public class Input {
    private static final Scanner in = new Scanner(System.in);

    public static int getOpzione() {
        int op;
        while (true) {
            try {
                out.print("cosa vuoi fare? ");
                op = in.nextInt();
                if ((op < 1 || op > 6) && op != 0) throw new IllegalArgumentException();
                return op;
            } catch (IllegalArgumentException e) {
                out.println("numero invalido");
            }
        }
    }

    public static Cliente creaCliente() {
        out.print("codice fiscale: ");
        String codiceFiscale = in.next();
        out.print("denominazione: ");
        in.nextLine();
        String denominazione = in.nextLine();
        out.print("indirizzo: ");
        String indirizzo = in.nextLine();
        out.print("citta': ");
        String citta = in.next();

        String telefono;
        while (true) {
            try {
                out.print("telefono: ");
                telefono = in.next();
                if (!telefono.matches("[0-9]+"))
                    throw new IllegalArgumentException("numero di telefono invalido");
                break;
            } catch (IllegalArgumentException e) {
                out.println(e.getMessage());
            }
        }
        return new Cliente(codiceFiscale, denominazione, indirizzo, citta, telefono);
    }

    public static Spedizione creaSpedizione(int codice) {
        out.println("la descrizione della della spedizione: ");
        in.nextLine();
        String descrizione = in.nextLine();

        while (true) {
            try {
                out.print("giorno: ");
                int giorno = in.nextInt();
                out.print("mese: ");
                int mese = in.nextInt();
                out.print("anno: ");
                int anno = in.nextInt();
                LocalDate date = LocalDate.of(anno, mese, giorno);

                return new Spedizione(codice, descrizione, date);
            } catch (DateTimeException e) {
                out.println(e.getMessage());
            }
        }
    }

    public static String getCodiceFiscale(String msg) {
        out.println("il codice fiscale del " + msg + ": ");
        return in.next();
    }

    public static int getCodiceSpedizione() {
        out.print("il codice di spedizione: ");
        return in.nextInt();
    }
}

import java.util.Scanner;

import static java.lang.System.out;

public class Main {
    private static final Scanner in = new Scanner(System.in);

    private static void menu() {
        System.out.println("1) memorizza un nuovo cliente");
        System.out.println("2) memorizza una nuova spedizione");
        System.out.println("3) visualizza tutte le spedizioni");
        System.out.println("4) salva i dati");
        System.out.println("0) Esc");
    }

    private static int getOpzione() {
        int op;
        while (true) {
            try {
                out.print("cosa vuoi fare? ");
                op = in.nextInt();
                if ((op < 1 || op > 4) && op != 0) throw new IllegalArgumentException();
                return op;
            } catch (IllegalArgumentException e) {
                out.println("numero invalido");
            }
        }
    }

    public static void main(String[] args) {
        Corriere corriere = new Corriere();
        int op = -1;
        while (op != 0) {
            menu();
            op = getOpzione();
            switch (op) {
                case 1: {
                    Cliente c = GestioneInput.creaCliente();
                    corriere.nuovoCliente(c);
                    out.println("aggiunto con successo");
                    break;
                }
                case 2: {
                    Spedizione s = GestioneInput.creaSpedizione();

                    out.println("il codice fiscale del mittente: ");
                    in.nextLine();
                    String cod_mittente = in.nextLine();
                    out.println("il codice fiscale del destinatario: ");
                    String cod_destinatario = in.nextLine();

                    corriere.nuovaSpedizione(s, cod_mittente, cod_destinatario);

                    out.println("aggiunta con successo");
                    break;
                }
                case 3:
                    corriere.stampa_spedizioni();
                    break;
                case 4:
                    break;

                default:
                    break;
            }
        }

    }
}

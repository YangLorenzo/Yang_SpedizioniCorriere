public class Main {
    public static void menu() {
        System.out.println("1) memorizza un nuovo cliente");
        System.out.println("2) memorizza una nuova spedizione");
        System.out.println("3) visualizza tutti i clienti");
        System.out.println("4) visualizza tutte le spedizioni");
        System.out.println("5) spedizioni di un cliente");
        System.out.println("6) salva dati");
        System.out.println("0) Esc");
    }

    public static void main(String[] args) {
        Corriere corriere = new Corriere();
        corriere.carica();

        int op = -1;
        while (op != 0) {
            menu();
            op = Input.getOpzione();
            switch (op) {
                case 1:
                    corriere.nuovoCliente();
                    break;
                case 2:
                    corriere.nuovaSpedizione();
                    break;
                case 3:
                    corriere.stampa_tuttiClienti();
                    break;
                case 4:
                    corriere.stampa_tutteSpedizioni();
                    break;
                case 5:
                    corriere.stampa_spedizioniDiCliente();
                    break;
                case 6:
                    corriere.salva();
                    break;
                default:
                    break;
            }
        }

    }
}

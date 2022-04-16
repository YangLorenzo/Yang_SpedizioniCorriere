import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public class Spedizione {
    private static int _codice = 0;

    private final int codice;
    private String descrizione;
    private LocalDate dataConsegna;

    public Spedizione(String descrizione, LocalDate dataConsegna) {
        this.codice = _codice++;
        this.descrizione = descrizione;
        this.dataConsegna = dataConsegna;
    }

    public int getCodice() {
        return codice;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public LocalDate getDataConsegna() {
        return dataConsegna;
    }

    public void setDataConsegna(LocalDate dataConsegna) {
        this.dataConsegna = dataConsegna;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Spedizione that = (Spedizione) o;
        return codice == that.codice;
    }

    @Override
    public int hashCode() {
        return Objects.hash(codice);
    }

    @Override
    public String toString() {
        return "spedizione cod." + codice + ": " + descrizione + "\n"
                + formattedDate(dataConsegna);
    }

    private String formattedDate(LocalDate d) {
        return d.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
    }
}

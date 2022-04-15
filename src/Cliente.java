import java.util.Objects;

public class Cliente implements Comparable<Cliente> {
    private String codiceFiscale;
    private String denominazione;
    private String indirizzo;
    private String citta;
    private String telefono;

    public Cliente(String codiceFiscale, String denominazione, String indirizzo, String citta, String telefono) {
        this.codiceFiscale = codiceFiscale;
        this.denominazione = denominazione;
        this.indirizzo = indirizzo;
        this.citta = citta;
        this.telefono = telefono;
    }

    public String getCodiceFiscale() {
        return codiceFiscale;
    }

    public void setCodiceFiscale(String codiceFiscale) {
        this.codiceFiscale = codiceFiscale;
    }

    public String getDenominazione() {
        return denominazione;
    }

    public void setDenominazione(String denominazione) {
        this.denominazione = denominazione;
    }

    public String getIndirizzo() {
        return indirizzo;
    }

    public void setIndirizzo(String indirizzo) {
        this.indirizzo = indirizzo;
    }

    public String getCitta() {
        return citta;
    }

    public void setCitta(String citta) {
        this.citta = citta;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cliente cliente = (Cliente) o;
        return codiceFiscale.equals(cliente.codiceFiscale);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codiceFiscale);
    }

    @Override
    public String toString() {
        return codiceFiscale + " " + denominazione + " " + indirizzo + " " + citta + " " + telefono;
    }

    @Override
    public int compareTo(Cliente c) {
        return this.denominazione.compareTo(c.denominazione);
    }
}

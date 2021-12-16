package ba.unsa.etf.rpr.biblioteka;

import javafx.beans.Observable;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class BibliotekaModel {
    private ObservableList<Knjiga> knjige = FXCollections.observableArrayList();
    private SimpleObjectProperty<Knjiga> trenutnaKnjiga = new SimpleObjectProperty<>();

    public ObservableList<Knjiga> getKnjige() {
        return knjige;
    }

    public void setKnjige(ObservableList<Knjiga> knjige) {
        this.knjige = knjige;
    }

    public Knjiga getTrenutnaKnjiga() {
        return trenutnaKnjiga.get();
    }

    public SimpleObjectProperty<Knjiga> trenutnaKnjigaProperty() {
        return trenutnaKnjiga;
    }

    public void setTrenutnaKnjiga(Knjiga trenutnaKnjiga) {
        this.trenutnaKnjiga.set(trenutnaKnjiga);
    }

    public void dodajKnjige() {
        knjige.add(new Knjiga("Ivo Andrić", "Most na Žepi", "12345"));
        knjige.add(new Knjiga("Meša Selimović", "Tvrđava", "111"));
        knjige.add(new Knjiga("Lav Tolstoj", "Rat i mir", "123"));
        trenutnaKnjiga.set(null);
    }
}

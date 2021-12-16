package ba.unsa.etf.rpr.biblioteka;

import javafx.beans.property.SimpleStringProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;

public class BibliotekaController {
    public TextField fldAutor;
    public TextField fldNaslov;
    public TextField fldISBN;
    public ChoiceBox<Knjiga> izborKnjige; // zbog izbKnjige.geValue()

    // private BibliotekaModel bibliotekaModel = new BibliotekaModel(); // nije dobra praksa, nego je bolje prepraviti main tj Biblioteku da se kontroler zadaje naknadno

    //VAŽNO: prvo napraviti program sa privatnim atributom kao što je iznad odmah pa kad se uvjerimo da radi onda razbiti poziv kontrolera na dva dijela, kod ispod:
    //TIME SE GUBI AUTOMATIZAM IZMEDJU KLASE CONTROLER I FXML!

    private BibliotekaModel bibliotekaModel;

    public BibliotekaController(BibliotekaModel bibliotekaModel) {
        this.bibliotekaModel = bibliotekaModel;
    }

    // dvostruko povezivanje samo iz java coda se moze uraditi!
    @FXML
    public void initialize() {
        izborKnjige.setItems(bibliotekaModel.getKnjige());
        // fldAutor.textProperty().bindBidirectional(bibliotekaModel.getTrenutnaKnjiga().autorProperty()); // ne radi ovaj način - MORA LISTENER
        bibliotekaModel.trenutnaKnjigaProperty().addListener(
                (obs, staraKnjiga, novaKnjiga) -> {
                    if(staraKnjiga != null) {
                        fldAutor.textProperty().unbindBidirectional(staraKnjiga.autorProperty());
                        fldNaslov.textProperty().unbindBidirectional(staraKnjiga.naslovProperty());
                        fldISBN.textProperty().unbindBidirectional(staraKnjiga.isbnProperty());
                    }
                    if(novaKnjiga == null) {
                        fldAutor.setText("");
                        fldNaslov.setText("");
                        fldISBN.setText("");
                    }
                    else {
                        fldAutor.textProperty().bindBidirectional(novaKnjiga.autorProperty());
                        fldNaslov.textProperty().bindBidirectional(novaKnjiga.naslovProperty());
                        fldISBN.textProperty().bindBidirectional(novaKnjiga.isbnProperty());
                    }
                }
        );
    }

    public void promjenaKnjige(ActionEvent actionEvent) {
        bibliotekaModel.setTrenutnaKnjiga(izborKnjige.getValue());
    }

    // jednosmjerno povezivanje (vrijednost propertya povezana sa kontrolom)
    public void ispisiKnjigu(ActionEvent actionEvent) {
        for(Knjiga k : bibliotekaModel.getKnjige()) {
            System.out.println(k);
        }
    }

}

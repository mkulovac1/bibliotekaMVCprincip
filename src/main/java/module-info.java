module ba.unsa.etf.rpr.biblioteka {
    requires javafx.controls;
    requires javafx.fxml;


    opens ba.unsa.etf.rpr.biblioteka to javafx.fxml;
    exports ba.unsa.etf.rpr.biblioteka;
}
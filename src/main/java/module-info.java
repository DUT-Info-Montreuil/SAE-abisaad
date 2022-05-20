
module fr.sae.aquilius {
    requires javafx.controls;
    requires javafx.fxml;
    requires com.google.gson;
    requires javafx.graphics;


    opens fr.sae.aquilius to javafx.fxml;
    exports fr.sae.aquilius;
    exports fr.sae.aquilius.controleur;
    opens fr.sae.aquilius.controleur to javafx.fxml;
    exports fr.sae.aquilius.model;
    opens fr.sae.aquilius.model to javafx.fxml;
}

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
    exports fr.sae.aquilius.model.Items;
    opens fr.sae.aquilius.model.Items to javafx.fxml;
    exports fr.sae.aquilius.model.Items.Nourriture;
    opens fr.sae.aquilius.model.Items.Nourriture to javafx.fxml;
    exports fr.sae.aquilius.model.Items.Armes;
    opens fr.sae.aquilius.model.Items.Armes to javafx.fxml;
    exports fr.sae.aquilius.model.Items.Outils;
    opens fr.sae.aquilius.model.Items.Outils to javafx.fxml;
}
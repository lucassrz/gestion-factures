module fr.lsarazin.gestionfacture {
    requires javafx.controls;
    requires javafx.fxml;


    opens fr.lsarazin.gestionfacture to javafx.fxml;
    exports fr.lsarazin.gestionfacture;
}
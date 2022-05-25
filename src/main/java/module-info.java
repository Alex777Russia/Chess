module com.example.chess {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.media;

    opens com.example.chess to javafx.fxml;
    exports com.example.chess;
    exports com.example.chess.Controllers;
    opens com.example.chess.Controllers to javafx.fxml;
}
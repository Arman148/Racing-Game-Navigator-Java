package gui.project1;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import Logic.Game;
import javafx.scene.control.TextArea;
import players.InvalidBenefitException;


public class CreatePlayerController {

    @FXML
    public TextArea consoleTextArea;

    private Game game;

    public CreatePlayerController() {
        game = new Game("Hello", consoleTextArea);
    }

    @FXML
    private Label welcomeText;

    @FXML
    void onHelloWorld(ActionEvent event) {
        game.helloWorld();
    }

    @FXML
    void onCreatePlayer(ActionEvent event) {
        game.createPlayer();
    }

    @FXML
    void onCreateOpponent(ActionEvent event) {
       game.createOpponent();
    }



    public void onPlay(ActionEvent actionEvent) {
        game.play();
    }

    public void onAction(ActionEvent actionEvent) throws InvalidBenefitException {
        game.next();
    }

    @FXML
    public void onRestart(ActionEvent actionEvent) {
        game.resetGame();
    }

    @FXML
    public void onCreateTrack(ActionEvent actionEvent) {
        // TODO
    }

    @FXML
    public void onStart(ActionEvent actionEvent) {
        game.start();
    }

    public void onChooseOne(ActionEvent actionEvent) {
        game.chooseOne();
    }

    public void onChoosetwo(ActionEvent actionEvent) {
        game.chooseTwo();

    }

    public void onChooseThree(ActionEvent actionEvent) {
        game.chooseThree();

    }


}

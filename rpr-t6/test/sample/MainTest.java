package sample;

import static org.junit.jupiter.api.Assertions.*;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.testfx.api.FxRobot;
import org.testfx.framework.junit5.ApplicationExtension;
import org.testfx.framework.junit5.Start;

@ExtendWith(ApplicationExtension.class)

class MainTest {

    @Start
    public void start (Stage stage) throws Exception {
        Parent mainNode = FXMLLoader.load(Main.class.getResource("sample.fxml"));
        stage.setScene(new Scene(mainNode));
        stage.show();
        stage.toFront();
    }
    @Test
    public void start (FxRobot robot) {
        TextField ime= robot.lookup("#ime").queryAs(TextField.class);
        assertEquals("", ime.getText());
    }
    @Test
    public void imeTest(FxRobot robot) {
        TextField ime = robot.lookup("#ime").queryAs(TextField.class);
        robot.clickOn("#ime").write("Amila");
        assertEquals("Amila", ime.getText());
    }
    @Test
    public void prezimeTest(FxRobot robot) {
        TextField prezime = robot.lookup("#prezime").queryAs(TextField.class);
        robot.clickOn("#prezime").write("Lakovic");
        assertEquals("Lakovic", prezime.getText());
    }
    @Test
    public void indexTest(FxRobot robot) {
        TextField index = robot.lookup("#index").queryAs(TextField.class);
        robot.clickOn("#index").write("18117");
        assertEquals("18117", index.getText());
    }
    @Test
    public void JMBGTest(FxRobot robot) {
        TextField jmbg = robot.lookup("#jmbg").queryAs(TextField.class);
        robot.clickOn("#jmbg").write("1806998175111");
        assertEquals("1806998175111", jmbg.getText());
    }
    @Test
    public void datumTest(FxRobot robot) {
        TextField datum = robot.lookup("#datum").queryAs(TextField.class);
        robot.clickOn("#datum").write("18.06.1998");
        assertEquals("18.06.1998", datum.getText());
    }
    @Test
    public void datum2Test(FxRobot robot) {
        TextField datum = robot.lookup("#datum").queryAs(TextField.class);
        robot.clickOn("#datum").write("18/06/1998");
        assertEquals("18/06/1998", datum.getText());
    }
    @Test
    public void mjestoTest(FxRobot robot) {
        ComboBox mjesto = robot.lookup("#mjesto").queryAs(ComboBox.class);
        robot.clickOn("#mjesto").write("Sarajevo");
        assertEquals("Sarajevo", mjesto.getEditor().getText());
    }
    @Test
    public void godinaTest(FxRobot robot) {
        ComboBox godina = robot.lookup("#godina").queryAs(ComboBox.class);
        robot.clickOn("#godina").clickOn("II");
        assertEquals("II", godina.getValue());
    }
    @Test
    public void smjerTest(FxRobot robot) {
        ComboBox godina = robot.lookup("#smjer").queryAs(ComboBox.class);
        robot.clickOn("#smjer").clickOn("RI");
        assertEquals("RI", godina.getValue());
    }
    @Test
    public void statusTest(FxRobot robot) {
        ComboBox godina = robot.lookup("#status").queryAs(ComboBox.class);
        robot.clickOn("#status").clickOn("redovan");
        assertEquals("redovan", godina.getValue());
    }
    @Test
    public void jmbgValidanTest(FxRobot robot) {
        TextField jmbg = robot.lookup("#jmbg").queryAs(TextField.class);
        robot.clickOn("#jmbg").write("1806998175111");
        assertEquals(true, jmbg.getStyleClass().contains("popunjeno"));
    }
    @Test
    public void emailValidan(FxRobot robot) {
        TextField email = robot.lookup("#email").queryAs(TextField.class);
        robot.clickOn("#email").write("alakovic1.com");
        assertEquals(true, email.getStyleClass().contains("nijepopunjeno"));
    }
    @Test
    public void borackaPripadnostTest(FxRobot robot) {
        CheckBox pripadnost = robot.lookup("#pripadnost").queryAs(CheckBox.class);
        robot.clickOn("#pripadnost");
        assertEquals(true, pripadnost.isSelected());
    }
    @Test
    public void sveObaveznoTest(FxRobot robot) {
        TextField ime = robot.lookup("#ime").queryAs(TextField.class);
        robot.clickOn("#ime").write("Amila");
        assertEquals("Amila", ime.getText());
        TextField prezime = robot.lookup("#prezime").queryAs(TextField.class);
        robot.clickOn("#prezime").write("Lakovic");
        assertEquals("Lakovic", prezime.getText());
        TextField index = robot.lookup("#index").queryAs(TextField.class);
        robot.clickOn("#index").write("18117");
        assertEquals("18117", index.getText());
        TextField email = robot.lookup("#email").queryAs(TextField.class);
        robot.clickOn("#email").write("alakovic1@etf.unsa.ba");
        assertEquals("alakovic1@etf.unsa.ba", email.getText());
        TextField jmbg = robot.lookup("#jmbg").queryAs(TextField.class);
        robot.clickOn("#jmbg").write("1806998175111");
        assertEquals("1806998175111", jmbg.getText());
        TextField datum = robot.lookup("#datum").queryAs(TextField.class);
        robot.clickOn("#datum").write("18.06.1998");
        assertEquals("18.06.1998", datum.getText());
    }

}
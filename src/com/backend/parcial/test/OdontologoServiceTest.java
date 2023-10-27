package src.com.backend.parcial.test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import src.com.backend.parcial.dao.impl.OdontologoDaoH2;
import src.com.backend.parcial.model.Odontologo;
import src.com.backend.parcial.service.OdontologoService;

import java.sql.Connection;
import java.sql.DriverManager;

import static org.junit.jupiter.api.Assertions.assertFalse;

public class OdontologoServiceTest {
    private OdontologoService odontologoService = new OdontologoService(new OdontologoDaoH2());

    @BeforeAll
    static void doBefore() {
        Connection connection = null;
        try {
            Class.forName("org.h2.Driver");
            connection = DriverManager.getConnection("jdbc:h2:~/parcial1;INIT=RUNSCRIPT FROM 'test.sql'", "sa", "sa");

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }

    @Test

    void deberianAgregarUnOdontologo(){

        Odontologo odontologo =new Odontologo(964521, "Walter", "Aldana");

        Odontologo odontologoRegistrado = odontologoService.registrarOdontologo(odontologo);

        Assertions.assertTrue(odontologoRegistrado.getId() != 0);

    }


    @Test

    void deberiaListarTodosLosOdontologos(){

        assertFalse(odontologoService.listarOdontologos().isEmpty());

    }

}

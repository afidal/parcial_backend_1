import dao.impl.OdontologoDaoH2;
import model.Odontologo;
import org.apache.log4j.Logger;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import service.OdontologoService;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.List;

@RunWith(JUnit4.class)

public class OdontologoServiceTest {

    private static OdontologoService odontologoService = new OdontologoService(new OdontologoDaoH2());

    @BeforeClass
    public static void cargarOdontologos(){

        Odontologo odontologo1 = odontologoService.guardar(new Odontologo(223344, "Martin", "Gutierrez"));
        Odontologo odontologo2 = odontologoService.guardar(new Odontologo(556677, "Roxana", "Romano"));
        Odontologo odontologo3 = odontologoService.guardar(new Odontologo(889911, "Lucas", "Paso"));
        Odontologo odontologo4 = odontologoService.guardar(new Odontologo(334466, "Maria", "Soler"));
        Odontologo odontologo5 = odontologoService.guardar(new Odontologo(889911, "Marcela", "Brance"));

    }

    @Test
    public void listarTodos() {
        List<Odontologo> odontologos = odontologoService.listarTodos();
        Assert.assertFalse(odontologos.isEmpty());
        Assert.assertTrue(odontologos.size() > 0);
        System.out.println("\n**************************************************************\nLista Completa de Odontólogos Registrados en la Base de Datos\n**************************************************************\n");
        for (Odontologo o : odontologos) {
            System.out.println(o);
        }
    }

}

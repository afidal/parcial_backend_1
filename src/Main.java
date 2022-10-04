import dao.impl.OdontologoDaoH2;
import model.Odontologo;
import service.OdontologoService;

import java.util.List;

public class Main {

    private static OdontologoService odontologoService = new OdontologoService(new OdontologoDaoH2());

    public static void main(String[] args) {

        /*Odontologo odontologo1 = odontologoService.guardar(new Odontologo(223344, "Martin", "Gutierrez"));
        Odontologo odontologo2 = odontologoService.guardar(new Odontologo(556677, "Roxana", "Romano"));
        Odontologo odontologo3 = odontologoService.guardar(new Odontologo(889911, "Lucas", "Paso"));
        Odontologo odontologo4 = odontologoService.guardar(new Odontologo(334466, "Maria", "Soler"));
        Odontologo odontologo5 = odontologoService.guardar(new Odontologo(889911, "Marcela", "Brance"));
        List<Odontologo> odontologos = odontologoService.listarTodos();
        System.out.println("\n**************\nLista Completa de Odontólogos Registrados\n**************\n");
        for (Odontologo o : odontologos) {
            System.out.println(o);
        }*/

    }


}

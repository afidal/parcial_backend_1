package dao.impl;

import dao.IDao;
import model.Odontologo;
import org.apache.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OdontologoDaoH2 implements IDao<Odontologo> {

    private final static String DB_JDBC_DRIVER = "org.h2.Driver";
    private final static String DB_URL = "jdbc:h2:~/test;INIT=RUNSCRIPT FROM 'createTable.sql'";
    private final static String DB_USER = "sa";
    private final static String DB_PASSWORD = "" ;

    // Logger
    private static final Logger logger = Logger.getLogger(OdontologoDaoH2.class);

    @Override
    public Odontologo guardar(Odontologo odontologo) {

        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {

            Class.forName(DB_JDBC_DRIVER);
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);

            try {

                preparedStatement = connection.prepareStatement("INSERT INTO odontologos(matricula, nombre,apellido) VALUES(?,?,?)", Statement.RETURN_GENERATED_KEYS);
                preparedStatement.setInt(1,odontologo.getMatricula());
                preparedStatement.setString(2, odontologo.getNombre());
                preparedStatement.setString(3, odontologo.getApellido());
                preparedStatement.executeUpdate();
                ResultSet keys = preparedStatement.getGeneratedKeys();
                if (keys.next())
                    odontologo.setId(keys.getLong(1));
                preparedStatement.close();
                logger.info("El odontólogo matricula MN" +odontologo.getMatricula() + " (" + odontologo.getNombre() + " " + odontologo.getApellido() + ") ha sido guardado en la base de datos con el ID = " + odontologo.getId() + ".");

            } catch (SQLException e) {
                // Problemas con el insert en la base de datos
                logger.error("Ha ocurrido un error al intentar guardar al odontólogo en la base de datos.",e);
            }

        } catch (ClassNotFoundException e){
            // Problemas del driver H2
            logger.error("Error del driver de H2.", e);
            System.exit(0);

        } catch (SQLException e){
            // Problemas de conexion con la base de datos
            logger.error("Error al conectar con la base de datos.", e);
            System.exit(0);

        } finally{

            try {
                connection.close();
            } catch (SQLException e) {
                // Problemas para cerrar la conexión
                logger.error("La conexión a la base de datos no se ha podido cerrar correctamente.", e);
            }

        }

        return odontologo;

    }

    @Override
    public List<Odontologo> listarTodos() {

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        List<Odontologo> odontologos = new ArrayList<>();

        try {

            Class.forName(DB_JDBC_DRIVER);
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);

            try {

                preparedStatement = connection.prepareStatement("SELECT *  FROM odontologos");
                ResultSet result = preparedStatement.executeQuery();

                while (result.next()) {

                    Long id = result.getLong(1);
                    int matricula = result.getInt(2);
                    String nombre = result.getString(3);
                    String apellido = result.getString(4);

                    Odontologo odontologo = new Odontologo(id, matricula, nombre, apellido);
                    odontologos.add(odontologo);
                }

                logger.info("La lista de todos los odontólogos guardados en la base de datos ha sido generada.");

            } catch (SQLException e) {
                // Problemas para listar todos los odontologos de la base de datos
                logger.error("Ha ocurrido un error al crear la lista de todos los odontólogos guardados en la base de datos.");
            }

        } catch (ClassNotFoundException e){
            // Problemas del driver H2
            logger.error("Error del driver de H2.", e);
            System.exit(0);

        } catch (SQLException e){
            // Problemas de conexion
            logger.error("Error al conectar con la base de datos.", e);
            System.exit(0);

        } finally{

            try {
                connection.close();
            } catch (SQLException e) {
                // Problemas para cerrar la conexión
                logger.error("La conexión a la base de datos no se ha podido cerrar correctamente.", e);
            }

        }
        return odontologos;
    }

}

package service;

import dao.IDao;
import model.Odontologo;

import java.util.List;


public class OdontologoService {

    // Atributos

    private IDao<Odontologo> odontologoIDao;

    // Constructor

    public OdontologoService(IDao<Odontologo> odontologoIDao) {
        this.odontologoIDao = odontologoIDao;
    }

    // Getters & Setters

    public IDao<Odontologo> getOdontologoIDao() {
        return odontologoIDao;
    }

    public void setOdontologoIDao(IDao<Odontologo> odontologoIDao) {
        this.odontologoIDao = odontologoIDao;
    }

    // Métodos

    public Odontologo guardar(Odontologo o) {
        return odontologoIDao.guardar(o);
    }

    public List<Odontologo> listarTodos() {
        return odontologoIDao.listarTodos();
    }


}

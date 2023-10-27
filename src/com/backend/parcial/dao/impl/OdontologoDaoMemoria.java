package src.com.backend.parcial.dao.impl;

import src.com.backend.parcial.dao.IDao;
import src.com.backend.parcial.model.Odontologo;

import java.util.List;
import java.util.Locale;
import org.apache.log4j.Logger;

public class OdontologoDaoMemoria implements IDao<Odontologo> {

    private  final Logger LOGGER = Logger.getLogger(OdontologoDaoMemoria.class);
    private List<Odontologo> odontologoList;

    public OdontologoDaoMemoria(List<Odontologo> odontologoList) {
        this.odontologoList = odontologoList;
    }

    @Override
    public Odontologo registrar(Odontologo odontologo) {
        int id = odontologoList.size() + 1;
        odontologoList.add(odontologo);
        Odontologo odontologoRegistrado = new Odontologo(id, odontologo.getNumeroMatricula(), odontologo.getNombre(), odontologo.getApellido());
        LOGGER.info("Odontologo registrado: " + odontologoRegistrado);
        return odontologo;
    }

    @Override
    public List<Odontologo> listarTodos() {
        LOGGER.info("Lista de odontologos registrados: " + odontologoList);
        return odontologoList;
    }
}

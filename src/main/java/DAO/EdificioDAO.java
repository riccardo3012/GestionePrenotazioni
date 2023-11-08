package DAO;
import entities.Edificio;
import java.util.List;

public interface EdificioDAO {
    public void save(Edificio edificio);
    public List<Edificio> findAll();
}
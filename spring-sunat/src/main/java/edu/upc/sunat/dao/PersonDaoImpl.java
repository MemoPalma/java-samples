/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.upc.sunat.dao;

import java.util.List;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import edu.upc.sunat.entity.Person;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Repository;
/**
 *
 * @author javier olivares
 */
@Repository
public class PersonDaoImpl extends JdbcDaoSupport implements DaoInterface<Person>{

    @Autowired
    public PersonDaoImpl(DataSource dataSource) {
        setDataSource(dataSource);
    }
    
    @Override
    public List<Person> listarTodos() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Integer insertar(Person object) {
        getJdbcTemplate().update("insert into sunat_person(name, ruc, phone, type) "
                + "values(?, ?, ?, ?)",
                object.getName(), object.getRuc(), object.getPhone(), object.getType());
        Integer id = getJdbcTemplate().queryForInt("Select last_insert_id()");
        object.setId(id);
        return id;
    }

    @Override
    public List<Person> listarPor(String[] filtro) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void elimnar(Person object) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void actualizar(Person object) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Person buscar(Integer pk) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Person buscar(String pk) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Person> listarPor(String filtro) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}

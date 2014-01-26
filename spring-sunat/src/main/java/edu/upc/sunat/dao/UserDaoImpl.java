/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.upc.sunat.dao;
import java.util.List;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import edu.upc.sunat.entity.User;
import java.util.HashMap;
import java.util.Map;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Repository;
/**
 *
 * @author javier olivares
 */
@Repository
public class UserDaoImpl extends JdbcDaoSupport implements DaoInterface<User>{

    @Autowired
    public UserDaoImpl(DataSource dataSource) {
        setDataSource(dataSource);
    }
    
    @Override
    public List<User> listarTodos() {
        return getJdbcTemplate().query(
                "select * from sunat_user",
                new BeanPropertyRowMapper<User>(User.class));
    }

    @Override
    public Integer insertar(User object) {
        getJdbcTemplate().update(
                "insert into sunat_user(full_name, username, salt, password,"
                + "email, is_active) values(?, ?, ?, ?, ?, ?)",
                object.getFullname(), object.getUsername(), object.getSalt(),
                object.getPassword(), object.getEmail(), object.getActive());
        return getJdbcTemplate().queryForInt("select last_insert_id()");
    }

    @Override
    public List<User> listarPor(String[] filtro) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void elimnar(User object) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void actualizar(User object) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public User buscar(Integer pk) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public User buscar(String pk) {
        try {
            return getJdbcTemplate().queryForObject(
                    "select * from sunat_user where email=?",
                    new BeanPropertyRowMapper<User>(User.class), pk);
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    @Override
    public List<User> listarPor(String filtro) {
        try {
            Map<String,String> parametros = new HashMap<String,String>();
            //parametros.put("email","%"+filtro+"%");
            return getJdbcTemplate().query(
                    "select * from sunat_user where email like '%"+filtro+"%'",
                    new BeanPropertyRowMapper<User>(User.class));
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }
    
}

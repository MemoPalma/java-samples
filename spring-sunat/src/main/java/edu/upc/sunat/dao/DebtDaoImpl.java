/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.upc.sunat.dao;

import edu.upc.sunat.entity.Concept;
import java.util.List;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import edu.upc.sunat.entity.Debt;
import edu.upc.sunat.entity.Person;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

/**
 *
 * @author javier olivares
 */
@Repository
public class DebtDaoImpl extends JdbcDaoSupport implements DaoInterface<Debt>{

    @Autowired
    public DebtDaoImpl(DataSource dataSource) {
        setDataSource(dataSource);
    }
    
    @Override
    public List<Debt> listarTodos() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Integer insertar(Debt object) {
        getJdbcTemplate().update("insert into sunat_debt(concept_id, person_id,"
                + "resolution_number, tax_code, period, amount) "
                + "values (?, ?, ?, ?, ?, ?)", object.getConcept().getId(),
                object.getPerson().getId(), object.getResolutionNumber(),
                object.getTaxcode(), object.getPeriod(), object.getAmount());
        return  getJdbcTemplate().queryForInt("Select last_insert_id()");
    }

    @Override
    public List<Debt> listarPor(String[] filtro) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void elimnar(Debt object) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void actualizar(Debt object) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Debt buscar(Integer pk) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Debt buscar(String pk) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Debt> listarPor(String ruc) {
        try {
            //Map<String,String> parametros = new HashMap<String,String>();
            //parametros.put("email","%"+filtro+"%");
            return getJdbcTemplate().query(
                    "select sd.id, sc.name, sp.ruc, sd.resolution_number, "
                    + "sd.tax_code, sd.amount, sd.period "
                    + "from sunat_debt sd "
                    + "left join sunat_concept sc "
                    + "on sd.concept_id = sc.id "
                    + "left join sunat_person sp "
                    + "on sd.person_id = sp.id "
                    + "where sp.ruc = '"+ruc+"'",
                    new RowMapper<Debt>() {

                @Override
                public Debt mapRow(ResultSet rs, int i) throws SQLException {
                    Debt d = new Debt();
                    d.setId(rs.getInt(1));
                    d.setResolutionNumber(rs.getString(4));
                    d.setTaxcode(rs.getString(5));
                    d.setPeriod(rs.getString(7));
                    d.setAmount(rs.getDouble(6));
                    d.setConcept(new Concept(i, rs.getString(2)));
                    Person p = new Person();
                    p.setRuc(rs.getString(3));
                    d.setPerson(p);
                    return d;
                }
            });
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }
    
}

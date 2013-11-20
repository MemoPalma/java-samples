/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.upc.vinos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author alumno
 */
public class VinoDAO {

    public List<Vino> findAll() {

        List<Vino> lista = new ArrayList<Vino>();
        Connection c = null;
        String sql = "select * from wine order by name";
        try {
            c = ConnectionHelper.getConnection();
            Statement statement = c.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                lista.add(processRow(rs));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return lista;
    }

    private Vino processRow(ResultSet rs) throws SQLException {
        Vino vino = new Vino();
        vino.setId(rs.getInt("id"));
        vino.setName(rs.getString("name"));
        vino.setGrapes(rs.getString("grapes"));
        vino.setCountry(rs.getString("country"));
        vino.setRegion(rs.getString("region"));
        vino.setYear(rs.getString("year"));
        vino.setPicture(rs.getString("picture"));
        vino.setDescription(rs.getString("description"));
        return vino;
    }

    public List<Vino> findByName(String name) {
        List<Vino> list = new ArrayList<Vino>();
        Connection c = null;
        String sql = "SELECT * FROM wine as e "
                + "WHERE UPPER(name) LIKE ? "
                + "ORDER BY name";
        try {
            c = ConnectionHelper.getConnection();
            PreparedStatement ps = c.prepareStatement(sql);
            ps.setString(1, "%" + name.toUpperCase() + "%");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(processRow(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        } finally {
            ConnectionHelper.close(c);
        }
        return list;
    }

    public Vino findById(int id) {
        String sql = "SELECT * FROM wine WHERE id = ?";
        Vino wine = null;
        Connection c = null;
        try {
            c = ConnectionHelper.getConnection();
            PreparedStatement ps = c.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                wine = processRow(rs);
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        } finally {
            ConnectionHelper.close(c);
        }
        return wine;
    }

    public Vino save(Vino wine) {
        return wine.getId() > 0 ? update(wine) : create(wine);
    }

    public Vino create(Vino wine) {
        Connection c = null;
        PreparedStatement ps = null;
        try {
            c = ConnectionHelper.getConnection();
            ps = c.prepareStatement("INSERT INTO wine (name, grapes, country, region, year, picture, description) VALUES (?, ?, ?, ?, ?, ?, ?)",
                    new String[]{"ID"});
            ps.setString(1, wine.getName());
            ps.setString(2, wine.getGrapes());
            ps.setString(3, wine.getCountry());
            ps.setString(4, wine.getRegion());
            ps.setString(5, wine.getYear());
            ps.setString(6, wine.getPicture());
            ps.setString(7, wine.getDescription());
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            rs.next();
            // Update the id in the returned object. This is important as this value must be returned to the client.
            int id = rs.getInt(1);
            wine.setId(id);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        } finally {
            ConnectionHelper.close(c);
        }
        return wine;
    }

    public Vino update(Vino wine) {
        Connection c = null;
        try {
            c = ConnectionHelper.getConnection();
            PreparedStatement ps = c.prepareStatement("UPDATE wine SET name=?, grapes=?, country=?, region=?, year=?, picture=?, description=? WHERE id=?");
            ps.setString(1, wine.getName());
            ps.setString(2, wine.getGrapes());
            ps.setString(3, wine.getCountry());
            ps.setString(4, wine.getRegion());
            ps.setString(5, wine.getYear());
            ps.setString(6, wine.getPicture());
            ps.setString(7, wine.getDescription());
            ps.setInt(8, wine.getId());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        } finally {
            ConnectionHelper.close(c);
        }
        return wine;
    }

    public boolean remove(int id) {
        Connection c = null;
        try {
            c = ConnectionHelper.getConnection();
            PreparedStatement ps = c.prepareStatement("DELETE FROM wine WHERE id=?");
            ps.setInt(1, id);
            int count = ps.executeUpdate();
            return count == 1;
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        } finally {
            ConnectionHelper.close(c);
        }
    }
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.upc.sunat.dao;

import java.util.List;

/**
 *
 * @author javier olivares
 */
public interface DaoInterface<T> {
    
    public List<T> listarTodos();
    public Integer insertar(T object);
    public List<T> listarPor(String[] filtro);
    public List<T> listarPor(String filtro);
    public void elimnar(T object);
    public void actualizar(T object);
    public T buscar(Integer pk);
    public T buscar(String pk);
}

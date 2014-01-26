/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.upc.sunat.service;

import java.util.List;

/**
 *
 * @author herald olivares
 */
public interface ServiceInterface<T> {
    public List<T> listarTodos();
    public Integer insertar(T object);
    public List<T> listarPor(String[] filtro);
    public List<T> listarPor(String filtro);
    public void elimnar(T object);
    public void actualizar(T object);
    public T buscar(Integer pk);
    
}

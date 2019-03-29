/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prueba.dao;

import java.util.List;
import prueba.vo.Persona;

/**
 *
 * @author bcortez
 */
public interface PersonaDAO {
    
    public void registrarPersona(Persona persona);
    
    public Persona consultarPersona(int documento);
    
    public List<Persona> listaDePersonas();
}

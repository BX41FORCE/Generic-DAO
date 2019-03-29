package prueba.dao.impl;


import java.util.List;
import prueba.dao.PersonaDAO;
import prueba.vo.Persona;

public class PersonaDAOImpl extends PersonaGenericDAOImpl<Persona, Integer> implements PersonaDAO{
    
    
/*
    public void registrarPersona(PersonaVO persona) {
        DbConnection conex = new DbConnection();
        try {
            Statement estatuto = conex.getConnection().createStatement();
            estatuto.execute("INSERT INTO persona VALUES('" + persona.getIdPersona() + "','"
                    + persona.getNombrePersona() + "','"
                    + persona.getApellidoPersona() + "','"
                    + persona.getProfesionPersona() + "')");
            JOptionPane.showMessageDialog(null, "Se ha registrado Exitosamente", "Información", JOptionPane.INFORMATION_MESSAGE);
            estatuto.close();
            conex.desconectar();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(null, "No se Registro la persona");
        }
    }

    /**
     * permite consultar el empleado asociado al documento enviado como
     * parametro
     *
     * @param documento
     * @return
     */
    @Override
    public Persona consultarPersona(int documento) {
        return this.find(documento);
    }
    /*public Persona consultarPersona(int documento) {
        ArrayList< PersonaVO> miEmpleado = new ArrayList< PersonaVO>();
        DbConnection conex = new DbConnection();

        try {
            PreparedStatement consulta = conex.getConnection().prepareStatement("SELECT * FROM persona where id = ? ");
            consulta.setInt(1, documento);
            ResultSet res = consulta.executeQuery();

            if (res.next()) {
                PersonaVO persona = new PersonaVO();
                persona.setIdPersona(res.getString("id_persona"));
                persona.setNombrePersona(res.getString("nombre"));
                persona.setApellidoPersona(res.getString("apellido"));
                persona.setProfesionPersona(res.getString("profesion"));
                miEmpleado.add(persona);
            }
            res.close();
            consulta.close();
            conex.desconectar();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "no se pudo consultar la Persona\n" + e);
        }
        return miEmpleado;
    }*/

    /**
     * permite consultar la lista de empleados
     *
     * @return
     */
    
    @Override
    public List<Persona> listaDePersonas() {
        return this.findAll();
    }
/*    public ArrayList<Persona> listaDePersonas() {
        ArrayList<PersonaVO> miEmpleado = new ArrayList<PersonaVO>();
        DbConnection conex = new DbConnection();

        try {
            PreparedStatement consulta = conex.getConnection().prepareStatement("SELECT * FROM persona");
            ResultSet res = consulta.executeQuery();
            while (res.next()) {
                PersonaVO persona = new PersonaVO();
                persona.setIdPersona(res.getString("id_persona"));
                persona.setNombrePersona(res.getString("nombre"));
                persona.setApellidoPersona(res.getString("nombre"));
                persona.setProfesionPersona(res.getString("profesion"));
                miEmpleado.add(persona);
            }
            res.close();
            consulta.close();
            conex.desconectar();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "no se pudo consultar la Persona\n" + e);
        }
        return miEmpleado;
    }
*/
    
    @Override
    public void registrarPersona(Persona persona) {
        this.add(persona);
    }
}

package prueba.vo;

public class PersonaVO {

    private String idPersona;
    private String nombrePersona;
    private String apellidoPersona;
    private String profesionPersona;
//get y set de id

    public String getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(String idPersona) {
        this.idPersona = idPersona;
    }
//get y set del nombre

    public String getNombrePersona() {
        return nombrePersona;
    }

    public void setNombrePersona(String nombrePersona) {
        this.nombrePersona = nombrePersona;
    }

    //get y set del apellido
    public String getApellidoPersona() {
        return apellidoPersona;
    }

    public void setApellidoPersona(String apellidoPersona) {
        this.apellidoPersona = apellidoPersona;
    }

    //get y set del profesion
    public String getProfesionPersona() {
        return profesionPersona;
    }

    public void setProfesionPersona(String profesionPersona) {
        this.profesionPersona = profesionPersona;
    }
}

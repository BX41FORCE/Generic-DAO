package prueba.principal;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import prueba.dao.impl.PersonaDAOImpl;
import prueba.vo.PersonaVO;

public class Principal {

    PersonaDAOImpl miPersonaDAO;

    public static void main(String[] args) {
        Principal miPrincipal = new Principal();
        miPrincipal.verMenu();
    }

    private void verMenu() {

        String textoMenu = "Menú Principal\n\n";
        textoMenu += "Ingrese alguna de las opciones del Menú    \n";
        textoMenu += "1. Registrar Persona\n";
        textoMenu += "2. Consultar Persona\n";
        textoMenu += "3. Ver Lista Personas\n";
        textoMenu += "4. Salir.\n\n";

        try {
            int seleccion = Integer.parseInt(JOptionPane.showInputDialog(textoMenu));
            defineSeleccion(seleccion);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Error en el ingreso de Datos, "
                    + "solo se permiten valores númericos", "ERROR", JOptionPane.ERROR_MESSAGE);
            verMenu();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error en el ingreso de Datos, "
                    + "solo se permiten valores númericos", "ERROR", JOptionPane.ERROR_MESSAGE);
            verMenu();
        }
    }

    private void defineSeleccion(int seleccion) {

        System.out.println("Selecciona " + seleccion);

        switch (seleccion) {
            case 1:
                registrarPersona();
                verMenu();
                break;
            case 2:
                int doc = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el numero"
                        + " de documento de la persona"));
                buscarPersona(doc);
                verMenu();
                break;
            case 3:
                obtenerRegistros();
                verMenu();
                break;
            case 4:
                System.exit(0);
                break;
            default:
                JOptionPane.showMessageDialog(null, "Ingrese un "
                        + "numero valido", "ADVERTENCIA", JOptionPane.WARNING_MESSAGE);
                verMenu();
                break;
        }

    }

    private void registrarPersona() {

        miPersonaDAO = new PersonaDAOImpl();
        PersonaVO miPersona = new PersonaVO();

        String mensajeIngreso = "Ingrese\n\n";

        String datosSolicitados[] = {"Documento : ", "Nombre : ",
            "Apellido: ", "Profesión: "};
        String datosPersona[] = new String[4];
        for (int i = 0; i < datosSolicitados.length; i++) {
            //solicita el ingreso del dato y se almacena en el arreglo de datosPersona
            datosPersona[i] = JOptionPane.showInputDialog(null, mensajeIngreso
                    + datosSolicitados[i], "Datos Persona", JOptionPane.INFORMATION_MESSAGE);

            System.out.println(datosSolicitados[i] + datosPersona[i]);
        }

        miPersona.setIdPersona(datosPersona[0]);
        miPersona.setNombrePersona(datosPersona[1]);
        miPersona.setApellidoPersona(datosPersona[2]);
        miPersona.setProfesionPersona(datosPersona[3]);

        miPersonaDAO.registrarPersona(miPersona);

    }

    private void obtenerRegistros() {
        miPersonaDAO = new PersonaDAOImpl();
        PersonaVO miPersona;

        //Se obtiene la lista de personas
        ArrayList<PersonaVO> listaPersonas = miPersonaDAO.listaDePersonas();
        //se valida si se obtubo o no informacion
        if (listaPersonas.size() > 0) {
            int numeroPersona = 0;
            //se recorre la lista de personas asignandose cada posicion en un objeto persona
            for (int i = 0; i < listaPersonas.size(); i++) {
                numeroPersona++;
                miPersona = listaPersonas.get(i);
                System.out.println("****************Persona " + numeroPersona + "**********************");
                System.out.println("Id Persona: " + miPersona.getIdPersona());
                System.out.println("Nombre Persona: " + miPersona.getNombrePersona());
                System.out.println("Apellido Persona: " + miPersona.getApellidoPersona());
                System.out.println("Profesión Persona: " + miPersona.getProfesionPersona());
                System.out.println("*************************************************\n");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Actualmente no "
                    + "existen registros de personas", "INFORMACIÓN", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    private void buscarPersona(int documento) {
        miPersonaDAO = new PersonaDAOImpl();
        PersonaVO miPersona;
        ArrayList<PersonaVO> personasEncontrada = miPersonaDAO.consultarPersona(documento);
        //se valida que se encuentre la persona
        if (personasEncontrada.size() > 0) {
            //se recorre la lista y se asignan los datos al objeto para imprimir los valores
            for (int i = 0; i < personasEncontrada.size(); i++) {
                miPersona = personasEncontrada.get(i);
                System.out.println("****************Persona*************************");
                System.out.println("Id Persona: " + miPersona.getIdPersona());
                System.out.println("Nombre Persona: " + miPersona.getNombrePersona());
                System.out.println("Apellido Persona: " + miPersona.getApellidoPersona());
                System.out.println("Profesión Persona: " + miPersona.getProfesionPersona());
                System.out.println("*************************************************\n");
            }
        } else {
            JOptionPane.showMessageDialog(null, "El documento ingresado "
                    + "no corresponde a ninguna persona", "INFORMACIÓN", JOptionPane.INFORMATION_MESSAGE);
        }
    }
}

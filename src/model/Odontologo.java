package model;

public class Odontologo {

    // Atributos
    private Long id;
    private int matricula;
    private String nombre;
    private String apellido;

    // Constructor con id para cuando traemos los datos de la tabla y agregamos odontólogos a la lista
    public Odontologo(Long id, int matricula, String nombre, String apellido) {
        this.id = id;
        this.matricula = matricula;
        this.nombre = nombre;
        this.apellido = apellido;
    }

    // Constructor sin id para cuando cargamos el odontólogo a la tabla (id auto-incremental)
    public Odontologo(int matricula, String nombre, String apellido) {
        this.matricula = matricula;
        this.nombre = nombre;
        this.apellido = apellido;
    }

    // Getters & Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getMatricula() {
        return matricula;
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    @Override
    public String toString(){
        return "Odontologo ID = " + id + ". Matricula: " + matricula + ". Nombre Completo: " + nombre + " " + apellido + ".";
    }

}

import java.time.LocalDate;

public class Departamento {


    private int numeroDepartamento;
    private String nombreDepartamento;
    private int numeroEmpleados;
    private String NSSgerente;
    private LocalDate fechaInicioGerente;


    public Departamento() {
    }

    public Departamento(int numeroDepartamento, String nombreDepartamento, int numeroEmpleados, String NSSgerente, LocalDate fechaInicioGerente) {
        this.numeroDepartamento = numeroDepartamento;
        this.nombreDepartamento = nombreDepartamento;
        this.numeroEmpleados = numeroEmpleados;
        this.NSSgerente = NSSgerente;
        this.fechaInicioGerente = fechaInicioGerente;
    }

    public int getNumeroDepartamento() {
        return numeroDepartamento;
    }

    public void setNumeroDepartamento(int numeroDepartamento) {
        if(numeroDepartamento<0 || numeroDepartamento>100){
            System.out.println("Numero deprtmento no valid");
        }else{
            this.numeroDepartamento = numeroDepartamento;
        }

    }

    public String getNombreDepartamento() {
        return nombreDepartamento;
    }

    public void setNombreDepartamento(String nombreDepartamento) {
        this.nombreDepartamento = nombreDepartamento;
    }

    public int getNumeroEmpleados() {
        return numeroEmpleados;
    }

    public void setNumeroEmpleados(int numeroEmpleados) {
        this.numeroEmpleados = numeroEmpleados;
    }

    public String getNSSgerente() {
        return NSSgerente;
    }

    public void setNSSgerente(String NSSgerente) {
        this.NSSgerente = NSSgerente;
    }

    public LocalDate getFechaInicioGerente() {
        return fechaInicioGerente;
    }

    public void setFechaInicioGerente(LocalDate fechaInicioGerente) {
        this.fechaInicioGerente = fechaInicioGerente;
    }
}

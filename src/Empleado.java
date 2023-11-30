import java.time.LocalDate;

public class Empleado {

    private String nss;
    private String nombre;
    private String apellido1;
    private String apellido2;
    private char sexo;
    private String direccion;
    private LocalDate fechaNacimiento;
    private int salario;
    private int numeroDepartamento;
    private String NSSsup;
    private String nif;

    public Empleado() {
    }

    public Empleado(String nss, String nombre, String apellido1, String apellido2, char sexo, String direccion, LocalDate fechaNacimiento, int salario, int numeroDepartamento, String NSSsup, String nif) {
        this.nss = nss;
        this.nombre = nombre;
        this.apellido1 = apellido1;
        this.apellido2 = apellido2;
        this.sexo = sexo;
        this.direccion = direccion;
        this.fechaNacimiento = fechaNacimiento;
        this.salario = salario;
        this.numeroDepartamento = numeroDepartamento;
        this.NSSsup = NSSsup;
        this.nif = nif;
    }



    public String getNss() {
        return nss;
    }

    public void setNss(String nss) {
        this.nss = nss;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido1() {
        return apellido1;
    }

    public void setApellido1(String apellido1) {
        this.apellido1 = apellido1;
    }

    public String getApellido2() {
        return apellido2;
    }

    public void setApellido2(String apellido2) {
        this.apellido2 = apellido2;
    }

    public char getSexo() {
        return sexo;
    }

    public void setSexo(char sexo) {
        // Validar que el sexo sea 'H' o 'M'
        if (sexo == 'F' || sexo == 'M') {
            this.sexo = sexo;
        } else {
            System.out.println("Error: El sexo debe ser 'H' o 'M'.");
        }
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public int getSalario() {
        return salario;
    }

    public void setSalario(int salario) {
        this.salario = salario;
    }

    public int getNumeroDepartamento() {
        return numeroDepartamento;
    }

    public void setNumeroDepartamento(int numeroDepartamento) {
        this.numeroDepartamento = numeroDepartamento;
    }

    public String getNSSsup() {
        return NSSsup;
    }

    public void setNSSsup(String NSSsup) {
        this.NSSsup = NSSsup;
    }

    public String getNif() {
        return nif;
    }

    public void setNif(String nif) {
        this.nif = nif;
    }

    @Override
    public String toString() {
        return "Empleado{" +
                "nss='" + nss + '\'' +
                ", nombre='" + nombre + '\'' +
                ", apellido1='" + apellido1 + '\'' +
                ", apellido2='" + apellido2 + '\'' +
                ", sexo=" + sexo +
                ", direccion='" + direccion + '\'' +
                ", fechaNacimiento=" + fechaNacimiento +
                ", salario=" + salario +
                ", numeroDepartamento=" + numeroDepartamento +
                ", NSSsup='" + NSSsup + '\'' +
                ", nif='" + nif + '\'' +
                '}';
    }


}

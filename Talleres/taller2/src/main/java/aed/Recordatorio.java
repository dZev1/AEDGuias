package aed;

public class Recordatorio {
    private String mensaje;
    private Fecha fecha;
    private Horario horario;

    public Recordatorio(String mensaje, Fecha fecha, Horario horario) {
        this.mensaje = mensaje;
        this.fecha = new Fecha(fecha);
        this.horario = horario;
    }

    public Horario horario() {
        return this.horario;
    }

    public Fecha fecha() {
        Fecha fecha = new Fecha(this.fecha);
        return fecha;
    }

    public String mensaje() {
        return this.mensaje;
    }

    @Override
    public String toString() {
        String mensaje = this.mensaje();
        Fecha fecha = this.fecha();
        Horario horario = this.horario();
        return mensaje + " @ " + fecha + " " + horario;
    }

    @Override
    public boolean equals(Object otro) {
        boolean otroEsNull = (otro == null);
        boolean claseDistinta = otro.getClass() != this.getClass();

        if (otroEsNull || claseDistinta) {
            return false;
        }

        Recordatorio otroRecordatorio = (Recordatorio) otro;
        return this.horario.equals(otroRecordatorio.horario) && this.fecha.equals(otroRecordatorio.fecha) && this.mensaje == otroRecordatorio.mensaje;
    }

}

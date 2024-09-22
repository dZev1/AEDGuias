package aed;

public class Horario {
    private int hora;
    private int minutos;

    public Horario(int hora, int minutos) {
        this.hora = hora;
        this.minutos = minutos;
    }

    public int hora() {
        return this.hora;
    }

    public int minutos() {
        return this.minutos;
    }

    @Override
    public String toString() {
        String hora = Integer.toString(this.hora);
        String minutos = Integer.toString(this.minutos);
        return hora + ":" + minutos;
    }

    @Override
    public boolean equals(Object otro) {
        boolean otroEsNull = (otro == null);
        boolean claseDistinta = otro.getClass() != this.getClass();

        if (otroEsNull || claseDistinta) {
            return false;
        }

        Horario otroHorario = (Horario) otro;

        return this.hora == otroHorario.hora && this.minutos == otroHorario.minutos;

    }

}

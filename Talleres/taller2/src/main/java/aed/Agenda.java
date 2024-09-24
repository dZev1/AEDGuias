package aed;

public class Agenda {
    private Fecha fechaActual;
    private ArregloRedimensionableDeRecordatorios agenda = new ArregloRedimensionableDeRecordatorios();

    public Agenda(Fecha fechaActual) {
        this.fechaActual = fechaActual;
    }

    public void agregarRecordatorio(Recordatorio recordatorio) {
        this.agenda.agregarAtras(recordatorio);
    }

    @Override
    public String toString() {
        String res1 = fechaActual.toString() + "\n" + "=====" + "\n";
        String res2 = "";
        for (int i = 0; i < this.agenda.longitud(); i++) {
            if (this.agenda.obtener(i).fecha().equals(fechaActual)) {
                res2 += this.agenda.obtener(i).toString() + "\n";
            }
        }

        return res1 + res2;
    }

    public void incrementarDia() {
        this.fechaActual.incrementarDia();
    }

    public Fecha fechaActual() {
        Fecha res = new Fecha(this.fechaActual);
        return res;
    }

}

package aed;

class ArregloRedimensionableDeRecordatorios {
    private Recordatorio[] recordatorios;
    public ArregloRedimensionableDeRecordatorios() {
        this.recordatorios = new Recordatorio[0];
    }

    public int longitud() {
        return this.recordatorios.length;
    }

    public void agregarAtras(Recordatorio i) {
        this.recordatorios = agregar(this.recordatorios, i);
    }

    private Recordatorio[] agregar(Recordatorio[] recordatorios, Recordatorio i) {
        Recordatorio[] r = new Recordatorio[recordatorios.length + 1];
        for (int j = 0; j < recordatorios.length; j++) {
            r[j] = recordatorios[j];
        }
        r[recordatorios.length] = i;
        return r;
    }

    public Recordatorio obtener(int i) {
        return this.recordatorios[i];
    }

    public void quitarAtras() {
        this.recordatorios = quitarUltimo(this.recordatorios);
    }

    private Recordatorio[] quitarUltimo(Recordatorio[] recordatorios) {
        Recordatorio[] r = new Recordatorio[recordatorios.length - 1];
        for (int j = 0; j < r.length; j++) {
            r[j] = recordatorios[j];
        }
        return r;
    }

    public void modificarPosicion(int indice, Recordatorio valor) {
        // Implementar
    }

    public ArregloRedimensionableDeRecordatorios(ArregloRedimensionableDeRecordatorios vector) {
        this.recordatorios = vector.recordatorios;
    }

    public ArregloRedimensionableDeRecordatorios copiar() {
        // Implementar
        return null;
    }
}

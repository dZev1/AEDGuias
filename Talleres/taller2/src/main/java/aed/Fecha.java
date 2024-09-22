package aed;

public class Fecha {
    private int dia;
    private int mes;

    public Fecha(int dia, int mes) {
        this.dia = dia;
        this.mes = mes;    
    }

    public Fecha(Fecha fecha) {
        this.dia = fecha.dia;
        this.mes = fecha.mes;
    }

    public Integer dia() {
        return this.dia;
    }

    public Integer mes() {
        return this.mes;
    }

    @Override
    public String toString() {
        String dia = String.valueOf(this.dia);
        String mes = String.valueOf(this.mes);
        return dia + "/" + mes;
    }

    @Override
    public boolean equals(Object otra) {
        boolean otroEsNull = (otra == null);
        boolean claseDistinta = otra.getClass() != this.getClass();
        
        if (otroEsNull || claseDistinta) {
        return false;
        }
        
        Fecha otraFecha = (Fecha) otra;
        return this.dia == otraFecha.dia && this.mes == otraFecha.mes;
    }

    public void incrementarDia() {
        int[] mesesCon31Dias = new int[] {1,3,5,7,8,10,12};
        int[] mesesCon30Dias = new int[] {4,6,9,11};

        if (this.dia == 31 && pertenece(this.mes,mesesCon31Dias)) {
            this.dia = 1;
            if (this.mes == 12) {
                this.mes = 1;
            } else {
                this.mes++;
            }
        }
        else if (this.dia == 30 && pertenece(this.mes,mesesCon30Dias)) {
            this.dia = 1;
            this.mes++;
        }
        else if (this.dia == 28 && this.mes == 2) {
            this.dia = 1;
            this.mes++;
        }
        else {
            this.dia++;
        }
        
    }

    private boolean pertenece(int n, int[] meses) {
        boolean res = false;
        for (int m : meses) {
            if (n == m) {
                res = true;
            }
        }
        return res;
    }

    private int diasEnMes(int mes) {
        int dias[] = {
                // ene, feb, mar, abr, may, jun
                31, 28, 31, 30, 31, 30,
                // jul, ago, sep, oct, nov, dic
                31, 31, 30, 31, 30, 31
        };
        return dias[mes - 1];
    }

}

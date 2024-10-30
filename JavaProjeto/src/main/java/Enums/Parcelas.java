package Enums;

public enum Parcelas {
    UMA(1),
    DUAS(2),
    TRES(3),
    QUATRO(4),
    CINCO(5),
    SEIS(6),
    SETE(7),
    OITO(8),
    NOVE(9),
    DEZ(10),
    ONZE(11),
    DOZE(12);

    private final int valor;

    Parcelas(int valor) {
        this.valor = valor;
    }

    public int getValor() {
        return valor;
    }
}
package br.com.vinicius.estudo.cursomc.enums;

public enum StatePayment {

    PENDING(1, "PENDENTE"),
    SETTLED(2, "QUITADO"),
    CANCELED(3, "CANCELADO");

    private int cod;
    private String description;

    StatePayment(int cod, String description) {
        this.cod = cod;
        this.description = description;
    }

    public int getCod() {
        return cod;
    }

    public String getDescription() {
        return description;
    }

    public static StatePayment toEnum(Integer cod){
        if (cod == null) return null;

        for(StatePayment x : StatePayment.values()) {
            if (cod.equals(x.getCod())) return x;
        }
        throw new IllegalArgumentException("Id inválido: " + cod);
    }

}

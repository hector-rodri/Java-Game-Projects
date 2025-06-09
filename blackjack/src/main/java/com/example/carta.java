package com.example;

public class carta {
    private String valor;
    private String tipo;

    public carta(String valor, String tipo){
        this.valor = valor;
        this.tipo = tipo;
    }

    public int getValor(){
        if (valor == "A") {
            return 11;
        } else if (valor == "K"| valor == "Q" | valor == "J") {
            return 10;
        } else{
            return Integer.parseInt(valor);
        }
    }

    public String infoCarta() {
        return valor + " de " + tipo;
    }

    
    public String getValorString() {
        if (valor.equals("A")) {
            return "11";
        } else if (valor.equals("K") || valor.equals("Q") || valor.equals("J")) {
            return "10";
        } else {
            return valor;
        }
    }
}

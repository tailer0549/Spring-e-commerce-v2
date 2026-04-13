package com.example.Revision.Entities.enums;

public enum OrderStatus {

    // OrderStatus serve para organizar tipos de dados que possuem um conjunto fixo e imutável de valores.
    // Permite que um campo (orderStatus) tenha apenas valores permitidos como (PAID, SHIPPED)..
    // Impede erros de digitação, caso o usuário tivesse que usar Strings.

    WAITING_PAYMENT(1),
    PAID(2),
    SHIPPED(3),
    DELIVERED(4),
    CANCELED(5);

    private int code; // Código do tipo enumerado

    // Construtor do tipo enumerado
    private OrderStatus(int code) {
        this.code = code;
    }

    // Método para converter um valor numérico em tipo enumerado
    public static OrderStatus valueOf(int code) {
        for (OrderStatus value : OrderStatus.values()) {
            if (value.getCode() == code) {
                return value;
            }
        }
        // Se chegar até aqui, o usuário digitou um código inválido
        throw new IllegalArgumentException("Invalid OrderStatus code");
    }

    public int getCode() {
        return code;
    }
}

package com.guimasoftware.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderRequest {

    public static enum Status {
        REALIZADO,
        PAGO,
        CONFIRMADO,
        PRONTO,
        SAIU_PARA_ENTREGA,
        ENTREGUE;
    }

    private String customerOrder;
    private String phone;
    private String email;
    private Status status;
    private int itemId;

}

package com.adria.noyauservice.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ListeFacturierRequest {
    private int clientId;
    private int canalType;
    private int accepteurCod;
    private Long canalCod;
    private String dateOperationCanal;
    private int facturierCategorie;
    private String lang;
    private Long auditNumber;
}

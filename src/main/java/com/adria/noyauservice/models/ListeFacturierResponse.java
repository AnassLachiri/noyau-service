package com.adria.noyauservice.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ListeFacturierResponse {
    private String dateOperationServeur;
    private int codeRetour;
    private String messageRetour;
    private List<Facturier> listeFacturiers;
}

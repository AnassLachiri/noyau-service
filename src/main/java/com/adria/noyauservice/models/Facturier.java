package com.adria.noyauservice.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.xml.bind.annotation.XmlElement;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Facturier {
    String FacturierName;
    String FacturierId;
    String FacturierDesc;
    String FacturierLogo;
    String FacturierWebSite;
    List<Param> Params;
}

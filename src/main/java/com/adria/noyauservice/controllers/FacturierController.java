package com.adria.noyauservice.controllers;


import com.adria.noyauservice.models.ListeFacturierRequest;
import com.adria.noyauservice.models.ListeFacturierResponse;
import com.adria.noyauservice.services.FacturierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "api/v1/")
public class FacturierController {

    private final FacturierService facturierService;

    @Autowired
    public FacturierController(FacturierService facturierService) {
        this.facturierService = facturierService;
    }

    @GetMapping(path = "/GetListeFacturier")
    public ListeFacturierResponse getListeFacturier(@RequestBody ListeFacturierRequest listeFacturierRequest){
        return facturierService.getListeFacturier(listeFacturierRequest);
    }
}

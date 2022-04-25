package com.adria.noyauservice.services;

import com.adria.noyauservice.entities.ConnectionMatrix;
import com.adria.noyauservice.models.ListeFacturierMiddleRequest;
import com.adria.noyauservice.models.ListeFacturierRequest;
import com.adria.noyauservice.models.ListeFacturierResponse;
import com.adria.noyauservice.repositories.ConnectionMatrixRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.server.ResponseStatusException;
import reactor.core.publisher.Mono;

import java.util.Optional;

@Service
public class FacturierService {

    private final String MIDDLE_SERVICE_URL = "http://localhost:8082/api/v1/GetListeFacturierMiddle";


    private final WebClient.Builder webClientBuilder;
    private final ConnectionMatrixRepository connectionMatrixRepository;

    @Autowired
    public FacturierService(WebClient.Builder webClientBuilder, ConnectionMatrixRepository connectionMatrixRepository){
        this.webClientBuilder = webClientBuilder;
        this.connectionMatrixRepository = connectionMatrixRepository;
//        this.restTemplate = restTemplate;
    }

    public ListeFacturierResponse getListeFacturier(ListeFacturierRequest listeFacturierRequest){
        Optional<ConnectionMatrix> connectionMatrixOptional = connectionMatrixRepository.findById(
                (long) listeFacturierRequest.getClientId());
        if(!connectionMatrixOptional.isPresent()){
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Client id not found"
            );
        }

        Long agregateurId = connectionMatrixOptional.get().getAgregateurId();
        System.out.println("Agregateur id     :   " + agregateurId);

//        ConnectionMatrix connectionMatrix = connectionMatrixOptional.get();

        ListeFacturierMiddleRequest listeFacturierMiddleRequest = new ListeFacturierMiddleRequest(
                listeFacturierRequest.getClientId(),
                agregateurId.intValue(),
                listeFacturierRequest.getCanalType(),
                listeFacturierRequest.getAccepteurCod(),
                listeFacturierRequest.getCanalCod(),
                listeFacturierRequest.getDateOperationCanal(),
                listeFacturierRequest.getFacturierCategorie(),
                listeFacturierRequest.getLang(),
                listeFacturierRequest.getAuditNumber()
        );

//        System.out.println(listeFacturierMiddleRequest);


        ListeFacturierResponse response = webClientBuilder.build()
                .method(HttpMethod.GET)
                .uri(MIDDLE_SERVICE_URL)
                .body(Mono.just(listeFacturierMiddleRequest), ListeFacturierMiddleRequest.class)
                .retrieve()
                .bodyToMono(ListeFacturierResponse.class)
                .block();


//        System.out.println(response);

        return response;
    }

}

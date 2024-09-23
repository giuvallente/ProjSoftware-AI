package br.insper.avIntermediaria.gerente;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class GerenteService {

    public ResponseEntity<RetornarGerenteDTO> getGerente(String cpf) {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForEntity(
                "http://184.72.80.215:8080/usuario/" + cpf,
                RetornarGerenteDTO.class);
    }
}

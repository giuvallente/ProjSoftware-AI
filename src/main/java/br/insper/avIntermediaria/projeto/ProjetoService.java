package br.insper.avIntermediaria.projeto;

import br.insper.avIntermediaria.gerente.GerenteNaoEncontradoException;
import br.insper.avIntermediaria.gerente.GerenteService;
import br.insper.avIntermediaria.gerente.RetornarGerenteDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ProjetoService {

    @Autowired
    private ProjetoRepository projetoRepository;

    @Autowired
    private GerenteService gerenteService;

    public Projeto salvar(Projeto projeto) {

        projeto.setId(UUID.randomUUID().toString());

        ResponseEntity<RetornarGerenteDTO> gerente = gerenteService.getGerente(projeto.getResponsavel());

        if (gerente.getStatusCode().is2xxSuccessful())  {
            List<RetornarGerenteDTO> participantes = new ArrayList<>();
            participantes.add(gerente.getBody());
            projeto.setParticipantes(participantes);

            return projetoRepository.save(projeto);
        } else {
            throw new GerenteNaoEncontradoException("Gerente não encontrado");
        }
    }

    public List<Projeto> listar(String status) {

        if (status == null) {
            return projetoRepository.findAll();
        } else {
            return projetoRepository.findByStatus(status);
        }
    }

    public Projeto adicionaParticipantes(String idProjeto, String cpfParticipante) {

        ResponseEntity<RetornarGerenteDTO> gerente = gerenteService.getGerente(cpfParticipante);

        if (gerente.getStatusCode().is2xxSuccessful()) {
            Optional<Projeto> projetoOpt = projetoRepository.findById(idProjeto);
            if (projetoOpt.isEmpty()) {
                throw new ProjetoNaoEncontradoException("Projeto não encontrado");
            }

            Projeto projeto = projetoOpt.get();

            if (projeto.getStatus().equals("FINALIZADO")) {
                throw new RuntimeException("Projeto finalizado");
            } else {
                List<RetornarGerenteDTO> participantes = projeto.getParticipantes();
                participantes.add(gerente.getBody());
                projeto.setParticipantes(participantes);
                return projetoRepository.save(projeto);
            }
        } else {
            throw new GerenteNaoEncontradoException("Gerente não encontrado");
        }
    }
}

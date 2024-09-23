package br.insper.avIntermediaria.projeto;

import br.insper.avIntermediaria.gerente.GerenteNaoEncontradoException;
import br.insper.avIntermediaria.gerente.GerenteService;
import br.insper.avIntermediaria.gerente.RetornarGerenteDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
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
}

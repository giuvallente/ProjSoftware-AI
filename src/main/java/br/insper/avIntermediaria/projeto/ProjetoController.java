package br.insper.avIntermediaria.projeto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/projeto")
public class ProjetoController {

    @Autowired
    private ProjetoService projetoService;

    @PostMapping
    public Projeto salvarProjeto(@RequestBody Projeto projeto) {
        return projetoService.salvar(projeto);
    }

    @GetMapping
    public List<Projeto> listarProjetos(@RequestParam(required = false) String status) {
        return projetoService.listar(status);
    }

    @PutMapping("/{id}/{cpf}")
    public Projeto adicionarParticipantesProjeto(@PathVariable String id, @PathVariable String cpf) {
        return projetoService.adicionaParticipantes(id, cpf);
    }
}

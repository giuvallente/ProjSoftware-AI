package br.insper.avIntermediaria.projeto;

import br.insper.avIntermediaria.gerente.RetornarGerenteDTO;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document
@Getter
@Setter
public class Projeto {

    @Id
    private String id;

    private String nome;

    private String descricao;

    private String status; // PLANEJAMENTO, EXECUCAO e FINALIZADO

    private String responsavel;

    private List<RetornarGerenteDTO> participantes;
}

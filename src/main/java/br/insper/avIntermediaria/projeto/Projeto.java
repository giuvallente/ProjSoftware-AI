package br.insper.avIntermediaria.projeto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

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
}

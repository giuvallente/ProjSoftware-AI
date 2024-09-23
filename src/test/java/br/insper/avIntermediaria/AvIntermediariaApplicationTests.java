package br.insper.avIntermediaria;

import br.insper.avIntermediaria.projeto.ProjetoRepository;
import br.insper.avIntermediaria.projeto.ProjetoService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

@ExtendWith(MockitoExtension.class)
class AvIntermediariaApplicationTests {

	@InjectMocks
	ProjetoService projetoService;

	@Mock
	ProjetoRepository projetoRepository;
}

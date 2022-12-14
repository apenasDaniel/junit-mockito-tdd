package br.ce.wcaquino.servicos;

import java.util.Date;

import org.junit.Assert;
import org.junit.Test;

import br.ce.wcaquino.entidades.Filme;
import br.ce.wcaquino.entidades.Locacao;
import br.ce.wcaquino.entidades.Usuario;
import br.ce.wcaquino.utils.DataUtils;

public class AssertTest {
	
	@Test
	public void teste() {
		
		LocacaoService service = new LocacaoService();
		Usuario usuario = new Usuario("suario 1");
		Filme filme = new Filme("Filme 1", 2, 5.0);
		
		Locacao locacao = service.alugarFilme(usuario, filme);
		
		Assert.assertEquals(5.0, locacao.getValor(), 0.01);
		Assert.assertTrue(DataUtils.isMesmaData(locacao.getDataLocacao(), new Date()));
		Assert.assertTrue(DataUtils.isMesmaData(locacao.getDataRetorno(), DataUtils.obterDataComDiferencaDias(1)));
		
		
	}

}

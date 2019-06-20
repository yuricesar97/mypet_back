package com.yuri.mypet.service;

import java.text.ParseException;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.yuri.mypet.domain.Categoria;
import com.yuri.mypet.domain.PessoaFisica;
import com.yuri.mypet.domain.PessoaJuridica;
import com.yuri.mypet.domain.Produto;
import com.yuri.mypet.domain.enums.Perfil;
import com.yuri.mypet.domain.enums.TipoCliente;
import com.yuri.mypet.repositories.CategoriasRepository;
import com.yuri.mypet.repositories.EnderecoFisicoRepository;
import com.yuri.mypet.repositories.EnderecoJuridicoRepository;
import com.yuri.mypet.repositories.ItemPedidoRepository;
import com.yuri.mypet.repositories.PagamentoRepository;
import com.yuri.mypet.repositories.PedidoRepository;
import com.yuri.mypet.repositories.PessoaFisicaRepository;
import com.yuri.mypet.repositories.PessoaJuridicaRepository;
import com.yuri.mypet.repositories.produtoRepository;

@Service // componente so spring pode ser injetado em outros lugares com o @Autowarid
public class DBService {

	@Autowired
	private CategoriasRepository categoriaRepository;
	@Autowired
	private produtoRepository produtoRepository;

	@Autowired
	private PessoaFisicaRepository clienteRepositoty;
	@Autowired
	private EnderecoFisicoRepository enderecoRepositoty;
	@Autowired
	private EnderecoJuridicoRepository enderecoJuridicoRepository;

	@Autowired
	private PessoaJuridicaRepository pessoaJuridicaRepository;

	@Autowired
	private PedidoRepository pedidoRepository;
	@Autowired
	private PagamentoRepository pagamentoRepository;
	@Autowired
	private ItemPedidoRepository itemPedidoRepository;
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoderEncoder;

	public void instantiateTestDataBase() throws ParseException {

		Categoria cat1 = new Categoria(null, "Informatica");
		Categoria cat2 = new Categoria(null, "Escritorio");
		Categoria cat3 = new Categoria(null, "Cama mesa e banho");
		Categoria cat4 = new Categoria(null, "Eletrônico");
		Categoria cat5 = new Categoria(null, "Jardinagem");
		Categoria cat6 = new Categoria(null, "Deceroção");
		Categoria cat7 = new Categoria(null, "Perfumaria");

		Produto produto1 = new Produto(null, "Computador", 2000.00);
		Produto produto2 = new Produto(null, "Impressora", 800.00);
		Produto produto3 = new Produto(null, "Mouse", 80.00);
		Produto produto4 = new Produto(null, "Mesa de escritório", 300.00);
		Produto produto5 = new Produto(null, "Toalha", 50.00);
		Produto produto6 = new Produto(null, "Colcha", 200.00);
		Produto produto7 = new Produto(null, "TV true color", 1200.00);
		Produto produto8 = new Produto(null, "Roçadeira", 800.00);
		Produto produto9 = new Produto(null, "Abajour", 100.00);
		Produto produto10 = new Produto(null, "Pendente", 180.00);
		Produto produto11 = new Produto(null, "Shampoo", 90.00);

		cat1.getProdutos().addAll(Arrays.asList(produto1, produto2, produto3));
		cat2.getProdutos().addAll(Arrays.asList(produto2, produto4));
		cat3.getProdutos().addAll(Arrays.asList(produto5, produto6));
		cat4.getProdutos().addAll(Arrays.asList(produto1, produto2, produto3, produto7));
		cat5.getProdutos().addAll(Arrays.asList(produto8));
		cat6.getProdutos().addAll(Arrays.asList(produto9, produto10));
		cat7.getProdutos().addAll(Arrays.asList(produto11));

		produto1.getCategorias().addAll(Arrays.asList(cat1, cat4));
		produto2.getCategorias().addAll(Arrays.asList(cat1, cat2, cat4));
		produto3.getCategorias().addAll(Arrays.asList(cat1, cat4));
		produto4.getCategorias().addAll(Arrays.asList(cat2));
		produto5.getCategorias().addAll(Arrays.asList(cat3));
		produto6.getCategorias().addAll(Arrays.asList(cat3));
		produto7.getCategorias().addAll(Arrays.asList(cat4));
		produto8.getCategorias().addAll(Arrays.asList(cat5));
		produto9.getCategorias().addAll(Arrays.asList(cat6));
		produto10.getCategorias().addAll(Arrays.asList(cat6));
		produto11.getCategorias().addAll(Arrays.asList(cat7));

		categoriaRepository.saveAll(Arrays.asList(cat1, cat2, cat3, cat4, cat5, cat6, cat7));
		produtoRepository.saveAll(Arrays.asList(produto1, produto2, produto3, produto4, produto5, produto6, produto7,
				produto8, produto9, produto10, produto11));

		cat1.getProdutos().addAll(Arrays.asList(produto1, produto2, produto3));
		cat2.getProdutos().addAll(Arrays.asList(produto2, produto4));
		cat3.getProdutos().addAll(Arrays.asList(produto5, produto6));
		cat4.getProdutos().addAll(Arrays.asList(produto1, produto2, produto3, produto7));
		cat5.getProdutos().addAll(Arrays.asList(produto8));
		cat6.getProdutos().addAll(Arrays.asList(produto9, produto10));
		cat7.getProdutos().addAll(Arrays.asList(produto11));

		produto1.getCategorias().addAll(Arrays.asList(cat1, cat4));
		produto2.getCategorias().addAll(Arrays.asList(cat1, cat2, cat4));
		produto3.getCategorias().addAll(Arrays.asList(cat1, cat4));
		produto4.getCategorias().addAll(Arrays.asList(cat2));
		produto5.getCategorias().addAll(Arrays.asList(cat3));
		produto6.getCategorias().addAll(Arrays.asList(cat3));
		produto7.getCategorias().addAll(Arrays.asList(cat4));
		produto8.getCategorias().addAll(Arrays.asList(cat5));
		produto9.getCategorias().addAll(Arrays.asList(cat6));
		produto10.getCategorias().addAll(Arrays.asList(cat6));
		produto11.getCategorias().addAll(Arrays.asList(cat7));

		categoriaRepository.saveAll(Arrays.asList(cat1, cat2, cat3, cat4, cat5, cat6, cat7));
		produtoRepository.saveAll(Arrays.asList(produto1, produto2, produto3, produto4, produto5, produto6, produto7,
				produto8, produto9, produto10, produto11));

		PessoaFisica cli1 = new PessoaFisica(null, "maria_silva", "Maria Silva", "yuricesar97@gmail.com", "36378912377",
				TipoCliente.PESSOAFISICA, bCryptPasswordEncoderEncoder.encode("123"), null, null, false, "21/04/1997",
				"Rua Flores", "300", "Apto 303", "Pompeia", "38220834", "Santos", null);
		cli1.getTelefones().addAll(Arrays.asList("27363323", "938393"));

		PessoaFisica cli2 = new PessoaFisica(null, "antonio_nunes", "Antonio Nunes", "antonio@gmail.com", "36378912377",
				TipoCliente.PESSOAFISICA, bCryptPasswordEncoderEncoder.encode("123"), null, null, false, "21/04/1997",
				"Rua Flores", "300", "Apto 303", "Chácaras São Paulo", "38220834", "Franca", null);
		cli1.getTelefones().addAll(Arrays.asList("27363323", "938393"));

		PessoaFisica cli3 = new PessoaFisica(null, "juliana_aparecida", "Juliana Aparecida", "juliana@gmail.com",
				"36378912377", TipoCliente.PESSOAFISICA, bCryptPasswordEncoderEncoder.encode("123"), null, null, false,
				"21/04/1997", "Rua Flores", "300", "Apto 303", "Colônia", "38220834", "Jundiaí", null);
		cli3.getTelefones().addAll(Arrays.asList("27363323", "938393"));

		PessoaFisica cli4 = new PessoaFisica(null, "fabiola_marcondes", "Fabiola Marcondes", "fabiola@gmail.com",
				"36378912377", TipoCliente.PESSOAFISICA, bCryptPasswordEncoderEncoder.encode("123"), null, null, false,
				"21/04/1997", "Rua Flores", "300", "Apto 303", "Centro", "38220834", "Campinas", null);
		cli4.getTelefones().addAll(Arrays.asList("27363323", "938393"));

		PessoaFisica cli5 = new PessoaFisica(null, "marina_david", "Marina David", "marina@gmail.com", "36378912377",
				TipoCliente.PESSOAFISICA, bCryptPasswordEncoderEncoder.encode("123"), null, null, false, "21/04/1997",
				"Rua Flores", "300", "Apto 303", "Bela vista", "38220834", "Bauru", null);
		cli5.getTelefones().addAll(Arrays.asList("27363323", "938393"));

		PessoaFisica cli6 = new PessoaFisica(null, "ana_costa", "Ana Costa", "ana@gmail.com", "36378912377",
				TipoCliente.PESSOAFISICA, bCryptPasswordEncoderEncoder.encode("321"), null, null, false, null,
				"Avenida Matos", "105", "Sala 800", "Alegre", "38777012", "Holambra", null);
		cli6.addPerfil(Perfil.ADMIN);
		cli2.getTelefones().addAll(Arrays.asList("23363323", "938388893"));

		// EnderecoFisico e1 = new EnderecoFisico(null, "Rua Flores", "300", "Apto 303",
		// "Jardim", "38220834", "Arraras",null, cli1 );
		// EnderecoFisico e2 = new EnderecoFisico(null, "Avenida Matos", "105", "Sala
		// 800", "Centro", "38777012", "Ponte",null,cli1);
		// EnderecoFisico e3 = new EnderecoFisico(null, "Avenida Floriano", "206", null,
		// "Campinas", "38777012", "Campinas", null,cli2);

		// cli1.getEndereço().addAll(Arrays.asList(e1,e2)); //cliente conhecendo seu
		// endereços
		// cli2.getEndereço().addAll(Arrays.asList(e3));

		clienteRepositoty.saveAll(Arrays.asList(cli1, cli2, cli3, cli4, cli5, cli6));
		// enderecoRepositoty.saveAll(Arrays.asList(e1,e2,e3));

		PessoaJuridica ju1 = new PessoaJuridica(null, "Mydog", "dog@gmail.com", "123456", TipoCliente.PESSOAJURIDICA,
				bCryptPasswordEncoderEncoder.encode("321"), null, null, "Somos o profisional que o seu animal precisa",
				null, null, null, false, false, false, false, false, false, false, false, false, false, false, true,
				false, false, false, false, "Rua Flores", "300", "Apto 303", "Pompeia", "38220834", "Santos", null);
		PessoaJuridica ju2 = new PessoaJuridica(null, "MyCia", "cia@gmail.com", "123456", TipoCliente.PESSOAJURIDICA,
				bCryptPasswordEncoderEncoder.encode("321"), null, null,
				"Temos todo o cuidado com seu animal, hospital 24 horas", null, null, null, false, false, false, false,
				false, false, false, false, false, false, false, true, false, false, false, false, "Rua dolores", "300",
				"Apto 303", "Chácaras São Paulo", "38220834", "Franca", null);
		PessoaJuridica ju3 = new PessoaJuridica(null, "MyVet", "vet@gmail.com", "123456", TipoCliente.PESSOAJURIDICA,
				bCryptPasswordEncoderEncoder.encode("321"), null, null,
				"Cuidando do seu pet onde você estiver, qualidade e segurança", null, null, null, false, false, false,
				false, false, false, false, false, false, false, true, false, false, false, false, false, "Rua gilda",
				"300", "Apto 303", "Rua Flores", "38220834", "Bauru", null);
		PessoaJuridica ju13 = new PessoaJuridica(null, "MyCat", "cat@gmail.com", "123456", TipoCliente.PESSOAJURIDICA,
				bCryptPasswordEncoderEncoder.encode("321"), null, null,
				"Cuidando do seu gato onde você estiver, qualidade e segurança", null, null, null, false, false, false,
				false, false, false, false, false, false, false, true, false, false, false, false, false, "Rua gilda",
				"300", "Apto 303", "Rua Flores", "38220834", "Sumaré", null);

		PessoaJuridica ju4 = new PessoaJuridica(null, "Petz", "petz@gmail.com", "123456", TipoCliente.PESSOAJURIDICA,
				bCryptPasswordEncoderEncoder.encode("321"), null, "Temos sempre pomoções que favorecem o seu pet", null,
				null, null, null, false, false, false, false, false, false, false, false, false, false, false, false,
				false, false, true, false, "Rua Flores", "300", "Apto 303", "Pompeia", "38220834", "Marília", null);
		PessoaJuridica ju5 = new PessoaJuridica(null, "	ClubPet", "club@gmail.com", "123456",
				TipoCliente.PESSOAJURIDICA, bCryptPasswordEncoderEncoder.encode("321"), null, "Realizamos banho e tosa",
				null, null, null, null, false, false, false, false, false, false, false, false, false, false, false,
				false, false, false, true, false, "Rua dolores", "300", "Apto 303", "Chácaras São Paulo", "38220834",
				"Franca", null);
		PessoaJuridica ju6 = new PessoaJuridica(null, "CaninPet", "canin@gmail.com", "123456",
				TipoCliente.PESSOAJURIDICA, bCryptPasswordEncoderEncoder.encode("321"), null,
				"No mes de julho 30% de desconto em toda area dos pets", null, null, null, null, false, false, false,
				false, false, false, false, false, false, false, false, false, false, false, true, false, "Rua gilda",
				"300", "Apto 303", "Rua Flores", "38220834", "Cotia", null);
		PessoaJuridica ju14 = new PessoaJuridica(null, "Cat&Pet", "cat&pet@gmail.com", "123456",
				TipoCliente.PESSOAJURIDICA, bCryptPasswordEncoderEncoder.encode("321"), null,
				"No mes de agosto 30% de desconto em toda area dos pets", null, null, null, null, false, false, false,
				false, false, false, false, false, false, false, false, false, false, false, true, false, "Rua gilda",
				"300", "Apto 303", "Rua Flores", "38220834", "Barueri", null);

		PessoaJuridica ju7 = new PessoaJuridica(null, "	homePet", "home@gmail.com", "123456",
				TipoCliente.PESSOAJURIDICA, bCryptPasswordEncoderEncoder.encode("321"), null, null, null,
				"Temos acomodações para seus animais", null, null, false, false, false, false, false, false, false,
				false, false, false, false, false, false, true, false, false, "Rua Flores", "300", "Apto 303",
				"Pompeia", "38220834", "Santo André", null);
		PessoaJuridica ju8 = new PessoaJuridica(null, "	housePet", "house@gmail.com", "123456",
				TipoCliente.PESSOAJURIDICA, bCryptPasswordEncoderEncoder.encode("321"), null, null, null,
				"Segurança, comodida junto com viagem tranquila", null, null, false, false, false, false, false, false,
				false, false, false, false, false, false, false, true, false, false, "Rua dolores", "300", "Apto 303",
				"Chácaras São Paulo", "38220834", "Limeira", null);
		PessoaJuridica ju9 = new PessoaJuridica(null, "	plusPet", "plus@gmail.com", "123456",
				TipoCliente.PESSOAJURIDICA, bCryptPasswordEncoderEncoder.encode("321"), null, null, null,
				"Viage sem preocupação, temos tudo que seus animais precisa", null, null, false, false, false, false,
				false, false, false, false, false, false, false, false, false, true, false, false, "Rua dolores", "300",
				"Apto 303", "Chácaras São Paulo", "38220834", "Taboão da Serra", null);
		PessoaJuridica ju15 = new PessoaJuridica(null, "	Pet", "pet@gmail.com", "123456", TipoCliente.PESSOAJURIDICA,
				bCryptPasswordEncoderEncoder.encode("321"), null, null, null,
				"Viage sem preocupação, temos tudo que seus animais precisa, comodida e segurança", null, null, false,
				false, false, false, false, false, false, false, false, false, false, false, false, false, true, false,
				"Rua dolores", "300", "Apto 303", "Chácaras São Paulo", "38220834", "Americana", null);

		PessoaJuridica ju10 = new PessoaJuridica(null, "	juli", "juli@gmail.com", "123456",
				TipoCliente.PESSOAJURIDICA, bCryptPasswordEncoderEncoder.encode("321"), null, null, null, null,
				"Tenho 2 cachorros", null, false, false, false, false, false, false, false, false, false, false, false,
				false, true, false, false, false, "Rua Flores", "300", "Apto 303", "Pompeia", "38220834", "Diadema",
				null);
		PessoaJuridica ju11 = new PessoaJuridica(null, "	debi", "debi@gmail.com", "123456",
				TipoCliente.PESSOAJURIDICA, bCryptPasswordEncoderEncoder.encode("321"), null, null, null, null,
				"Adoto animais ", null, false, false, false, false, false, false, false, false, false, false, false,
				false, true, false, false, false, "Rua dolores", "300", "Apto 303", "Chácaras São Paulo", "38220834",
				"Mogi das Cruzes", null);
		PessoaJuridica ju12 = new PessoaJuridica(null, "	cats", "cats@gmail.com", "123456",
				TipoCliente.PESSOAJURIDICA, bCryptPasswordEncoderEncoder.encode("321"), null, null, null, null,
				"Tenhos 4 gatos, quero mais um", null, false, false, false, false, false, false, false, false, false,
				false, true, false, false, false, false, false, "Rua dolores", "300", "Apto 303", "Chácaras São Paulo",
				"38220834", "Osasco", null);

		// PessoaJuridica t = new PessoaJuridica(id, razaoSocial, email, cnpj,
		// tipoPerfil, senha, fotoPerfil, descricaoPetShop, descricaoPetVet,
		// descricaoPetHome, descricaoPetClient, situacaoAprovacao, farmacia, banho,
		// tosa, loja, vacinacao, consulta, exames, apartamento, casa, fumante, telado,
		// petVet, petClient, petHome, petShop, checkStatus, logradouro, numero,
		// complemento, bairro, cep, cidade, estado)

		// EnderecoJuridico end1 = new EnderecoJuridico(null, "Rua Flores", "300", "Apto
		// 303", "Jardim", "38220834", "Arraras",null, ju );

		pessoaJuridicaRepository.saveAll(
				Arrays.asList(ju1, ju2, ju3, ju4, ju5, ju6, ju7, ju8, ju9, ju10, ju11, ju12, ju13, ju14, ju15));
		/**
		 * 
		 * enderecoJuridicoRepository.saveAll(Arrays.asList(end1));
		 * 
		 * 
		 * SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyy HH:mm"); /// para
		 * formatação de data e hora
		 * 
		 * Pedido ped1 = new Pedido(null, sdf.parse("30/09/2017 10:32 "), cli1, e1);
		 * Pedido ped2 = new Pedido(null, sdf.parse("10/10/2017 19:35 "), cli1, e2); /
		 * 
		 * Pagamento pgto1 = new PagamentoComCartao(null, EstadoPagamento.QUITADO, ped1,
		 * 6); ped1.setPagamento(pgto1);
		 * 
		 * 
		 * Pagamento pgto2 = new PagamentoComBoleto(null, EstadoPagamento.PENDENTE,
		 * ped2, sdf.parse("20/10/2017 00:00"), null); ped2.setPagamento(pgto2);
		 * 
		 * cli1.getPedidos().addAll(Arrays.asList(ped1,ped2));
		 * 
		 * 
		 * pedidoRepository.saveAll(Arrays.asList(ped1,ped2));
		 * pagamentoRepository.saveAll(Arrays.asList(pgto1,pgto2));
		 * 
		 * 
		 * ItemPedido ip1 = new ItemPedido(ped1, produto1, 0.00, 1, 2000.00); ItemPedido
		 * ip2 = new ItemPedido(ped1, produto3, 0.00, 2, 80.00); ItemPedido ip3 = new
		 * ItemPedido(ped2, produto2, 100.00, 1, 800.00);
		 * 
		 * ped1.getItens().addAll(Arrays.asList(ip1,ip2));
		 * ped2.getItens().addAll(Arrays.asList(ip3));
		 * 
		 * produto1.getItens().addAll(Arrays.asList(ip1));
		 * produto2.getItens().addAll(Arrays.asList(ip3));
		 * produto3.getItens().addAll(Arrays.asList(ip2));
		 * 
		 * itemPedidoRepository.saveAll(Arrays.asList(ip1,ip2,ip3));
		 */
	}

	// EnderecoFisico e1 = new EnderecoFisico(null, "Rua Flores", "300", "Apto 303",
	// "Jardim", "38220834", "Arraras",null, cli1 );
	// EnderecoFisico e2 = new EnderecoFisico(null, "Avenida Matos", "105", "Sala
	// 800", "Centro", "38777012", "Ponte",null,cli1);
	// EnderecoFisico e3 = new EnderecoFisico(null, "Avenida Floriano", "206", null,
	// "Campinas", "38777012", "Campinas", null,cli2);

	// cli1.getEndereço().addAll(Arrays.asList(e1,e2)); //cliente conhecendo seu
	// endereços
	// cli2.getEndereço().addAll(Arrays.asList(e3));

	// enderecoRepositoty.saveAll(Arrays.asList(e1,e2,e3));

	/**
	 * 
	 * enderecoJuridicoRepository.saveAll(Arrays.asList(end1));
	 * 
	 * 
	 * SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyy HH:mm"); /// para
	 * formatação de data e hora
	 * 
	 * Pedido ped1 = new Pedido(null, sdf.parse("30/09/2017 10:32 "), cli1, e1);
	 * Pedido ped2 = new Pedido(null, sdf.parse("10/10/2017 19:35 "), cli1, e2); /
	 * 
	 * Pagamento pgto1 = new PagamentoComCartao(null, EstadoPagamento.QUITADO, ped1,
	 * 6); ped1.setPagamento(pgto1);
	 * 
	 * 
	 * Pagamento pgto2 = new PagamentoComBoleto(null, EstadoPagamento.PENDENTE,
	 * ped2, sdf.parse("20/10/2017 00:00"), null); ped2.setPagamento(pgto2);
	 * 
	 * cli1.getPedidos().addAll(Arrays.asList(ped1,ped2));
	 * 
	 * 
	 * pedidoRepository.saveAll(Arrays.asList(ped1,ped2));
	 * pagamentoRepository.saveAll(Arrays.asList(pgto1,pgto2));
	 * 
	 * 
	 * ItemPedido ip1 = new ItemPedido(ped1, produto1, 0.00, 1, 2000.00); ItemPedido
	 * ip2 = new ItemPedido(ped1, produto3, 0.00, 2, 80.00); ItemPedido ip3 = new
	 * ItemPedido(ped2, produto2, 100.00, 1, 800.00);
	 * 
	 * ped1.getItens().addAll(Arrays.asList(ip1,ip2));
	 * ped2.getItens().addAll(Arrays.asList(ip3));
	 * 
	 * produto1.getItens().addAll(Arrays.asList(ip1));
	 * produto2.getItens().addAll(Arrays.asList(ip3));
	 * produto3.getItens().addAll(Arrays.asList(ip2));
	 * 
	 * itemPedidoRepository.saveAll(Arrays.asList(ip1,ip2,ip3));
	 */
}

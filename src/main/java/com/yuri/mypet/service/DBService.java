package com.yuri.mypet.service;

import java.text.ParseException;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.yuri.mypet.domain.Categoria;

import com.yuri.mypet.domain.PetClient;
import com.yuri.mypet.domain.PetProvider;
import com.yuri.mypet.domain.Produto;
import com.yuri.mypet.domain.enums.Perfil;
import com.yuri.mypet.domain.enums.TipoCliente;
import com.yuri.mypet.repositories.CategoriasRepository;
import com.yuri.mypet.repositories.EnderecoFisicoRepository;
import com.yuri.mypet.repositories.EnderecoJuridicoRepository;
import com.yuri.mypet.repositories.ItemPedidoRepository;
import com.yuri.mypet.repositories.PagamentoRepository;
import com.yuri.mypet.repositories.PedidoRepository;


import com.yuri.mypet.repositories.PetClientRepository;
import com.yuri.mypet.repositories.PetProviderRepository;
import com.yuri.mypet.repositories.produtoRepository;

@Service // componente so spring pode ser injetado em outros lugares com o @Autowarid
public class DBService {

	@Autowired
	private CategoriasRepository categoriaRepository;
	@Autowired
	private produtoRepository produtoRepository;

	@Autowired
	private PetClientRepository petClientRepository;
	@Autowired
	private EnderecoFisicoRepository enderecoRepositoty;
	@Autowired
	private EnderecoJuridicoRepository enderecoJuridicoRepository;

	@Autowired
	private PetProviderRepository petProviderRepository;

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

				PetClient cli1 = new PetClient(null, "maria_silva", "Maria Silva", "yuricesar97@gmail.com", "36378912377",
				TipoCliente.PESSOAFISICA, bCryptPasswordEncoderEncoder.encode("123"), null, null, "21/04/1997",
				"Rua Flores", "300", "Apto 303", "Pompeia", "38220834", "Santos", null);
		cli1.getTelefones().addAll(Arrays.asList("27363323", "938393"));

		PetClient cli2 = new PetClient(null, "antonio_nunes", "Antonio Nunes", "antonio@gmail.com", "36378912377",
				TipoCliente.PESSOAFISICA, bCryptPasswordEncoderEncoder.encode("123"), null, null, "21/04/1997",
				"Rua Flores", "300", "Apto 303", "Chácaras São Paulo", "38220834", "Franca", null);
		cli1.getTelefones().addAll(Arrays.asList("27363323", "938393"));
			cli2.addPerfil(Perfil.ADMIN);
			
		PetClient cli3 = new PetClient(null, "juliana_aparecida", "Juliana Aparecida", "juliana@gmail.com",
				"36378912377", TipoCliente.PESSOAFISICA, bCryptPasswordEncoderEncoder.encode("123"), null, null, 
				"21/04/1997", "Rua Flores", "300", "Apto 303", "Colônia", "38220834", "Jundiaí", null);
		cli3.getTelefones().addAll(Arrays.asList("27363323", "938393"));

		PetClient cli4 = new PetClient(null, "fabiola_marcondes", "Fabiola Marcondes", "fabiola@gmail.com",
				"36378912377", TipoCliente.PESSOAFISICA, bCryptPasswordEncoderEncoder.encode("123"), null, null, 
				"21/04/1997", "Rua Flores", "300", "Apto 303", "Centro", "38220834", "Campinas", null);
		cli4.getTelefones().addAll(Arrays.asList("27363323", "938393"));

		PetClient cli5 = new PetClient(null, "marina_david", "Marina David", "marina@gmail.com", "36378912377",
				TipoCliente.PESSOAFISICA, bCryptPasswordEncoderEncoder.encode("123"), null, null,  "21/04/1997",
				"Rua Flores", "300", "Apto 303", "Bela vista", "38220834", "Bauru", null);
		cli5.getTelefones().addAll(Arrays.asList("27363323", "938393"));

		PetClient cli6 = new PetClient(null, "ana_costa", "Ana Costa", "ana@gmail.com", "36378912377",
				TipoCliente.PESSOAFISICA, bCryptPasswordEncoderEncoder.encode("321"), null, null, null,
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

		petClientRepository.saveAll(Arrays.asList(cli1, cli2, cli3, cli4, cli5, cli6));
		// enderecoRepositoty.saveAll(Arrays.asList(e1,e2,e3));

		PetProvider ju1 = new PetProvider(null, "Mydog", "dog@gmail.com", "123456", TipoCliente.PESSOAJURIDICA,
				bCryptPasswordEncoderEncoder.encode("321"), null,
				"Busca facilitar a vida dos tutores, oferecendo ração, veterinário, banho & tosa e acessórios em um só lugar.",
				 null, null, false, false, false, false, false, false, false, false, false, false, false,
				true, false, false, false, false, "Rua Flores", "300", "Apto 303", "Pompeia", "38220834", "Dom Pedro",
				"Maranhão (MA)");
				ju1.addPerfil(Perfil.ADMIN);

				PetProvider ju2 = new PetProvider(null, "PersonalPet", "personal@gmail.com", "123456",
				TipoCliente.PESSOAJURIDICA, bCryptPasswordEncoderEncoder.encode("321"), null,
				"Personal Pet  surgiu do nosso amor , paixão aos animais e o pensamento de melhorar a qualidade de vida dos cães , bem estar da família e sociedade",
				  null, null, false, false, false, false, false, false, false, false, false, false, false,
				true, false, false, false, false, "Rua dolores", "300", "Apto 303", "Chácaras São Paulo", "38220834",
				"Abreu e Lima", "Pernambuco (PE)");

				PetProvider ju3 = new PetProvider(null, "Carloss", "p@gmail.com", "123456", TipoCliente.PESSOAJURIDICA,
				bCryptPasswordEncoderEncoder.encode("321"), null,
				"Sou o Carlos, tenho 54 anos e sou cuidador e passeador de cachorros e gatos!", null, null,
				false, false, false, false, false, false, false, false, false, false, false, true, false, false, false,
				false, "Rua dolores", "300", "Apto 303", "Chácaras São Paulo", "38220834", "Agua Preta",
				"Pernambuco (PE)");

				PetProvider ju13 = new PetProvider(null, "Homeopet", "homeopet@gmail.com", "123456",
				TipoCliente.PESSOAJURIDICA, bCryptPasswordEncoderEncoder.encode("321"), null,
				"Com décadas de experiência, a Homeo Pet possui uma completa linha de homeopatia veterinária para cuidar da saúde do seu bichinho evitando medicações alopáticas e ampliando o bem-estar.",
				 null, null, false, false, false, false, false, false, false, false, false, false, true,
				false, false, false, false, false, "Rua gilda", "300", "Apto 303", "Rua Flores", "38220834", "Altinho",
				"Pernambuco (PE)");

				PetProvider ju4 = new PetProvider(null, "Petz", "petz@gmail.com", "123456", TipoCliente.PESSOAJURIDICA,
				bCryptPasswordEncoderEncoder.encode("321"), null,
				"Cada dia mais moderna e equipada nossa clínica veterinária oferece: exames, tratamentos, cirurgias e serviços diferenciados.",
				 null, null, false, false, false, false, false, false, false, false, false, false, false,
				false, false, false, true, false, "Rua Flores", "300", "Apto 303", "Pompeia", "38220834", "Marília",
				"São Paulo (SP)");

				PetProvider ju5 = new PetProvider(null, "	ClubPet", "club@gmail.com", "123456",
				TipoCliente.PESSOAJURIDICA, bCryptPasswordEncoderEncoder.encode("321"), null,
				"O banho e tosa foi construído para que o seu Pet esteja em um ambiente confortável,   com cuidados e carinho",
				 null, null, false, false, false, false, false, false, false, false, false, false, false,
				false, false, false, true, false, "Rua dolores", "300", "Apto 303", "Chácaras São Paulo", "38220834",
				"campinas", "São Paulo (SP)");

				PetProvider ju6 = new PetProvider(null, "CaninPet", "canin@gmail.com", "123456",
				TipoCliente.PESSOAJURIDICA, bCryptPasswordEncoderEncoder.encode("321"), null,
				"Encontre os produtos certos para seu bichinho de estimação: rações, brinquedos, acessórios e muitos outros itens para ele.",
				 null, null, false, false, false, false, false, false, false, false, false, false, false,
				false, false, false, true, false, "Rua gilda", "300", "Apto 303", "Rua Flores", "38220834", "Sapucaia",
				"Rio de Janeiro (RJ)");

				PetProvider ju14 = new PetProvider(null, "HotelPet", "hotel@pet@gmail.com", "123456",
				TipoCliente.PESSOAJURIDICA, bCryptPasswordEncoderEncoder.encode("321"), null,
				"O hotelzinho que seu cachorro merece é um lar: com um herói que cuida com amor e mantém a rotina dele como em casa",
				 null, null, false, false, false, false, false, false, false, false, false, false, false,
				false, false, false, true, false, "Rua gilda", "300", "Apto 303", "Rua Flores", "38220834",
				"Barro Preto", "Bahia (BA)");

				PetProvider ju7 = new PetProvider(null, "	LarTemporario", "lartemp@gmail.com", "123456",
				TipoCliente.PESSOAJURIDICA, bCryptPasswordEncoderEncoder.encode("321"), null,
				"Oferecemos nosso espaço até que eles sejam doados por um preço bem mais em conta do que um cão/gato que esteja hospedado em nosso hotel.",
				 null, null, false, false, false, false, false, false, false, false, false, false, false,
				false, false, true, false, false, "Rua Flores", "300", "Apto 303", "Pompeia", "38220834", "Bonito",
				"Bahia (BA)");

				PetProvider ju8 = new PetProvider(null, "LarPermanente", "larper@gmail.com", "123456",
				TipoCliente.PESSOAJURIDICA, bCryptPasswordEncoderEncoder.encode("321"), null,
				"Esse tipo de hospedagem nada mais é do que a guarda compartilhada do seu animalzinho com um preço bem mais em conta do que uma hospedagem normal de um animal de férias no hotel.",
				 null, null, false, false, false, false, false, false, false, false, false, false, false,
				false, false, true, false, false, "Rua dolores", "300", "Apto 303", "Chácaras São Paulo", "38220834",
				"Alfenas", "Minas Gerais (MG)");

				PetProvider ju9 = new PetProvider(null, "	plusPet", "plus@gmail.com", "123456",
				TipoCliente.PESSOAJURIDICA, bCryptPasswordEncoderEncoder.encode("321"), null,
				"No mes de julho 30% de desconto em toda area dos pets", null, null, false, false, false,
				false, false, false, false, false, false, false, false, false, false, true, false, false, "Rua dolores",
				"300", "Apto 303", "Chácaras São Paulo", "38220834", "Abre Campo", "Minas Gerais (MG)");

				PetProvider ju15 = new PetProvider(null, "PetPlus", "pett@gmail.com", "123456",
				TipoCliente.PESSOAJURIDICA, bCryptPasswordEncoderEncoder.encode("321"), null,
				"Assim como é natural que as crianças tenham acompanhamento pediátrico, os pets também precisam de um médico de confiança. As visitas ao médico veterinário devem ser parte da rotina de saúde do pet.",
				 null, null, false, false, false, false, false, false, false, false, false, false, false,
				false, false, false, true, false, "Rua dolores", "300", "Apto 303", "Chácaras São Paulo", "38220834",
				"Mangaratiba", "Rio de Janeiro (RJ)");

				PetProvider ju10 = new PetProvider(null, "juli", "juli@gmail.com", "123456", TipoCliente.PESSOAJURIDICA,
				bCryptPasswordEncoderEncoder.encode("321"), null,
				"O passeio é uma das atividades mais importantes na vida de qualquer cachorro. Além de propiciar uma melhora em sua saúde e bem estar, o passeio é uma forma do cachorro manter sua mente em atividade.",
				 null, null, false, false, false, false, false, false, false, false, false, false, false,
				false, true, false, false, false, "Rua Flores", "300", "Apto 303", "Pompeia", "38220834", "Niteroi",
				"Rio de Janeiro (RJ)");

				PetProvider ju11 = new PetProvider(null, "DomicilioVet", "domiciovet@gmail.com", "123456",
				TipoCliente.PESSOAJURIDICA, bCryptPasswordEncoderEncoder.encode("321"), null,
				"Os cuidados com os animais devem ser constantes, e quem tem um amigo de quatro patas sabe o quão importante são as visitas ao veterinário e a manutenção da saúde dos pets. Com isso em foco, o mercado super aquecido dos cachorros e gatos.",
				 null, null, false, false, false, false, false, false, false, false, false, false, false,
				false, true, false, false, false, "Rua dolores", "300", "Apto 303", "Chácaras São Paulo", "38220834",
				"Mogi das Cruzes", "São Paulo (SP)");

				PetProvider ju12 = new PetProvider(null, "Health", "health@gmail.com", "123456",
				TipoCliente.PESSOAJURIDICA, bCryptPasswordEncoderEncoder.encode("321"), null,
				"Os bichinhos de estimação já são parte da família, né? Tem quem use apelidos carinhosos para falar com eles, quem chame de filho ou filha... é muito amor envolvido! E, como diz a música, quem ama cuida! É aqui que entra a Health for Pet.",
				 null, null, false, false, false, false, false, false, false, false, false, false, true,
				false, false, false, false, false, "Rua dolores", "300", "Apto 303", "Chácaras São Paulo", "38220834",
				"Osasco", "São Paulo (SP)");
				PetProvider forneAdmin = new PetProvider(null, "Cobasi", "admin@admin.com", "60177020000164",
				TipoCliente.PESSOAJURIDICA, bCryptPasswordEncoderEncoder.encode("123"), null,
				"Loja referência no mercado dos Petshops. Inaugurada em 14 de outubro de 1985, a Cobasi é consierado um shopping dos animais domésticos.",
				 null, null, false, false, false, false, false, false, false, false, false, false, true,
				false, false, false, false, false, "Rua Álvaro Alves Fussi", "10", "Small mall",
				"Jardim Botânico (Sousas)", "13106252", "Campinas", "SP");

		// PessoaJuridica t = new PessoaJuridica(id, razaoSocial, email, cnpj,
		// tipoPerfil, senha, fotoPerfil, descricaoPetShop, descricaoPetVet,
		// descricaoPetHome, descricaoPetClient, situacaoAprovacao, farmacia, banho,
		// tosa, loja, vacinacao, consulta, exames, apartamento, casa, fumante, telado,
		// petVet, petClient, petHome, petShop, checkStatus, logradouro, numero,
		// complemento, bairro, cep, cidade, estado)

		// EnderecoJuridico end1 = new EnderecoJuridico(null, "Rua Flores", "300", "Apto
		// 303", "Jardim", "38220834", "Arraras",null, ju );

		petProviderRepository.saveAll(Arrays.asList(ju1, ju2, ju3, ju4, ju13, ju5, ju6, ju7, ju8, ju9, ju10, ju11,
				ju12, ju14, ju15, forneAdmin));
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
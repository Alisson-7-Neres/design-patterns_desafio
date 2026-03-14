package one.digitalInnovation.gof.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import one.digitalInnovation.gof.model.Cliente;
import one.digitalInnovation.gof.model.ClienteRepository;
import one.digitalInnovation.gof.model.Endereco;
import one.digitalInnovation.gof.model.EnderecoRepository;
import one.digitalInnovation.gof.service.ClienteService;
import one.digitalInnovation.gof.service.ViaCepService;


/**
 * Implementação da <b>Strategy</b> {@link ClienteService}, a qual pode ser
 * injetada pelo Spring (via {@link Autowired}). Com isso, como essa classe é um
 * {@link Service}, ela será tratada como um <b>Singleton</b>.
 * 
 */
@Service
public class ClienteServiceImpl implements ClienteService {

	// Singleton: Injetar os componentes do Spring com @Autowired.
	@Autowired
	private ClienteRepository clienteRepository;
	@Autowired
	private EnderecoRepository enderecoRepository;
	@Autowired
	private ViaCepService viaCepService;
	
	// Strategy: Implementar os métodos definidos na interface.
	// Facade: Abstrair integrações com subsistemas, provendo uma interface simples.

	@Override
	public Iterable<Cliente> buscarTodos() {
		// Buscar todos os Clientes.
		return clienteRepository.findAll();
	}

	@Override
	public Cliente buscarPorId(Long id) {
		// Buscar Cliente por ID.
		clienteCadastrado(id);
		Optional<Cliente> cliente = clienteRepository.findById(id);
		return cliente.get();
	}

	@Override
	public void inserir(Cliente cliente) {
		salvarClienteComCep(cliente);
	}

	@Override
	public void atualizar(Long id, Cliente cliente) {
		// Buscar Cliente por ID, caso exista:
		clienteCadastrado(id);
		salvarClienteComCep(cliente);
	}

	@Override
	public void deletar(Long id) {
		// Deletar Cliente por ID.
			clienteCadastrado(id);
			clienteRepository.deleteById(id);
	}
	
	private void clienteCadastrado(Long id) {
		// Válidando se o id existe
	    clienteRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("Cliente inexistente!"));
	}

	private void salvarClienteComCep(Cliente cliente) {
		// Verificar se o Endereco do Cliente já existe (pelo CEP).
		String cep = cliente.getEndereco().getCep();
		Endereco endereco = enderecoRepository.findById(cep).orElseGet(() -> {
			// Caso não exista, integrar com o ViaCEP e persistir o retorno.
			Endereco novoEndereco = viaCepService.consultarCep(cep);
			enderecoRepository.save(novoEndereco);
			return novoEndereco;
		});
		cliente.setEndereco(endereco);
		// Inserir Cliente, vinculando o Endereco (novo ou existente).
		clienteRepository.save(cliente);
	}

}
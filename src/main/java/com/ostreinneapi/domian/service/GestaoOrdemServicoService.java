package com.ostreinneapi.domian.service;

import java.time.OffsetDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ostreinneapi.domian.exceprion.EntidadeNaoEncontradaException;
import com.ostreinneapi.domian.exceprion.NegocioException;
import com.ostreinneapi.domian.model.Cliente;
import com.ostreinneapi.domian.model.Comentario;
import com.ostreinneapi.domian.model.OrdemServico;
import com.ostreinneapi.domian.model.StatusOrdemServico;
import com.ostreinneapi.domian.repository.ClienteRepository;
import com.ostreinneapi.domian.repository.ComentarioRepository;
import com.ostreinneapi.domian.repository.OrdemServicoRepository;

@Service
public class GestaoOrdemServicoService {

	@Autowired
	private OrdemServicoRepository ordemServicoRepository;
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
	private ComentarioRepository comentarioRepository;
	
	public OrdemServico criar(OrdemServico ordemServico) {
		System.out.println(ordemServico.getCliente().getId());
		Cliente cliente = clienteRepository.findById(ordemServico.getCliente().getId())
				.orElseThrow (() -> new NegocioException("Cliente não encontrado"));
		
		ordemServico.setCliente(cliente);
		ordemServico.setStatus(StatusOrdemServico.ABERTA);
		ordemServico.setDataAbertura(OffsetDateTime.now());
		return ordemServicoRepository.save(ordemServico);
	}
	
	public void finalizar(Long ordemServicoId) {
		OrdemServico ordemServico = buscar(ordemServicoId);

		ordemServico.finalizar();
		
		ordemServicoRepository.save(ordemServico);
	}
	
	public Comentario adicionarComentario(Long ordemServicoId, String descricao) {
		OrdemServico ordemServico = buscar(ordemServicoId);
		
		Comentario comentario = new Comentario();
		comentario.setDataEnvio(OffsetDateTime.now());
		comentario.setDescricao(descricao);
		comentario.setOrdemServico(ordemServico);		
		return comentarioRepository.save(comentario);
	}
	
	private OrdemServico buscar(Long ordemServicoId) {
		return ordemServicoRepository.findById(ordemServicoId)
				.orElseThrow(()-> new EntidadeNaoEncontradaException("Ordem de  Servico não encontrada "));
	}
	
}

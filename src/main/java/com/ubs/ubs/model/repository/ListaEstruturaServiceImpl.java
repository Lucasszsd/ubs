package com.ubs.ubs.model.repository;

import com.ubs.ubs.model.domain.Consultas;
import com.ubs.ubs.model.domain.Medico;
import com.ubs.ubs.model.domain.OperacaoListaEstrutura;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Queue;


@Service
public class ListaEstruturaServiceImpl implements ListaEstruturaService {

    private ListaEstruturaRepository listaEstruturaRepository;
    private ConsultasRepository consultaRepository;
    private PacienteRepository pacienteRepository;

    private MedicoRepository medicoRepository;
    @Autowired
    public ListaEstruturaServiceImpl(ListaEstruturaRepository listaEstruturaRepository, ConsultasRepository consultaRepository) {
        this.listaEstruturaRepository = listaEstruturaRepository;
        this.consultaRepository = consultaRepository;
    }

    @Override
    public void processarListaEstrutura(Queue<OperacaoListaEstrutura> operacoes) {
        listaEstruturaRepository.processarListaEstrutura(operacoes);
    }

    @Autowired
    public void ListaEstruturaService(ListaEstruturaRepository listaEstruturaRepository, ConsultasRepository consultaRepository) {
        this.listaEstruturaRepository = listaEstruturaRepository;
        this.consultaRepository = consultaRepository;
    }
    @Transactional
    public void processarListaEmLote(Queue<OperacaoListaEstrutura> operacoes) {
        for (OperacaoListaEstrutura operacao : operacoes) {
            if (operacao.getTipoOperacao().equals("agendamento")) {
                // Modifique a lógica de agendamento conforme necessário
                agendarConsulta(operacao.getMedico().getId(), operacao.getPaciente().getId(), operacao.getDataConsulta());
            }
        }
    }


    private <List> void agendarConsulta(Long idMedico, Long idPaciente, Date dataConsulta) {
        // Buscar o médico pelo ID usando um método do seu repositório
        Medico medico = medicoRepository.findById(idMedico).orElse(null);

        if (medico != null) {
            // Verificar se o médico está disponível na data desejada
            List consultasDoMedicoNaData = (List) consultaRepository.findByMedicoAndDataConsulta(medico, dataConsulta);

            if (consultasDoMedicoNaData.equals(null)) {
                // O médico está disponível, então agende a consulta
                Consultas novaConsulta = new Consultas();
                novaConsulta.setMedico(medico);
                // Buscar o paciente pelo ID usando um método do seu repositório
                novaConsulta.setPaciente(pacienteRepository.findById(idPaciente).orElse(null));
                novaConsulta.setDataMarcada(dataConsulta);

                consultaRepository.save(novaConsulta);
            } else {
                System.out.println("Não localizado");
            }
        } else {
            System.out.println("Não localizado");
        }
    }
}

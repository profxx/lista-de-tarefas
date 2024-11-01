package br.com.senai.lista_de_tarefas.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.senai.lista_de_tarefas.entity.Tarefa;
import br.com.senai.lista_de_tarefas.repository.TarefaRepository;

@Service
public class TarefaService {

    @Autowired
    private TarefaRepository tarefaRepository;
    
    public List<Tarefa> findAll(){
        return tarefaRepository.findAll();
    }

    public Tarefa findById(Long id){
        return tarefaRepository.findById(id).orElse(null);
    }

    public Tarefa insertNew(Tarefa tarefa){
        return tarefaRepository.save(tarefa);
    }

    public Tarefa update(Long id, Tarefa tarefa){
        Tarefa tarefaAtual = findById(id);
        tarefaAtual.setNome(tarefa.getNome());
        tarefaAtual.setStatus(tarefa.getStatus());
        return tarefaRepository.save(tarefaAtual);
    }

    public Boolean deleteById(Long id){
        Tarefa tarefa = findById(id);
        if (tarefa == null){
            return false;
        }else{
            tarefaRepository.deleteById(id);
            return true;
        }
    }



}

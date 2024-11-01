package br.com.senai.lista_de_tarefas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.senai.lista_de_tarefas.entity.Tarefa;
import br.com.senai.lista_de_tarefas.service.TarefaService;

@RestController
@RequestMapping("/tarefas")
public class TarefaController {
    
    @Autowired
    private TarefaService tarefaService;

    @GetMapping
    public ResponseEntity<List<Tarefa>> findAll(){
        List<Tarefa> tarefas = tarefaService.findAll();
        return ResponseEntity.ok().body(tarefas);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Tarefa> findById(@PathVariable Long id){
        Tarefa tarefa = tarefaService.findById(id);
        return ResponseEntity.ok().body(tarefa);
    }

    @PostMapping
    public ResponseEntity<Tarefa> insertNew(@RequestBody Tarefa tarefa){
        Tarefa tarefaInserida = tarefaService.insertNew(tarefa);
        return ResponseEntity.ok().body(tarefaInserida);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Tarefa> update(@PathVariable Long id, @RequestBody Tarefa tarefa){
        Tarefa tarefaAlterada = tarefaService.update(id, tarefa);
        return ResponseEntity.ok().body(tarefaAlterada);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteById(@PathVariable Long id){
        Boolean flag = tarefaService.deleteById(id);
        return ResponseEntity.ok().body(flag);
    }


}

function convertTarefaToTr(tarefa){
    return `
        <tr>
            <td>${tarefa.nome}</td>
            <td>${tarefa.status}</td>
            <td>
                <button class="btn btn-warning btn-sm">Excluir</button>
            </td>
        </tr>
    `
}
function mostrarTarefas(){
    let listaafazer = document.getElementById("listaafazer");
    let listaconcluida = document.getElementById("listaconcluida");
    fetch("../tarefas")
        .then((response) => response.json())
        .then((jsonresponse) => {
            listaafazer.innerHTML = jsonresponse
                .filter((tarefa) => tarefa.status == "a fazer")
                .map(convertTarefaToTr).join("");
            
            listaconcluida.innerHTML = jsonresponse
                .filter((tarefa) => tarefa.status == "concluída")
                .map(convertTarefaToTr).join("");

        })
        .catch((error) => "MostraTarefas: " + error)
}
function cadastrarTarefa(){
    let mensagem = document.getElementById("mensagem").value;
    fetch("../tarefas", {
        method: "POST",
        headers:{"Content-Type":"application/json"},
        body: JSON.stringify({
            "nome": mensagem,
            "status": "a fazer"
        })
    })
        .then(() => {
            document.getElementById("mensagem").value = "";
            mostrarTarefas();
        })
}



mostrarTarefas();
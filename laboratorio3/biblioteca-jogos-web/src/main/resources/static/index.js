i= 0
function uuidv4() {
    return ([1e7]+-1e3+-4e3+-8e3+-1e11).replace(/[018]/g, c =>
      (c ^ crypto.getRandomValues(new Uint8Array(1))[0] & 15 >> c / 4).toString(16)
    );
  }

const btnAdd = document.getElementById('submitBtn')
function Adicionar() {
    axios.post('http://localhost:8080/games', {
        id: inputID.value,
        name: nomeJogo.value,
        developer: desenvolvedora.value,
        year: parseInt(ano.value),
        genre: genero.value
    }) .then(response => {
        window.location.reload();
        console.log("Jogo adicionado", response.data)
    }).catch(e => {
        console.error("Erro ao adicionar jogo", e)
        }
    )
}
btnAdd.addEventListener('click',Adicionar)
document.addEventListener("DOMContentLoaded", () => {

    fetch("http://localhost:8080/games") 
        .then(response => response.json())
        .then(data => {
            
            const gameList = document.getElementById("game-list");
            data.forEach(game => {
                const listItem = document.createElement("li");
                const deleteButton = document.createElement('button') 
                const upItem = document.createElement("input")
                const upButton = document.createElement("button");
                const inputID = document.getElementById('inputID')
                const nomeJogo = document.getElementById('nomeJogo')
                const desenvolvedora = document.getElementById('desenvolvedora')
                const ano = document.getElementById('ano')
                const genero = document.getElementById('genero')
                inputID.setAttribute('value',uuidv4())
                upButton.innerHTML = "Editar";
                deleteButton.innerHTML = "Excluir";
                listItem.innerHTML = `<strong>${game.name}</strong> - ${game.developer} (${game.year}) - ${game.genre}`;
                listItem.style.marginBottom = "15px";
                listItem.style.padding = "10px";
                listItem.style.backgroundColor = "#f8f9fa";
                listItem.style.borderRadius = "5px";
                gameList.appendChild(listItem);
                upItem.placeholder = "Novo nome do jogo";
                upItem.style.marginRight = "5px";
                gameList.appendChild(upItem);
                gameList.appendChild(upButton);
                gameList.appendChild(deleteButton);
                upButton.setAttribute('id',i);
                
                upButton.setAttribute('class','btn btn-primary')
                deleteButton.setAttribute('class','btn btn-danger')
                i++;
                upButton.addEventListener('click',Update)
                deleteButton.addEventListener('click', Excluir)
                function Update(){
                   upItemValor = upItem.value;
                   if(upItemValor) {
                       axios.put("http://localhost:8080/games/"+game.id , { 
                           id: game.id, 
                           name: upItemValor,
                           developer: game.developer,
                           year: game.year,
                           genre: game.genre
                       })
                       .then(response => {
                        console.log("Jogo atualizado com sucesso:", response.data)
                            listItem.innerHTML = `<strong>${upItemValor}</strong> - ${game.developer} (${game.year}) - ${game.genre}`;
                            upItem.value = "";
                    })
                    .catch(error => {
                        console.error("Erro ao atualizar o jogo:", error);
                    });
                   }
                }

                function Excluir(){
                    axios.delete("http://localhost:8080/games/"+game.id, { id: game.id })
                    .then(response =>{
                        console.log('Deletado', response.data)
                        upButton.remove()
                        deleteButton.remove()
                        listItem.remove()
                        upItem.remove()
                    })
                    .catch(error => {
                        console.error("Erro ao deletar", error)
                    })
                }

            });
        });
});


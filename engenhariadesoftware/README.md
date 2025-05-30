# bertoti

## RESUMO DOS DOIS TRECHOS:

O primeiro trecho fala sobre as diferenças entre "engenharia de software", "programação" e "ciência da computação". Enquanto programação é basicamente escrever código, engenharia de software vai além, envolvendo o uso de conhecimento teórico para criar sistemas que funcionem bem. O autor compara isso com outras áreas de engenharia, destacando que, ao contrário dessas, a engenharia de software ainda não tem a mesma rigidez. Com a crescente importância do software em nossas vidas, ele sugere que é hora de adotar práticas mais rigorosas. A experiência do Google pode trazer novas ideias sobre como melhorar a engenharia de software.

No segundo trecho, a noção de "engenharia de software" é ampliada para incluir todos os processos que asseguram a manutenção do código ao longo do tempo. O autor introduz o conceito de "programação integrada ao longo do tempo", ressaltando a importância de desenvolver código que se adapte a mudanças. Ele destaca três princípios fundamentais: como o código deve evoluir, como a organização precisa crescer e como tomar decisões considerando trade-offs e custos. Esses princípios guiam as empresas na construção de software que seja sustentável e eficaz, refletindo o que o Google aprendeu ao lidar com sistemas complexos.

## 3 exemplos:

### Flexibilidade vs. Consistência:
**Descrição:** Um sistema flexível permite personalizações, mas pode comprometer a consistência dos dados e da experiência do usuário.
**Explicação:** É preciso encontrar um equilíbrio entre personalização e integridade do sistema.

### Escalabilidade vs. Complexidade:
**Descrição:** Sistemas escaláveis podem ter arquiteturas mais complexas, como microserviços, que são mais difíceis de gerenciar.
**Explicação:** A decisão deve considerar se a complexidade vale a pena para atender a futuros aumentos de demanda.

### Controle de Qualidade vs. Velocidade de Entrega:
**Descrição:** Aumentar o controle de qualidade pode atrasar lançamentos, enquanto priorizar a velocidade pode resultar em bugs.
**Explicação:** É fundamental equilibrar a entrega rápida e a manutenção da qualidade do produto.

## CLASSE UML EXEMPLO UTILIZADO:

**Classe:** Tarefa

**ATRIBUTOS:**  
- titulo  
- descricao  
- status  

e o metodo no final do processo, adiciona-se:  
- marcarComoConcluida()
<img src="https://github.com/user-attachments/assets/b2fa1308-9d47-4874-bf35-1d2adb7829b8" alt="dd30e703-4a08-4a9f-afe6-df3610f81b88" width="300"/>

### JAVA:

## Classe Tarefa

```java
public class Tarefa {
    private String titulo;
    private String descricao;
    private String status;

    public Tarefa(String titulo, String descricao) {
        this.titulo = titulo;
        this.descricao = descricao;
        this.status = "Pendente";
    }

    public void marcarComoConcluida() {
        this.status = "Concluída";
    }
}
```

## Teste 

```java
import org.junit.Test;
import static org.junit.Assert.*;

public class TarefaTest {
    @Test
    public void testMarcarComoConcluida() {
        Tarefa tarefa = new Tarefa("Tarefa 1", "Descrição da Tarefa");
        tarefa.marcarComoConcluida();
        assertEquals("Concluída", tarefa.getStatus());
    }
}
public String getStatus() {
    return this.status;
}
```


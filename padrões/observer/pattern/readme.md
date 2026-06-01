# Observer Pattern

Padrao de projeto comportamental que define um mecanismo de assinatura para notificar varios objetos quando o estado de outro objeto muda. No exemplo, `GerenciadorPedido` notifica email, SMS e push quando o status do pedido muda.

<img src="padraoOB.jpg" width="600">

## Como executar

Na pasta `ObserverPadrao`:

```bash
javac -d out src/main/java/org/example/*.java
java -cp out org.example.Main
```

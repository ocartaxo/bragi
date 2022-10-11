# Comece por aqui


| :placard: Vitrine.Dev |     |
| -------------  | --- |
| :sparkles: Nome        | **BRAGI**
| :label: Tecnologias | java, python, maven, poetry, spring boot, rabbitmq, docker, requests, mapstruct, mysql


<!-- Inserir imagem com a #vitrinedev ao final do link -->
![](https://via.placeholder.com/1200x500.png?text=imagem+lindona+do+meu+projeto#vitrinedev)

## Detalhes do projeto

Um sistema para processar notificações sobre o status de assinaturas de usuários de uma plataforma de </i>streaming</i>

### Arquitetura
<img src="DesafioFila.png" width="500" height="500">

### Modelo do Banco de Dados
<img src="database_model.png" width="500" height="500">


### Documentação

#### Notificações:

- `SUBSCRIPTION_PURCHASED` - A Compra foi realizada e a assinatura deve estar com status ativa.

- `SUBSCRIPTION_CANCELED` - A Compra foi cancelada e a assinatura deve estar com status cancelada.

- `SUBSCRIPTION_RESTARTED` - A Compra foi recuperada e a assinatura deve estar com status ativa.


#### Status da notificação:
- `ACTIVE` - Assinatura ativa.
- `CANCELED` - Assinatura cancelada.

O serviço do RabbitMQ inicializa através de um container no docker, o qual utiliza as portas `5672` para a comunicação
AMQP e `15672` para o <i>interface</i> web do RabbitMQ. Um <i>script</i> em python irá realizar as requisções HTTP para a
API REST --- construída utilizando Spring Boot, com as informações do tipo da notificação e o `id` da mesma, e analizará
o servidor deve tratar aquela notificação para realizar as manipulações devidas no banco de dados. 


Caso a notificação seja para uma compra, significa que foi realizada uma nova assinatura, portanto se deve persisitir
aquela informação no banco de dados com o status apropriado. Nos dois últimos casos, e necessário verificar se a
notificação existe no banco de dados. Caso não exista, irá lançar uma exceção. Em caso de cancelamento, é enviada uma
notificação do tipo `SUBSCRIPTION_CANCELED`, e será necessário atualizar a informação para aquela assinatura. Por último,
se a notificação for do tipo `SUBSCRIPTION_RESTARTED`, é necessário mudar o status da notificação de `CANCELED` para `ACTIVE`.


#### Referências

* [Rabbit MQ com Java Spring Boot](https://youtube.com/playlist?list=PL1OeYyl9zqzHDN67rto7KMtezTLmk1N*K)
* [Como utilizar o tipo String como `id` em JPA](https://stackoverflow.com/questions/18622716/how-to-use-id-with-string-type-in-jpa-hibernate)
* [Persistência de Enums na JPA](https://www.baeldung.com/jpa-persisting-enums-in-jpa)
* [Padrão de Projeto Strategy](https://www.baeldung.com/jpa-persisting-enums-in-jpa)
* [Padrão de Projeto Factory](https://refactoring.guru/design-patterns/factory-method)

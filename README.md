# Hexagonal Template

Este repositório é um template demonstrando como estruturar um projeto Java usando **Spring Boot**, **arquitetura hexagonal**. Ele é ideal para servir de base em novos projetos ou estudos relacionados a estas abordagens.

## Estrutura de Pastas

```bash
.
├── HexagonalTemplateApplication.java
├── application
│   ├── adapters
│   │   └── in
│   │       └── SqsMessageListenerAdapter.java
│   ├── dto
│   │   └── sqs
│   │       ├── EventDto.java
│   │       └── EventPropertyDto.java
│   ├── services
│   │   └── CampaignEvaluationService.java
│   └── usecase
│       └── CampaignProcessingUseCase.java
├── domain
│   ├── enums
│   │   └── MessageDestinationType.java
│   ├── model
│   │   ├── MessageHistory.java
│   │   ├── campaign
│   │   │   ├── Campaign.java
│   │   │   └── CampaignCondition.java
│   │   └── event
│   │       ├── MessageEvent.java
│   │       └── MessageEventProperty.java
│   └── ports
│       ├── in
│       │   └── EventHandlerPort.java
│       └── out
│           ├── CampaignProviderPort.java
│           ├── CampaignPublishPort.java
│           └── HistoryRepositoryPort.java
└── infrastructure
    ├── adapters
    │   └── out
    │       ├── DynamoDbHistoryAdapter.java
    │       ├── HttpCampaignAdapter.java
    │       └── SqsCampaignPublishAdapter.java
    ├── config
    │   └── AwsConfig.java
```

- **domain**  
  Contém as entidades do domínio e suas regras (ex.: modelos, enums, portas de entrada/saída).  
- **application**  
  Lida com casos de uso: orquestra chamadas e coordena fluxo entre domínio e camadas externas.  
- **infrastructure**  
  Adaptadores (entrada/saída) que conectam o domínio a detalhes de implementação (ex.: SQS, bancos de dados, HTTP).
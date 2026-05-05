# ✈️ FastTripPlanner

Aplicativo Android desenvolvido em Kotlin com Jetpack Compose para planejamento de viagens.

---

##  Sobre o Projeto

O **FastTripPlanner** permite ao usuário planejar uma viagem informando:

* Destino
* Número de dias
* Orçamento diário

Além disso, o usuário pode escolher:

* Tipo de hospedagem
* Serviços adicionais

Ao final, o aplicativo calcula automaticamente o custo total da viagem.

---

## Funcionalidades

###  Tela 1 — Dados da Viagem

* Inserção de destino
* Inserção de número de dias
* Inserção de orçamento diário
* Validação dos dados
* Navegação para próxima tela via Intent

---

###  Tela 2 — Opções da Viagem

* Escolha de hospedagem:

  * Econômica
  * Conforto
  * Luxo
* Seleção de serviços:

  * Transporte
  * Alimentação
  * Passeios
* Botões:

  * Calcular
  * Voltar

---

###  Tela 3 — Resumo da Viagem

* Exibição dos dados informados
* Aplicação das regras de cálculo
* Exibição do valor total
* Botão para reiniciar o planejamento

---

##  Regras de Cálculo

### Base:

custoBase = dias × orçamento

### Multiplicador de hospedagem:

* Econômica → 1.0
* Conforto → 1.5
* Luxo → 2.2

### Extras:

* Transporte → + R$ 300
* Alimentação → + R$ 50 por dia
* Passeios → + R$ 120 por dia

---

##  Tecnologias utilizadas

* Kotlin
* Android Studio
* Jetpack Compose
* Intents (navegação entre telas)

---

##  Fluxo do Aplicativo

1. Usuário insere dados da viagem
2. Escolhe hospedagem e serviços
3. Visualiza o resumo com cálculo total
4. Pode reiniciar o planejamento

---

##  Estrutura

* MainActivity → Tela 1
* OpçõesViagem → Tela 2
* ResumoViagem → Tela 3

---

##  Objetivo Acadêmico

Projeto desenvolvido para aplicação dos conceitos de:

* Desenvolvimento Android
* Navegação entre telas (Intents)
* Gerenciamento de estado com Compose
* Estruturação de código

---
## 🎥Demonstração do sistema

Assista ao vídeo de funcionamento do projeto:

https://drive.google.com/drive/folders/1DRCw9M5B4cdVabEweUQKVtvkEjLGKhUc?usp=sharing

##  Autor

Fernando Rodrigues

---

##  Observação

Projeto desenvolvido para fins acadêmicos, sem uso de banco de dados ou APIs externas, conforme especificação do exercício.

---

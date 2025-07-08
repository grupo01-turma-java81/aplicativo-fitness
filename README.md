# 🏋️‍♂️ Repzone

![Repzone](https://i.postimg.cc/1zj3BXWd/repzone.png)

A **Repzone** é uma aplicação RESTful desenvolvida com **Spring Boot**, focada no gerenciamento de **treinos** e **exercícios físicos**. O projeto foi construído com uma estrutura modular e limpa, permitindo cadastrar, editar, buscar e deletar exercícios relacionados a treinos de forma eficiente e escalável.

> 🔧 Projeto funcional em ambiente local e preparado para deploy em serviços como **Render, Railway, AWS**, entre outros.

## ✨ Funcionalidades

* 🔗 **API RESTful completa**, seguindo boas práticas com Spring Boot.
* 🔄 **CRUD completo** para:
   * Treinos
   * Exercícios
* 🔍 Buscar treinos por nome (ignorando caixa alta/baixa)
* 🧠 Relacionamento 1:N entre treinos e exercícios
* 🔥 Tratamento de erros com ResponseStatusException
* 🧼 Validações com anotações do Bean Validation

## 🧠 Entidades e Relacionamentos

🔸 **Treino**

Representa uma rotina ou plano de exercícios.

| Atributo     | Tipo             | Descrição                        |
| ------------ | ---------------- | -------------------------------- |
| `id`         | Long             | Identificador único (autogerado) |
| `nome`       | String           | Nome do treino (ex: Treino A)    |
| `exercicios` | List\<Exercicio> | Lista de exercícios associados   |


📌 **Relacionamento:** Um Treino pode ter vários Exercicios (1:N)

---

🔹 **Exercício**

Representa um exercício físico dentro de um treino.
| Atributo         | Tipo   | Descrição                                  |
| ---------------- | ------ | ------------------------------------------ |
| `id`             | Long   | Identificador único do exercício           |
| `nome`           | String | Nome do exercício                          |
| `descricao`      | String | Descrição geral                            |
| `regiaoMuscular` | String | Região alvo (ex: Peitoral, Costas, Pernas) |
| `diaExercicio`   | String | Dia da semana para execução                |
| `treino`         | Treino | Treino ao qual o exercício pertence        |

## 🗂️ Estrutura do Projeto
```shell
├── controller/
│   ├── ExercicioController.java   # Endpoints de Exercício
│   └── TreinoController.java      # Endpoints de Treino
│
├── model/
│   ├── Exercicio.java             # Entidade Exercicio
│   └── Treino.java                # Entidade Treino
│
├── repository/
│   ├── ExercicioRepository.java   # Interface JPA Exercício
│   └── TreinoRepository.java      # Interface JPA Treino
```

## 🚀 Como Rodar o Projeto

Siga os passos abaixo para executar o projeto localmente:

```bash
# 1. Clone o repositório
git clone https://github.com/grupo01-turma-java81/aplicativo-fitness.git

# 2. Acesse a pasta do projeto
cd aplicativo-fitness

# 3. Execute o projeto com sua IDE (IntelliJ, Eclipse, VS Code) ou via Maven/Gradle
```

## 🔗 Endpoints
Supondo que a aplicação esteja rodando em `http://localhost:8080`

🧱 **Exercícios** `/exercicio`
| Método | Endpoint | Descrição                      |
| ------ | -------- | ------------------------------ |
| GET    | `/`      | Lista todos os exercícios      |
| GET    | `/{id}`  | Busca exercício por ID         |
| POST   | `/`      | Cadastra novo exercício        |
| PUT    | `/`      | Atualiza dados de um exercício |
| DELETE | `/{id}`  | Deleta exercício por ID        |


🏋️ **Treinos** `/treino`
| Método | Endpoint       | Descrição                                 |
| ------ | -------------- | ----------------------------------------- |
| GET    | `/`            | Lista todos os treinos                    |
| GET    | `/{id}`        | Busca treino por ID                       |
| GET    | `/nome/{nome}` | Busca treinos por nome (case-insensitive) |
| POST   | `/`            | Cadastra novo treino                      |
| PUT    | `/`            | Atualiza dados de um treino               |
| DELETE | `/{id}`        | Deleta treino por ID                      |


## 🧪 Tecnologias Utilizadas

* [**Java**](https://www.java.com/pt-BR/) - Linguagem de programação orientada a objetos, robusta e multiplataforma.
* [**Spring Boot**](https://spring.io/projects/spring-boot) - Framework Java para aplicações web robustas e seguras.
* [**MySQL**](https://www.mysql.com/) - Banco de dados relacional utilizado no ambiente de **desenvolvimento**.
* [**Postman**](https://www.postman.com/) - Ferramenta para teste e validação de APIs. </br>
![Repzone Postman](https://i.postimg.cc/pr4jSx2W/repzone-postman.png)

## 💡 Melhorias Futuras

* Integração com banco de dados PostgreSQL
* Criação de camada de serviço (`@Service`)
* Autenticação e autorização com Spring Security
* Integração com o [front-end do projeto](https://github.com/grupo01-turma-java81/repzone), que está em desenvolvimento com foco na criação de uma interface gráfica interativa e responsiva
* Validações mais robustas via regex

## 🤝 Contribuição
Contribuições são sempre bem-vindas! Você pode colaborar com sugestões, feedbacks ou melhorias no código. Sinta-se à vontade para abrir issues ou enviar pull requests.

> 💙 Este projeto foi desenvolvido de forma colaborativa por um grupo comprometido com o aprendizado e a prática de desenvolvimento backend com Spring Boot.

👤 **Colaboradores do Projeto**
<table> <tr> <td align="center"> <a href="https://github.com/ViniCristhian"> <img src="https://github.com/ViniCristhian.png" width="100px;" alt="Vinícius Cristhian"/> <br /> <sub><b>Vinícius Cristhian</b></sub> </a><br /> <a href="https://www.linkedin.com/in/vinicristhian/">🔗 LinkedIn</a> </td> <td align="center"> <a href="https://github.com/IagoWiliian"> <img src="https://github.com/IagoWiliian.png" width="100px;" alt="Iago Willian"/> <br /> <sub><b>Iago Willian</b></sub> </a><br /> <a href="https://www.linkedin.com/in/iago-willian-/">🔗 LinkedIn</a> </td> <td align="center"> <a href="https://github.com/GiulioArantes"> <img src="https://github.com/GiulioArantes.png" width="100px;" alt="Giulio Gabriel"/> <br /> <sub><b>Giulio Gabriel</b></sub> </a><br /> <a href="https://www.linkedin.com/in/giulio-arantes/">🔗 LinkedIn</a> </td> <td align="center"> <a href="https://github.com/Yasmimruescas"> <img src="https://github.com/Yasmimruescas.png" width="100px;" alt="Yasmim Ruescas"/> <br /> <sub><b>Yasmim Ruescas</b></sub> </a><br /> <a href="https://www.linkedin.com/in/yasmim-ruescas/">🔗 LinkedIn</a> </td> <td align="center"> <a href="https://github.com/Vitoriacmlly"> <img src="https://github.com/Vitoriacmlly.png" width="100px;" alt="Vitoria Camilly"/> <br /> <sub><b>Vitoria Camilly</b></sub> </a><br /> <a href="https://www.linkedin.com/in/vitoria-camilly/">🔗 LinkedIn</a> </td> <td align="center"> <a href="https://github.com/BrunoDaniel13"> <img src="https://github.com/BrunoDaniel13.png" width="100px;" alt="Bruno Daniel"/> <br /> <sub><b>Bruno Daniel</b></sub> </a><br /> <a href="https://www.linkedin.com/in/bruno-daniel-ferreira-leite/">🔗 LinkedIn</a> </td> </tr> </table>

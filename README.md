# blog-api
Criação das APIs de um blog em Spring Boot.

Para rodar o código: mvn spring-boot:run

# Trabalho 1 - JPA

Desenvolva um sistema Java/JPA para um Portal para escritores de blogs (algo como Medium).

Neste sistema cada postagem (**Post**) possui um **identificador único**, um **título**, um **texto** e uma **data/hora** de publicação.

Cada post pode ser escrito por diversos **autores** que, por sua vez, pode escrever diversos **posts** (relacionamento n:m post<->autor). No momento que cada post é criado, é possível definir se o mesmo é compartilhado com os demais autores da plataforma - ou fica exclusivo para o autor-criador (deve existir um atributo booleano para esta finalidade). Cada autor tem um **identificador único**, um **nome**, um **email** e uma **senha** de acesso. 

Além dos autores dos posts, há **leitores** que somente podem ter acesso as **posts** (publicações) por meio de um cadastro prévio. Cada **leitor** possui os mesmos atributos dos **escritores** (relacionamento de herança) mas devem cadastrar - além dos atributos herdados - seus **endereços** (relacionamento 1:1 leitor-> endereço) para que futuras correspondências promocionais sejam enviadas para o endereço cadastrado. Cada **endereço** possui **identificador único**, um **bairro**, uma **rua**, um **número**, um **complemento** e um **cep**.

**Exigências:**

* CRUD de Posts
* CRUD de Autores
* CRUD de Leitores
* CRUD de Endereços

**Obrigatório:**

* Usar *annotations* JPA para mapear os relacionamentos
* Usar JAVA
* Usar PostgreSQL
* Usar MAVEN

**Prazo:** 02/09

**Valor:** 3

**Extra:** 1

* Desenvolver uma API ou
* Desenvolver o sitema com interface gráfica (desktop, web ou etc.)

**obs:** é possível usar qualquer biblioteca ou framework para isso.

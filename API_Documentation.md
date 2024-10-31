# 📑 Tournament Manager API Documentation

### ** Select your language | Selecione o idioma**

- [🇧🇷 Português](#documentação-da-api-para-o-aplicativo-de-torneios-de-damas)
- [🇺🇸 English](#tournament-manager-api-documentation)



---

--- 



## 🇧🇷 Documentação da API para o Aplicativo de Torneios de Damas

### Sumário

1. [Tela de Login e Registro](#tela-de-login-e-registro)
    - [Rota de Registro](#rota-de-registro)
    - [Rota de Login](#rota-de-login)
    - [Rota de Busca de Região (Estados e Cidades)](#rota-de-busca-de-região-estados-e-cidades)
2. [Menu Inicial](#menu-inicial)
    - [Rota de Torneios Próximos (Limitada)](#rota-de-torneios-próximos-limitada)
    - [Rota de Todos os Torneios Próximos](#rota-de-todos-os-torneios-próximos)
    - [Rota de Filtragem de Torneios](#rota-de-filtragem-de-torneios)
3. [Perfil do Usuário](#perfil-do-usuário)
4. [Rotas Internas para Administração de Torneios](#rotas-internas-para-administração-de-torneios)
    - [Rota para Criar Torneio](#rota-para-criar-torneio)
    - [Rota para Deletar um Torneio](#rota-para-deletar-um-torneio)
5. [Observações](#observações)



---

--- 



## Tela de Login e Registro

### Rota de Registro

- **Descrição**: Registra um novo usuário no sistema, salvando suas informações de perfil e localização.
- **Método HTTP**: `POST`
- **Endpoint**: `/auth/register`
- **Corpo da Requisição**:
    ```json
    {
      "nome": "string",
      "email": "string",
      "senha": "string",
      "estado_id": "long",
      "cidade_id": "long"
    }
    ```
- **Resposta**:
    - **Status**: `201 Created`
    - **Corpo da Resposta**:
      ```json
      {
        "id": "long",
        "nome": "string",
        "email": "string",
        "estado_id": "string",
        "cidade_id": "string"
      }
      ```
- **Lógica Aplicada**: Após o registro, o front-end deve armazenar os dados retornados para manter o usuário conectado (ex.: usando `localStorage` ou `sessionStorage`).

---

### Rota de Login

- **Descrição**: Autentica o usuário verificando o `email` e `senha`. Se as credenciais forem corretas, retorna as informações do usuário.
- **Método HTTP**: `POST`
- **Endpoint**: `/auth/login`
- **Corpo da Requisição**:
    ```json
    {
      "email": "string",
      "senha": "string"
    }
    ```
- **Resposta**:
    - **Status**:
        - `200 OK` se as credenciais estiverem corretas.
        - `401 Unauthorized` se `email` ou `senha` forem inválidos.
    - **Corpo em caso de sucesso**:
      ```json
      {
        "id": "long",
        "nome": "string",
        "email": "string",
        "estado_id": "string",
        "cidade_id": "string"
      }
      ```
- **Lógica Aplicada**: O front-end deve armazenar o `id` e os dados retornados para gerenciar a sessão e permitir acesso contínuo às funcionalidades.

---

### Rota de Busca de Região (Estados e Cidades)

- **Descrição**: Permite a busca de **Estados** e **Cidades** para registro ou atualização de perfil.
- **Método HTTP**: `GET`
- **Endpoints**:
    - `/states` para listar todos os estados disponíveis.
    - `/states/:id/cities` para listar as cidades associadas ao estado selecionado.
- **Lógica Aplicada**: O front-end deve iniciar a busca de cidades após o terceiro caractere digitado, e o estado e cidade escolhidos serão vinculados ao perfil do usuário.



## Menu Inicial

### Rota de Torneios Próximos (Limitada)

- **Descrição**: Retorna os 4 torneios mais próximos (ordenados pela data) na região do usuário.
- **Método HTTP**: `GET`
- **Endpoint**: `/torneios/proximos`
- **Parâmetros de Query**:
    - `estado_id` (long): estado do usuário.
    - `cidade_id` (long): cidade do usuário.
- **Resposta**:
    ```json
    [
      {
        "nome": "string",
        "descricao": "string",
        "data": "dd/MM/yyyy",
        "horario": "HH:mm",
        "local": "string",
        "preco": "0,00"
      }
    ]
    ```

---

### Rota de Todos os Torneios Próximos

- **Descrição**: Retorna todos os torneios futuros na região do usuário, ordenados pela data de forma crescente.
- **Método HTTP**: `GET`
- **Endpoint**: `/torneios/todos`
- **Parâmetros de Query**:
    - `estado_id` (long): estado do usuário.
    - `cidade_id` (long): cidade do usuário.
- **Resposta**:
    ```json
    [
      {
        "nome": "string",
        "descricao": "string",
        "data": "dd/MM/yyyy",
        "horario": "HH:mm",
        "local": "string",
        "preco": "0,00"
      }
    ]
    ```

---

### Rota de Filtragem de Torneios

- **Descrição**: Filtra torneios com base em região (estado e/ou cidade) e data.
- **Método HTTP**: `GET`
- **Endpoint**: `/torneios/filtrar`
- **Parâmetros de Query**:
    - `estado_id` (long, opcional)
    - `cidade_id` (long, opcional)
    - `data` (date, opcional): filtra por uma data ou intervalo específico.
- **Resposta**:
    ```json
    [
      {
        "nome": "string",
        "descricao": "string",
        "data": "dd/MM/yyyy",
        "horario": "HH:mm",
        "local": "string",
        "preco": "0,00"
      }
    ]
    ```



## Perfil do Usuário

### Rota para Exibir Dados do Perfil

- **Descrição**: Retorna os dados do perfil do usuário.
- **Método HTTP**: `GET`
- **Endpoint**: `/usuarios/:id`
- **Parâmetros**: 
    - `id` (long): ID do usuário.
- **Resposta**:
    ```json
    {
      "nome": "string",
      "email": "string",
      "estado_id": "long",
      "cidade_id": "long"
    }
    ```



## Rotas Internas para Administração de Torneios

> **Nota**: Estas rotas são acessíveis apenas para administradores ou organizadores de torneios e não são visíveis para o usuário final do aplicativo.

### Rota para Criar Torneio

- **Descrição**: Cria um novo torneio no sistema com todas as informações necessárias.
- **Método HTTP**: `POST`
- **Endpoint**: `/torneios`
- **Corpo da Requisição**:
    ```json
    {
      "nome": "string",
      "descricao": "string",
      "data": "dd/MM/yyyy",
      "horario": "HH:mm",
      "local": "string",
      "preco": "0,00"
    }
    ```
- **Resposta**: Status `201 Created`, com o `id` do torneio e informações criadas.

---

### Rota para Deletar um Torneio

- **Descrição**: Remove um torneio existente do sistema.
- **Método HTTP**: `DELETE`
- **Endpoint**: `/torneios/:id`
- **Parâmetros**:
    - `id` (long): ID do torneio a ser deletado.
- **Resposta**: Status `204 No Content`, indicando que o torneio foi excluído com sucesso.

--- 

--- 

## Observações ⚠️

- **Autenticação**: Não será utilizado sistema de terceiros para autenticação. Todos os processos de registro e login serão internos ao sistema.
- **Notificações**: Não haverá notificação ou ícone de notificação na interface do usuário.
- **Histórico de Torneios**: O histórico de torneios foi removido do aplicativo, tanto na página de perfil quanto em qualquer outra tela.
- **Elemento de Geolocalização**: Não haverá elemento de geolocalização nos detalhes de torneios.



--- 

--- 




## 🇺🇸 Tournament Manager API Documentation

### Table of Contents

1. [Login and Registration Screen](#login-and-registration-screen)
    - [Registration Route](#registration-route)
    - [Login Route](#login-route)
    - [Region Search Route (States and Cities)](#region-search-route-states-and-cities)
2. [Main Menu](#main-menu)
    - [Upcoming Tournaments Route (Limited)](#upcoming-tournaments-route-limited)
    - [All Upcoming Tournaments Route](#all-upcoming-tournaments-route)
    - [Tournament Filtering Route](#tournament-filtering-route)
3. [User Profile](#user-profile)
4. [Internal Routes for Tournament Management](#internal-routes-for-tournament-management)
    - [Create Tournament Route](#create-tournament-route)
    - [Delete Tournament Route](#delete-tournament-route)
5. [Notes](#notes)



---

---



## Login and Registration Screen

### Registration Route

- **Description**: Registers a new user in the system, saving their profile and location information.
- **HTTP Method**: `POST`
- **Endpoint**: `/auth/register`
- **Request Body**:
    ```json
    {
      "name": "string",
      "email": "string",
      "password": "string",
      "state_id": "long",
      "city_id": "long"
    }
    ```
- **Response**:
    - **Status**: `201 Created`
    - **Response Body**:
      ```json
      {
        "id": "long",
        "name": "string",
        "email": "string",
        "state_id": "string",
        "city_id": "string"
      }
      ```
- **Logic Applied**: After registration, the front-end should store the returned data to keep the user logged in (e.g., using `localStorage` or `sessionStorage`).

---

### Login Route

- **Description**: Authenticates the user by verifying `email` and `password`. If the credentials are correct, returns the user’s information.
- **HTTP Method**: `POST`
- **Endpoint**: `/auth/login`
- **Request Body**:
    ```json
    {
      "email": "string",
      "password": "string"
    }
    ```
- **Response**:
    - **Status**:
        - `200 OK` if the credentials are correct.
        - `401 Unauthorized` if `email` or `password` are invalid.
    - **Response Body on Success**:
      ```json
      {
        "id": "long",
        "name": "string",
        "email": "string",
        "state_id": "string",
        "city_id": "string"
      }
      ```
- **Logic Applied**: The front-end should store the returned `id` and user data to manage the session and provide continuous access to features.

---

### Region Search Route (States and Cities)

- **Description**: Allows searching for **States** and **Cities** for registration or profile update.
- **HTTP Method**: `GET`
- **Endpoints**:
    - `/states` to list all available states.
    - `/states/:id/cities` to list cities associated with the selected state.
- **Logic Applied**: The front-end should initiate city search after the third character is typed, and the chosen state and city will be linked to the user's profile.



## Main Menu

### Upcoming Tournaments Route (Limited)

- **Description**: Returns the 4 closest tournaments (sorted by date) in the user's region.
- **HTTP Method**: `GET`
- **Endpoint**: `/tournaments/upcoming`
- **Query Parameters**:
    - `state_id` (long): user’s state.
    - `city_id` (long): user’s city.
- **Response**:
    ```json
    [
      {
        "name": "string",
        "description": "string",
        "date": "MM/dd/yyyy",
        "time": "HH:mm",
        "location": "string",
        "price": "0.00"
      }
    ]
    ```

---

### All Upcoming Tournaments Route

- **Description**: Returns all future tournaments in the user’s region, sorted by the closest date.
- **HTTP Method**: `GET`
- **Endpoint**: `/tournaments/all`
- **Query Parameters**:
    - `state_id` (long): user’s state.
    - `city_id` (long): user’s city.
- **Response**:
    ```json
    [
      {
        "name": "string",
        "description": "string",
        "date": "MM/dd/yyyy",
        "time": "HH:mm",
        "location": "string",
        "price": "0.00"
      }
    ]
    ```

---

### Tournament Filtering Route

- **Description**: Filters tournaments based on region (state and/or city) and date.
- **HTTP Method**: `GET`
- **Endpoint**: `/tournaments/filter`
- **Query Parameters**:
    - `state_id` (long, optional)
    - `city_id` (long, optional)
    - `date` (date, optional): filters by a specific date or range.
- **Response**:
    ```json
    [
      {
        "name": "string",
        "description": "string",
        "date": "MM/dd/yyyy",
        "time": "HH:mm",
        "location": "string",
        "price": "0.00"
      }
    ]
    ```



## User Profile

### Route to Display Profile Data

- **Description**: Returns the user profile data.
- **HTTP Method**: `GET`
- **Endpoint**: `/users/:id`
- **Parameters**: 
    - `id` (long): user’s ID.
- **Response**:
    ```json
    {
      "name": "string",
      "email": "string",
      "state_id": "long",
      "city_id": "long"
    }
    ```



## Internal Routes for Tournament Management

> **Note**: These routes are accessible only to administrators or tournament organizers and are not visible to the end-user of the application.

### Create Tournament Route

- **Description**: Creates a new tournament in the system with all necessary information.
- **HTTP Method**: `POST`
- **Endpoint**: `/tournaments`
- **Request Body**:
    ```json
    {
      "name": "string",
      "description": "string",
      "date": "MM/dd/yyyy",
      "time": "HH:mm",
      "location": "string",
      "price": "0.00"
    }
    ```
- **Response**: Status `201 Created`, with the tournament’s `id` and created information.

---

### Delete Tournament Route

- **Description**: Removes an existing tournament from the system.
- **HTTP Method**: `DELETE`
- **Endpoint**: `/tournaments/:id`
- **Parameters**:
    - `id` (long): ID of the tournament to be deleted.
- **Response**: Status `204 No Content`, indicating that the tournament was successfully deleted.

--- 

--- 

## Notes ⚠️

- **Authentication**: No third-party system will be used for authentication. All registration and login processes will be handled internally.
- **Notifications**: There will be no notification or notification icon in the user interface.
- **Tournament History**: Tournament history has been removed from the application, both on the profile page and on any other screen.
- **Geolocation Element**: There will be no geolocation element in tournament details.

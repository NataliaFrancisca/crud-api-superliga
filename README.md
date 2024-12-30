# API - SUPERLIGA

API SUPERLIGA é uma API da Superliga com operações CRUD, onde é possível gerenciar times, treinadores e jogadoras.

🌟 Esse projeto foi criado para colocar em prática o que foi aprendido nos vídeos da Fernanda:
- [Live Coding Java: CRUD com Java Spring | Construa uma API Rest na prática](https://www.youtube.com/watch?v=tP6wtEaCnSI)
- [Live Coding: Continuação API REST com Java Spring](https://www.youtube.com/watch?v=HanaSiIlMVY&t=2683s)

O projeto é bem simples, nele é possível fazer operações CRUD (Create, Read, Update e Delete) nas rotas do time, treinador e jogador.


## URL Base

A URL base para todas as requisições é:  ``localhost:8080``

## Endpoints - TEAM

### 1. **GET /team**

Obtém uma lista de todos os times.

#### Requisição:
- **Método**: GET
- **Endpoint**: `/team`
- **Exemplo de URL**: `https://localhost:8080/team`

#### Resposta:
- **Código de Status**: 200 OK
- **Corpo**:
  ```json
  [
    {
        "id": "71ff6834-723b-4523-9c1c-70439c260582",
        "name": "Gerdau Minas",
        "state": "Minas Gerais",
        "coach": {
            "id": "e84c92f7-b628-42c4-880f-e3fcdf0587bf",
            "name": "Nicola Negro",
            "nationality": "Itália"
        }
    }
  ]

### 2. **GET /team/{id}**

Retorna um time

#### Requisição:
- **Método**: GET
- **Endpoint**: `/team`
- **Exemplo de URL**: `https://localhost:8080/team/{id}`


#### Resposta:
- **Código de Status**: 200 OK
- **Corpo**:
  ```json
    {
      "id": "71ff6834-723b-4523-9c1c-70439c260582",
      "name": "Gerdau Minas",
      "state": "Minas Gerais",
      "coach": {
      "id": "e84c92f7-b628-42c4-880f-e3fcdf0587bf",
      "name": "Nicola Negro",
      "nationality": "Itália"
      },
      "athletes": [
          {
          "id": "fe4c0d4b-5521-44dc-8433-2da64034f511",
          "name": "THAISA DAHER DE MENEZES",
          "position": "Central",
          "height": 1.96,
          "birthdate": "1987-05-15",
          "nationality": "Brasil",
          "photo": null
          },
          {
          "id": "729dc7b5-ed78-4c1c-94c2-e01deda390e7",
          "name": "YONKAIRA PAOLA PEÑA ISABEL",
          "position": "Ponteira",
          "height": 1.9,
          "birthdate": "1993-05-10",
          "nationality": "República Dominicana",
          "photo": null
          }
      ]
    }
  ```

### 3. **POST /team**

Cria um novo time

#### Requisição:
- Método: POST
- Endpoint: `/team`
- Exemplo de URL: `https://localhost:8080/team`
- Corpo da Requisição:
    ```json
    {
      "name": "Osasco",
      "state": "São Paulo"
    }
    ```

    ```json
    {
      "name": "Fluminense",
      "state": "Rio de Janeiro",
      "coach_id": "091d1d86-1015-4b39-9c17-feb3383d01b9"
    }
    ```

#### Resposta:
- Código de Status: 200 OK
- Corpo: ``Team created successfully``


### 4. **UPDATE /team**

Atualiza um time

#### Requisição:
- Método: PUT
- Endpoint: `/team`
- Exemplo de URL: `https://localhost:8080/team`
- Corpo da Requisição:
     ```json
    {
      "name": "Osasco",
      "state": "São Paulo",
      "coach_id": "862b40db-a991-477c-8d52-dae69bdf3c4a"
    }
    ```

#### Resposta:
- Código de Status: 200 OK
- Corpo: ``Team updated successfully``


### 5. **DELETE /team/{id}**

Deleta um time

#### Requisição:
- Método: DELETE
- Endpoint: `/team`
- Exemplo de URL: `https://localhost:8080/team/{id}`


#### Resposta: 
- Código de Status: 200 OK
- Corpo: ``Team deleted successfully``

---

## Endpoints - COACH

### 1. **GET /coach**

Obtém uma lista de todos os treinadores

#### Requisição:
- **Método**: GET
- **Endpoint**: `/coach`
- **Exemplo de URL**: `https://localhost:8080/coach`

#### Resposta:
- **Código de Status**: 200 OK
- **Corpo**:
  ```json
    [
        {
          "id": "091d1d86-1015-4b39-9c17-feb3383d01b9",
          "name": "Guilherme Schimitz Vieira",
          "nationality": "Brasil"
        },
        {
          "id": "e84c92f7-b628-42c4-880f-e3fcdf0587bf",
          "name": "Nicola Negro",
          "nationality": "Itália"
        },
        {
          "id": "862b40db-a991-477c-8d52-dae69bdf3c4a",
          "name": "Luiz Omar de Moura",
          "nationality": "Brasil"
        }
    ]
  ```

### 2. **GET /coach/{id}**

Retorna uma treinador

#### Requisição:
- **Método**: GET
- **Endpoint**: `/coach`
- **Exemplo de URL**: `https://localhost:8080/coach/{id}`

#### Resposta:
- **Código de Status**: 200 OK
- **Corpo**:
  ```json
    {
      "id": "e84c92f7-b628-42c4-880f-e3fcdf0587bf",
      "name": "Nicola Negro",
      "nationality": "Itália"
     }
  ```
    
### 3. **POST /coach**

Cria um novo treinador

#### Requisição:
- Método: POST
- Endpoint: `/coach`
- Exemplo de URL: `https://localhost:8080/coach`
- Corpo da Requisição:
    ```json
        {
          "name": "Bernardo Rezende (Bernardinho)",
          "nationality": "Brasil"
        }
    ```

#### Resposta:
- Código de Status: 200 OK
- Corpo: ``Coach created successfully``


### 4. **UPDATE /coach**

Atualiza um treinador

#### Requisição:
- Método: PUT
- Endpoint: `/coach`
- Exemplo de URL: `https://localhost:8080/coach`
- Corpo da Requisição:
     ```json
        {
          "id": "5ede7d59-51ac-4f79-9dcb-7fa4f1bdaa8d",
          "name": "Bernardo Rezende",
          "nationality": "Brasil"
        }
    ```

#### Resposta:
- Código de Status: 200 OK
- Corpo: ``Coach updated successfully``


### 5. **DELETE /coach/{id}**

Deleta um treinador

#### Requisição:
- Método: DELETE
- Endpoint: `/coach`
- Exemplo de URL: `https://localhost:8080/coach/{id}`


#### Resposta:
- Código de Status: 200 OK
- Corpo: ``Coach deleted successfully``

---

## Endpoints - ATHLETE

### 1. **GET /athlete**

Obtém uma lista de todos os atletas.

#### Requisição:
- **Método**: GET
- **Endpoint**: `/athlete`
- **Exemplo de URL**: `https://localhost:8080/athlete`

#### Resposta:
- **Código de Status**: 200 OK
  - **Corpo**:
    ```json
    [
      {
          "id": "fe4c0d4b-5521-44dc-8433-2da64034f511",
          "name": "THAISA DAHER DE MENEZES",
          "position": "Central",
          "height": 1.96,
          "birthdate": "1987-05-15",
          "nationality": "Brasil",
          "teamId": "71ff6834-723b-4523-9c1c-70439c260582",
          "photo": null
      },
      {
          "id": "729dc7b5-ed78-4c1c-94c2-e01deda390e7",
          "name": "YONKAIRA PAOLA PEÑA ISABEL",
          "position": "Ponteira",
          "height": 1.9,
          "birthdate": "1993-05-10",
          "nationality": "República Dominicana",
          "teamId": "71ff6834-723b-4523-9c1c-70439c260582",
          "photo": null
      }
    ]

### 2. **GET /athlete/{id}**

Retorna dados do atleta.

#### Requisição:
- **Método**: GET
- **Endpoint**: `/athlete`
- **Exemplo de URL**: `https://localhost:8080/athlete/{id}`


#### Resposta:
- **Código de Status**: 200 OK
- **Corpo**:
  ```json
    {
        "id": "fe4c0d4b-5521-44dc-8433-2da64034f511",
        "name": "THAISA DAHER DE MENEZES",
        "position": "Central",
        "height": 1.96,
        "birthdate": "1987-05-15",
        "nationality": "Brasil",
        "teamId": "71ff6834-723b-4523-9c1c-70439c260582",
        "photo": null
    }
  ```

### 3. **POST /athlete**

Cria um novo atleta.

#### Requisição:
- Método: POST
- Endpoint: `/athlete`
- Exemplo de URL: `https://localhost:8080/athlete`
  - Corpo da Requisição:
      ```json
       {
          "teamId": "a3cb75f4-e509-4056-a426-e44d33b94fae",
          "name": "CAMILA DE PAULA BRAIT",
          "position": "LÍBERO",
          "height": 1.68,
          "birthdate": "1988-10-28",
          "nationality": "BRASIL",
          "photo": "https://assets.volleystation.com/website/teams/2123846/players/2340992.png?123"
       }
      ```

#### Resposta:
- Código de Status: 200 OK
- Corpo: ``Athlete created successfully``


### 4. **UPDATE /athlete**

Atualiza um atleta.

#### Requisição:
- Método: PUT
- Endpoint: `/athlete`
- Exemplo de URL: `https://localhost:8080/athlete`
- Corpo da Requisição:
     ```json
      {
        "id": "fe4c0d4b-5521-44dc-8433-2da64034f511",
        "name": "THAISA DAHER DE MENEZES",
        "position": "Central",
        "height": 1.96,
        "birthdate": "1987-05-15",
        "nationality": "Brasil",
        "teamId": "71ff6834-723b-4523-9c1c-70439c260582",
        "photo": "https://assets.volleystation.com/website/teams/2123881/players/2340268.png?123"
      }
    ```

#### Resposta:
- Código de Status: 200 OK
- Corpo: ``Athlete updated successfully``


### 5. **DELETE /athlete/{id}**

Deleta um atleta.

#### Requisição:
- Método: DELETE
- Endpoint: `/athlete`
- Exemplo de URL: `https://localhost:8080/athlete/{id}`


#### Resposta:
- Código de Status: 200 OK
- Corpo: ``Athlete deleted successfully``
  

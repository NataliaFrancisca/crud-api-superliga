# API - SUPERLIGA

API SUPERLIGA é uma API da Superliga com operações CRUD, onde é possível gerenciar times, treinadores e jogadoras.

🌟 Esse projeto foi criado para colocar em prática o que foi aprendido nos vídeos da Fernanda:
- [Live Coding Java: CRUD com Java Spring | Construa uma API Rest na prática](https://www.youtube.com/watch?v=tP6wtEaCnSI)
- [Live Coding: Continuação API REST com Java Spring](https://www.youtube.com/watch?v=HanaSiIlMVY&t=2683s)

O projeto é bem simples, nele é possível fazer operações CRUD (Create, Read, Update e Delete) nas rotas do time, treinador e jogador.

A URL base para todas as requisições é:  ``localhost:8080``

</br>

## 🏐 Endpoints - TEAM

</br>

### 1. **GET ALL**

| Método | Endpoint | Descrição | Parâmetros |  Localização do Parâmetro |
|--------|----------------------------|----------------------------------|----------------------------------|--------------------------|
|GET| /team | Obtém uma lista de todos os times. | Nenhum | - |

#### Resposta:
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
  ```

### 2. **GET ONE**

| Método | Endpoint | Descrição | Parâmetros | Localização do Parâmetro |
|--------|----------------------------|----------------------------------|----------------------------------|--------------------------|
|GET| /team/{id} | Retorna o time de acordo com o id. | id: string | URL |

#### Resposta:
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

### 3. **POST**

| Método | Endpoint | Descrição | Parâmetros | Localização do Parâmetro | Resposta |
|--------|----------------------------|----------------------------------|----------------------------------|--------------------------|------------------------------------|
|POST| /team | Cria uma novo time. | name: string, state: string, coach_id: string | Body | ``Team created successfully``


### 4. **UPDATE**

| Método | Endpoint | Descrição | Parâmetros | Localização do Parâmetro | Resposta |
|--------|----------------------------|----------------------------------|----------------------------------|--------------------------|------------------------------------|
|PUT| /team | Atualiza um time. | name: string, state: string, coach_id: string | Body | ``Team updated successfully``

### 5. **DELETE**

| Método | Endpoint | Descrição | Parâmetros | Localização do Parâmetro | Resposta |
|--------|----------------------------|----------------------------------|----------------------------------|--------------------------|------------------------------------|
|DELETE| /team/{id} | Cria uma novo time. | id | URL | ``Team deleted successfully`` |


</br>

## 👩🏽‍🏫 Endpoints - COACH

</br>


### 1. **GET ALL**

| Método | Endpoint | Descrição | Parâmetros | Localização do Parâmetro |
|--------|----------------------------|----------------------------------|----------------------------------|--------------------------|
|GET| /coach | Retorna uma lista de todos os treinadores | Nenhum | -

#### Resposta:
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

### 2. **GET ONE**

| Método | Endpoint | Descrição | Parâmetros | Localização do Parâmetro |
|--------|----------------------------|----------------------------------|----------------------------------|--------------------------|
|GET| /coach/{id} | Retorna um treinador de acordo com o id | id: string | URL


#### Resposta:
  ```json
    {
      "id": "e84c92f7-b628-42c4-880f-e3fcdf0587bf",
      "name": "Nicola Negro",
      "nationality": "Itália"
     }
  ```
    
### 3. **POST**

| Método | Endpoint | Descrição | Parâmetros | Localização do Parâmetro | Resposta |
|--------|----------------------------|----------------------------------|----------------------------------|--------------------------|------------------------------------|
|POST| /coach | Cria um novo treinador | name: string, nationality: string | Body | ``Coach created successfully``

### 4. **UPDATE**

| Método | Endpoint | Descrição | Parâmetros | Localização do Parâmetro | Resposta |
|--------|----------------------------|----------------------------------|----------------------------------|--------------------------|------------------------------------|
|PUT| /coach | Atualiza um treinador. | id: string, name: string, nationality: string | Body | ``Coach updated successfully``

### 5. **DELETE**

| Método | Endpoint | Descrição | Parâmetros | Localização do Parâmetro | Resposta |
|--------|----------------------------|----------------------------------|----------------------------------|--------------------------|------------------------------------|
|DELETE| /coach/{id} | Deleta um treinador | id: string | URL | ``Coach deleted successfully``

</br>

## 🤾🏽Endpoints - ATHLETE

</br>

### 1. **GET ALL**

| Método | Endpoint | Descrição | Parâmetros | Localização do Parâmetro |
|--------|----------------------------|----------------------------------|----------------------------------|--------------------------|
|GET| /athlete | Retorna uma lista de todos os atletas | Nenhum | -

#### Resposta:
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
```

### 2. **GET ONE**

| Método | Endpoint | Descrição | Parâmetros | Localização do Parâmetro |
|--------|----------------------------|----------------------------------|----------------------------------|--------------------------|
|GET| /athlete/{id} | Retorna um atleta de acordo com o id. | id: string | URL

#### Resposta:
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

### 3. **POST**

| Método | Endpoint | Descrição | Parâmetros | Localização do Parâmetro | Resposta |
|--------|----------------------------|----------------------------------|----------------------------------|--------------------------|------------------------------------|
|POST| /athlete | Cria um novo atleta. | teamId: string, name: string, position: string, height: double, birthdate: date, nationality: string, photo: string | Body | ``Athlete created successfully``

### 4. **UPDATE**

| Método | Endpoint | Descrição | Parâmetros | Localização do Parâmetro | Resposta |
|--------|----------------------------|----------------------------------|----------------------------------|--------------------------|------------------------------------|
|PUT| /athlete | Atualiza um atleta. | teamId: string, name: string, position: string, height: double, birthdate: date, nationality: string, photo: string | Body | ``Athlete updated successfully``


### 5. **DELETE**

| Método | Endpoint | Descrição | Parâmetros | Localização do Parâmetro | Resposta |
|--------|----------------------------|----------------------------------|----------------------------------|--------------------------|------------------------------------|
|DELETE | /athlete/{id} | Deleta um atleta. | id: string | URL | ``Athlete deleted successfully``


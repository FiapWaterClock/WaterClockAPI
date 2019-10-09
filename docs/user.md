## URL  [https://fiapwaterclock.herokuapp.com/api/user]
### Cadastro de usuário [POST]


+ Request
    + Headers       
    ```json
        "Content-Type": "application/json
    ```
    +Body
     ```json
     {
         "firstName": "Novo",
         "lastName": "Fiap",
         "email": "fiaap@email.com",
         "password": "senhaforte",
         "matchingPassword": "senhaforte"
     }
    ```
+ Response 200 (application/json)
    + Body
        ```json
        {
            "id": 6,
            "firstName": "Novo",
            "lastName": "Fiap",
            "email": "fiaap@email.com",
            "address": null,
            "enabled": true,
            "tokenExpired": false,
            "clock": null,
            "roles": [
                {
                    "id": 4,
                    "name": "ROLE_USER",
                    "privileges": [
                        {
                            "id": 1,
                            "name": "READ_PRIVILEGE"
                        }
                    ]
                }
            ]
        }
        ```
+ response 401

    + body
    ```json
    
    {
      "error_description": "There is an account with that email address: fiaap@email.com"
    }
    ```
    
      
  ## URL  [https://fiapwaterclock.herokuapp.com/api/user/{user_id}]
  ### Consulta de um usuário [GET]
  
  + Parameters
      + [token](/docs/authentication.md)
  
  + Request
      + Headers       
      ```json
          "Content-Type": "application/json;charset=UTF-8"
          "Authorization": "Bearer <YourTokenHere>"
        
      ```
  
+ Response 200 (application/json)
  + Body
      ```json
      {
          "id": 5,
          "firstName": "Admin",
          "lastName": "Admin",
          "email": "test@test.com",
          "address": "Avenida Paulista, 198",
          "enabled": true,
          "tokenExpired": false,
          "clock": [],
          "roles": [
              {
                  "id": 3,
                  "name": "ROLE_ADMIN",
                  "privileges": [
                      {
                          "id": 1,
                          "name": "READ_PRIVILEGE"
                      },
                      {
                          "id": 2,
                          "name": "WRITE_PRIVILEGE"
                      }
                  ]
              }
          ]
      }
          ```
    
        
## URL  [https://fiapwaterclock.herokuapp.com/api/user]
### Consulta de todos os usuários cadastrados [GET]

+ Parameters
    + [token](/docs/authentication.md)

+ Request
    + Headers       
    ```json
        "Content-Type": "application/json;charset=UTF-8"
        "Authorization": "Bearer <YourTokenHere>"
      
    ```

+ Response 200 (application/json)
    + Body
        ```json
        [
            {
                "id": 5,
                "firstName": "Admin",
                "lastName": "Admin",
                "email": "test@test.com",
                "address": "Avenida Paulista, 198",
                "enabled": true,
                "tokenExpired": false,
                "clock": [],
                "roles": [
                    {
                        "id": 3,
                        "name": "ROLE_ADMIN",
                        "privileges": [
                            {
                                "id": 1,
                                "name": "READ_PRIVILEGE"
                            },
                            {
                                "id": 2,
                                "name": "WRITE_PRIVILEGE"
                            }
                        ]
                    }
                ]
            }
        ]
        ```
 ## URL  [https://fiapwaterclock.herokuapp.com/api/user/{clock_id}]
 ### Deletar usuário [DELETE]
 
 + Parameters
     + [token](/docs/authentication.md)
 
 + Request
     + Headers       
     ```json
         "Content-Type": "application/json;charset=UTF-8"
         "Authorization": "Bearer <YourTokenHere>"
       
     ```
 
 + Response 200 (application/json)



  
## URL  [<client_id>:<client_secret>@https://fiapwaterclock.herokuapp.com/oauth/token]
### Autenticação de usuário [POST]

+ Parameters
    + usuário 
    + senha

+ Request
    + Headers 
    ```json
        Content-Type: application/x-www-form-urlencoded
    ```
    + Body
        ```json
        {
            "grant_type": "password",
            "username": "user_email@email",
            "password": "exemplo"
      
        }
        ```
+ Response 200 (application/json)
    + Body
        ```json
        {
            "access_token": "YourTokenHere",
            "token_type": "bearer",
            "expires_in": 43199,
            "scope": "read write",
            "jti": "6c7ff8d4-60a4-4d5d-8047-81ecd29222d4"
        }
        ```

+ Response 401 (application/json)
    + Body
        ```json
       {
           "timestamp": "2019-10-05T21:57:30.951+0000",
           "status": 401,
           "error": "Unauthorized",
           "message": "Unauthorized",
           "path": "/oauth/token"
       }
        ```

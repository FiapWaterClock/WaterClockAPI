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
            "access_token": "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJhdWQiOlsidGVzdGp3dHJlc291cmNlaWQiXSwidXNlcl9uYW1lIjoia2FAYXIuY29tIiwic2NvcGUiOlsicmVhZCIsIndyaXRlIl0sImV4cCI6MTU3MDM1NDc1NiwiYXV0aG9yaXRpZXMiOlsiUkVBRF9QUklWSUxFR0UiXSwianRpIjoiNmM3ZmY4ZDQtNjBhNC00ZDVkLTgwNDctODFlY2QyOTIyMmQ0IiwiY2xpZW50X2lkIjoidGVzdGp3dGNsaWVudGlkIn0.iOHMnuXUN_0IXDe-oh2Kg5dO5_6-4fkVTabQ6_R1mMU",
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

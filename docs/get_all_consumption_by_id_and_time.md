## URL  [https:/fiapwaterclock.herokuapp.com/api/consumption/clock/{clock_id}/month/{month}/year/{year}]
### Request de todo o consumo de água por relógio em um mês especifico [GET]

+ Parameters
    + [token](/docs/authentication.md) - autenticação 
    + clock_id - Identificador do relógio 
    + month - Mês de consulta.
    + year - Ano de consulta.

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
            "id": 86,
            "time": "2019-10-06",
            "litersPerMinute": 4.3
        },
        {
            "id": 88,
            "time": "2019-10-06",
            "litersPerMinute": 4.3
        },
        {
            "id": 89,
            "time": "2019-10-06",
            "litersPerMinute": 4.3
        },
        {
            "id": 92,
            "time": "2019-10-06",
            "litersPerMinute": 4.3
        },
        {
            "id": 129,
            "time": "2019-10-06",
            "litersPerMinute": 8.7
        }
    ]
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
            
     + Response 400 (application/json) Caso os parametros não sejam passados corretamente.
        + Body
          ```json
             {
                 "timestamp": "2019-10-06T23:07:56.227+0000",
                 "status": 400,
                 "error": "Bad Request",
                 "message": "Failed to convert value of type 'java.lang.String' to required type 'int'; nested exception is java.lang.NumberFormatException: For input string: \"X\"",
                 "path": "/api/consumption/clock/123/month/X/year/2019"
             }
          ```
  
  
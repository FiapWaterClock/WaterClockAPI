## URL  [https://fiapwaterclock.herokuapp.com/api/consumption/{clock_id}]
### Autenticação de usuário [POST]

+ Parameters
    + [token](/docs/authentication.md)

+ Request
    + Headers       
    ```json
        Content-Type: application/json;charset=UTF-8
        Authorization: Bearer <token>
      
    ```
    
+ Response 200 (application/json)
    + Body
        ```json
        [
            {
                "id": 1,
                "clock": {
                    "id": 1,
                    "activate": true,
                    "intallation_date": null,
                    "serial_number": null,
                    "consumptions": []
                },
                "time": null,
                "litersPerMinute": 5.0
            },
            {
                "id": 2,
                "clock": {
                    "id": 1,
                    "activate": true,
                    "intallation_date": null,
                    "serial_number": null,
                    "consumptions": []
                },
                "time": null,
                "litersPerMinute": 5.0
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

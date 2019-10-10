## URL  [https://fiapwaterclock.herokuapp.com/api/consumption/{clock_id}]
### Request de todo o consumo de água por relógio [GET]

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
            "activate": true,
            "installation_date": "2014-01-01",
            "serial_number": "8765sw7dsw337",
            "consumptions": [
                {
                    "id": 25,
                    "time": "2014-01-01",
                    "litersPerMinute": 2.0
                },
                {
                    "id": 26,
                    "time": "2014-01-01",
                    "litersPerMinute": 4.0
                }
            ]
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

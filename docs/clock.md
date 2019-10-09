## URL  [https://fiapwaterclock.herokuapp.com/api/clock]
### Criação de um relógio [POST]

+ Parameters
    + [token](/docs/authentication.md)
    + activate - Se o relógio está ativo ou não.
    + serial number - número de série
    + data de instalação - formato AAA-MM-DD

+ Request
    + Headers       
    ```json
        "Content-Type": "application/json;charset=UTF-8"
        "Authorization": "Bearer <YourTokenHere>"
      
    ```
    
    + body 
    ```json
    {
    	"activate" : true,
    	"serial_number": "11111434", 
    	"intallation_date": "2019-01-01"
    }
    ```

+ Response 200 (application/json)
    + Body
        ```json
        {
            "id": 3,
            "activate": true,
            "intallation_date": "2019-01-01",
            "serial_number": "11111434",
            "consumptions": null
        }
        ```


## URL  [https://fiapwaterclock.herokuapp.com/api/clock]
### Consulta de todos os relógios cadastrados [GET]

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
                "id": 1,
                "activate": false,
                "intallation_date": null,
                "serial_number": "1242233545434",
                "consumptions": []
            },
            {
                "id": 2,
                "activate": false,
                "intallation_date": null,
                "serial_number": "3311111434",
                "consumptions": []
            },
            {
                "id": 3,
                "activate": true,
                "intallation_date": "2019-01-01",
                "serial_number": "11111434",
                "consumptions": []
            }
        ]
        ```
        
        
  ## URL  [https://fiapwaterclock.herokuapp.com/api/clock/{clock_id}]
  ### Consulta de um relógio [GET]
  
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
              "id": 1,
              "activate": false,
              "intallation_date": null,
              "serial_number": "1242545434",
              "consumptions": []
          }
          ```
          
## URL  [https://fiapwaterclock.herokuapp.com/api/clock/{clock_id}]
### update de um relogio [PUT]

+ Parameters
    + [token](/docs/authentication.md)
    + activate - Se o relógio está ativo ou não.
    + serial number - número de série
    + data de instalação - formato AAA-MM-DD

+ Request
    + Headers       
    ```json
        "Content-Type": "application/json;charset=UTF-8"
        "Authorization": "Bearer <YourTokenHere>"
      
    ```
    
    + body 
    ```json
    {
        "id": 1,
        "activate": true,
        "intallation_date": "2019-10-10",
        "serial_number": "12425445434",
        "consumptions": []
    }
    ```

+ Response 200 (application/json)
    + Body
        ```json
        {
            "id": 1,
            "activate": true,
            "intallation_date": "2019-10-10",
            "serial_number": "12425445434",
            "consumptions": []
        }
        ```
        
 ## URL  [https://fiapwaterclock.herokuapp.com/api/clock/{clock_id}]
 ### Consulta de todos os relógios cadastrados [DELETE]
 
 + Parameters
     + [token](/docs/authentication.md)
 
 + Request
     + Headers       
     ```json
         "Content-Type": "application/json;charset=UTF-8"
         "Authorization": "Bearer <YourTokenHere>"
       
     ```
 
 + Response 200 (application/json)
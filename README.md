# gendra-zip-code-demo

## CURL


    curl --location --request GET 'https://gendra-zip-service-uqjpj7hczq-ue.a.run.app/zip-codes/22645'

## Success

```json
{
  "code": "200",
  "message": "Info results for 01460",
  "response": {
    "zipcode": "01460",
    "municipality": "Álvaro Obregón",
    "fedaralEntity": "Ciudad de México",
    "locality": "Ciudad de México",
    "settlements": [
      {
        "zoneType": "Urbano",
        "settlement_type": "Colonia",
        "name": "Alfonso XIII"
      }
    ]
  }
}
```

## No match 


HTTP CODE 404

```json
{
  "code": "100",
  "message": "No match for your search 12345"
}
```


## Deliverable
- Add a README with a *curl* example on how to consume your service (must be the address of the service deployed)
- You need to upload your code to a public hosting repository site (GitHub, Gitlab, Bitbucket, etc)
- When your done, share with us the link of the us

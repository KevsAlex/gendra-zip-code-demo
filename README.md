# Backend Coding Challenge

## Requirements

Design a REST API endpoint that provides the details of a zip-code in Mexico.

- The endpoint is exposed at `/zip-codes/{zip-code}`
- The endpoint returns a JSON response with an object with the details of the given zip-code or return 404 if doesn´t exists

## Constraints

- Use your favorite JAVA framework

- The result must be deployed on google cloud (it has a free tier)

## Data Sources
You can download the entire register of zip codes of Mexico here.
- https://www.correosdemexico.gob.mx/SSLServicios/ConsultaCP/Descarga.aspx

## Advice

- **Try to design and implement your solution as you would do for real production code**. Show us how you create clean, maintainable code that does awesome stuff. Build something that we'd be happy to contribute to. This is not a programming contest where dirty hacks win the game.
- Documentation and maintainability are a plus, and don't you forget those unit tests.
- We don’t want to know if you can do exactly as asked (or everybody would have the same result). We want to know what **you** bring to the table when working on a project, what is your secret sauce. More features? Best solution? Thinking outside the box?

## Can I use a database?

You can use the database you want, but need to justify your choice. Keep in mind that **our goal here is to see some code of yours**; if you only implement a thin API on top of a DB we won't have much to look at.

Our advice is that if you choose to use an external search system, you had better be doing something really truly awesome with it.

## Sample responses

These responses are meant to provide guidance. The exact values can vary based on the data source and scoring algorithm

**Near match**

    GET /zip-codes/06140

```json
{
  "zip_code": "06140",
  "locality": "CIUDAD DE MEXICO",
  "federal_entity": "CIUDAD DE MEXICO",
  "settlements": [
    {
      "name": "CONDESA",
      "zone_type": "Urbano",
      "settlement_type": "Colonia"
    }
  ],
  "municipality": "CUAUHTEMOC"
}
```

**No match**

    GET /zip-codes/00000

```json
{}
```

## Deliverable
- Add a README with a *curl* example on how to consume your service (must be the address of the service deployed)
- You need to upload your code to a public hosting repository site (GitHub, Gitlab, Bitbucket, etc)
- When your done, share with us the link of the us

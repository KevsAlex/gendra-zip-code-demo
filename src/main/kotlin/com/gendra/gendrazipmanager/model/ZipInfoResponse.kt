package com.gendra.gendrazipmanager.model

class ZipInfoResponse {

    var zipcode : String = ""
    var asentamiento : String = ""
    var tipoAsentamiento : String = ""
    var municipio : String = ""
    var estado : String = ""
    var ciudad : String = ""
    var tipoZona = ""

    /**
     * {
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
     */
}
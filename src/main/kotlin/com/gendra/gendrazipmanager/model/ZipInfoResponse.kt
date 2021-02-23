package com.gendra.gendrazipmanager.model

class ZipInfoResponse {

    var zipcode : String = ""

    var municipality : String = ""
    var fedaralEntity : String = ""
    var locality : String = ""

    var settlements = arrayListOf<LocallityDetail>()


}
package com.gendra.gendrazipmanager.exception

/**
 * Some custom response for 404
 */
class NotFoundException : RuntimeException {

    val serialVersionUID = 1L

    //Some Arbitrary code
    var customCode: String? = null
    var responseMessage: String? = null
    var className: String? = null

    constructor(customCode: String, responseMessage: String, className: String) : super() {
        this.customCode = customCode
        this.responseMessage = responseMessage
        this.className = className
    }




}
package com.gendra.gendrazipmanager.model

/***
 * Generic class response
 */
class GenericResponse<T> {

    var code = "200"
    var message = ""
    var response: T? = null

}
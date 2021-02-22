package com.gendra.gendrazipmanager.service

import com.gendra.gendrazipmanager.model.GenericResponse
import org.springframework.stereotype.Component

@Component
interface IZipService {

    fun locationByZipCode(zipCode : String) : GenericResponse<Any>
}
package com.gendra.gendrazipmanager.controller

import com.gendra.gendrazipmanager.exception.NotFoundException
import com.gendra.gendrazipmanager.model.GenericResponse
import com.gendra.gendrazipmanager.service.IZipService
import com.gendra.gendrazipmanager.utiils.Documentation
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

import io.swagger.annotations.ApiOperation


@RestController
@RequestMapping("zip-codes/")
class ZipController {

    @Autowired
    lateinit var serviceZip: IZipService

    /**
     * Given a zipcode , gets the locallity description
     */
    @GetMapping("{zipCode}", "")
    @ApiOperation(
        value = Documentation.zipController_locationByZipCode,
        notes = Documentation.zipController_locationByZipCode_note)
    fun locationByZipCode(@PathVariable(required = false) zipCode: String?): GenericResponse<Any> {

        if (zipCode.isNullOrEmpty()) {
            throw NotFoundException("100", "empty zipCode", this::class::java.name)
        }
        return serviceZip.locationByZipCode(zipCode)
    }
}
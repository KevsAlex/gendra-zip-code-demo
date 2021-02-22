package com.gendra.gendrazipmanager.business

import com.gendra.gendrazipmanager.exception.NotFoundException
import com.gendra.gendrazipmanager.model.ConsultaCP
import com.gendra.gendrazipmanager.model.GenericResponse
import com.gendra.gendrazipmanager.model.ZipInfoResponse
import com.gendra.gendrazipmanager.service.IZipService
import com.google.api.core.ApiFuture
import com.google.cloud.firestore.Firestore
import com.google.cloud.firestore.QuerySnapshot
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service
import com.google.api.core.ApiFutureCallback

import com.google.api.core.ApiFutures
import com.google.firebase.auth.FirebaseToken

import com.google.firebase.auth.FirebaseAuth

import java.util.concurrent.Executor
import com.google.cloud.firestore.DocumentSnapshot


@Service
class ZipService : IZipService {

    @Autowired
    lateinit var db: Firestore

    override fun locationByZipCode(zipCode: String): GenericResponse<Any> {
        val citiesRef = db.collection("zipcodes")
        val genericResponse = GenericResponse<Any>()
        var zipArrayResponse = arrayListOf<ZipInfoResponse>()

        val query = citiesRef.whereEqualTo("d_codigo", zipCode)
        var documents = query.get().get().documents
        if (documents.size <= 0){
            throw NotFoundException("100","No match for your search ${zipCode}",this::class.java.name)
        }
        for (document in documents) {
            var zipInfo = document.toObject(ConsultaCP::class.java)
            val zipInfoResponse = ZipInfoResponse()
            zipInfoResponse.zipcode = zipCode
            zipInfoResponse.ciudad = zipInfo.d_ciudad
            zipInfoResponse.asentamiento = zipInfo.d_asenta
            zipInfoResponse.municipio = zipInfo.D_mnpio
            zipInfoResponse.estado = zipInfo.d_estado
            zipInfoResponse.tipoAsentamiento = zipInfo.d_tipo_asenta
            zipInfoResponse.tipoZona = zipInfo.d_zona
            zipArrayResponse.add(zipInfoResponse)
        }

        genericResponse.response = zipArrayResponse
        return genericResponse
    }
}
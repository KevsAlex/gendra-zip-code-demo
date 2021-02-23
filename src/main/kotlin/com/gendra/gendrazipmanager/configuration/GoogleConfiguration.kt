package com.gendra.gendrazipmanager.configuration

import com.google.api.gax.paging.Page
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import com.google.cloud.firestore.Firestore

import com.google.firebase.FirebaseApp

import com.google.firebase.FirebaseOptions

import com.google.auth.oauth2.GoogleCredentials
import com.google.cloud.storage.Bucket
import com.google.cloud.storage.Storage
import com.google.firebase.cloud.FirestoreClient
import com.google.cloud.storage.StorageOptions
import com.google.common.collect.Lists

import java.io.FileInputStream

import java.io.IOException
import com.google.api.client.googleapis.auth.oauth2.GoogleCredential
import org.springframework.beans.factory.annotation.Value


@Suppress("DEPRECATION")
@Configuration
class GoogleConfiguration {

    @Value("\${google.proyect.id}")
    lateinit var proyectGCP: String

    /**
     * Google cloud config
     */
    @Bean
    fun fireStoreConfig(): Firestore {

        //val credentials = GoogleCredentials.getApplicationDefault()
        val credentials: GoogleCredentials = GoogleCredentials.fromStream(FileInputStream("google_owner_account.json"))
            .createScoped(Lists.newArrayList("https://www.googleapis.com/auth/cloud-platform"))
        val storage: Storage = StorageOptions.newBuilder().setCredentials(credentials).build().service
        println("Buckets:")
        val buckets: Page<Bucket> = storage.list()
        for (bucket in buckets.iterateAll()) {
            System.out.println(bucket.toString())
        }


        val options = FirebaseOptions.Builder()
            .setCredentials(credentials)
            .setProjectId(proyectGCP)
            .build()
        FirebaseApp.initializeApp(options)

        return FirestoreClient.getFirestore()

    }





}
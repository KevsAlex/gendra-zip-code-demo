package com.gendra.gendrazipmanager.unit

import com.gendra.gendrazipmanager.model.GenericResponse
import com.gendra.gendrazipmanager.model.ZipInfoResponse
import com.gendra.gendrazipmanager.service.IZipService
import org.hamcrest.CoreMatchers
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mockito
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.http.MediaType
import org.springframework.test.context.junit4.SpringRunner
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.MvcResult
import org.springframework.test.web.servlet.RequestBuilder
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import org.springframework.test.web.servlet.result.MockMvcResultHandlers
import org.springframework.test.web.servlet.result.MockMvcResultMatchers

@RunWith(SpringRunner::class)
@SpringBootTest
@AutoConfigureMockMvc
class ZipServiceTest {

    @Autowired
    private lateinit var mockMvc: MockMvc

    @MockBean
    lateinit var serviceZip: IZipService


    private val genericProductoResponse: GenericResponse<Any> = GenericResponse()
    private val zipInfoResponse = ZipInfoResponse()
    private fun <T> any(type: Class<T>): T = Mockito.any<T>(type)

    /**
     * Check if the service response is correct
     */
    @Test
    @Throws(Exception::class)
    fun test_locationByZipCode() {

        zipInfoResponse.zipcode = "some zipCode"
        zipInfoResponse.fedaralEntity = "some federal"
        zipInfoResponse.locality = "some"
        zipInfoResponse.municipality = "some municipallity"
        genericProductoResponse.response = zipInfoResponse
        Mockito.`when`(serviceZip.locationByZipCode("22645")).thenReturn(genericProductoResponse)

        val requestBuilder: RequestBuilder = MockMvcRequestBuilders.get("/zip-codes/22645")
            .accept("application/json")
            .contentType("application/json")


        val resultOK: MvcResult = mockMvc.perform(requestBuilder).andExpect(MockMvcResultMatchers.status().isOk)
            .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
            .andExpect(
                MockMvcResultMatchers.jsonPath(
                    "$.response.municipality",
                    CoreMatchers.`is`(zipInfoResponse.municipality)
                )
            )
            .andReturn()
    }

    /**
     * Check if 404 is thrown
     */
    @Test
    @Throws(Exception::class)
    fun testAnExeptionisThrown() {
        val requestBuilderFalse: RequestBuilder = MockMvcRequestBuilders.get("/zip-codes/aaaa/aaaa")
        mockMvc.perform(requestBuilderFalse)
            .andExpect(MockMvcResultMatchers.status().isNotFound)
            .andDo(MockMvcResultHandlers.print())
            .andReturn()


    }
}
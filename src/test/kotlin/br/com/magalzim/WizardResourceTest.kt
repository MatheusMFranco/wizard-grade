package br.com.magalzim

import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.get
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import org.springframework.test.web.servlet.result.MockMvcResultMatchers
import org.testcontainers.junit.jupiter.Testcontainers

@Testcontainers
@AutoConfigureMockMvc
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class WizardResourceTest : DatabaseContainerConfigurationTest() {

    @Autowired
    private lateinit var mockMvc: MockMvc

    companion object {
        private const val URI = "/wizards"
    }

    @Test
    fun `should return 200 code when call wizards endpoint`() {
        mockMvc.get(URI).andExpect { status { isOk() } }
    }

    @Test
    fun `should return 200 code when call one wizard`() {
        mockMvc.get(URI.plus("/t811825")).andExpect { status { isOk() } }
    }

    @Test
    fun `should return 200 code when save wizard`() {
        val wizard = """
            {
                "id": "x1234567",
                "name": "Sirius Black",
                "house": "Grifinória",
                "isStudent": false
            }
        """
        mockMvc.perform(MockMvcRequestBuilders.post(URI)
            .contentType(MediaType.APPLICATION_JSON)
            .content(wizard))
            .andExpect(MockMvcResultMatchers.status().is2xxSuccessful)
    }
    @Test
    fun `should return 200 code when update wizard`() {
        val wizard = """
            {
                "id": "x1285016",
                "name": "Lord Voldemort",
                "house": "Sonserina",
                "isStudent": false
            }
        """"
        mockMvc.perform(MockMvcRequestBuilders.put(URI.plus("/x1285016"))
            .contentType(MediaType.APPLICATION_JSON)
            .content(wizard))
            .andExpect(MockMvcResultMatchers.status().is2xxSuccessful)
    }

    @Test
    fun `should return 200 code when call wizards by house`() {
        mockMvc.get(URI.plus("/house/grifinoria")).andExpect { status { isOk() } }
    }
}
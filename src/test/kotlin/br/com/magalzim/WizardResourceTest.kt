package br.com.magalzim

import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.get
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
}
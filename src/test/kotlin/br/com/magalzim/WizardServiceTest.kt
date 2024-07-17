package br.com.magalzim

import br.com.magalzim.adapters.http.WizardHttpService
import br.com.magalzim.core.service.WizardService
import br.com.magalzim.domain.ports.WizardRepository
import io.kotest.core.spec.style.FunSpec
import io.mockk.coEvery
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify

class WizardServiceTest : FunSpec({
    val wizard = WizardFixture.getWizard()

    lateinit var wizardRepository: WizardRepository
    lateinit var wizardHttpService: WizardHttpService
    lateinit var wizardService: WizardService

    beforeTest {
        wizardRepository = mockk {
            every { listAll() } returns listOf(wizard)
            every { listByHouse(any()) } returns listOf(wizard)
        }

        wizardHttpService = mockk {
            coEvery { getByHouse(any()) }  returns mockk()
        }

        wizardService = WizardService(wizardRepository, wizardHttpService)
    }

    test("should return all items of specific house") {
        wizardService.list("grifinoria")

        verify(exactly = 1) { wizardRepository.listByHouse(any()) }
        verify(exactly = 0) { wizardRepository.listAll() }
    }

    test("should return all items of all houses") {
        wizardService.list(null)

        verify(exactly = 0) { wizardRepository.listByHouse(any()) }
        verify(exactly = 1) { wizardRepository.listAll() }
    }

})
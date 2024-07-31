package br.com.magalzim

import br.com.magalzim.adapters.http.WizardHttpService
import br.com.magalzim.core.converter.WizardToMuggleConverter
import br.com.magalzim.core.service.WizardService
import br.com.magalzim.domain.ports.WizardRepository
import io.kotest.core.spec.style.FunSpec
import io.mockk.*

class WizardServiceTest : FunSpec({
    val wizard = WizardFixture.getWizard()
    val muggle = WizardHttpFixture.getWizardHttp()

    lateinit var wizardRepository: WizardRepository
    lateinit var wizardHttpService: WizardHttpService
    lateinit var wizardService: WizardService

    beforeTest {
        wizardRepository = mockk {
            every { listAll() } returns listOf(wizard)
            every { listByHouse(any()) } returns listOf(wizard)
            every { findById(any()) } returns wizard
            every { save(any()) } returns 1
            every { update(any(), any()) } returns 1
        }

        mockkStatic(WizardToMuggleConverter::class)
        wizardHttpService = mockk {
            coEvery { getByHouse(any()) } returns listOf(muggle)
        }

        wizardService = WizardService(wizardRepository, wizardHttpService)
    }

    test("should return all items of specific house") {
        wizardService.list("Grifindor")
        verify(exactly = 1) { wizardRepository.listByHouse(any()) }
        verify(exactly = 0) { wizardRepository.listAll() }
    }

    test("should return all items of all houses") {
        wizardService.list(null)
        verify(exactly = 0) { wizardRepository.listByHouse(any()) }
        verify(exactly = 1) { wizardRepository.listAll() }
    }

    test("should save a wizard") {
        wizardService.save(wizard)
        verify(exactly = 1) { wizardRepository.save(wizard) }
    }

    test("should update a wizard") {
        wizardService.update(wizard, wizard.id)
        verify(exactly = 1) { wizardRepository.update(wizard, wizard.id) }
    }

    test("should find a wizard") {
        wizardService.findById(wizard.id)
        verify(exactly = 1) { wizardRepository.findById(wizard.id) }
    }

    test("should return all wizards by house") {
        val house = "grifinoria"
        wizardService.findByHouse(house)
        coVerify(exactly = 1) { wizardHttpService.getByHouse(house) }
    }

})
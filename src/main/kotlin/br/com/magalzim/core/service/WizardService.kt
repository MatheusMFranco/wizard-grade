package br.com.magalzim.core.service

import br.com.magalzim.adapters.http.WizardHttpService
import br.com.magalzim.core.converter.WizardToMuggleConverter
import br.com.magalzim.domain.model.Wizard
import br.com.magalzim.domain.ports.WizardRepository
import br.com.magalzim.domain.ports.WizardService
import kotlinx.coroutines.coroutineScope
import org.springframework.cache.annotation.CacheEvict
import org.springframework.cache.annotation.Cacheable
import org.springframework.stereotype.Service

@Service
internal class WizardService(
    private val wizardRepository: WizardRepository,
    private val wizardHttpService: WizardHttpService
) : WizardService {

    @Cacheable(cacheNames = ["Wizard"], key = "#root.method.name")
    override fun list(house: String?) =
        house?.let {
            wizardRepository.listByHouse(it)
        } ?: wizardRepository.listAll()

    @CacheEvict(cacheNames = ["Wizard"], allEntries = true)
    override fun save(wizard: Wizard) = wizardRepository.save(wizard)

    @CacheEvict(cacheNames = ["Wizard"], allEntries = true)
    override fun update(wizard: Wizard, id: String) = wizardRepository.update(wizard, id)

    override fun findById(id: String): Wizard {
        return wizardRepository.findById(id) ?: throw RuntimeException()
    }

    override suspend fun findByHouse(house: String) = coroutineScope {
        val response = wizardHttpService.getByHouse(house)
        WizardToMuggleConverter.toMuggle(response)
    }
}

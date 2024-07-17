package br.com.magalzim.domain.ports

import br.com.magalzim.domain.model.Wizard

interface WizardService {
    fun list(house: String?): List<Wizard>
    fun save(wizard: Wizard): Int
    fun update(wizard: Wizard, id: String): Int
    fun findById(id: String): Wizard
    suspend fun findByHouse(house: String): List<Wizard>?
}

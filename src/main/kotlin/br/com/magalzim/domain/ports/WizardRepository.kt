package br.com.magalzim.domain.ports

import br.com.magalzim.domain.model.Wizard

interface WizardRepository {
    fun listAll(): List<Wizard>
    fun listByHouse(house: String): List<Wizard>
    fun save(wizard: Wizard): Int
    fun update(wizard: Wizard, id: String): Int
    fun findById(id: String): Wizard?
}

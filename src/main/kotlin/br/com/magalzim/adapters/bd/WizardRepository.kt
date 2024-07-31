package br.com.magalzim.adapters.bd

import br.com.magalzim.domain.model.Wizard
import br.com.magalzim.domain.ports.WizardRepository
import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.stereotype.Repository

@Repository
class WizardRepository(
    private val jdbcTemplate: JdbcTemplate
) : WizardRepository {

    override fun listAll(): List<Wizard> = jdbcTemplate.query("SELECT * FROM wizard", WizardMapper())

    override fun listByHouse(house: String): List<Wizard> =
        jdbcTemplate.query("SELECT * FROM wizard WHERE house = ?", WizardMapper(), house)

    override fun save(wizard: Wizard) = jdbcTemplate.update(
        "INSERT INTO wizard(name, house, is_student, id) VALUES(?,?,?,?)",
        wizard.name,
        wizard.house,
        wizard.isStudent,
        wizard.id
    )

    override fun update(wizard: Wizard, id: String) = jdbcTemplate.update(
        "UPDATE wizard SET name = ?, house = ?, is_student = ? WHERE id = ?",
        wizard.name,
        wizard.house,
        wizard.isStudent,
        id
    )

    override fun findById(id: String): Wizard? = jdbcTemplate.queryForObject("SELECT * FROM wizard WHERE id = ?", WizardMapper(), id)
}

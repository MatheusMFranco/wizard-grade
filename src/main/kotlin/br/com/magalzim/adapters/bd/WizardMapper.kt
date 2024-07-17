package br.com.magalzim.adapters.bd

import br.com.magalzim.domain.model.Wizard
import org.springframework.jdbc.core.RowMapper
import java.sql.ResultSet

class WizardMapper : RowMapper<Wizard> {
    override fun mapRow(rs: ResultSet, rowNum: Int) = Wizard(
        id = requireNotNull(rs.getString("id")),
        name = requireNotNull(rs.getString("name")),
        house = requireNotNull(rs.getString("house")),
        isStudent = rs.getBoolean("is_student")
    )
}

package br.com.magalzim.core.converter

import br.com.magalzim.adapters.http.WizardHttp
import br.com.magalzim.domain.model.Wizard
import br.com.magalzim.util.house
import br.com.magalzim.util.wizardID

object WizardToMuggleConverter {
    fun toMuggle(wizardsHttp: List<WizardHttp>) =
        wizardsHttp.map {
            Wizard(
                id = it.id.wizardID((it.hogwartsStudent)),
                name = it.name,
                isStudent = it.hogwartsStudent,
                house = it.house.house()
            )
        }
}
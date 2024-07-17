package br.com.magalzim.adapters.api

import br.com.magalzim.domain.model.Wizard
import br.com.magalzim.domain.ports.WizardService
import br.com.magalzim.util.houseFromPortuguese
import kotlinx.coroutines.runBlocking
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/wizards")
class WizardResource(
    private val wizardService: WizardService
) {
    @GetMapping
    fun list(@RequestParam(required = false) house: String?) = wizardService.list(house)

    @PostMapping
    fun save(@RequestBody wizard: Wizard) = wizardService.save(wizard)

    @PutMapping("/{id}")
    fun update(@RequestBody wizard: Wizard, @PathVariable id: String) = wizardService.update(wizard, id)

    @GetMapping("/{house}")
    fun getByImdb(@PathVariable house: String) = runBlocking {
        wizardService.findByHouse(house.houseFromPortuguese())
    }
}
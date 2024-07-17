package br.com.magalzim

import br.com.magalzim.util.house
import br.com.magalzim.util.houseFromPortuguese
import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

class WizardTest : FunSpec({

    val wizard = WizardFixture.getWizard()
    val muggle = WizardHttpFixture.getWizardHttp()

    test("should return original name house") {
        val actual = wizard.house

        actual.houseFromPortuguese() shouldBe "gryffindor"
    }

    test("should return portuguese name house") {
        val actual = muggle.house

        actual.house() shouldBe "Grifinória"
    }
})
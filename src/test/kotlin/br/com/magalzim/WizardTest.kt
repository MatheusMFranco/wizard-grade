package br.com.magalzim

import br.com.magalzim.util.house
import br.com.magalzim.util.houseFromPortuguese
import br.com.magalzim.util.wizardID
import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

class WizardTest : FunSpec({

    val wizard = WizardFixture.getWizard()
    val muggle = WizardHttpFixture.getWizardHttp()

    test("should return original name house") {
        "grifinoria".houseFromPortuguese() shouldBe "gryffindor"
        "lufalufa".houseFromPortuguese() shouldBe "hufflepuff"
        "corvinal".houseFromPortuguese() shouldBe "ravenclaw"
        "sonserina".houseFromPortuguese() shouldBe "slytherin"
        "castelobruxo".houseFromPortuguese() shouldBe "Unknown House"
    }

    test("should return portuguese name house") {
        "gryffindor".house() shouldBe "Grifinória"
        "hufflepuff".house() shouldBe "Lufa-Lufa"
        "ravenclaw".house() shouldBe "Corvinal"
        "slytherin".house() shouldBe "Sonserina"
        "castelobruxo".house() shouldBe "Casa desconhecida"
    }

    test("should return wizard id") {
        muggle.id.wizardID(true) shouldBe wizard.id
        muggle.id.wizardID(false) shouldBe "x9e3f7ce"
    }
})
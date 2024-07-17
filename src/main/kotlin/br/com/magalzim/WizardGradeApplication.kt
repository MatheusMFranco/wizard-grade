package br.com.magalzim

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cache.annotation.EnableCaching
import org.springframework.context.annotation.ComponentScan

@EnableCaching
@SpringBootApplication
@ComponentScan("br.com.magalzim")
class WizardGradeApplication

fun main(args: Array<String>) {
    runApplication<WizardGradeApplication>(*args)
}

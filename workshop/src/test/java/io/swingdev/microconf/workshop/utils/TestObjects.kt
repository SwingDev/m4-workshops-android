package io.swingdev.microconf.workshop.utils

import io.swingdev.microconf.workshop.domain.model.CatFact


object TestObjects {
    val savedFacts: List<CatFact> = listOf(
        CatFact("a", "First fact"),
        CatFact("b", "Second fact"),
        CatFact("c", "Third fact")
    )

    val newFacts: List<CatFact> = listOf(
        CatFact("d", "New First fact"),
        CatFact("e", "New Second fact"),
        CatFact("f", "New Third fact")
    )
}
package com.github.ianlondon.pokeapi

import argonaut._, Argonaut._

case class Pokemon(name: String, id: Int, height: Int, weight: Int) {
  override def toString: String = s"""${name.capitalize}: #$id
    |==============================
    |Height: $height
    |Weight: $weight""".stripMargin
}


object Pokemon {
  implicit def PokemonCodecJson: CodecJson[Pokemon] =
    casecodec4(Pokemon.apply, Pokemon.unapply)("name", "id", "height", "weight")
}


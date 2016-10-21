package pokeapi

import org.scalatest.{FlatSpec, Matchers}
import argonaut._, Argonaut._

class PokemonSpec extends FlatSpec with Matchers {

  trait Pikachu {
    val pikaJSON = """
      {
        "name":"pikachu",
        "id":25,
        "height":4,
        "weight":60
      }
    """

    val pikaPokemon = Pokemon("pikachu", 25, 4, 60)
  }

  "Pokemon model" should "decode JSON" in new Pikachu {
    val pokeOption = pikaJSON.decodeOption[Pokemon]
    pokeOption should contain (pikaPokemon)
  }

  it should "fetch pikachu from pokeapi by name" in new Pikachu {
    PokeAPI.getPokemonOption("pikachu") should contain (pikaPokemon)
  }

  it should "fetch pikachu from pokeapi by id" in new Pikachu {
    PokeAPI.getPokemonOption(pikaPokemon.id.toString) should contain (pikaPokemon)
  }

}

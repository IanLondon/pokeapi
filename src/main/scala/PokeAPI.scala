package com.github.ianlondon.pokeapi

import argonaut._, Argonaut._
import scalaj.http._

object PokeAPI {
  val usage = """
  Usage:
    pokeapi <pokemon id or name>
  """

  def getPokemonOption(pokemonIdOrName: String, 
    connTimeoutMs: Int = 5000,
    readTimeoutMs: Int = 5000): Option[Pokemon] = {

    val baseUrl = "http://pokeapi.co/api/v2/pokemon/"

    val response: HttpResponse[String] = 
      Http(baseUrl + pokemonIdOrName).option(
        HttpOptions.followRedirects(true)
      ).timeout(
        connTimeoutMs = connTimeoutMs, 
        readTimeoutMs = readTimeoutMs
      ).asString

    val rawJSON: Option[String] = 
      if (response.code == 200) Some(response.body) 
      else {
        println(s"Got bad response code ${response.code} .")
        None
      }
 
    rawJSON flatMap (_.decodeOption[Pokemon])
  }

  def main(args: Array[String]): Unit = {

    if (args.length == 1) {
      val pokeOption = getPokemonOption(args(0))

      println(pokeOption.getOrElse("pokemon not found"))
    }
    else println(usage)
  }
}

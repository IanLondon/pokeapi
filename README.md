# Extremely minimal Pokéapi wrapper in Scala

Not so much a wrapper as a Pokédex that uses Pokéapi.

You can get Pokémon info via Pokémon name or ID number. Try `sbt "run pikachu"` or `sbt "run 151"` to show some Pokédex information.

```
Pikachu: #25
==============================
Height: 4
Weight: 60
```

# TODO:
* Make installable command-line tool
* Display more info about a Pokémon
* Use Either instead of Option for more detailed failure messages
* Get rid of `println`

# Details:
Gets data from [Pokéapi](https://pokeapi.co/). Uses [Argonaut](http://argonaut.io/) to parse JSON, and [scalaj](https://github.com/scalaj/scalaj-http) for HTTP requests.

Run the tests with `sbt test`

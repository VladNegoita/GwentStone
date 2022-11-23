# GwentStone

<div align="center"><img src="https://tenor.com/view/witcher3-gif-9340436.gif" width="500px"></div>

## Structure

In order to be consistent, I have provided a class for
each possible action and for each possible card that
has an ability.

### Cards

```
.
├── Ability.java
├── Card.java
├── EnvironmentCards
│   ├── Environment.java
│   ├── Firestorm.java
│   ├── HeartHound.java
│   └── Winterfell.java
├── HeroCards
│   ├── EmpressThorina.java
│   ├── GeneralKocioraw.java
│   ├── Hero.java
│   ├── KingMudface.java
│   └── LordRoyce.java
└── MinionCards
    ├── Disciple.java
    ├── Minion.java
    ├── Miraj.java
    ├── SpecialAbilityMinion.java
    ├── TheCursedOne.java
    └── TheRipper.java
```

`Card` class that is the ancestor of all the other
card classes (hence providing a common way of being stored).<br />

`Ability` is an interface provided for cards performing
specific actions (e.g. Heroes, Environment Cards, Minions
with special abilities).

### Actions
```
.
├── Action.java
├── CardUsesAbility.java
├── CardUsesAttack.java
├── EndPlayerTurn.java
├── GetCardAtPosition.java
├── GetCardsInHand.java
├── GetCardsOnTable.java
├── GetEnvironmentCardsInHand.java
├── GetFrozenCardsOnTable.java
├── GetPlayerDeck.java
├── GetPlayerHero.java
├── GetPlayerMana.java
├── GetPlayerOneWins.java
├── GetPlayerTurn.java
├── GetPlayerTwoWins.java
├── GetTotalGamesPlayed.java
├── PlaceCard.java
├── UseAttackHero.java
├── UseEnvironmentCard.java
└── UseHeroAbility.java
```

### Other Classes

```
.
├── Constants.java
├── Helpers.java
├── LoadNewGame.java
├── Main.java
├── Player.java
├── Stats.java
├── Table.java
└── Test.java
```

`Constants` is a static class that stores values of the constants.
<br />
`Stats` is used for displaying statistics for the current match.
<br />
`LoadNewGame` handles the beginning of a new game.
<br />
`Helpers` stores some useful static methods.




## Game Flow
First of all, we load the `decks` for the `players`.
<br />
Each new game launches a method `loadStartGame` that
loads the specific configuration of the game.
Then, we apply each `Action` using the generic `apply` method.

## Usage
You should run `Main` - it includes the entire checker functionality.

###### Copyright: Vlad-Andrei Negoita

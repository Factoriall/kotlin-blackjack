package blackjack

import java.util.Stack

class CardDeck(
    cards: List<PlayingCard> = PlayingCards.createCards().cards,
    shuffleStrategy: ShuffleStrategy = RandomShuffleStrategy()
) {
    val cardDeck = Stack<PlayingCard>().apply {
        addAll(shuffleStrategy.shuffle(cards))
    }

    fun drawCard(): PlayingCard = cardDeck.pop()
    fun drawInitialCards(): List<PlayingCard> = listOf(drawCard(), drawCard())
}
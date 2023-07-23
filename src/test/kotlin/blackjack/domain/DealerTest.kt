package blackjack.domain

import blackjack.testdouble.StubCardGenerator
import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.collections.shouldHaveSize
import io.kotest.matchers.shouldBe

class DealerTest : FunSpec({

    test("딜러는 플레이어에게 랜덤으로 카드를 나누어준다.") {
        // given
        val card = Card(Rank.JACK, Suit.SPADE)
        val dealer = Dealer(StubCardGenerator(card))

        // when
        val actual = dealer.dealCard()

        // then
        actual shouldBe card
    }

    test("딜러는 카드를 받을 수 있다.") {
        // given
        val dealer = Dealer()
        val expectedSize = 2
        val cards = listOf(Card(Rank.THREE, Suit.SPADE), Card(Rank.QUEEN, Suit.CLUB))

        // when
        dealer.receiveCards(cards)

        // then
        dealer.cards.values shouldHaveSize expectedSize
    }
})
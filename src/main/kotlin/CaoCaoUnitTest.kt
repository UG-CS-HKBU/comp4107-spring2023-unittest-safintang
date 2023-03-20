import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test



class CaoCaoUnitTest {

    @Test
    fun testCaoDodgeAttack(){
        fakeHeroes.add(fakeMonarchHero)
        fakeMonarchHero.setCommand(Abandon(fakeMonarchHero))
        for (i in 0..2) {
            var fakeHero =UnitTest.FakeNonmoarchFactory.createRandomHero()
            fakeHero.index = fakeHeroes.size;
            fakeHeroes.add(fakeHero)
        }

        assertTrue(fakeMonarchHero.dodgeAttack())
    }
}
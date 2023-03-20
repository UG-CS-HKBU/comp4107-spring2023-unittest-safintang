
import junit.framework.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test


var fakeMonarchHero: MonarchHero = UnitTest.FakeMonarchFactory.createRandomHero() as MonarchHero
var fakeHeroes = mutableListOf<Hero>();

class UnitTest {
    @Test
    public fun test1CaoDodgeAttack(): Unit {
        var haveWeiMinisterRole: Boolean = false;
        monarchHero = CaoCao()
        for (i in 0 until 7) {
            val random = NoneMonarchFactory.createRandomHero()
            if (random == SimaYi(MinisterRole()) ||
                random == XuChu(MinisterRole()) ||
                random == XiaHouyuan(MinisterRole())
            ) {
                haveWeiMinisterRole = true;
            }
            heroes.add(random);
        }

        if (haveWeiMinisterRole) {
            assertTrue(monarchHero.dodgeAttack());
        } else {
        }
    }

    @Test
    fun test2BeingAttacked() {
        if (heroes.size==0){
            heroes.add(NoneMonarchFactory.createRandomHero())
        }
        for(i in 0 until heroes.size){
            var hero= heroes[i]
           object : Hero(hero.role){
                override val name: String = hero.name
                override fun beingAttacked() {
                   super.beingAttacked()
                   assertTrue(hero.hp >= 0)
               }
            }
            for(p in 0 until 10)
                hero.beingAttacked()
        }
    }


    object FakeNonmoarchFactory: GameObjectFactory {
        var count = 0
        var last: WeiHero? = null
        init {
            monarchHero = CaoCao()
        }
        override fun getRandomRole(): Role =
            MinisterRole()
        override fun createRandomHero(): Hero {
            val hero = when(count++) {
                0->SimaYi(MinisterRole())
                1->XuChu(MinisterRole())
                else->XiaHouyuan(MinisterRole())
            }
            val cao = fakeMonarchHero as CaoCao
            if (last == null)
                cao.helper = hero
            else
                last!!.setNext(hero)
            last = hero
            return hero }}

    object FakeMonarchFactory: GameObjectFactory{
        override fun getRandomRole(): Role {
            TODO("Unnecessary")
        }

        override fun createRandomHero(): Hero {
            return CaoCao()
        }
    }

    class DummyRole() : Role {
        override val roleTitle: String = "";
        override fun getEnemy(): String {
           return "";
        }
    }

    @Test
    fun testDiscardCards() {
        val dummy = DummyRole() 
        val hero = ZhangFei(dummy)
        val spy = object: WarriorHero(MinisterRole()) {
            override val name = hero.name
            override fun discardCards() {
                hero.discardCards()
                assertTrue(hero.hp >= hero.numOfCards)
            } }
        for(i in 0..10)
            spy.discardCards()
    }
}




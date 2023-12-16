fun main(args: Array<String>) {
    val tim = Player("Tim")
//    println(tim.name)
//    println(tim.lives)
//    println(tim.level)
//    println(tim.score)
    tim.show()

    val louise = Player("Louise",5)
    louise.show()

    val petr = Player("Petr", 4, 8)
    val honza = Player("Honza", 2, 5, 1000)

    petr.show()
    honza.show()
    println(honza.weapon.name.uppercase())
    println(honza.weapon.damageInflicted)

    val axe = Weapon("Axe", 12)
    honza.weapon = axe
    println(honza.weapon.name)
    println(axe.name)

    axe.damageInflicted = 24
    println(axe.damageInflicted)

    tim.weapon =Weapon("Sword", 10)
    println(tim.weapon.name)

    louise.weapon = tim.weapon
    louise.show()
    tim.show()

    val redPotion = Loot("Red potion", LootType.POTION, 7.50)
    tim.getLoot(redPotion)
    val chestArmor = Loot("+3 ChestArmor", LootType.ARMOR,80.00)
    tim.getLoot(chestArmor)

    tim.getLoot(Loot("Ring of protection + 2", LootType.RING, 40.25))
    tim.getLoot(Loot("Invisibility Potion", LootType.POTION, 35.95))
    tim.showInventory()

    if (tim.dropLoot(redPotion)) {
        tim.showInventory()
    } else {
        println("you don't hava a ${redPotion.name}")
    }

    val bluePotion = Loot("Blue Potion", LootType.POTION, 6.00)
    if (tim.dropLoot(bluePotion)) {
        tim.showInventory()
    } else {
        println("you don't have ${bluePotion.name}")
    }

    if (tim.dropLoot("Invisibility Potion")) {
        tim.showInventory()
    } else {
        println("You don't have an Invisibility Potion")
    }


//    for (i in 0 until 10) {
//        println("$i squared is ${i*i}")
//    }
//
//    for (i in 10 downTo 0) {
//        println("$i squared is ${i*i}")
//    }
//
//    for (i in 10 downTo 0 step 2) {
//        println("$i squared is ${i*i}")
//    }
//
//    for (i in 0 until 10) {
//        println("$i squared is ${i*i}")
//    }

//    for (i in 0 until 100 step 3) {
//        if ((i % 3) == 0 && (i % 5) == 0) {
//            println("$i is divisible by 3 and 5")
//        }
//    }
}
enum class LootType {
    POTION, RING, ARMOR
}

class Loot(val name: String, val type: LootType, val value: Double) {

    override fun toString(): String {
        return "Loot $name is $type with $value"
    }
}
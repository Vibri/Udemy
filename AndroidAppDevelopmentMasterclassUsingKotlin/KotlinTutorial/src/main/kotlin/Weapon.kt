class Weapon(val name: String, var damageInflicted: Int) {

    override fun toString(): String {
        return "$name with damage inflicted $damageInflicted"
    }
}
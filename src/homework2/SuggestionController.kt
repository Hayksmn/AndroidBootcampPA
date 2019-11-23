package homework2

import homework2.entity.Tag
import homework2.entity.User
import java.util.*

private val userList: List<User> = listOf(
    User(UUID.randomUUID().toString(), "a", "Kirstie", "Gebhardt"),
    User(UUID.randomUUID().toString(), "b", "Tambra", "Krone"),
    User(UUID.randomUUID().toString(), "c", "Sherice", "Lucey"),
    User(UUID.randomUUID().toString(), "d", "Casandra", "Farr"),
    User(UUID.randomUUID().toString(), "e", "Werner", "Bertram"),
    User(UUID.randomUUID().toString(), "f", "Magdalena", "Vanzile"),
    User(UUID.randomUUID().toString(), "g", "Perry", "Perkin"),
    User(UUID.randomUUID().toString(), "h", "Zachariah", "Amon"),
    User(UUID.randomUUID().toString(), "i", "Parker", "Lyles"),
    User(UUID.randomUUID().toString(), "j", "Fawn", "Fredericksen"),
    User(UUID.randomUUID().toString(), "k", "Kyla", "Sergio"),
    User(UUID.randomUUID().toString(), "l", "Jeffrey", "Bramblett"),
    User(UUID.randomUUID().toString(), "m", "Irina", "Beason"),
    User(UUID.randomUUID().toString(), "n", "Marsha", "Gierlach"),
    User(UUID.randomUUID().toString(), "o", "Latrice", "Breshears"),
    User(UUID.randomUUID().toString(), "p", "Ramonita", "Arroyo"),
    User(UUID.randomUUID().toString(), "q", "Elizbeth", "Shingleton"),
    User(UUID.randomUUID().toString(), "r", "Pauletta", "Landis"),
    User(UUID.randomUUID().toString(), "s", "Meri", "Mcauliffe"),
    User(UUID.randomUUID().toString(), "t", "Cordell", "Devalle"),
    User(UUID.randomUUID().toString(), "u", "Levi", "Hiltner"),
    User(UUID.randomUUID().toString(), "v", "Ike", "Printz"),
    User(UUID.randomUUID().toString(), "w", "Roxy", "Bruning"),
    User(UUID.randomUUID().toString(), "x", "Eulah", "Kohen"),
    User(UUID.randomUUID().toString(), "y", "Sherril", "Botkin"),
    User(UUID.randomUUID().toString(), "z", "Sol", "Grubaugh")
)

private val userRecent = mutableSetOf<User>()

private val tagList: List<Tag> = listOf(
    Tag(UUID.randomUUID().toString(), "art"),
    Tag(UUID.randomUUID().toString(), "tagblender"),
    Tag(UUID.randomUUID().toString(), "artist"),
    Tag(UUID.randomUUID().toString(), "artistic"),
    Tag(UUID.randomUUID().toString(), "myart"),
    Tag(UUID.randomUUID().toString(), "artwork"),
    Tag(UUID.randomUUID().toString(), "illustration"),
    Tag(UUID.randomUUID().toString(), "color"),
    Tag(UUID.randomUUID().toString(), "colour"),
    Tag(UUID.randomUUID().toString(), "colorful"),
    Tag(UUID.randomUUID().toString(), "painting"),
    Tag(UUID.randomUUID().toString(), "drawing"),
    Tag(UUID.randomUUID().toString(), "markers"),
    Tag(UUID.randomUUID().toString(), "paintings"),
    Tag(UUID.randomUUID().toString(), "watercolor"),
    Tag(UUID.randomUUID().toString(), "ink"),
    Tag(UUID.randomUUID().toString(), "creative"),
    Tag(UUID.randomUUID().toString(), "sketch"),
    Tag(UUID.randomUUID().toString(), "pencil"),
    Tag(UUID.randomUUID().toString(), "beautiful")
)

private val tagRecent = mutableSetOf<Tag>()

interface SuggestionController<T> {
    fun search(query: String): List<T>
    fun recent(): Set<T>
    fun get(name: String): T?
}

class UserSuggestionController : SuggestionController<User> {
    override fun search(query: String): List<User> {
        return userList.filter {
            it.firstName.contains(query)
                    || it.lastName.contains(query)
                    || it.username.contains(query)
        }
    }

    override fun recent(): Set<User> {
        return userRecent
    }

    override fun get(name: String): User? {
        val user: User? = userList.find { it.username == name }
        if (user != null) {
            userRecent.add(user)
        }
        return user
    }

}

class TagSuggestionController : SuggestionController<Tag> {
    override fun search(query: String): List<Tag> {
        return tagList.filter {
            it.tag.contains(query)
        }
    }

    override fun recent(): Set<Tag> {
        return tagRecent
    }

    override fun get(name: String): Tag? {
        val tag: Tag? = tagList.find { it.tag == name }
        if (tag != null) {
            tagRecent.add(tag)
        }
        return tag
    }

}



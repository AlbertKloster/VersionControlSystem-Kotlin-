package svcs

import java.io.StringReader
import java.io.StringWriter
import java.util.*

class Serializer {
    fun deserializeLog(serializedLog: String): Log {
        val properties = Properties()
        properties.load(StringReader(serializedLog))

        val hash = properties.getProperty("hash") ?: throw IllegalArgumentException("Invalid serialized log format")
        val author = properties.getProperty("author") ?: throw IllegalArgumentException("Invalid serialized log format")
        val comment = properties.getProperty("comment") ?: throw IllegalArgumentException("Invalid serialized log format")

        return Log(hash, author, comment)
    }

    fun serializeLog(log: Log): String {
        val properties = Properties()
        properties.setProperty("hash", log.hash)
        properties.setProperty("author", log.author)
        properties.setProperty("comment", log.comment)

        val stringWriter = StringWriter()
        properties.store(stringWriter, null)

        return stringWriter.toString()
    }
}
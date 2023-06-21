package svcs

import java.io.File

class FileHandler {

    private val root = File("./vcs")
    private val commitsPath = "/commits"
    private val configPath = "/config.txt"
    private val indexPath = "/index.txt"
    private val logPath = "/log.txt"
    private val serializer = Serializer()

    init {
        createRootDirectoryIfNotExists()
        createCommitsDirectoryIfNotExists()
    }

    fun readBytes(filename: String) = File("./$filename").readBytes()

    fun readIndex(): String {
        return read(indexPath)
    }

    fun writeIndex(filename: String) {
        write(indexPath, "$filename\n", true)
    }

    fun readConfig(): String {
        return read(configPath)
    }

    fun writeConfig(user: String) {
        write(configPath, user)
    }

    private fun read(path:String): String {
        createRootDirectoryIfNotExists()
        return File(root.path + path).readText()
    }

    private fun write(path: String, text: String, append: Boolean = false) {
        createRootDirectoryIfNotExists()
        if (append) {
            File(root.path + path).appendText(text)
        } else {
            File(root.path + path).writeText(text)
        }
    }

    private fun createRootDirectoryIfNotExists() {
        if (!root.exists()) {
            root.mkdir()
        }
    }

    private fun createCommitsDirectoryIfNotExists() {
        if (!File(root.path + commitsPath).exists()) {
            File(root.path + commitsPath).mkdir()
        }
    }

    fun exists(filename: String): Boolean {
        return File("./$filename").exists()
    }

    fun readLog(): List<Log> {
        val log = mutableListOf<Log>()
        if (!File(root.path + logPath).exists()) {
            return log
        }
        val text = File(root.path  + logPath).readText()
        if (text.isBlank()) {
            return log
        }
        val split = text.split(Regex("#.*\\r\\n"))
        for (serializedLog in split) {
            if (serializedLog.isNotBlank()) {
                log.add(serializer.deserializeLog(serializedLog))
            }
        }
        return log.asReversed()
    }

    fun writeLog(log: Log) {
        File(root.path + logPath).appendText(serializer.serializeLog(log) + "\n")
    }

    fun writeCommit(hash: String, files: List<String>) {
        files.forEach { file -> File("./$file").copyTo(File(root.path + commitsPath + "/" + hash + "/" + file))}
    }

    fun restoreById(id: String): Boolean {
        val directory = File(root.path + commitsPath + "/" + id)
        return if (directory.exists()) {
            directory.copyRecursively(File("./"), true)
            true
        } else {
            false
        }
    }

}
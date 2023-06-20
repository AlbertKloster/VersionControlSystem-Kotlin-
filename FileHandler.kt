package svcs

import java.io.File

class FileHandler {

    private val root = File("./vcs")
    private val configPath = "/config.txt"
    private val indexPath = "/index.txt"

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

    fun exists(filename: String): Boolean {
        return File("./$filename").exists()
    }
}
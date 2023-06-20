package svcs

import java.io.IOException
import java.security.MessageDigest

val fileHandler = FileHandler()
fun main(args: Array<String>) {

    try {
        when (val command = if (args.isEmpty()) Commands.HELP else Commands.getCommand(args[0])) {
            Commands.HELP -> printHelp(args)
            Commands.CONFIG -> config(args)
            Commands.ADD -> add(args)
            Commands.COMMIT -> commit(args)
            Commands.LOG -> log()
            else -> println(command.description)
        }
    } catch (e: RuntimeException) {
        println(e.message)
    }

}

fun calculateSHA256Hash(input: ByteArray): String {
    val digest = MessageDigest.getInstance("SHA-256")
    val encodedHash = digest.digest(input)

    val hexString = StringBuilder()
    for (byte in encodedHash) {
        val hex = String.format("%02x", byte)
        hexString.append(hex)
    }

    return hexString.toString()
}

private fun commit(args: Array<String>) {
    if (args.size < 2) {
        println("Message was not passed.")
    } else {
        val files = readIndex()
        if (files.isEmpty()) {
            println("Nothing to commit.")
        } else {
            var byteArray = byteArrayOf()
            for (file in files) {
                byteArray += fileHandler.readBytes(file)
            }
            val hash = calculateSHA256Hash(byteArray)
            val author = fileHandler.readConfig()
            val comment = args[1]
            val log = fileHandler.readLog()

            if (log.isNotEmpty() && log[0].hash == hash) {
                println("Nothing to commit.")
            } else {
                fileHandler.writeLog(Log(hash, author, comment))
                fileHandler.writeCommit(hash, files)
                println("Changes are committed.")
            }
        }
    }
}

private fun log() {
    val log = fileHandler.readLog()
    if (log.isEmpty()) {
        println("No commits yet.")
    } else {
        log.forEach {
            print("commit ${it.hash}\nAuthor: ${it.author}\n${it.comment}\n\n")
        }
    }
}

private fun add(args: Array<String>) {
    if (args.size < 2) {
        val files = readIndex()
        if (files.isEmpty()) {
            println("Add a file to the index.")
        } else {
            println("Tracked files:")
            println(files.joinToString("\n"))
        }
    } else {
        val filename = args[1]
        if (fileHandler.exists(filename)) {
            fileHandler.writeIndex(filename)
            println("The file '$filename' is tracked.")
        } else {
            println("Can't find '$filename'.")
        }
    }
}

private fun readIndex(): List<String> {
    val files = mutableListOf<String>()
    val filename = "vcs/index.txt"
    if (fileHandler.exists(filename)) {
        files.addAll(fileHandler.readIndex().trim().split("\n"))
    }
    return files
}

private fun printHelp(args: Array<String>) {
    if (args.size < 2) {
        println(Commands.HELP.description)
    } else {
        println(Commands.getCommand(args[1]).description)
    }
}

private fun config(args: Array<String>) {
    if (args.size < 2) {
        printUser()
    } else {
        val user = args[1]
        try {
            fileHandler.writeConfig(user)
            println("The username is $user.")
        } catch (e: IOException) {
            println(e.message)
        }
    }
}

private fun printUser() {
    try {
        val user = fileHandler.readConfig()
        println("The username is $user.")
    } catch (e: IOException) {
        println("Please, tell me who you are.")
    }
}
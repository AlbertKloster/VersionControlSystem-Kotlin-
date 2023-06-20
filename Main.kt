package svcs

import java.io.IOException

fun main(args: Array<String>) {
    try {
        when (val command = if (args.isEmpty()) Commands.HELP else Commands.getCommand(args[0])) {
            Commands.HELP -> printHelp(args)
            Commands.CONFIG -> config(args)
            Commands.ADD -> add(args)
            else -> println(command.description)
        }
    } catch (e: RuntimeException) {
        println(e.message)
    }

}

private fun add(args: Array<String>) {
    if (args.size < 2) {
        readIndex()
    } else {
        val filename = args[1]
        val fileHandler = FileHandler()
        if (fileHandler.exists(filename)) {
            fileHandler.writeIndex(filename)
            println("The file '$filename' is tracked.")
        } else {
            println("Can't find '$filename'.")
        }
    }
}

private fun readIndex() {
    val fileHandler = FileHandler()
    val filename = "vcs/index.txt"
    if (fileHandler.exists(filename)) {
        val trackedFiles = fileHandler.readIndex()
        if (trackedFiles.isNotBlank()) {
            println("Tracked files:")
            println(trackedFiles)
        } else {
            println("Add a file to the index.")
        }
    } else {
        println("Add a file to the index.")
    }


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
        val fileHandler = FileHandler()
        try {
            fileHandler.writeConfig(user)
            println("The username is $user.")
        } catch (e: IOException) {
            println(e.message)
        }
    }
}

private fun printUser() {
    val fileHandler = FileHandler()
    try {
        val user = fileHandler.readConfig()
        println("The username is $user.")
    } catch (e:IOException) {
        println("Please, tell me who you are.")
    }
}
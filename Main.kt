package svcs

fun main(args: Array<String>) {
    try {
        val command = if (args.isEmpty()) Commands.HELP else Commands.getCommand(args[0])
        println(command.description)
    } catch (e: RuntimeException) {
        println(e.message)
    }

}
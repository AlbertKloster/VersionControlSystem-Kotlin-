package svcs

enum class Commands(val string: String, val description: String) {
    CONFIG("config", "Get and set a username."),
    HELP("--help", """
        These are SVCS commands:
        config     Get and set a username.
        add        Add a file to the index.
        log        Show commit logs.
        commit     Save changes.
        checkout   Restore a file.
    """.trimIndent()),
    ADD("add", "Add a file to the index."),
    LOG("log", "Show commit logs."),
    COMMIT("commit", "Save changes."),
    CHECKOUT("checkout", "Restore a file.");

    companion object {
        fun getCommand(input: String): Commands {
            for (command in Commands.values()) {
                if (command.string == input.lowercase()) {
                    return command
                }
            }
            throw RuntimeException("'$input' is not a SVCS command.")
        }
    }
}
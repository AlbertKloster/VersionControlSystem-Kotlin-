# Stage 1/4: Help page
## Description
A version control system is software that can keep track of the changes that were implemented to a program. There are several popular version control systems (like Git, SVN, or Mercurial). Each of them has its pros and cons. They share one common idea. A version control system remembers who changed the file, when it was done, and why. It allows you to roll back to the previous versions as well.

In this project, you need to implement a simple version control system. It will be your own Git. By the way, if you want to learn how to work with Git, take a look at the <a href="https://githowto.com/">Git How To</a>.

Take a look at the commands you will need to implement during this project:

- `config` sets or outputs the name of a commit author;
- `--help` prints the help page;
- `add` adds a file to the list of tracked files or outputs this list;
- `log` shows all commits;
- `commit` saves file changes and the author name;
- `checkout` allows you to switch between commits and restore a previous file state.

In this stage, your program should be able to accept a single argument and, depending on the argument, print help information.

## Objectives
In this stage, your program should:

- Take one argument as a command.
- If an argument is missing or it is `--help`, print the entire help page.
- If a command exists, the program should output a description of the command.
- If the command is wrong, print `[passed argument]` is not a SVCS command.

<i>Unlike many other projects, the program does not run in an infinite loop. The program starts with arguments that are passed to the main function and should do something, then starts from scratch again with other arguments and should do something else.</i>

## Examples
The greater-than symbol followed by a space (`> `) represents the user input. Note that it's not part of the input. The verification system ignores all spaces, but we suggest trying to create a nice output.

<b>Example 1:</b> <i>the `--help` argument</i>
```
These are SVCS commands:
config     Get and set a username.
add        Add a file to the index.
log        Show commit logs.
commit     Save changes.
checkout   Restore a file.
```

<b>Example 2:</b> <i>no arguments</i>
```
These are SVCS commands:
config     Get and set a username.
add        Add a file to the index.
log        Show commit logs.
commit     Save changes.
checkout   Restore a file.
```

<b>Example 3:</b> <i>the config argument</i>
```
Get and set a username.
```
<b>Example 4:</b> <i>the wrong argument</i>
```
'wrong' is not a SVCS command.
```

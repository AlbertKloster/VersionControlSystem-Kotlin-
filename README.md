# Stage 2/4: Add & config
## Description
In this stage, your program should allow a user to set their name and add the files they want to track. Store a username in <i>config.txt</i>.

Index.txt stores the files that were added to the index. Don't forget to store all the files of the version control system in the vcs directory. You should create this directory programmatically. It may look something like this:
```
.
├── vcs
│   ├── config.txt
│   └── index.txt
├── tracked_file.txt
└── untracked_file.txt
```

## Objectives
You need to work on the following commands:

- `config` should allow the user to set their own name or output an already existing name. If a user wants to set a new name, the program must overwrite the old one.
- `add` should allow the user to set the name of a file that they want to track or output the names of tracked files. If the file does not exist, the program should inform a user that the file does not exist.

<i>Do not create `tracked_file.txt` and `untracked_file.txt`. This is an example of the files that a user of your version control system will work with.</i>

## Examples
The greater-than symbol followed by a space (`> `) represents the user input. Note that it's not part of the input.

<b>Example 1:</b> <i>the `config` argument</i>
```
Please, tell me who you are.
```
<b>Example 2:</b> <i>the `config John` argument</i>
```
The username is John.
```
<b>Example 3:</b> <i>the `config` argument</i>
```
The username is John.
```
<b>Example 4:</b> <i>the `config Max` argument</i>
```
The username is Max.
```
<b>Example 5:</b> <i>the `add` argument.</i>
```
Add a file to the index.
```
<b>Example 6:</b> <i>the `add file.txt` arguments</i>
```
The file 'file.txt' is tracked.
```
<b>Example 7:</b> <i>the `add` argument</i>
```
Tracked files:
file.txt
```

<b>Example 8:</b> <i>the `add new_file.txt` argument</i>
```
The file 'new_file.txt' is tracked.
```

<b>Example 9:</b> <i>the `add` argument</i>
```
Tracked files:
file.txt
new_file.txt
```

<b>Example 10:</b> <i>the `add not_exists_file.txt` argument</i>
```
Can't find 'not_exists_file.txt'.
```

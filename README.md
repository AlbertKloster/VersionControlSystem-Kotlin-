# Stage 3/4: Log & commit
## Description
In this stage, you should implement two commands. `Commit` will allow a user to save file changes; `log` will allow viewing the commit history.

Git may seem quite complicated. If you want to learn more, watch the <a href="https://www.youtube.com/watch?v=P6jD966jzlk">video explanation</a> by GitLab.

The purpose of this project is to work with files. Store different file versions in the index according to the commits and make sure that each commit has a unique ID. ID should allow you to find a specific file version that matches this commit. You need to think about the concept of a commit ID.

You can store commits inside <i>vsc/commits</i>. Each commit will be saved to a separate directory. These directories will include a commit's ID and additional information that you can store in <i>vsc/log.txt</i>.

You will also need to find out whether a file has been changed since the last commit. For that, you need to calculate the hash of the current file and the hash of the last commit. If these values are different, then the file has been changed. Use <b>Java Cryptography Architecture</b> (JCA). JCA includes solutions that are based on various cryptographic algorithms such as <b>SHA1</b>, <b>SHA256</b>, and others. Hash functions are optional, you can use a different solution.

## Objectives
Implement the following commands:

- `commit` must be passed to the program along with a message (see examples). Save all changes. Each commit must be assigned a unique id. if there were no changes since the last commit, do not create a new commit. You don't need to optimize the storage of changes, just copy all the staged files to the commit folder every time.
- `log` should show all the commits in reverse order.

<i>Do not create file1.txt, file2.txt and untracked_file.txt. This is an example of the files that a user of your version control system will work with.</i>

## Examples
The greater-than symbol followed by a space (`> `) represents the user input. Note that it's not part of the input.

<b>Example 1:</b> <i>the `log` argument</i>
```
No commits yet.
```
<i>This is the directory tree. Don't output it.</i>
```
.
├── vcs
│   ├── commits
│   ├── config.txt
│   ├── index.txt
│   └── log.txt
├── file1.txt
├── file2.txt
└── untracked_file.txt
```

<b>Example 2:</b> <i>the `commit "Added several lines of code to the file1.txt"` argument</i>
```
Changes are committed.
```
<i>This is the directory tree. Don't output it.</i>
```
.
├── vcs
│   ├── commits
│   │   └── 0b4f05fcd3e1dcc47f58fed4bb189196f99da89a
│   │       ├── file1.txt
│   │       └── file2.txt
│   ├── config.txt
│   ├── index.txt
│   └── log.txt
├── file1.txt
├── file2.txt
└── untracked_file.txt
```

<b>Example 3:</b> <i>the `log` argument</i>
```
commit 0b4f05fcd3e1dcc47f58fed4bb189196f99da89a
Author: John
Added several lines of code to the file1.txt
```

<b>Example 4:</b> <i>the `commit "Changed several lines of code in the file2.txt"` argument</i>
```
Changes are committed.

```
<b>Example 5:</b> <i>the `log` argument</i>
```
commit 2853da19f31cfc086cd5c40915253cb28d5eb01c
Author: John
Changed several lines of code in the file2.txt

commit 0b4f05fcd3e1dcc47f58fed4bb189196f99da89a
Author: John
Added several lines of code to the file1.txt
```

<i>This is the directory tree. Don't output it.</i>
```
.
├── vcs
│   ├── commits
│   │   ├── 2853da19f31cfc086cd5c40915253cb28d5eb01c
│   │   │   ├── file1.txt
│   │   │   └── file2.txt
│   │   └── 0b4f05fcd3e1dcc47f58fed4bb189196f99da89a
│   │       ├── file1.txt
│   │       └── file2.txt
│   ├── config.txt
│   ├── index.txt
│   └── log.txt
├── file1.txt
├── file2.txt
└── untracked_file.txt
```

<b>Example 6:</b> <i>the `commit "Files were not changed"` argument</i>
```
Nothing to commit.
```
<b>Example 7:</b> <i>the `commit` argument</i>
```
Message was not passed.
```

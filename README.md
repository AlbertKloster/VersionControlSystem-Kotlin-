# Stage 4/4: Checkout time
## Description
In the last stage, implement the `checkout` command. It allows a user to switch between commits and restore the contents of the files according to the current commit.

Get the files you need from the commit directory by the commit id and rewrite the current files.
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

## Objectives
The `checkout` command must be passed to the program together with the commit ID to indicate which commit should be used. If a commit with the given ID exists, the contents of the tracked file should be restored in accordance with this commit.

<i>Do not create file1.txt, file2.txt and untracked_file.txt. This is an example of the files that a user of your version control system will work with.</i>

## Examples
The greater-than symbol followed by a space (`> `) represents the user input. Note that it's not part of the input.

<b>Example 1:</b> <i>the `log` argument</i>
```
commit 2853da19f31cfc086cd5c40915253cb28d5eb01c
Author: John
Changed several lines of code

commit 0b4f05fcd3e1dcc47f58fed4bb189196f99da89a
Author: John
Added several lines of code
```

<b>Example 2:</b> <i>the `checkout 0b4f05fcd3e1dcc47f58fed4bb189196f99da89a` argument</i>
```
Switched to commit 0b4f05fcd3e1dcc47f58fed4bb189196f99da89a.
```

<b>Example 3:</b> <i>the `checkout fb92cc1be7f60c8d9acf74cbd4a67841d8d2e844` argument</i>
```
Commit does not exist.
```

<b>Example 4:</b> <i>the `checkout` argument</i>
```
Commit id was not passed.
```

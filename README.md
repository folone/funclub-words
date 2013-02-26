funclub-words
=============

```
words [master●●] % ./createfile.sh                                                            ~/workspace/words
words [master●●] % ls -la | grep newfile                                                      ~/workspace/words
-rw-r--r--  1 folone folone 1133095500 Feb 26 22:21 newfile.txt
words [master●●] % sbt                                                                        ~/workspace/words
[info] Loading global plugins from /home/folone/.sbt/plugins
[info] Set current project to simplewords (in build file:/home/folone/workspace/words/)
> run "md.txt"                        

Multiple main classes detected, select one to run:

 [1] info.folone.words.WordsStream
 [2] info.folone.words.WordMachine
 [3] info.folone.words.WordsMemory

Enter number: 3

[info] Running info.folone.words.WordsMemory md.txt
Elapsed time: 2793296411 ns

the: 14441
of: 6603
and: 6428
a: 4716
to: 4629
in: 4170
that: 2986
his: 2529
it: 2426
i: 1987
[success] Total time: 7 s, completed Feb 26, 2013 11:23:00 PM
> run "md.txt"

Multiple main classes detected, select one to run:

 [1] info.folone.words.WordsStream
 [2] info.folone.words.WordMachine
 [3] info.folone.words.WordsMemory

Enter number: 1

[info] Running info.folone.words.WordsStream md.txt
Elapsed time: 8524561845 ns

the: 14441
of: 6603
and: 6428
a: 4716
to: 4629
in: 4170
that: 2986
his: 2529
it: 2426
i: 1987
[success] Total time: 11 s, completed Feb 26, 2013 11:23:14 PM
> run "md.txt"

Multiple main classes detected, select one to run:

 [1] info.folone.words.WordsStream
 [2] info.folone.words.WordMachine
 [3] info.folone.words.WordsMemory

Enter number: 2

[info] Running info.folone.words.WordMachine md.txt
Elapsed time: 2912315952 ns

the: 14441
of: 6603
and: 6428
a: 4716
to: 4629
in: 4170
that: 2986
his: 2529
it: 2426
i: 1987
[success] Total time: 5 s, completed Feb 26, 2013 11:23:23 PM
```

funclub-words
=============

```
funclub-words [master●●] % sbt                                                                            ~/workspace/funclub-words
[info] Set current project to simplewords (in build file:/home/folone/workspace/funclub-words/)
> run "md.txt"

Multiple main classes detected, select one to run:

 [1] info.folone.words.WordMachine
 [2] info.folone.words.Main
 [3] info.folone.words.WordsStream
 [4] info.folone.words.WordsMemory

Enter number: 2

[info] Running info.folone.words.Main md.txt
In memory
Elapsed time: 1454259843 ns

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
Streamed
Elapsed time: 11071950190 ns

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
Using the wc Procedure.
Elapsed time: 883683709 ns

the: 14442
of: 6603
and: 6428
a: 4737
to: 4629
in: 4170
that: 3081
his: 2529
it: 2528
i: 2125
Using the wordCount function
Elapsed time: 9044096231 ns

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
[success] Total time: 25 s, completed Feb 28, 2013 4:39:31 PM
> exit
```

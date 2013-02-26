funclub-words
=============

```
funclub-words [master●] % dd if=/dev/random iflag=fullblock of=randomFile100M.txt bs=100M count=1                                    ~/workspace/funclub-words
1+0 records in                                                               
1+0 records out
104857600 bytes (105 MB) copied, 33.1194 s, 3.2 MB/s

funclub-words [master●] % sbt                                                                                                        ~/workspace/funclub-words
[info] Set current project to simplewords (in build file:/home/folone/workspace/funclub-words/)
> run "md.txt"                        

Multiple main classes detected, select one to run:

 [1] info.folone.words.WordMachine
 [2] info.folone.words.WordsStream
 [3] info.folone.words.WordsMemory

Enter number: 3

[info] Running info.folone.words.WordsMemory md.txt
Elapsed time: 1505113480 ns

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
[success] Total time: 6 s, completed Feb 26, 2013 5:29:45 PM
> run "md.txt"

Multiple main classes detected, select one to run:

 [1] info.folone.words.WordMachine
 [2] info.folone.words.WordsStream
 [3] info.folone.words.WordsMemory

Enter number: 2

[info] Running info.folone.words.WordsStream md.txt
Elapsed time: 98456430408 ns

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
[success] Total time: 103 s, completed Feb 26, 2013 5:31:33 PM
> run "md.txt"

Multiple main classes detected, select one to run:

 [1] info.folone.words.WordMachine
 [2] info.folone.words.WordsStream
 [3] info.folone.words.WordsMemory

Enter number: 1

[info] Running info.folone.words.WordMachine md.txt
Elapsed time: 1714833384 ns

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
[success] Total time: 9 s, completed Feb 26, 2013 5:32:02 PM
> run "randomFile100M.txt"                    

Multiple main classes detected, select one to run:

 [1] info.folone.words.WordMachine
 [2] info.folone.words.WordsStream
 [3] info.folone.words.WordsMemory

Enter number: 1

[info] Running info.folone.words.WordMachine randomFile100M.txt
Elapsed time: 46719251389 ns

y: 38894
b: 38856
i: 38833
a: 38741
d: 38701
t: 38691
e: 38667
x: 38649
p: 38624
g: 38614
[success] Total time: 54 s, completed Feb 26, 2013 5:33:09 PM
> exit
funclub-words [master●] % units                                                                                                      ~/workspace/funclub-words
Currency exchange rates from 2012-06-06 
2552 units, 85 prefixes, 66 nonlinear units

You have: 1505113480 ns
You want: sec
  * 1.5051135
	/ 0.66440173
You have: 98456430408 ns
You want: sec
	* 98.45643
	/ 0.010156777
You have: 1714833384 ns
You want: sec
	* 1.7148334
	/ 0.58314703
You have: 46719251389 ns
You want: sec
	* 46.719251
	/ 0.021404453
```

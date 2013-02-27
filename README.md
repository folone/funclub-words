funclub-words
=============

```
funclub-words [master●] % ./createfile.sh                                                                 ~/workspace/funclub-words
funclub-words [master●] % ls -la random.txt                                                               ~/workspace/funclub-words
-rw-r--r-- 1 folone users 100000000 Feb 27 13:51 random.txt
funclub-words [master●] % sbt                                                                             ~/workspace/funclub-words
[info] Set current project to simplewords (in build file:/home/folone/workspace/funclub-words/)
> run "md.txt"                        

Multiple main classes detected, select one to run:

 [1] info.folone.words.WordsStream
 [2] info.folone.words.WordMachine
 [3] info.folone.words.WordsMemory

Enter number: 3

[info] Running info.folone.words.WordsMemory md.txt
Elapsed time: 1500076979 ns

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
[success] Total time: 5 s, completed Feb 27, 2013 12:52:21 PM
> run "md.txt"

Multiple main classes detected, select one to run:

 [1] info.folone.words.WordsStream
 [2] info.folone.words.WordMachine
 [3] info.folone.words.WordsMemory

Enter number: 1

[info] Running info.folone.words.WordsStream md.txt
Elapsed time: 10903347478 ns

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
[success] Total time: 16 s, completed Feb 27, 2013 12:52:40 PM
> run "md.txt"

Multiple main classes detected, select one to run:

 [1] info.folone.words.WordsStream
 [2] info.folone.words.WordMachine
 [3] info.folone.words.WordsMemory

Enter number: 2

[info] Running info.folone.words.WordMachine md.txt
Elapsed time: 9808724738 ns

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
[success] Total time: 12 s, completed Feb 27, 2013 12:52:55 PM
> run "random.txt"

Multiple main classes detected, select one to run:

 [1] info.folone.words.WordsStream
 [2] info.folone.words.WordMachine
 [3] info.folone.words.WordsMemory

Enter number: 1

[info] Running info.folone.words.WordsStream random.txt
Elapsed time: 176449604254 ns

ozp2gicjep2ilu3cdg0v4w2vetvvp4aytilcs1r5ymt5tnasucvxtwxnn2bnqafjd3c5fubymq: 1
4apbciytchjftumovert04fzc4muknnaa1ogdfuw6dxhctj4dsbu1an3jqnirgtghy8itdszybk: 1
5kctmjdbib4oehjprmvcqmvczzbizgwdrssvpd1uvep78xvosmk8x3gj487qi8uppzlshalhw: 1
hpfcefmtbclknfwqtctdsyoeqk7wothfpsq8dx3b3hfilx9wrkbppp4trrsjn4ofpq6arrafi: 1
ukvgcby9tytxwoxdxhpeihqmwlujapoi5sl64o0ctst0rll6djbudumj6y004rauxbutrt: 1
yzbwyc1hyukbyu2zqgbsyk9ojylbrgdcidgw5gyawnaocuepdskj7paylwlqccba3m8zuli: 1
dh6r6p0tulmskckofqxqaqnpokh5donok3rhlncpriczveefxg2us0id7gguabol4e7sgab9b9: 1
zhtzwvouckhrdktsc0jb58gjnkymd5itmaugeh9enmra3j6dgogfn74sqtddtrltuz7t38bbuex: 1
bfu6mrwnmwwhayscp6bvclosb2bwxiu95hd2lqltvumerksl9onxrcmft1nwsuxqf2gebkdjfypn: 1
w4ynubrid5h0yrzmxd7xpq2sny4z4hwyqx2wextape53hyn1ypz1ed18qnwe8vdexj5pasef: 1
[success] Total time: 182 s, completed Feb 27, 2013 12:56:09 PM
> run "random.txt"

Multiple main classes detected, select one to run:

 [1] info.folone.words.WordsStream
 [2] info.folone.words.WordMachine
 [3] info.folone.words.WordsMemory

Enter number: 2

[info] Running info.folone.words.WordMachine random.txt
Elapsed time: 197135000132 ns

ozp2gicjep2ilu3cdg0v4w2vetvvp4aytilcs1r5ymt5tnasucvxtwxnn2bnqafjd3c5fubymq: 1
4apbciytchjftumovert04fzc4muknnaa1ogdfuw6dxhctj4dsbu1an3jqnirgtghy8itdszybk: 1
5kctmjdbib4oehjprmvcqmvczzbizgwdrssvpd1uvep78xvosmk8x3gj487qi8uppzlshalhw: 1
hpfcefmtbclknfwqtctdsyoeqk7wothfpsq8dx3b3hfilx9wrkbppp4trrsjn4ofpq6arrafi: 1
ukvgcby9tytxwoxdxhpeihqmwlujapoi5sl64o0ctst0rll6djbudumj6y004rauxbutrt: 1
yzbwyc1hyukbyu2zqgbsyk9ojylbrgdcidgw5gyawnaocuepdskj7paylwlqccba3m8zuli: 1
dh6r6p0tulmskckofqxqaqnpokh5donok3rhlncpriczveefxg2us0id7gguabol4e7sgab9b9: 1
zhtzwvouckhrdktsc0jb58gjnkymd5itmaugeh9enmra3j6dgogfn74sqtddtrltuz7t38bbuex: 1
bfu6mrwnmwwhayscp6bvclosb2bwxiu95hd2lqltvumerksl9onxrcmft1nwsuxqf2gebkdjfypn: 1
w4ynubrid5h0yrzmxd7xpq2sny4z4hwyqx2wextape53hyn1ypz1ed18qnwe8vdexj5pasef: 1
[success] Total time: 201 s, completed Feb 27, 2013 12:59:33 PM
> exit
funclub-words [master●] % units                                                                           ~/workspace/funclub-words
Currency exchange rates from 2012-06-06 
2552 units, 85 prefixes, 66 nonlinear units

You have: 1500076979 ns
You want: sec
	* 1.500077
	/ 0.66663246
You have: 10903347478 ns
You want: sec
	* 10.903347
	/ 0.091714953
You have: 9808724738 ns
You want: sec
	* 9.8087247
	/ 0.10195005
You have: 176449604254 ns
You want: sec
	* 176.4496
	/ 0.0056673406
You have: 197135000132 ns
You want: sec
	* 197.135
	/ 0.0050726659
```

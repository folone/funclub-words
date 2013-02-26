funclub-words
=============

```
words [master●●] % ./createfile.sh                                                            ~/workspace/words
words [master●●] % ls -ls random.txt                                                          ~/workspace/words
97664 -rw-r--r-- 1 folone folone 100000000 Feb 26 22:48 random.txt
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
> run "random.txt"

Multiple main classes detected, select one to run:

 [1] info.folone.words.WordsStream
 [2] info.folone.words.WordMachine
 [3] info.folone.words.WordsMemory

Enter number: 1

[info] Running info.folone.words.WordsStream random.txt
Elapsed time: 181887661446 ns

rw4kexvfinnab9fsfccqnvnujhq3l6uarsuihhwysmhsde4ggbuzilpvyxjgzfugd8bzomf6of: 1
pn1k2z01wwwoh0amvlycydw62bsavlmsvcvbhcacvqm5hxkwwxsfmn2thiconxc0i7puj7kwx: 1
jskymvoj8buqwgysrteuhisx6frdiifwb4cbgqwmefc1ewfjw3oz3tdovvrly4ofl2n7f7sx: 1
0blqwfsvbn1a8uhrgkki0yqeluty0bxvpqxxqw6haa9zfu5erkulauovwpqhvqnjrnondophukmh: 1
fzp7ka0ghl8es3b4nhqbhrmkwweeavjkm9dxt1fzzwsop10r6hcchyexsuckkfasfgzsvhkvnyc: 1
si2xqcpn7338n1edycizgadvjczvgjrkzqaj8ztcdtu8gkxhkov8ejqqwv1kh27cromkj9dujlx: 1
1lm9acdhmsckdwbaq5a8ywdpid6tce74ubcw6czyybykwsikb8zhyxrzh9u2mzwhkzq7ehf5: 1
8jckgzogrsbwj0zg0ytgk87wc5vmbpw3lnblvgpfyzsmm2urr3ggt6kx0ujixw38ddilbv9by: 1
7ohpglec2sagxqzoamzf7bcqo3mxylu10m6ldvnrkvewhui1vne529okapllhk0latv2vsqcmyg: 1
7c5bqeco0f2bujenkyql7rr4msflns7co0x8upfmbycqejt53czx9muodktaetefkniuhb4px: 1
[success] Total time: 184 s, completed Feb 26, 2013 11:54:05 PM
> run "random.txt"

Multiple main classes detected, select one to run:

 [1] info.folone.words.WordsStream
 [2] info.folone.words.WordMachine
 [3] info.folone.words.WordsMemory

Enter number: 2

[info] Running info.folone.words.WordMachine random.txt
Elapsed time: 56427491744 ns

rw4kexvfinnab9fsfccqnvnujhq3l6uarsuihhwysmhsde4ggbuzilpvyxjgzfugd8bzomf6of: 1
pn1k2z01wwwoh0amvlycydw62bsavlmsvcvbhcacvqm5hxkwwxsfmn2thiconxc0i7puj7kwx: 1
jskymvoj8buqwgysrteuhisx6frdiifwb4cbgqwmefc1ewfjw3oz3tdovvrly4ofl2n7f7sx: 1
0blqwfsvbn1a8uhrgkki0yqeluty0bxvpqxxqw6haa9zfu5erkulauovwpqhvqnjrnondophukmh: 1
fzp7ka0ghl8es3b4nhqbhrmkwweeavjkm9dxt1fzzwsop10r6hcchyexsuckkfasfgzsvhkvnyc: 1
si2xqcpn7338n1edycizgadvjczvgjrkzqaj8ztcdtu8gkxhkov8ejqqwv1kh27cromkj9dujlx: 1
1lm9acdhmsckdwbaq5a8ywdpid6tce74ubcw6czyybykwsikb8zhyxrzh9u2mzwhkzq7ehf5: 1
8jckgzogrsbwj0zg0ytgk87wc5vmbpw3lnblvgpfyzsmm2urr3ggt6kx0ujixw38ddilbv9by: 1
7ohpglec2sagxqzoamzf7bcqo3mxylu10m6ldvnrkvewhui1vne529okapllhk0latv2vsqcmyg: 1
7c5bqeco0f2bujenkyql7rr4msflns7co0x8upfmbycqejt53czx9muodktaetefkniuhb4px: 1
[success] Total time: 61 s, completed Feb 26, 2013 11:50:19 PM
> exit
words [master●] % units                                                                       ~/workspace/words
zsh: correct 'units' to '_units' [nyae]? n
Currency exchange rates from 2012-06-06 
2552 units, 85 prefixes, 66 nonlinear units

You have: 2793296411 ns
You want: sec
	* 2.7932964
	/ 0.35799996
You have: 8524561845 ns
You want: sec
	* 8.5245618
	/ 0.11730808
You have: 2912315952 ns
You want: sec
	* 2.912316
	/ 0.34336934
You have: 181887661446 ns
You want: sec
	* 181.88766
	/ 0.005497899
You have: 56427491744 ns
You want: sec
	* 56.427492
	/ 0.017721858
You have: ^C
```

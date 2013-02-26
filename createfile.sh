for i in {1..250};
do cat md.txt >> newfile.txt && cat wp.txt >> newfile.txt;
done;

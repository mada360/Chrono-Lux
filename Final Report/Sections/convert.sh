# This script was created to convert a directory full
# of markdown files into rst equivalents. It uses
# pandoc to do the conversion.
#
# 1. Install pandoc from http://johnmacfarlane.net/pandoc/
# 2. Copy this script into the directory containing the .md files
# 3. Ensure that the script has execute permissions
# 4. Run the script
#
# By default this will keep the original .md file

for f in *.md; do aspell check --lang=en_GB --add-tex-command="cite op" --add-tex-command="citep op" --add-tex-command="citet op" --add-tex-command="parencite op" $f; done

FILES=*.md
for f in $FILES
do
  # extension="${f##*.}"
  filename="${f%.*}"
  echo "Converting $f to $filename.tex"
  `pandoc $f -t latex --listings -o ../Report/$filename.tex`
  # uncomment this line to delete the source file.
  # rm $f
done

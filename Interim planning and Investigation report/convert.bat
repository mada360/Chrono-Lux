@ECHO OFF

FOR /r "." %%i IN (*.md) DO pandoc -f markdown -t latex "%%~fi" -o "%%~dpni.tex"
mv *.tex ./Report/
rm -rf *~

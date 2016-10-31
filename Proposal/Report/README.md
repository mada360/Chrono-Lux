# Report MD to LaTeX

## LaTeX
There is one main .tex file called Report.tex; this file is the formatting and outlining for any reports I will be producing, this file includes "reflection.tex" which contains the basic content of the report.

## reflection.md/.tex
As writing in markdown is cleaner and simpler for me than writing in LaTeX I intend to write my content in the markdown format and use pandoc to convert the file to the .tex format to be inlcuded in the Report.tex.

## Produce Batch file
The produce batch file converts all .md files into .tex and then uses pdflatex to typeset the Report.tex file. In the future to produce a different report simply changing the include within the Report.tex file to match the file name of the .md file with the report content.

The batch file also cleans up any files left over from either pandoc or pdflatex to keep the folder structure clean.

## Extras and useful information
I had used MikTex to edit the .tex files, however Texmaker is a nicer editor allowing for code completion, spell checking and live views of the files you're working on. It can be found [here](http://www.xm1math.net/texmaker/)

[Pandoc Download link](http://pandoc.org/installing.html)

## Using Chocolatey on Windows
Chocolatey can be installed using the following command line promt from an Admin instance:
```
C:\> @powershell -NoProfile -ExecutionPolicy Bypass -Command "iex ((new-object net.webclient).DownloadString('https://chocolatey.org/install.ps1'))" && SET PATH=%PATH%;%ALLUSERSPROFILE%\chocolatey\bin
```
Once installed using the following command will install pandoc and miktex.
```
C:\> choco install pandocpdf
```
Optionally running the following will also install Texmaker
```
C:\> choco install texmaker
```

For the Atom text editor
```
C:\> choco install atom
```
[Chocolatey Home page](https://chocolatey.org/)

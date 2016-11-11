@echo off
setlocal EnableDelayedExpansion

rem Populate the array with existent files in folder
set i=0
for %%a in (*.md) do (
   set /A i+=1
   set list[!i!]=%%a
   set output[!i!]=%%~na
)
set Filesx=%i%


rem Display array elements
for /L %%i in (1,1,%Filesx%) do pandoc -t latex -f markdown !list[%%i]! --toc -o !output[%%i]!.tex

pdflatex.exe Report.tex

Del /Q *.aux *.log *.gz README.tex reflection.tex

Report.pdf

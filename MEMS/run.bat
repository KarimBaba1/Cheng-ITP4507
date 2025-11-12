
@echo off
javac *.java
if errorlevel 1 (
    echo Compilation failed.
    pause
    exit /b 1
)

java Main
pause


@echo off
javac *.java
if errorlevel 1 (
    echo Compilation failed.
    pause
    exit /b 1
)

echo Running test01_sample_basic
java Main < test01_sample_basic.txt > test01_sample_basic.out

echo Running test02_undo_redo
java Main < test02_undo_redo.txt > test02_undo_redo.out

echo Running test03_invalid_inputs
java Main < test03_invalid_inputs.txt > test03_invalid_inputs.out

echo Running test04_invalid_set_current
java Main < test04_invalid_set_current.txt > test04_invalid_set_current.out

echo Running test05_undo_remove_ensemble
java Main < test05_undo_remove_ensemble.txt > test05_undo_remove_ensemble.out

echo All tests completed.
pause

@echo off
set TEST_DIR=tests
set OUT_DIR=test_outputs

if not exist "%OUT_DIR%" (
    mkdir "%OUT_DIR%"
)

echo Compiling Java sources...
javac *.java
if errorlevel 1 (
    echo Compilation failed.
    pause
    exit /b 1
)

echo Running test01_sample_basic...
java Main < "%TEST_DIR%\test01_sample_basic.txt" > "%OUT_DIR%\test01_sample_basic.out"

echo Running test02_undo_redo...
java Main < "%TEST_DIR%\test02_undo_redo.txt" > "%OUT_DIR%\test02_undo_redo.out"

echo Running test03_invalid_inputs...
java Main < "%TEST_DIR%\test03_invalid_inputs.txt" > "%OUT_DIR%\test03_invalid_inputs.out"

echo Running test04_invalid_set_current...
java Main < "%TEST_DIR%\test04_invalid_set_current.txt" > "%OUT_DIR%\test04_invalid_set_current.out"

echo Running test05_undo_remove_ensemble...
java Main < "%TEST_DIR%\test05_undo_remove_ensemble.txt" > "%OUT_DIR%\test05_undo_remove_ensemble.out"

echo Running test06_rock_band_basic...
java Main < "%TEST_DIR%\test06_rock_band_basic.txt" > "%OUT_DIR%\test06_rock_band_basic.out"

echo Running test07_rock_band_invalid_role...
java Main < "%TEST_DIR%\test07_rock_band_invalid_role.txt" > "%OUT_DIR%\test07_rock_band_invalid_role.out"

echo All tests completed. Outputs stored in %OUT_DIR%\
pause


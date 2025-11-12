#!/usr/bin/env bash

set -e

OUT_DIR="test_outputs"
mkdir -p "$OUT_DIR"

echo "Compiling Java sources..."
javac *.java

echo "Running test01_sample_basic..."
java Main <test01_sample_basic.txt | tee "$OUT_DIR/test01_sample_basic.out"

echo "Running test02_undo_redo..."
java Main <test02_undo_redo.txt | tee "$OUT_DIR/test02_undo_redo.out"

echo "Running test03_invalid_inputs..."
java Main <test03_invalid_inputs.txt | tee "$OUT_DIR/test03_invalid_inputs.out"

echo "Running test04_invalid_set_current..."
java Main <test04_invalid_set_current.txt | tee "$OUT_DIR/test04_invalid_set_current.out"

echo "Running test05_undo_remove_ensemble..."
java Main <test05_undo_remove_ensemble.txt | tee "$OUT_DIR/test05_undo_remove_ensemble.out"

echo "All tests completed. Outputs stored in $OUT_DIR/"

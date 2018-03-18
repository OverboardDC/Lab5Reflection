package com.training.homework.entity;

import com.training.homework.annotation.Special;
import com.training.homework.annotation.SpecialField;
import com.training.homework.interfaces.BaseMatrix;

import java.util.Arrays;

public class Matrix implements BaseMatrix {

    @SpecialField
    private int[][] matrixArray;
    private int determinant;

    public Matrix(int[][] matrixArray) {
        this.matrixArray = matrixArray;
        this.determinant = calculateDeterminant();
    }


    @Override
    public int calculateDeterminant() {
        int sum = 0;
        int s;
        if (matrixArray.length == 1) {
            return (matrixArray[0][0]);
        }
        for (int i = 0; i < matrixArray.length; i++) {
            int[][] smaller = new int[matrixArray.length - 1][matrixArray.length - 1];
            for (int a = 1; a < matrixArray.length; a++) {
                for (int b = 0; b < matrixArray.length; b++) {
                    if (b < i) {
                        smaller[a - 1][b] = matrixArray[a][b];
                    } else if (b > i) {
                        smaller[a - 1][b - 1] = matrixArray[a][b];
                    }
                }
            }
            if (i % 2 == 0) {
                s = 1;
            } else {
                s = -1;
            }
            matrixArray = smaller;
            sum += s * matrixArray[0][i] * (calculateDeterminant());
        }
        return (sum);
    }

    @Special
    public void printDeterminant() {
        System.out.println("Determinant is: " + determinant);
    }

    public int[][] getMatrixArray() {
        return matrixArray;
    }

    public void setMatrixArray(int[][] matrixArray) {
        this.matrixArray = matrixArray;
    }

    public int getDeterminant() {
        return determinant;
    }

    public void setDeterminant(int determinant) {
        this.determinant = determinant;
    }

    @Override
    public String toString() {
        return "Matrix{" +
                "matrixArray=" + Arrays.deepToString(matrixArray) +
                ", determinant=" + determinant +
                '}';
    }
}

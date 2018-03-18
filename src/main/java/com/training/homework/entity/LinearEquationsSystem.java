package com.training.homework.entity;

import com.training.homework.enums.SolvingMethod;

import java.util.Arrays;

public class LinearEquationsSystem extends Matrix{

    private int[] freeMembers;
    private SolvingMethod solvingMethod;

    public LinearEquationsSystem(int[][] matrixArray ,int[] freeMembers, SolvingMethod solvingMethod) {
        super(matrixArray);
        this.freeMembers = freeMembers;
        this.solvingMethod = solvingMethod;
    }


    public int[] getFreeMembers() {
        return freeMembers;
    }

    public void setFreeMembers(int[] freeMembers) {
        this.freeMembers = freeMembers;
    }

    public SolvingMethod getSolvingMethod() {
        return solvingMethod;
    }

    public void setSolvingMethod(SolvingMethod solvingMethod) {
        this.solvingMethod = solvingMethod;
    }

    @Override
    public String toString() {
        return "LinearEquationsSystem{" +
                ",\nfreeMembers=" + Arrays.toString(freeMembers) +
                ", solvingMethod=" + solvingMethod +
                '}';
    }
}

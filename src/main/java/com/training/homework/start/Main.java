package com.training.homework.start;

import com.training.homework.annotation.Special;
import com.training.homework.entity.LinearEquationsSystem;
import com.training.homework.entity.Matrix;
import com.training.homework.enums.SolvingMethod;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Main {

    public static void main(String[] args) {
        int matrixArray[][] = {
                {1, 2, 3,},
                {4, 1, 6,},
                {7, 8, 9,},
        };

        Matrix matrix = new Matrix(matrixArray);
        int freeMembers[] = {2, 4, 7};

        LinearEquationsSystem equationsSystem = new LinearEquationsSystem(matrixArray, freeMembers, SolvingMethod.GAUSSIAN_ELIMINATION);

        Class matrixClass = matrix.getClass();
        Class equationSystemClass = equationsSystem.getClass();

        System.out.println("Interfaces of " + matrixClass.getSimpleName() + ":");
        getClassInterfaces(matrixClass);

        System.out.println("\nFields of " + matrixClass.getSimpleName() + ":");
        getFieldsInfo(matrixClass);

        System.out.println("\nFields of " + equationSystemClass.getSimpleName() + ":");
        getFieldsInfo(equationSystemClass);

        System.out.println("\nMethods invoked using reflection: ");
        try {
            invokeAnnotatedMethods(matrixClass, matrix);
        } catch (InvocationTargetException | IllegalAccessException e) {
            e.printStackTrace();
        }


    }

    private static void getClassInterfaces(Class clazz) {
        for (Class tempClass : clazz.getInterfaces()) {
            printClassInfo(tempClass);
        }
    }

    private static void getFieldsInfo(Class clazz) {
        for (Field field : clazz.getDeclaredFields()) {
            printFieldsInfo(field);
        }
    }

    private static void printClassInfo(Class clazz) {
        System.out.println(clazz.getSimpleName());
    }

    private static void printFieldsInfo(Field field) {
        StringBuilder stringBuilder = new StringBuilder("Field: " + field.getName() +
                ", Type: " + field.getType().getTypeName());
        if(field.getAnnotations().length > 0) {
            stringBuilder.append(", Annotations: ");
            for (Annotation annotation : field.getAnnotations()) {
                stringBuilder.append(annotation.toString());
            }
        }
        System.out.println(stringBuilder);
    }

    private static void invokeAnnotatedMethods(Class clazz, Matrix matrix) throws InvocationTargetException, IllegalAccessException {
        for (Method method : clazz.getMethods()) {
            if (method.isAnnotationPresent(Special.class)) {
                method.invoke(matrix);
            }
        }
    }
}

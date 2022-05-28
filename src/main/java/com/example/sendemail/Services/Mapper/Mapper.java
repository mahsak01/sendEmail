package com.example.sendemail.Services.Mapper;

import org.springframework.stereotype.Component;

import java.lang.reflect.*;

@Component
public class Mapper {

    public <D> D map(Object source, Type destinationType) {

        Object target = null;
        try {

            Class<?> sourceClass = source.getClass();
            Constructor<?>[] sourceClassConstructors = sourceClass.getConstructors();

            Class<?> targetClass = Class.forName(destinationType.getTypeName());
            target = targetClass.newInstance();

            for (Constructor<?> constructor : sourceClassConstructors) {
                if (constructor.getParameterCount() != 0) {

                    Parameter[] sourceClassDeclaredConstructorParameters = constructor.getParameters();
                    int parameterCount = constructor.getParameterCount();
                    for (int i = 0; i < parameterCount; i++) {

                        String propertyName = sourceClassDeclaredConstructorParameters[i].getName();
                        String methodName = "get" + propertyName.substring(0, 1).toUpperCase() + propertyName.substring(1);
                        Method method = sourceClass.getMethod(methodName, null);
                        Object propertyValue = method.invoke(source, null);

                        // or instead use setter method - better approach
                        Field field;
                        try {
                            field = targetClass.getDeclaredField(propertyName);
                        } catch (NoSuchFieldException e) {
                            field = targetClass.getSuperclass().getDeclaredField(propertyName);
                        }
                        field.setAccessible(true);
                        field.set(target, propertyValue);
                    }
                }
            }
        } catch (Throwable e) {
            e.printStackTrace();
        }

        return (D) target;
    }
}
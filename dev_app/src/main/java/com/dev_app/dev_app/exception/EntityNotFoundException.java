package com.dev_app.dev_app.exception;

public class EntityNotFoundException extends RuntimeException {

    public EntityNotFoundException(Long id, Class<?> entity) {
        super("The "+ entity.getSimpleName().toLowerCase(null) + "with id '"+ id +"' does not exist in our records");
    }
    
}

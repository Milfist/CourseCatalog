package service;

import java.util.Optional;

public interface CreateNewObjectInDaoCallService<T> {
    Optional<Integer> createNewObjectInDaoCall(T object);
}

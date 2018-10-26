package service;

import java.util.List;
import java.util.Optional;

public interface FindObjectInDaoCallService<T> {
    Optional<List<T>> findObjectInDaoCall();
}

package service;

import javax.servlet.http.HttpServletRequest;

public interface AbstractServiceFactory {

    FindObjectInDaoCallService newFindObjectService(HttpServletRequest request);

    CreateNewObjectInDaoCallService newCreateNewObjectService(HttpServletRequest request);
}

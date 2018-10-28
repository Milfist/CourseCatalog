package service;

import javax.servlet.http.HttpServletRequest;

public interface AbstractServiceFactory {

    FindObjectInDaoCallService newFindObjectService();

    CreateNewObjectInDaoCallService newCreateNewObjectService();
}

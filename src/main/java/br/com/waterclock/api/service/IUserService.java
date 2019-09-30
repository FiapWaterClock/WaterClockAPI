package br.com.waterclock.api.service;

import br.com.waterclock.api.entity.User;
import br.com.waterclock.api.entity.UserDto;
import br.com.waterclock.api.exception.EmailExistsException;

public interface IUserService {
    User registerNewUserAccount(UserDto accountDto)
            throws EmailExistsException;
}

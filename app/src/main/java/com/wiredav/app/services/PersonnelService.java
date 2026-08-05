package com.wiredav.app.services;

import com.wiredav.app.dtos.personnelDTOs.*;
import com.wiredav.app.enums.PersonnelRole;
import org.springframework.stereotype.Service;


@Service
public class PersonnelService {

    public Boolean Register(RegisterUserRequestDTO newUser){
        return true;
    }

    public LoginResponseDTO Login(LoginRequestDTO loginInfo){
        return new LoginResponseDTO();
    }

    public PersonnelInfoDTO AddPersonnel(AddPersonnelRequestDTO info){
        return new PersonnelInfoDTO();
    }

    public Boolean RemovePersonnel(Long personnelId){
        return true;
    }

    public PersonnelInfoDTO UpdatePersonnel(PersonnelInfoDTO newInfo){
        return newInfo;
    }

    public PersonnelInfoDTO GetPersonnel(Long personnelId){
        return new PersonnelInfoDTO();
    }

    public GetPersonnelListResponseDTO GetPersonnelList(PersonnelRole role){
        return new GetPersonnelListResponseDTO();
    }
}

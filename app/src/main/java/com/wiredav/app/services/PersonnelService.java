package com.wiredav.app.services;

import com.wiredav.app.dtos.personnelDTOs.*;
import com.wiredav.app.entities.Personnel;
import com.wiredav.app.enums.PersonnelRole;
import com.wiredav.app.repositories.PersonnelRepository;
import org.springframework.stereotype.Service;


@Service
public class PersonnelService {

//    private final PersonnelRepository personnelRepository;
//
//    public PersonnelService(PersonnelRepository personnelRepository) {
//        this.personnelRepository = personnelRepository;
//    }
//
//    public Boolean Register(RegisterUserRequestDTO newUser){
//        return true;
//    }
//
//    public LoginResponseDTO Login(LoginRequestDTO loginInfo){
//        return new LoginResponseDTO();
//    }

//    public PersonnelInfoDTO AddPersonnel(AddPersonnelRequestDTO info){
//        return new PersonnelInfoDTO();
//    }
//
//    public Boolean RemovePersonnel(Long personnelId){
//        return true;
//    }
//
//    public PersonnelInfoDTO UpdatePersonnel(PersonnelInfoDTO newInfo){
//        return newInfo;
//    }
//
//    public Personnel GetPersonnel(Long personnelId){
//        var personnel = personnelRepository.findById(personnelId);
//
//        if (personnel.isPresent()) {
//            return personnel.get();
//        }
//
//        return null;
//    }
//
//    public GetPersonnelListResponseDTO GetPersonnelList(PersonnelRole role){
//        return new GetPersonnelListResponseDTO();
//    }
}

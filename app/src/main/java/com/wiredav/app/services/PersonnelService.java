package com.wiredav.app.services;

import com.wiredav.app.dtos.personnelDTOs.*;
import com.wiredav.app.entities.Personnel;
import com.wiredav.app.repositories.PersonnelRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;


@Service
@RequiredArgsConstructor
public class PersonnelService {

    private final PersonnelRepository personnelRepository;

    public Personnel registerPersonnel(AddPersonnelRequestDTO request){
        Personnel newPersonnel = Personnel.builder()
                .firstName(request.firstName())
                .lastName(request.lastName())
                .personnelEmail(request.email())
                .role(request.role())
                .build();


        return personnelRepository.save(newPersonnel);
    }

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
    public Personnel getPersonnel(Long personnelId){
        var personnel = personnelRepository.findById(personnelId);

        if (personnel.isPresent()) {
            return personnel.get();
        } else {
            return null;
        }
    }

    public Set<Personnel> GetPersonnelList(){
        var allPersonnel = personnelRepository.findAll();
        Set<Personnel> personnelList = new HashSet<>();

        for (Personnel personnel : allPersonnel) {
            personnelList.add(personnel);
        }

        return personnelList;
    }
}

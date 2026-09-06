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


    //This is for registering technicians to the company roster
    public Personnel registerTechnician(RegisterTechnicianRequestDTO request){
        Personnel newTechnician = Personnel.builder()
                .firstName(request.firstName())
                .lastName(request.lastName())
                .personnelEmail(request.email())
                .role(request.role())
                .build();

        return personnelRepository.save(newTechnician);
    }

//    public LoginResponseDTO Login(LoginRequestDTO loginInfo){
//        return new LoginResponseDTO();
//    }

//    public Boolean RemovePersonnel(Long personnelId){
//        return true;
//    }
//
    public Personnel updatePersonnel(PersonnelInfoDTO newInfo){
        var updatedPersonnel = personnelRepository.findById(newInfo.personnelId()).get();

        updatedPersonnel.setFirstName(newInfo.firstName());
        updatedPersonnel.setLastName(newInfo.lastName());
        updatedPersonnel.setPersonnelEmail(newInfo.email());
        updatedPersonnel.setRole(newInfo.role());

        return updatedPersonnel;
    }

    public Personnel getPersonnel(Long personnelId){
        var personnel = personnelRepository.findById(personnelId);

        if (personnel.isPresent()) {
            return personnel.get();
        } else {
            return null;
        }
    }

    public Set<Personnel> getPersonnelList(){
        var allPersonnel = personnelRepository.findAll();
        Set<Personnel> personnelList = new HashSet<>();

        for (Personnel personnel : allPersonnel) {
            personnelList.add(personnel);
        }

        return personnelList;
    }
}

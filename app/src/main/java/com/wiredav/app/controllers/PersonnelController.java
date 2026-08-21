package com.wiredav.app.controllers;

import com.wiredav.app.dtos.personnelDTOs.*;
import com.wiredav.app.entities.Personnel;
import com.wiredav.app.enums.PersonnelRole;
import com.wiredav.app.services.PersonnelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/personnel")
public class PersonnelController {
//
    private PersonnelService personnelService;

//    @PostMapping("/register")
//    public ResponseEntity<Void> RegisterUser(@RequestBody RegisterUserRequestDTO newUser){
//        Boolean result = personnelService.Register(newUser);
//        return ResponseEntity
//                .status(HttpStatus.OK)
//                .build();
//    }
//
//    @PostMapping("/login")
//    public ResponseEntity<LoginResponseDTO> Login(@RequestBody LoginRequestDTO loginInfo){
//        LoginResponseDTO loginResponse = personnelService.Login(loginInfo);
//        return ResponseEntity
//                .status(HttpStatus.OK)
//                .body(loginResponse);
//    }

//    @PostMapping("/personnel")
//    public ResponseEntity<PersonnelInfoDTO> AddPersonnel(@RequestBody AddPersonnelRequestDTO newPersonnel){
//        PersonnelInfoDTO createdPersonnel = personnelService.AddPersonnel(newPersonnel);
//        return ResponseEntity
//                .status(HttpStatus.OK)
//                .body(createdPersonnel);
//    }

//    @DeleteMapping("/{id}")
//    public ResponseEntity<Void> RemovePersonnel(@PathVariable("id") Long id){
//        Boolean result = personnelService.RemovePersonnel(id);
//        return ResponseEntity
//                .status(HttpStatus.OK)
//                .build();
//    }
//
//    @PostMapping("/update")
//    public ResponseEntity<PersonnelInfoDTO> UpdatePersonnel(@RequestBody PersonnelInfoDTO newInfo){
//        PersonnelInfoDTO updatedPersonnel = personnelService.UpdatePersonnel(newInfo);
//        return ResponseEntity
//                .status(HttpStatus.OK)
//                .body(updatedPersonnel);
//    }
//
    @GetMapping("/{personnelId}")
    public ResponseEntity<PersonnelInfoDTO> GetPersonnel(@PathVariable("personnelId") Long id){
        var personnel = personnelService.getPersonnel(id).toResponse();
        return ResponseEntity.ok(personnel);
    }
//
//    @GetMapping("/personnel/{role}")
//    public ResponseEntity<GetPersonnelListResponseDTO> GetPersonnelList(@PathVariable("role") PersonnelRole role){
//        GetPersonnelListResponseDTO personnelList = personnelService.GetPersonnelList(role);
//        return ResponseEntity
//                .status(HttpStatus.OK)
//                .body(personnelList);
//    }

}

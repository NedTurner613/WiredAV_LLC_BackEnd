package com.wiredav.app.controllers;

import com.wiredav.app.dtos.personnelDTOs.*;
import com.wiredav.app.entities.Personnel;
import com.wiredav.app.services.PersonnelService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;
import java.util.stream.Collectors;

@RestController
@RequestMapping("api/personnel")
public class PersonnelController {
//
    private PersonnelService personnelService;

    public PersonnelController(PersonnelService personnelService) {
        this.personnelService = personnelService;
    }

    @PostMapping("/register")
    public ResponseEntity<AddPersonnelResponseDTO> registerUser(@RequestBody AddPersonnelRequestDTO newUser){
        System.out.println("If you see this line, the service worked");
        var result = personnelService.registerPersonnel(newUser);
        System.out.println(result);
        System.out.println("If you see this line, you at least got to just before the return in the controller");
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(result.toAddPersonnelResponseDTO());
    }

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
    @GetMapping("/{id}")
    public ResponseEntity<PersonnelInfoDTO> GetPersonnel(@PathVariable Long id){
        var personnel = personnelService.getPersonnel(id).toResponse();
        return ResponseEntity.ok(personnel);
    }

    @GetMapping
    public ResponseEntity<GetPersonnelListWrapper> getAllPersonnel() {
        var personnelList = personnelService.GetPersonnelList();
        Set<GetPersonnelListResponseDTO> response = personnelList.stream().map(Personnel::toPersonnelListResponseDTO).collect(Collectors.toSet());
        GetPersonnelListWrapper wrappedResponse = new GetPersonnelListWrapper(response);

        return ResponseEntity.ok(wrappedResponse);
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

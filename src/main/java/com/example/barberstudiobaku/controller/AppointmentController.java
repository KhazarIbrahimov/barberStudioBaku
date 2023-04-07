//package com.example.barberstudiobaku.controller;
//
//import com.example.barberstudiobaku.business.AppointmentService;
//import com.example.barberstudiobaku.dto.AppointmentDTO;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController
//@RequestMapping("/appointments")
//public class AppointmentController {
//
//    @Autowired
//    private AppointmentService appointmentService;
//
//    @GetMapping("/{id}")
//    public ResponseEntity<AppointmentDTO> getAppointment(@PathVariable Long id) {
//        AppointmentDTO appointmentDTO = appointmentService.getAppointmentById(id);
//        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//    }
//        AppointmentDTO appointmentDTO = appointmentService.getAppointmentById(id);
//        if (appointmentDTO != null) {
//            return new ResponseEntity<>(appointmentDTO, HttpStatus.OK);
//        }
//        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//    }
//
//    @PostMapping
//    public ResponseEntity<AppointmentDTO> addAppointment(@RequestBody AppointmentDTO appointmentDTO) {
//        appointmentDTO = appointmentService.addAppointment(appointmentDTO);
//        return new ResponseEntity<>(appointmentDTO, HttpStatus.CREATED);
//    }
//
//    @PutMapping("/{id}")
//    public ResponseEntity<AppointmentDTO> updateAppointment(@PathVariable Long id, @RequestBody AppointmentDTO appointmentDTO) {
//        appointmentDTO.setId(id);
//        appointmentDTO = appointmentService.updateAppointment(appointmentDTO);
//        if (appointmentDTO == null) {
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
//        return new ResponseEntity<>(appointmentDTO, HttpStatus.OK);
//    }
//
//    @DeleteMapping("/{id}")
//    public ResponseEntity<Void> deleteAppointment(@PathVariable Long id) {
//        if (!appointmentService.deleteAppointment(id)) {
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
//        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//    }
//
//    @GetMapping
//    public ResponseEntity<List<AppointmentDTO>> getAllAppointments() {
//        List<AppointmentDTO> appointmentDTOs = appointmentService.getAllAppointments();
//        return new ResponseEntity<>(appointmentDTOs, HttpStatus.OK);
//    }
//
//
//}
//

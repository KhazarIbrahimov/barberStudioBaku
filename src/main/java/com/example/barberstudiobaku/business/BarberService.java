package com.example.barberstudiobaku.business;

import com.example.barberstudiobaku.dataAccess.BarberDAO;
import com.example.barberstudiobaku.dto.BarberDTO;
import com.example.barberstudiobaku.mapper.BarberMapper;
import com.example.barberstudiobaku.model.Barber;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BarberService {

    @Autowired
    private BarberDAO barberDAO;

    public List<BarberDTO> getAllBarbers() {
        List<Barber> barbers = barberDAO.getAllBarbers();
        List<BarberDTO> barberDTOs = new ArrayList<>();
        for (Barber barber : barbers) {
            barberDTOs.add(BarberMapper.toBarberDTO(barber));
        }
        return barberDTOs;
    }

    public BarberDTO getBarberById(int id) {
        Barber barber = barberDAO.getBarberById(id);
        if (barber == null) {
            return null;
        }
        return BarberMapper.toBarberDTO(barber);
    }

    public void addBarber(BarberDTO barberDTO) {
        Barber barber = BarberMapper.toBarber(barberDTO);
        barberDAO.addBarber(barber);
    }

    public void updateBarber(BarberDTO barberDTO) {
        Barber barber = BarberMapper.toBarber(barberDTO);
        barberDAO.updateBarber(barber);
    }

    public void deleteBarber(int id) {
        barberDAO.deleteBarber(id);
    }
}

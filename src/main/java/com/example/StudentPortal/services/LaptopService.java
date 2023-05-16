package com.example.StudentPortal.services;

import com.example.StudentPortal.models.Laptop;
import com.example.StudentPortal.repos.ILaptopRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LaptopService {
    @Autowired
    private ILaptopRepo laptopRepository;




    public List<Laptop> getAllLaptops() {
        return laptopRepository.findAll();
    }

    public Laptop getLaptopById(String id) {
        Optional<Laptop> laptop = laptopRepository.findById(id);
        return laptop.orElse(null);
    }

    public Laptop createLaptop(Laptop laptop) {
        return laptopRepository.save(laptop);
    }

    public Laptop updateLaptop(String id, Laptop laptop) {
        Optional<Laptop> existingLaptop = laptopRepository.findById(id);
        if (existingLaptop.isPresent()) {
            laptop.setID(existingLaptop.get().getID());
            return laptopRepository.save(laptop);
        }
        return null;
    }

    public boolean deleteLaptop(String id) {
        Optional<Laptop> existingLaptop = laptopRepository.findById(id);
        if (existingLaptop.isPresent()) {
            laptopRepository.delete(existingLaptop.get());
            return true;
        }
        return false;
    }
}


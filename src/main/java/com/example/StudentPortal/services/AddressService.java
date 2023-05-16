package com.example.StudentPortal.services;

import com.example.StudentPortal.models.Address;
import com.example.StudentPortal.repos.IAddressRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AddressService {
    @Autowired
    private  IAddressRepo addressRepository;




    public List<Address> getAllAddresses() {
        return addressRepository.findAll();
    }

    public Address getAddressById(Long id) {
        Optional<Address> address = addressRepository.findById(id);
        return address.orElse(null);
    }

    public Address createAddress(Address address) {
        return addressRepository.save(address);
    }

    public Address updateAddress(Long id, Address address) {
        Optional<Address> existingAddress = addressRepository.findById(id);
        if (existingAddress.isPresent()) {
            address.setAddressId(existingAddress.get().getAddressId());
            return addressRepository.save(address);
        }
        return null;
    }

    public boolean deleteAddress(Long id) {
        Optional<Address> existingAddress = addressRepository.findById(id);
        if (existingAddress.isPresent()) {
            addressRepository.delete(existingAddress.get());
            return true;
        }
        return false;
    }
}


package com.swe206.group_two.backend.sport;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SportServiceImpl implements SportService {
    @Autowired
    private SportRepository sportRepository;

    public List<Sport> getAllSports() {
        List<Sport> sports = new ArrayList<>();
        sportRepository.findAll().forEach(sports::add);
        return sports;
    }

    public Optional<Sport> getSportById(Integer id) {
        return sportRepository.findById(id);
    }

    public List<Sport> getSportByNameContaining(String name) {
        return sportRepository.getSportByNameContaining(name);
    }

    public Sport createSport(Sport sport) {
        return sportRepository.save(sport);
    }

    public Sport updateSportById(Integer id, Sport sport) {
        Sport _sport = sportRepository.findById(id).get();
        _sport.setName(sport.getName());
        return sportRepository.save(_sport);
    }

    @Override
    public boolean deleteAllSports() {
        sportRepository.deleteAll();
        return true;
    }

    @Override
    public boolean deleteSportById(Integer id) {
        sportRepository.deleteById(id);
        return true;
    }
}
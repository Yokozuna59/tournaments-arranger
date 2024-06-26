package com.swe206.group_two.backend.participant;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ParticipantServiceImpl implements ParticipantService {
    @Autowired
    private ParticipantRepository participantRepository;

    @Override
    public List<Participant> getAllParticipants() {
        List<Participant> participants = new ArrayList<>();
        participantRepository.findAll().forEach(participants::add);
        return participants;
    }

    @Override
    public Optional<Participant> getParticipantById(Integer id) {
        return participantRepository.findById(id);
    }

    @Override
    public List<Participant> getAllParticipantsByTournamentId(Integer id) {
        return participantRepository.findAllByTournamentId(id);
    }

    @Override
    public List<Participant> getAllParticipantByUserId(Integer id) {
        return participantRepository.findAllByUserId(id);
    }

    @Override
    public List<Participant> getAllParticipantsByTeamId(Integer id) {
        return participantRepository.findAllByTeamId(id);
    }

    @Override
    public Participant createParticipant(Participant participant) {
        return participantRepository.save(participant);
    }

    @Override
    public Participant updateParticipant(Participant participant) {
        return participantRepository.save(participant);
    }

    @Override
    public void deleteAllParticipants() {
        participantRepository.deleteAll();
    }

    @Override
    public void deleteParticipantById(Integer id) {
        participantRepository.deleteById(id);
    }
}

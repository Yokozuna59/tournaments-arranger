package com.swe206.group_two.backend.participant;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ParticipantRepository extends JpaRepository<Participant, Integer> {
    @Override
    public abstract List<Participant> findAll();

    @Override
    public abstract Optional<Participant> findById(Integer id);

    public abstract List<Participant> findAllByTournamentId(Integer id);

    public abstract List<Participant> findAllByUserId(Integer id);

    public abstract List<Participant> findAllByTeamId(Integer id);

    @Override
    public abstract <S extends Participant> S save(S participant);

    @Override
    public abstract void deleteAll();

    @Override
    public abstract void deleteById(Integer id);
}

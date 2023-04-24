package com.swe206.group_two.backend.team;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TeamRepository extends JpaRepository<Team, Integer> {
    @Override
    public abstract List<Team> findAll();

    @Override
    public abstract Optional<Team> findById(Integer id);

    public abstract Optional<Team> findByTournamentId(Integer id);

    public abstract Optional<Team> findByRankId(Integer id);

    @Override
    public abstract <S extends Team> S save(S team);

    @Override
    public abstract void deleteAll();

    @Override
    public abstract void deleteById(Integer id);
}

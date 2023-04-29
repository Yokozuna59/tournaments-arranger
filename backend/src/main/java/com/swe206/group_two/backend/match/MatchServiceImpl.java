package com.swe206.group_two.backend.match;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.swe206.group_two.backend.participant.Participant;
import com.swe206.group_two.backend.participant.ParticipantServiceImpl;
import com.swe206.group_two.backend.team.Team;
import com.swe206.group_two.backend.team.TeamServiceImpl;
import com.swe206.group_two.backend.tournament.Tournament;
import com.swe206.group_two.backend.tournament.TournamentServiceImpl;
import com.swe206.group_two.backend.utils.TournamentBased;
import com.swe206.group_two.backend.utils.TournamentType;

@Service
public class MatchServiceImpl implements MatchService {
    @Autowired
    private MatchRepository matchRepository;

    @Autowired
    private TournamentServiceImpl tournamentServiceImpl;

    @Autowired
    private ParticipantServiceImpl participantServiceImpl;

    @Autowired
    private TeamServiceImpl teamServiceImpl;

    @Override
    public List<Match> getAllMatches() {
        List<Match> matches = new ArrayList<>();
        matchRepository.findAll().forEach(matches::add);
        return matches;
    }

    @Override
    public Optional<Match> getMatchById(Integer id) {
        return matchRepository.findById(id);
    }

    @Override
    public List<Match> getMatchesByTournamentId(Integer tournamentId) {
        return matchRepository.findAllByTournamentId(tournamentId);
    }

    @Override
    public Match createMatch(Match match) {
        return matchRepository.save(match);
    }

    @Override
    public void deleteAllMatches() {
        matchRepository.deleteAll();
    }

    @Override
    public void deleteMatchById(Integer id) {
        matchRepository.deleteById(id);
    }

    @Override
    public List<Match> generateMatches(Integer tournamentId) {
        List<Match> matches = new ArrayList<>();
        Tournament tournament = tournamentServiceImpl.getTournamentById(tournamentId).get();
        TournamentType type = tournament.getType();
        TournamentBased based = tournament.getBased();
        Integer daysBetweenStages = tournament.getDaysBetweenStages();
        LocalDate date = tournament.getStartDate();

        List<Participant> participants;
        List<Team> teams;
        Integer numberOfParticipants;

        if (type.equals(TournamentType.RoundRobin)) {
            if (based.equals(TournamentBased.Individual)) {
                participants = participantServiceImpl.getAllParticipantsByTournamentId(tournamentId).stream()
                        .filter(participant -> participant.getTeamId().equals(null)).collect(Collectors.toList());
                numberOfParticipants = participants.size();

                List<Integer> ids = new ArrayList<>();

                for (int i = 0; i < numberOfParticipants; i++) {
                    ids.add(participants.get(i).getId());
                }
                roundRobinSchedualing(ids, matches, tournamentId, daysBetweenStages, date);
            } else {
                teams = teamServiceImpl.getAllTeamsByTournamentId(tournamentId);
                numberOfParticipants = teams.size();

                List<Integer> ids = new ArrayList<>();

                for (int i = 0; i < numberOfParticipants; i++) {
                    ids.add(teams.get(i).getId());
                }
                roundRobinSchedualing(ids, matches, tournamentId, daysBetweenStages, date);
            }
        } else {
            if (based.equals(TournamentBased.Individual)) {
                participants = participantServiceImpl.getAllParticipantsByTournamentId(tournamentId).stream()
                        .filter(participant -> participant.getTeamId().equals(null)).collect(Collectors.toList());
                numberOfParticipants = participants.size();

                List<Integer> ids = new ArrayList<>();

                for (int i = 0; i < numberOfParticipants; i++) {
                    ids.add(participants.get(i).getId());
                }
                eliminationSchedualing(ids, matches, tournamentId, daysBetweenStages, date);
            } else {
                teams = teamServiceImpl.getAllTeamsByTournamentId(tournamentId);
                numberOfParticipants = teams.size();

                List<Integer> ids = new ArrayList<>();

                for (int i = 0; i < numberOfParticipants; i++) {
                    ids.add(teams.get(i).getId());
                }
                eliminationSchedualing(ids, matches, tournamentId, daysBetweenStages, date);
            }
        }
        return matches;
    }

    public void roundRobinSchedualing(List<Integer> usersIds, List<Match> matches, Integer tournamentId,
            Integer daysBetweenStages, LocalDate date) {

        int numberOfParticipants = usersIds.size();

        if (numberOfParticipants % 2 != 0) {
            usersIds.add(0); // If odd number of teams add a dummy
            numberOfParticipants++;
        }

        int daysToFinishTheTournament = (numberOfParticipants - 1); // rounds needed to complete tournament
        int halfSize = numberOfParticipants / 2;

        List<Integer> teams = new ArrayList<>();

        teams.addAll(usersIds); // Add teams to List and remove the first team
        teams.remove(0);

        int teamsLength = teams.size();
        int i = 0;
        for (int day = 0; day < daysToFinishTheTournament; day++) {

            int teamId = day % teamsLength;
            if (teams.get(teamId) == 0 || teams.get(0) == 0) {
            } else {
                matches.add(new Match(tournamentId, teams.get(teamId),
                        teams.get(0), null,
                        null, date.plusDays(i * daysBetweenStages)));
                i++;
            }

            for (int id = 1; id < halfSize; id++) {
                int firstTeam = (day + id) % teamsLength;
                int secondTeam = (day + teamsLength - id) % teamsLength;
                if (teams.get(firstTeam) == 0 || teams.get(secondTeam) == 0) {
                } else {
                    matches.add(new Match(tournamentId, teams.get(firstTeam),
                            teams.get(secondTeam), null,
                            null, date.plusDays(i * daysBetweenStages)));
                    i++;
                }
            }
        }
    }

    public void eliminationSchedualing(List<Integer> usersIds, List<Match> matches, Integer tournamentId,
            Integer daysBetweenStages, LocalDate date) {
        int i = 0;
        while (i < usersIds.size() / 2 - 1) {
            matches.add(new Match(tournamentId, usersIds.get(2 * i), usersIds.get(2 * i + 1),
                    null, null, date.plusDays(i * daysBetweenStages)));
            i++;
        }
    }

    // @Override
    // public void changeMatchPoints(Integer points) {
    // matchRepository.setPoints(points);
    // }
}

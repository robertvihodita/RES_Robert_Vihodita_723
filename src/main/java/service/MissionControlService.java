package service;

import model.*;
import repository.*;

import java.io.*;
import java.util.*;
import java.util.stream.*;

public class MissionControlService {

    private IRepository<Astronaut> astronautRepo;
    private IRepository<MissionEvent> eventRepo;
    private IRepository<Supply> supplyRepo;

    private List<Astronaut> astronauts;
    private List<MissionEvent> events;
    private List<Supply> supplies;

    public MissionControlService(
            IRepository<Astronaut> a,
            IRepository<MissionEvent> e,
            IRepository<Supply> s) {

        astronautRepo = a;
        eventRepo = e;
        supplyRepo = s;

        load();
    }

    public void load() {

        astronauts = astronautRepo.findAll();
        events = eventRepo.findAll();
        supplies = supplyRepo.findAll();
    }

    public List<Astronaut> getAstronauts() {
        return astronauts;
    }

    public List<MissionEvent> getEvents() {
        return events;
    }

    public List<Supply> getSupplies() {
        return supplies;
    }

    // TASK 2
    public List<Astronaut> filter(String spacecraft) {

        return astronauts.stream()

                .filter(a ->
                        a.getSpacecraft().equals(spacecraft)
                                &&
                                a.getStatus() == AstronautStatus.ACTIVE)

                .collect(Collectors.toList());
    }

    // TASK 3
    public List<Astronaut> sort() {

        return astronauts.stream()

                .sorted(
                        Comparator
                                .comparingInt(Astronaut::getExperienceLevel)
                                .reversed()
                                .thenComparing(Astronaut::getName)
                )

                .collect(Collectors.toList());
    }

    // TASK 4
    public void writeSortedReverse(String filename)
            throws Exception {

        List<Astronaut> sorted = sort();

        Collections.reverse(sorted);

        PrintWriter pw = new PrintWriter(filename);

        for (Astronaut a : sorted)
            pw.println(a);

        pw.close();
    }

    // TASK 5
    public int computePoints(MissionEvent e) {

        switch (e.getType()) {

            case EVA:
                return e.getBasePoints() + 2 * e.getDay();

            case SYSTEM_FAILURE:
                return e.getBasePoints() - 3 - e.getDay();

            case SCIENCE:
                return e.getBasePoints() + e.getDay() % 4;

            case MEDICAL:
                return e.getBasePoints() - 2 * (e.getDay() % 3);

            case COMMUNICATION:
                return e.getBasePoints() + 5;
        }

        return 0;
    }


}




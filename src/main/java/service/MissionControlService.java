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

}




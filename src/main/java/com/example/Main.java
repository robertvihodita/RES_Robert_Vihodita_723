package com.example;

import model.*;
import repository.*;
import service.*;

import java.util.*;

public class Main {

    public static void main(String[] args)
            throws Exception {

        IRepository<Astronaut> aRepo =
                new AstronautRepository("astronauts.json");

        IRepository<MissionEvent> eRepo =
                new MissionEventRepository("events.json");

        IRepository<Supply> sRepo =
                new SupplyRepository("supplies.json");

        MissionControlService service =
                new MissionControlService(
                        aRepo, eRepo, sRepo);

        System.out.println(
                "Astronauts loaded: "
                        + service.getAstronauts().size());

        System.out.println(
                "Events loaded: "
                        + service.getEvents().size());

        System.out.println(
                "Supplies loaded: "
                        + service.getSupplies().size());

        service.getAstronauts()
                .forEach(System.out::println);

        Scanner sc = new Scanner(System.in);

        System.out.print("Input spacecraft: ");

        String input = sc.nextLine();

        service.filter(input)
                .forEach(System.out::println);

        service.sort()
                .forEach(System.out::println);

        service.writeSortedReverse(
                "astronauts_sorted.txt");

        service.getEvents()
                .stream()
                .limit(5)
                .forEach(e ->
                        System.out.println(
                                "Event "
                                        + e.getId()
                                        + " -> raw="
                                        + e.getBasePoints()
                                        + " -> computed="
                                        + service.computePoints(e)
                        )
                );

        service.ranking();
    }
}

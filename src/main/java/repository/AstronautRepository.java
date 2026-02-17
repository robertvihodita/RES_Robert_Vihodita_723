package repository;

import model.*;

import java.util.Map;

public class AstronautRepository
        extends InFileRepository<Astronaut> {

    public AstronautRepository(String filename) {
        super(filename);
    }


    @Override
    protected Astronaut mapEntity(Map<String,String> map) {

        return new Astronaut(

                Integer.parseInt(map.get("id")),
                map.get("name"),
                map.get("spacecraft"),
                AstronautStatus.valueOf(map.get("status")),
                Integer.parseInt(map.get("experienceLevel"))

        );
    }
}

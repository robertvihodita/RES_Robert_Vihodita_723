package repository;

import model.*;

import java.util.Map;

public class MissionEventRepository
        extends InFileRepository<MissionEvent> {

    public MissionEventRepository(String filename) {
        super(filename);
    }

    @Override
    protected MissionEvent mapEntity(Map<String,String> map) {

        return new MissionEvent(

                Integer.parseInt(map.get("id")),
                Integer.parseInt(map.get("astronautId")),
                MissionEventType.valueOf(map.get("type")),
                Integer.parseInt(map.get("basePoints")),
                Integer.parseInt(map.get("day"))

        );
    }
}

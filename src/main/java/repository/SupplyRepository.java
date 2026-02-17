package repository;

import model.*;

import java.util.Map;

public class SupplyRepository
        extends InFileRepository<Supply> {

    public SupplyRepository(String filename) {
        super(filename);
    }

    @Override
    protected Supply mapEntity(Map<String,String> map) {
        return new Supply(
                Integer.parseInt(map.get("id")),
                Integer.parseInt(map.get("astronautId")),
                map.get("type"),
                Integer.parseInt(map.get("value")),
                0
        );
    }
}
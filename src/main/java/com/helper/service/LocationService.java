package com.helper.service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.helper.model.Location;
import com.helper.repository.LocationRepository;


@Service
public class LocationService {
    private final LocationRepository locationRepository;

    public LocationService(LocationRepository locationRepository) {
        this.locationRepository = locationRepository;
    }

    public List<Location> getLocationList() {
        return locationRepository.listLocation();
    }

    public Location getLocationById(Long id) {
        return locationRepository.findLocationById(id);
    }

    public void createLocation(Location location) {
        locationRepository.createLocation(location.getName(), location.getDescription());
    }

    public void updateLocation(Long id, Location location) {
        locationRepository.updateLocation(id, location.getName(), location.getDescription());
    }

    public Location deleteLocation(Long id) {
        Location location = locationRepository.findLocationById(id);
        if (location == null) {
            throw new IllegalArgumentException("Location with id " + id + " does not exist");
        }
        locationRepository.deleteLocation(id);
        return location;
    }
}

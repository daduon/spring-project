package com.helper.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.helper.checkResponse.BaseRest;
import com.helper.checkResponse.BaseRestFactory;
import com.helper.model.Location;
import com.helper.repository.LocationRepository;


@Service
public class LocationService {
    private final LocationRepository locationRepository;

    public LocationService(LocationRepository locationRepository) {
        this.locationRepository = locationRepository;
    }

    public BaseRest<List<Location>> getLocationList() {
        return BaseRestFactory.success(locationRepository.listLocation());
    }

    public BaseRest<Location> getLocationById(Long id) {
        return BaseRestFactory.success(locationRepository.findLocationById(id));
    }

    public BaseRest<Location> createLocation(Location location) {
        locationRepository.createLocation(location.getName(), location.getDescription());
        return BaseRestFactory.success(location);
    }

    public BaseRest<Location> updateLocation(Long id, Location location) {
        int updated = locationRepository.updateLocation(id, location.getName(), location.getDescription());
        if (updated == 0) {
            throw new IllegalArgumentException("Location with ID " + id + " not found.");
        }
        location.setId(id);
        return BaseRestFactory.success(location);
    }

    public BaseRest<Location> deleteLocation(Long id) {
        Location location = locationRepository.findLocationById(id);
        if (location == null) {
            throw new IllegalArgumentException("Location with id " + id + " does not exist");
        }
        int deleted = locationRepository.deleteLocation(id);
        if (deleted == 0) {
            throw new RuntimeException("Failed to delete location with id " + id);
        }
        return BaseRestFactory.success(location);
    }
}

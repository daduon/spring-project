package com.helper.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.helper.checkResponse.BaseRest;
import com.helper.model.Location;
import com.helper.service.LocationService;



@RestController
@RequestMapping("/api/location")
public class LocationController {
    private final LocationService locationService;

    public LocationController(LocationService locationService) {
        this.locationService = locationService;
    }

    @GetMapping("/list")
    public ResponseEntity<BaseRest<List<Location>>> getAllLocations() {
        return ResponseEntity.ok(locationService.getLocationList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<BaseRest<Location>> getLocationById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(locationService.getLocationById(id));
    }

    @PostMapping("/create")
    public ResponseEntity<BaseRest<Location>> createLocation(@RequestBody Location location) {
        locationService.createLocation(location);
        return ResponseEntity.ok(locationService.createLocation(location));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<BaseRest<Location>> updateLocation(@PathVariable("id") Long id, @RequestBody Location location) {
        BaseRest<Location> response = locationService.updateLocation(id, location);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<BaseRest<Location>> deleteLocation(@PathVariable("id") Long id) {
        return ResponseEntity.ok(locationService.deleteLocation(id));
    }
}

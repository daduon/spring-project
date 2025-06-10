package com.helper.controller;

import java.time.LocalDateTime;
import java.util.List;

import com.helper.checkResponse.BaseRest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
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
    public ResponseEntity<List<Location>> getAllLocations() {
        List<Location> list = locationService.getLocationList();
        return ResponseEntity.ok(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Location> getLocationById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(locationService.getLocationById(id));
    }

    @PostMapping("/create")
    public ResponseEntity<String> createLocation(@RequestBody Location location) {
        locationService.createLocation(location);
        return ResponseEntity.ok("Location created successfully");
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<String> updateLocation(@PathVariable("id") Long id, @RequestBody Location location) {
        locationService.updateLocation(id, location);
        return ResponseEntity.ok("Location updated successfully");
    }

    @DeleteMapping("/delete/{id}")
    public BaseRest<?> deleteLocation(@PathVariable("id") Long id) {
        Location location = locationService.deleteLocation(id);
        return BaseRest.builder()
                .message("Location deleted successfully")
                .status(true)
                .code(HttpStatus.OK.value())
                .timestamp(LocalDateTime.now())
                .data(location)
                .build();
    }
}

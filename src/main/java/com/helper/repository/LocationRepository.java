package com.helper.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.helper.model.Location;

import jakarta.transaction.Transactional;
import org.springframework.data.repository.query.Param;

@Transactional
public interface LocationRepository extends JpaRepository<Location, Long> {

    // Native SQL
    @Query(value = "SELECT * FROM locations", nativeQuery = true)
    List<Location> listLocation();

    // get location by id
    @Query(value = "SELECT * FROM locations lo WHERE lo.id = :id", nativeQuery = true)
    Location findLocationById(@Param("id") Long id);

    // create a new location
    @Modifying
    @Query(value = "INSERT INTO locations (name, description) VALUES (:name, :description)", nativeQuery = true)
    void createLocation(@Param("name") String name, @Param("description") String description);

    // update location by id
    @Modifying
    @Query(value = "UPDATE locations SET name = :name, description = :description WHERE id = :id", nativeQuery = true)
    void updateLocation(@Param("id") Long id, @Param("name") String name, @Param("description") String description);

    // delete location by id
    @Modifying
    @Query(value = "DELETE FROM locations lo WHERE lo.id = :id", nativeQuery = true)
    void deleteLocation(@Param("id") Long id);
}

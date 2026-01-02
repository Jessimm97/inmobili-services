package com.micro.properties.repository;

import com.micro.properties.model.Property;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface PropertyRepository extends JpaRepository<Property, Long> {
    @Query("SELECT p FROM Property p WHERE " +
           "(:keyword IS NULL OR LOWER(p.title) LIKE LOWER(CONCAT('%', :keyword, '%')) OR LOWER(p.location) LIKE LOWER(CONCAT('%', :keyword, '%'))) AND " +
           "(:minBedrooms IS NULL OR p.bedrooms >= :minBedrooms) AND " +
           "(:maxPrice IS NULL OR CAST(REPLACE(REPLACE(p.price, '$', ''), ',', '') AS double) <= :maxPrice)")
    List<Property> searchProperties(
            @Param("keyword") String keyword,
            @Param("minBedrooms") Integer minBedrooms,
            @Param("maxPrice") Double maxPrice
    );
}
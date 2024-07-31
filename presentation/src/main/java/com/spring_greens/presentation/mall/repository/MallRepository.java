package com.spring_greens.presentation.mall.repository;

import com.spring_greens.presentation.mall.dto.projection.Coordinate;
import com.spring_greens.presentation.mall.dto.projection.Destination;
import com.spring_greens.presentation.mall.entity.Mall;
import io.lettuce.core.dynamic.annotation.Param;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;


public interface MallRepository extends CrudRepository<Mall, Long> {
    /**
     * This repository used Projection so Coordinate interface that contains latitude, longitude attributes.
     * @return
     */
    @Query(value = "select name from Mall where id != 1", nativeQuery = true)
    List<String> findAllMallName();

    @Query(value = "select m.latitude as latitude, " +
            "m.longitude as longitude " +
            "from Mall as m where id = 1", nativeQuery = true)
    Coordinate findStandardCoordinate();

    @Query(value = "select m.width as width, " +
            "m.latitude as latitude, " +
            "m.longitude as longitude " +
            "from Mall as m where m.name = :mallName", nativeQuery = true)
    Destination findMallDestination(@Param("mallName") String mallName);

}
package com.example.examprepmusicdb.repository;

import com.example.examprepmusicdb.model.entity.Album;
import com.example.examprepmusicdb.model.view.AlbumViewModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

@Repository
public interface AlbumRepository extends JpaRepository<Album, Long> {

    @Query("SELECT sum (a.copies) from Album a ")
    Integer findAlbumsByTotalSoldCopies();


    List<Album> findAlbumByCopies(String album);

   // String findByName();
}

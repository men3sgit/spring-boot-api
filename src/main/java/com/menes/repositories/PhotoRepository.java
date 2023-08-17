package com.menes.repositories;

import com.menes.models.PhotoDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PhotoRepository extends JpaRepository<PhotoDetails, Long> {

    @Query("SELECT pd FROM PhotoDetails pd")
    public Optional<PhotoDetails> getAllPhotoDetails();


}

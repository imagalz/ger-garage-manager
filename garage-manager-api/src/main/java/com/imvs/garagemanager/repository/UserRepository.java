package com.imvs.garagemanager.repository;

import com.imvs.garagemanager.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@Component
public interface UserRepository extends JpaRepository<User, Long> {

    List<User> findByProfileId(Long profileId);

    List<User> findByLastName(String lastName);

    List<User> findAll();

    Optional<User> findById(Long id);

    Optional<User> findByEmail(String email);

    User save(User booking);

    User update(User booking);
    
}

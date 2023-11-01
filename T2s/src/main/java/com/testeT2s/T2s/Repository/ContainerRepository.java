package com.testeT2s.T2s.Repository;

import com.testeT2s.T2s.Model.Container;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository
public interface ContainerRepository extends JpaRepository<Container, UUID> {
}

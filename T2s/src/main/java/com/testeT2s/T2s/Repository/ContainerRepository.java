package com.testeT2s.T2s.Repository;

import com.testeT2s.T2s.Model.Container;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ContainerRepository extends JpaRepository<Container, UUID> {
}

package com.example.nointurn.Category;

import com.example.nointurn.Category.entity.Ability;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface AbilityRepository extends JpaRepository<Ability,Long> {
    List<Ability> findAllByAbilityIdx(Long abilityIdx);
}

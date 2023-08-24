package com.example.nointurn.Category;

import com.example.nointurn.Category.entity.Ability;
import com.example.nointurn.Category.entity.UserAbility;
import com.example.nointurn.User.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserAbilityRepository extends JpaRepository<UserAbility,Long> {
    List<UserAbility> findAllByUserIdx(User userIdx);
    List<UserAbility> findAllByAbilityIdx(Ability ability);
}

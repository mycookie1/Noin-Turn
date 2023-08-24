package com.example.nointurn.User;

import com.example.nointurn.Company.entity.Company;
import com.example.nointurn.User.entity.User;
import com.example.nointurn.User.entity.UserApply;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserApplyRepository extends JpaRepository<UserApply,Long> {
    List<UserApply> findAllByUserIdx(User UserIdx);
    List<UserApply> findAllByCompanyIdx(Company companyIdx);
}

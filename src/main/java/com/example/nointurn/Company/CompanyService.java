package com.example.nointurn.Company;

import com.example.nointurn.Category.CompanyAbilityRepository;
import com.example.nointurn.Category.UserAbilityRepository;
import com.example.nointurn.Category.entity.CompanyAbility;
import com.example.nointurn.Category.entity.UserAbility;
import com.example.nointurn.Company.entity.Company;
import com.example.nointurn.Company.entity.CompanyApply;
import com.example.nointurn.User.UserApplyRepository;
import com.example.nointurn.User.UserRepository;
import com.example.nointurn.User.entity.User;
import com.example.nointurn.User.entity.UserApply;
import com.example.nointurn.User.model.GetCompanyRes;
import com.example.nointurn.User.model.GetUserRes;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Transactional
@RequiredArgsConstructor
@Service
public class CompanyService {
    @Autowired
    private CompanyRepository companyRepository;
    @Autowired
    private CompanyAbilityRepository companyAbilityRepository;
    @Autowired
    private CompanyApplyRepository companyApplyRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserApplyRepository userApplyRepository;
    @Autowired
    private UserAbilityRepository userAbilityRepository;

    @Transactional(readOnly = true)
    public GetCompanyRes getCompany(Long companyIdx) {
        Company company = companyRepository.findByCompanyIdx(companyIdx).get();
        List<CompanyAbility> companyAbilityList = companyAbilityRepository.findAllByCompanyIdx(company);
        String abilitySentence = "";
        for(int i = 0; i<companyAbilityList.size(); i++){
            abilitySentence += companyAbilityList.get(i).getAbilityIdx().getCategoryDetail();
            if(i != companyAbilityList.size()-1){
                abilitySentence += ", ";
            }
        }
        com.example.nointurn.User.model.GetCompanyRes getCompanyRes = new GetCompanyRes(companyIdx, company.getName(),company.getLocation(),company.getImageURL(),company.getContext(), company.getAge(), company.getCareer(),abilitySentence ,company.getWage(), company.getPeriod());
        return getCompanyRes;
    }
    @Transactional(readOnly = false)
    public String getPhone(Long companyIdx, Long userIdx) {
        User user = userRepository.findByUserIdx(userIdx).get();
        Company company =companyRepository.findByCompanyIdx(companyIdx).get();
        CompanyApply newCompanyApply = new CompanyApply(user,company);
        CompanyApply companyApply = companyApplyRepository.save(newCompanyApply);
        return user.getPhone();
    }
    //지원자 리스트
    @Transactional(readOnly = true)
    public List<GetUserRes> getApplyRes(Long companyIdx) {
        Company company = companyRepository.findByCompanyIdx(companyIdx).get();
        List<UserApply> userApplyList = userApplyRepository.findAllByCompanyIdx(company);
        List<GetUserRes> getUserResList = new ArrayList<>();
        for(UserApply userApply: userApplyList){
            User newUser = userRepository.findByUserIdx(userApply.getUserIdx().getUserIdx()).get();
            //ability
            List<UserAbility> abilityList = userAbilityRepository.findAllByUserIdx(newUser);
            String abilitySentence = "";
            for(int i = 0; i<abilityList.size(); i++){
                abilitySentence += abilityList.get(i).getAbilityIdx().getCategoryDetail();
                if(i != abilityList.size()-1){
                    abilitySentence += ", ";
                }
            }
            //careerList
            String career[] = newUser.getCareer().split(",");
            List<String> careerList = new ArrayList<>();
            for(String temp: career){
                careerList.add(temp);
            }
            GetUserRes getUserRes = new GetUserRes(newUser.getUserIdx(), newUser.getName(), newUser.getAge(), newUser.getLocation(),abilitySentence,careerList);
            getUserResList.add(getUserRes);
        }
        return getUserResList;
    }

    //기업이 보낸 콘텍 리스트
    @Transactional(readOnly = true)
    public List<GetUserRes> getContact(Long companyIdx) {
        Company company = companyRepository.findByCompanyIdx(companyIdx).get();
        List<CompanyApply> companyApplyList = companyApplyRepository.findAllByCompanyIdx(company);
        List<GetUserRes> getUserResList = new ArrayList<>();
        for(CompanyApply companyApply: companyApplyList){
            User newUser = userRepository.findByUserIdx(companyApply.getUserIdx().getUserIdx()).get();
            //ability
            List<UserAbility> abilityList = userAbilityRepository.findAllByUserIdx(newUser);
            String abilitySentence = "";
            for(int i = 0; i<abilityList.size(); i++){
                abilitySentence += abilityList.get(i).getAbilityIdx().getCategoryDetail();
                if(i != abilityList.size()-1){
                    abilitySentence += ", ";
                }
            }
            //careerList
            String career[] = newUser.getCareer().split(",");
            List<String> careerList = new ArrayList<>();
            for(String temp: career){
                careerList.add(temp);
            }
            GetUserRes getUserRes = new GetUserRes(newUser.getUserIdx(), newUser.getName(), newUser.getAge(), newUser.getLocation(),abilitySentence,careerList);
            getUserResList.add(getUserRes);
        }
        return getUserResList;
    }
    //기업과 맞는 지원자 리스트
    @Transactional(readOnly = true)
    public List<GetUserRes> getUser(Long companyIdx) {
        Company company = companyRepository.findByCompanyIdx(companyIdx).get();
        //ability
        List<CompanyAbility> companyAbilityList = companyAbilityRepository.findAllByCompanyIdx(company);

        Set<User> userSet = new HashSet<>();
        for(CompanyAbility companyAbility: companyAbilityList){
            List<UserAbility> userAbilityList = userAbilityRepository.findAllByAbilityIdx(companyAbility.getAbilityIdx());
            for(UserAbility userAbility: userAbilityList){
                userSet.add(userAbility.getUserIdx());
            }
        }
        List<GetUserRes> getUserResList = new ArrayList<>();
        for (User user: userSet){
            List<UserAbility> userAbilityList = userAbilityRepository.findAllByUserIdx(user);
            String abilitySentence = "";
            for(int i = 0; i<userAbilityList.size(); i++){
                abilitySentence += userAbilityList.get(i).getAbilityIdx().getCategoryDetail();
                if(i != userAbilityList.size()-1){
                    abilitySentence += ", ";
                }
            }
            //careerList
            String career[] = user.getCareer().split(",");
            List<String> careerList = new ArrayList<>();
            for(String temp: career){
                careerList.add(temp);
            }

            GetUserRes newGetUserRes = new GetUserRes(user.getUserIdx(),user.getName(),user.getAge(),user.getLocation(),abilitySentence,careerList);
            getUserResList.add(newGetUserRes);
        }

        return getUserResList;
    }
}

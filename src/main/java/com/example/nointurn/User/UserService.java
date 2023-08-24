package com.example.nointurn.User;

import com.example.nointurn.Category.CompanyAbilityRepository;
import com.example.nointurn.Category.UserAbilityRepository;
import com.example.nointurn.Category.entity.CompanyAbility;
import com.example.nointurn.Category.entity.UserAbility;
import com.example.nointurn.Company.CompanyApplyRepository;
import com.example.nointurn.Company.CompanyRepository;
import com.example.nointurn.Company.entity.Company;
import com.example.nointurn.Company.entity.CompanyApply;
import com.example.nointurn.User.entity.User;
import com.example.nointurn.User.entity.UserApply;
import com.example.nointurn.User.model.*;
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
public class UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserAbilityRepository userAbilityRepository;
    @Autowired
    private CompanyAbilityRepository companyAbilityRepository;
    @Autowired
    private UserApplyRepository userApplyRepository;
    @Autowired
    private CompanyApplyRepository companyApplyRepository;
    @Autowired
    private CompanyRepository companyRepository;

    //user 찾기
    @Transactional(readOnly = true)
    public GetUserRes getUser(Long userIdx) {
        User newUser = userRepository.findByUserIdx(userIdx).get();
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
        GetUserRes getUserRes = new GetUserRes(newUser.getName(), newUser.getAge(), newUser.getLocation(),abilitySentence,careerList);
       return getUserRes;
    }
    //유저의 요구와 맞는 기업 리스트
    @Transactional(readOnly = true)
    public List<GetFindJobRes> getFindJobRes(Long userIdx) {
        User newUser = userRepository.findByUserIdx(userIdx).get();
        //ability
        List<UserAbility> userAbilityList = userAbilityRepository.findAllByUserIdx(newUser);

        Set<Company> companySet = new HashSet<>();
        for(UserAbility userAbility: userAbilityList){
            List<CompanyAbility> companyAbilityList = companyAbilityRepository.findAllByAbilityIdx(userAbility.getAbilityIdx());
            for(CompanyAbility companyAbility: companyAbilityList){
                companySet.add(companyAbility.getCompanyIdx());
            }
        }
        List<GetFindJobRes> getFindJobResList = new ArrayList<>();
        for (Company company: companySet){
            List<CompanyAbility> companyAbilityList = companyAbilityRepository.findAllByCompanyIdx(company);
            String abilitySentence = "";
            for(int i = 0; i<companyAbilityList.size(); i++){
                abilitySentence += companyAbilityList.get(i).getAbilityIdx().getCategoryDetail();
                if(i != companyAbilityList.size()-1){
                    abilitySentence += ", ";
                }
            }
            GetFindJobRes newGetFindJobRes = new GetFindJobRes(company.getCompanyIdx(),userIdx, company.getName(), company.getLocation(), company.getImageURL(), company.getContext(), company.getAge(), company.getCareer(),abilitySentence, company.getWage(), company.getPeriod());
            getFindJobResList.add(newGetFindJobRes);
        }

        return getFindJobResList;
    }
    //기업에게 제공받은 일자리
    @Transactional(readOnly = true)
    public List<GetOfferJobRes> getOfferJobRes(Long userIdx) {
        User newUser = userRepository.findByUserIdx(userIdx).get();
        //기업에서 제안한 일자리
        List<CompanyApply> companyApplyList = companyApplyRepository.findAllByUserIdx(newUser);

        List<GetOfferJobRes> getOfferJobResList = new ArrayList<>();
        for(CompanyApply companyApply: companyApplyList){
            GetOfferJobRes newGetOfferJobRes = new GetOfferJobRes(companyApply.getCompanyIdx().getName(),companyApply.getCompanyIdx().getLocation(),companyApply.getCompanyIdx().getImageURL());
            getOfferJobResList.add(newGetOfferJobRes);
        }

        return getOfferJobResList;
    }
    //기업 디테일
    @Transactional(readOnly = true)
    public GetCompanyRes getCompanyRes(Long companyIdx) {
        Company company = companyRepository.findByCompanyIdx(companyIdx).get();
        List<CompanyAbility> companyAbilityList = companyAbilityRepository.findAllByCompanyIdx(company);
        String abilitySentence = "";
        for(int i = 0; i<companyAbilityList.size(); i++){
            abilitySentence += companyAbilityList.get(i).getAbilityIdx().getCategoryDetail();
            if(i != companyAbilityList.size()-1){
                abilitySentence += ", ";
            }
        }
        GetCompanyRes getCompanyRes = new GetCompanyRes(company.getName(),company.getLocation(),company.getImageURL(),company.getContext(), company.getAge(), company.getCareer(),abilitySentence ,company.getWage(), company.getPeriod());
        return getCompanyRes;
    }
    //유저가 지원한 기업
    @Transactional(readOnly = true)
    public List<GetApplyJobRes> getApplyJobRes(Long userIdx) {
        User newUser = userRepository.findByUserIdx(userIdx).get();
        List<UserApply> userApplyList = userApplyRepository.findAllByUserIdx(newUser);
        List<GetApplyJobRes> getApplyJobResList = new ArrayList<>();
        for(UserApply userApply: userApplyList){
            GetApplyJobRes getApplyJobRes = new GetApplyJobRes(userApply.getCompanyIdx().getName(),userApply.getCompanyIdx().getLocation(),userApply.getCompanyIdx().getImageURL());
            getApplyJobResList.add(getApplyJobRes);
        }
        return getApplyJobResList;
    }
}

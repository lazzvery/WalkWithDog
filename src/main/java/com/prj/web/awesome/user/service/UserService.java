package com.prj.web.awesome.user.service;

import com.prj.web.awesome.user.dto.UserDTO;
import com.prj.web.awesome.user.mapperInterface.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    // 1. selectList
//    List<UserDTO> selectList();

    @Autowired
    UserMapper mapper;

    public List<UserDTO> selectList(){
        List<UserDTO> selectList = new ArrayList<UserDTO>();

        try {
            selectList = mapper.selectList();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return selectList;
    }

    //    // 2. selectOne : Detail
//    UserDTO selectOne(UserDTO vo);
//
    // 3. insert
    public int insert(UserDTO vo){
        return mapper.insert(vo);
    };
//
//    // 4. update
//    int update(UserDTO vo);
//
//    // 5. delete
//    int delete(UserDTO vo);

}

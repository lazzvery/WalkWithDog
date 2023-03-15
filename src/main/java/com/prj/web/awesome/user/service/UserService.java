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

    // 2. selectOne : Detail
    public UserDTO userSelectOne(UserDTO dto){
        return mapper.userSelectOne(dto);
    }

    // 3. insert
    public int userInsert(UserDTO dto){
        return mapper.userInsert(dto);
    }

//    // 4. update
    public int userUpdate(UserDTO dto) { return mapper.userUpdate(dto);}

//    // 5. delete
    public int userDelete(UserDTO dto){
        return mapper.userDelete(dto);
    }



    public String findId(String name, String phone) {
        return mapper.findId(name, phone);
    }

}

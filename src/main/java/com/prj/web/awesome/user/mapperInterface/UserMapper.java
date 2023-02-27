package com.prj.web.awesome.user.mapperInterface;

import com.prj.web.awesome.user.dto.UserDTO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface UserMapper {

    // 1. selectList
    List<UserDTO> selectList() throws Exception;

//    // 2. selectOne : Detail
//    @Select("select * from member where id=#{id}")
//    // => xml Mapper 적용
//    UserDTO selectOne(UserDTO vo);
//
//    // 3. insert
    int insert(UserDTO vo);
//
//    // 4. update
//    // => password 암호화 이후, password 변경은 별도로 처리해야 됩니다~
//    //	  password=#{password}  제외
//    @Update("update member set name=#{name}, age=#{age}, jno=#{jno},"
//            +" info=#{info}, point=#{point}, birthday=#{birthday},"
//            +" rid=#{rid}, uploadfile=#{uploadfile} where id=#{id}")
//    int update(UserDTO vo);
//
//    // 5. delete
//    @Delete("delete from member where id=#{id}")
//    int delete(UserDTO vo);
}

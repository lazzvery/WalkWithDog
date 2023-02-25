package com.prj.web.awesome.KdhTest.mapper;

import com.prj.web.awesome.KdhTest.dto.KdhTestDto;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface KdhTestMapper {

    /**
     *
     *  1. Mapper Interface의 패키지 경로를 Mybatis xml에 Mapping 하여야 한다. <!-- 1.  -->
     *  2. Mapper Interface에 선언 된 Method 들의 명칭과 Mybatis xml에 정의 된 Query ID는 동일 하여야 Mapping이 된다. <!-- 2.  -->
     *
     *  - kdhTest.xml
     *  <mapper namespace="com.prj.web.awesome.KdhTest.mapper.KdhTestMapper">    <!-- 1.  -->
     *    <select id="chkUserId" resultType="com.prj.web.awesome.KdhTest.dto.KdhTestDto">   <!-- 2.  -->
     *
     * */
    KdhTestDto chkUserId(KdhTestDto kdhTestDto);
}

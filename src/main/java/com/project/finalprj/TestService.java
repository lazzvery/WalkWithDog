package com.project.finalprj;

import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


// @RestController 해당 class 는 REST API 처리하는 Controller 
// @RequestMapping("/api") RequestMapping URI 를 지정해주는 Annotation 
@Service
@Log4j2
public class TestService {
	
    public List<Map<String, Object>> retvNewItemList(Map<String, Object> pMap) {

       log.info("pMap.toString() {}", pMap.toString());

       /**
        *   controller에서 service를 호출 한 것처럼
        *   service에서 dao를 호출 하면 된다.
        *
        *   Controller에서는 클라이언트에서 넘겨준 데이터를 받아 service에서 요구하는 값으로 전달
        *   Service 에서는 Service 로직 처리 (업무 로직) 및 Dao 호출
        *   Dao 에서는 Mybatis 호출 하여 SQL 처리
        * */



       List<Map<String, Object>> list = new ArrayList<>();

       for(int i = 0; i <= 20; i++) {
           Map<String, Object> map = new HashMap<>();

           map.put("name", ("길동" + i));
           map.put("age", i);

           list.add(map);
       }

        return list;
    }
}

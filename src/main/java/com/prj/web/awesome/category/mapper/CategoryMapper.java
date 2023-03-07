package com.prj.web.awesome.category.mapper;

import java.util.List;

import com.prj.web.awesome.item.dto.ItemDto;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.prj.web.awesome.category.dto.CategoryDTO;

@Repository
@Mapper
public interface CategoryMapper {
	List<CategoryDTO> categoryList() throws Exception;
	// 인터페이스에서 오류처리를 할 수 없기 때문에 Mapper에 Exception 이 발생하면 서비스에 넘겨주는 것

	List<CategoryDTO> searchCtgr(String prt_ctgr_cd);
}

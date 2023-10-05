package org.iclass.mvc.dao;

import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.iclass.mvc.dto.BookUser;
import org.iclass.mvc.dto.Community;

@Mapper
public interface BookuserMapper {

	BookUser login(Map<String, String> map);
	int join(BookUser dto);
	int update(BookUser vo);
	BookUser selectId(String id);
}

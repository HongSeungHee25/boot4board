package org.iclass.mvc.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.iclass.mvc.dto.Community;
import org.iclass.mvc.dto.PageRequestDTO;

@Mapper
public interface CommunityMapper {
	//글목록 페이징
	/* List<Community> pagelist(Map<String,Integer> map);
	int count(); */
	//글 수정,글 읽기
	Community selectByIdx(long idx);
	//글 읽기 
	void setReadCount(long idx);
	//글 쓰기
	int insert(Community vo);
	//글 수정
	int update(Community vo);
	//글 삭제
	int delete(long idx);

	/* 검색 기능 추가  */
	List<Community> pagelist(PageRequestDTO dto);
	int count(PageRequestDTO dto);

}


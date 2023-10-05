package org.iclass.mvc.service;

import java.util.Map;

import org.iclass.mvc.dao.BookuserMapper;
import org.iclass.mvc.dto.BookUser;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BookUserService {

	private final BookuserMapper dao;
	
	//로그인
	public BookUser login(Map<String,String> map){
		return dao.login(map);
	}
	//회원가입
	public int join(BookUser dto) {
		return dao.join(dto);
	}
	public int update(BookUser vo){
		return dao.update(vo);
	}
	public BookUser selectId(String id){
		return dao.selectId(id);
	}
}

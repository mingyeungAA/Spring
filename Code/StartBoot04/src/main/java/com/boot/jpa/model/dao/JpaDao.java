package com.boot.jpa.model.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.boot.jpa.model.dto.JpaDto;

@Repository
public interface JpaDao extends JpaRepository<JpaDto, Integer> {  //ID : myno의 type
	
	//JpaRepository에 있는 이름 쓰는 거라서 그대로 쓴다.(다른거로 쓰려면 따로 구현해야함)
	//selectList
	public List<JpaDto> findAll();
	
	//selectOne
	public JpaDto findByMyno(int myno);
	
	//insert
	public JpaDto save(JpaDto dto);
	
	//update
	public JpaDto saveAndFlush(JpaDto dto);
	
	//save와 saveAndFlush는 조금 다름
	
	
	@Transactional
	public void deleteByMyno(int myno);
	
}

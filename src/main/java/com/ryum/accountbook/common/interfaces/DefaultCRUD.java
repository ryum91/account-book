package com.ryum.accountbook.common.interfaces;

import java.util.List;

import com.ryum.accountbook.common.exception.HttpStatusException;

/**
 * CRUD 지원 Interface
 * @author ryum
 *
 * @param <T> 객체 타입
 * @param <K> 키 타입
 */
public interface DefaultCRUD<T, K> {

	/**
	 * 전체 목록 조회
	 * @return
	 */
	List<T> selectAll();
	
	/**
	 * 추가
	 * @param object
	 * @return
	 * @throws HttpStatusException
	 */
	T insert(T object) throws HttpStatusException;
	
	/**
	 * 수정
	 * @param object
	 * @return
	 * @throws HttpStatusException
	 */
	T update(T object) throws HttpStatusException;
	
	/**
	 * 삭제
	 * @param key
	 * @throws HttpStatusException
	 */
	void delete(K key) throws HttpStatusException;
}

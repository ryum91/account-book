package com.ryum.accountbook.common.interfaces;

import java.util.List;

/**
 * CRUD 지원 Interface
 * 
 * @author ryum
 *
 * @param <T> 객체 타입
 * @param <K> 키 타입
 */
public interface DefaultCRUD<T, K> {

	/**
	 * 전체 목록 조회
	 * 
	 * @return
	 */
	List<T> selectAll();

	/**
	 * 추가
	 * 
	 * @param object
	 * @return
	 */
	T insert(T object);

	/**
	 * 수정
	 * 
	 * @param object
	 * @return
	 */
	T update(T object);

	/**
	 * 삭제
	 * 
	 * @param key
	 */
	void delete(K key);
}

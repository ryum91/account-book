package com.ryum.accountbook.history.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ryum.accountbook.history.dto.History;

/**
 * 결제내역 Repository
 * @author ryum
 */
@Repository
public interface HistoryRepository extends JpaRepository<History, Integer> {

}

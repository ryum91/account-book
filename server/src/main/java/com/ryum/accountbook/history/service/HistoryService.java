package com.ryum.accountbook.history.service;

import com.ryum.accountbook.common.interfaces.DefaultCRUD;
import com.ryum.accountbook.history.dto.History;
import com.ryum.accountbook.history.repository.HistoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 결제내역 Service
 * 
 * @author ryum
 */
@Service
public class HistoryService implements DefaultCRUD<History, Integer> {

	@Autowired
	HistoryRepository historyRepository;

	@Override
	public List<History> selectAll() {
		return historyRepository.findAll();
	}

	@Override
	public History insert(History history) {
		return historyRepository.save(history);
	}

	@Override
	public History update(History history) {
		return historyRepository.save(history);
	}

	@Override
	public void delete(Integer key) {
		historyRepository.deleteById(key);
	}

}

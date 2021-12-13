package com.example.MiniProject.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.MiniProject.dao.LoggerRepository;
import com.example.MiniProject.model.Logger;

@Service
public class LoggerService {
	@Autowired
	LoggerRepository loggerRepository;

	public void addLog(Logger logger) {
		loggerRepository.save(logger);
	}

	public Logger showLog(int acctID) {
		return loggerRepository.findById(acctID).orElse(null);
	}

	public void deleteLog(int acctID) {
		loggerRepository.deleteById(acctID);
	}
}

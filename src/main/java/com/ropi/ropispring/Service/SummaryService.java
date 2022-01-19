package com.ropi.ropispring.Service;

import com.ropi.ropispring.Model.Summary;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface SummaryService {
	
    List<Summary> listSummary();
    void setSummary(Summary summary);
    void deleteSummary(Summary summary);
    void updateSummary(Summary summary);
    Summary getSummary(String symbol);
}

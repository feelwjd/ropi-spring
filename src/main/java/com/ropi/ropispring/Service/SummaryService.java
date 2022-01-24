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
    Summary getSummary(String symbol, String countrycode);
    Summary getRopi6Summary(String symbol, String countrycode);
    Summary getRopi7Summary(String symbol, String countrycode);
    List<Summary> listRopi6Summary();
    List<Summary> listRopi7Summary();
    String dbCheck();
    String dbRopi6Check();
    String dbRopi7Check();
}

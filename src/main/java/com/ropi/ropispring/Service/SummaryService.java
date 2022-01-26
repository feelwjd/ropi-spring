package com.ropi.ropispring.Service;

import com.ropi.ropispring.Model.Summary;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface SummaryService {
	
    List<Summary> listSummary();
    List<Summary> listRopi6Summary();
    List<Summary> listRopi7Summary();

    void setSummary(Summary summary);
    void setRopi6Summary(Summary summary);
    void setRopi7Summary(Summary summary);

    void deleteSummary(Summary summary);
    void deleteRopi6Summary(Summary summary);
    void deleteRopi7Summary(Summary summary);

    void updateSummary(Summary summary);
    void updateRopi6Summary(Summary summary);
    void updateRopi7Summary(Summary summary);

    Summary getSummary(String symbol, String countrycode);
    Summary getRopi6Summary(String symbol, String countrycode);
    Summary getRopi7Summary(String symbol, String countrycode);

    String dbCheck();
    String dbRopi6Check();
    String dbRopi7Check();
}

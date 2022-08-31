package com.ropi.ropispring.Service;

import com.ropi.ropispring.Model.Industry;
import com.ropi.ropispring.Model.Sector;
import com.ropi.ropispring.Model.Summary;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface SummaryService {
	
	List<Summary> listSummary(String database, int page, int pageSize);
//    List<Summary> listRopi6Summary();
//    List<Summary> listRopi7Summary();

	int setSummary(String selectedDBList, Summary summary);
    void setSummary(Summary summary);
    void setRopi6Summary(Summary summary);
    void setRopi7Summary(Summary summary);

    void deleteSummary(Summary summary);
    void deleteRopi6Summary(Summary summary);
    void deleteRopi7Summary(Summary summary);

    void updateSummary(Summary summary);
    void updateRopi6Summary(Summary summary);
    void updateRopi7Summary(Summary summary);

    Summary getSummary(String database, String symbol, String countrycode);
    Summary getSummary(String symbol, String countrycode);
    Summary getRopi6Summary(String symbol, String countrycode);
    Summary getRopi7Summary(String symbol, String countrycode);

    String dbCheck(String database);
    String dbCheck();
    String dbRopi6Check();
    String dbRopi7Check();
    
    int getSummaryCount(String database);
	int deleteSummary(String database, Summary summary);

	List<Sector> getSectorList(String database);
	List<Industry> getIndustryList(String database);
}

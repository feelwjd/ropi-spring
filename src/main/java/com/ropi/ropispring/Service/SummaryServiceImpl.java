package com.ropi.ropispring.Service;

import com.ropi.ropispring.DAO.SummaryDAO;
import com.ropi.ropispring.DAO6.SummaryRopi6DAO;
import com.ropi.ropispring.DAO7.SummaryRopi7DAO;
import com.ropi.ropispring.Model.Summary;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.List;

@Service
@RequiredArgsConstructor
public class SummaryServiceImpl implements SummaryService{

    @Autowired
    SummaryDAO summaryDAO;
    
    @Autowired
    SummaryRopi6DAO summaryRopi6DAO;
    
    @Autowired
    SummaryRopi7DAO summaryRopi7DAO;

    @Override
    public List<Summary> listSummary() {
        return summaryDAO.listSummary();
    }
    @Override
    public List<Summary> listRopi6Summary() {
        return summaryRopi6DAO.listSummary();
    }
    @Override
    public List<Summary> listRopi7Summary() {
        return summaryRopi7DAO.listSummary();
    }

    @Override
    public void setSummary(Summary summary) {
    	int result;
    	
    	//로피1
    	result = summaryDAO.checkSummary(summary);
    	System.out.println("service result1 : " + result);
    	if(result == 0) {
    		summaryDAO.setSummary(summary);
    	}
    	
    	//로피6
    	result = summaryRopi6DAO.checkSummary(summary);
    	System.out.println("service result2 : " + result);
    	if(result == 0) {
    		summaryRopi6DAO.setSummary(summary);
    	}
    	
    	//로피7
//    	result = summaryRopi7DAO.checkSummary(summary);
//    	System.out.println("service result3 : " + result);
//    	if(result == 0) {
//    		summaryRopi7DAO.setSummary(summary);
//    	}
    }

    @Override
    public void deleteSummary(Summary summary) {
        summaryDAO.deleteSummary(summary);
        summaryRopi6DAO.deleteSummary(summary);
//        summaryRopi7DAO.deleteSummary(summary);
    }

    @Override
    public void updateSummary(Summary summary) {
        summaryDAO.updateSummary(summary);
        summaryRopi6DAO.updateSummary(summary);
//        summaryRopi7DAO.updateSummary(summary);
    }

    @Override
    public Summary getSummary(String symbol){return summaryDAO.getSummary(symbol);}
}

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
        return summaryDAO.listSummary();
    }

    @Override
    public void setSummary(Summary summary) {
    	System.out.println("service start");
    	summaryDAO.setSummary(summary);
        summaryRopi6DAO.setSummary(summary);
        summaryRopi7DAO.setSummary(summary);
        System.out.println("service end");
    }

    @Override
    public void deleteSummary(Summary summary) {
        summaryDAO.deleteSummary(summary);
    }

    @Override
    public void updateSummary(Summary summary) {
        summaryDAO.updateSummary(summary);
    }

    @Override
    public Summary getSummary(String symbol){return summaryDAO.getSummary(symbol);}
}

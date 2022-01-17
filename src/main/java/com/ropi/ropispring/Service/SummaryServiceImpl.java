package com.ropi.ropispring.Service;

import com.ropi.ropispring.DAO.SummaryDAO;
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

    @Override
    public List<Summary> listSummary() {
        return summaryDAO.listSummary();
    }

    @Override
    public void setSummary(Summary summary) {
        summaryDAO.setSummary(summary);
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

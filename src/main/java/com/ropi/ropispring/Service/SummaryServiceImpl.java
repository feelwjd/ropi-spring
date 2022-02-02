package com.ropi.ropispring.Service;

import com.ropi.ropispring.DAO.SummaryDAO;
import com.ropi.ropispring.DAO6.SummaryRopi6DAO;
import com.ropi.ropispring.DAO7.SummaryRopi7DAO;
import com.ropi.ropispring.Model.Summary;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.inject.Inject;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    public List<Summary> listSummary(String database, int page, int pageSize) {
    	List<Summary> list = null;
    	Map<String, Integer> map = new HashMap<>();
    	map.put("page", page);
    	map.put("pageSize", pageSize);
    	
    	if(database.equals("ropi1")) {
    		System.out.println("service 1");
    		list = summaryDAO.listSummary(map);
    		
    	}else if(database.equals("ropi6")) {
    		System.out.println("service 6");
    		list = summaryRopi6DAO.listSummary(map);
    		
    	}else if(database.equals("ropi7")) {
    		System.out.println("service 7");
    		list = summaryRopi7DAO.listSummary(map);
    		
    	}
        return list;
    }
//
//    @Override
//    public List<Summary> listRopi6Summary() {
//        return summaryRopi6DAO.listSummary();
//    }
//    @Override
//    public List<Summary> listRopi7Summary() {
//        return summaryRopi7DAO.listSummary();
//    }

    @Override
    public void setSummary(Summary summary) {
    	try {
            summaryDAO.setSummary(summary);
        }catch (Exception e){}
    }

    @Override
    public void setRopi6Summary(Summary summary){
        try {
            summaryRopi6DAO.setSummary(summary);
        }catch (Exception e){}
    }

    @Override
    public void setRopi7Summary(Summary summary){
        try {
            summaryRopi7DAO.setSummary(summary);
        }catch (Exception e){}
    }

    @Override
    public void deleteSummary(Summary summary) {
        try {
            summaryDAO.deleteSummary(summary);
        }catch (Exception e){}
    }

    @Override
    public void deleteRopi6Summary(Summary summary) {
        try {
            summaryRopi6DAO.deleteSummary(summary);
        }catch (Exception e){}
    }

    @Override
    public void deleteRopi7Summary(Summary summary) {
        try {
            summaryRopi7DAO.deleteSummary(summary);
        }catch (Exception e){}
    }

    @Override
    public void updateSummary(Summary summary) {
        try {
            summaryDAO.updateSummary(summary);
        }catch (Exception e){}
    }

    @Override
    public void updateRopi6Summary(Summary summary) {
        try {
            summaryRopi6DAO.updateSummary(summary);
        }catch (Exception e){}
    }

    @Override
    public void updateRopi7Summary(Summary summary) {
        try {
            summaryRopi7DAO.updateSummary(summary);
        }catch (Exception e){}
    }
    
    @Override
    public Summary getSummary(String symbol, String countrycode){
    	Summary summary = new Summary();
    	summary = summaryDAO.getSummary(symbol, countrycode);
    	summary.toString();
    	return summary; 
    }

	@Override
	public Summary getRopi6Summary(String symbol, String countrycode) {
		return summaryRopi6DAO.getSummary(symbol, countrycode);
	}

	@Override
	public Summary getRopi7Summary(String symbol, String countrycode) {
		return summaryRopi7DAO.getSummary(symbol, countrycode);
	}

    @Override
    public String dbCheck(String database){
    	String result = null;
		if (database.equals("ropi1")) {
			result = summaryDAO.dbCheck();
		} else if (database.equals("ropi6")) {
			result = summaryRopi6DAO.dbCheck();
		} else if (database.equals("ropi7")) {
			result = summaryRopi7DAO.dbCheck();
		}
		
		if(result != null) {
			return database;
		}else {
			return "";
		}
    }

	@Override
	public int getSummaryCount() {
		return summaryDAO.getSummaryCount();
	}

	@Override
	public String dbCheck() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String dbRopi6Check() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String dbRopi7Check() {
		// TODO Auto-generated method stub
		return null;
	}
}

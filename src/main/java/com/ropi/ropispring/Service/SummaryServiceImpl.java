package com.ropi.ropispring.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ropi.ropispring.DAO.SummaryDAO;
import com.ropi.ropispring.DAO6.SummaryRopi6DAO;
import com.ropi.ropispring.DAO7.SummaryRopi7DAO;
import com.ropi.ropispring.Model.Industry;
import com.ropi.ropispring.Model.Sector;
import com.ropi.ropispring.Model.Summary;

import lombok.RequiredArgsConstructor;

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
    		list = summaryDAO.listSummary(map);
    	}else if(database.equals("ropi6")) {
    		list = summaryRopi6DAO.listSummary(map);
    	}else if(database.equals("ropi7")) {
    		list = summaryRopi7DAO.listSummary(map);
    	}
        return list;
    }

    @Override
    public void setSummary(Summary summary) {
    	try {
    		System.out.println("serviceimpl summ : " + summary.toString());
            int result = summaryDAO.setSummary(summary);
            System.out.println("service result : " + result);
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
	public Summary getSummary(String database, String symbol, String countrycode) {
    	Summary summary = new Summary();
    	
    	if(database.equals("ropi1")) {
    		summary = summaryDAO.getSummary(symbol, countrycode);
    	}else if(database.equals("ropi6")) {
    		summary = summaryRopi6DAO.getSummary(symbol, countrycode);
    	}else if(database.equals("ropi6")) {
    		summary = summaryRopi7DAO.getSummary(symbol, countrycode);
    	}
		return summary;
	}
    
    @Override
    public Summary getSummary(String symbol, String countrycode){
    	Summary summary = new Summary();
    	summary = summaryDAO.getSummary(symbol, countrycode);
    	summary.toString();
    	return null; 
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
			return "error";
		}
    }

	@Override
	public int getSummaryCount(String database) {
		int result = 0;
		if (database.equals("ropi1")) {
			result = summaryDAO.getSummaryCount();
		} else if (database.equals("ropi6")) {
			result = summaryRopi6DAO.getSummaryCount();
		} else if (database.equals("ropi7")) {
			result = summaryRopi7DAO.getSummaryCount();
		}
		return result;
	}
	
	@Override
	public int deleteSummary(String database, Summary summary) {
		int result = 0;
		
		if (database.equals("ropi1")) {
			result = summaryDAO.deleteSummary(summary);
		} else if (database.equals("ropi6")) {
			result = summaryRopi6DAO.deleteSummary(summary);
		} else if (database.equals("ropi7")) {
			result = summaryRopi7DAO.deleteSummary(summary);
		}
		return result;
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

	@Override
	public int setSummary(String selectedDBList, Summary summary) {
		System.out.println("service im db : " + selectedDBList + " / summ : " + summary.toString());
		String databases[] = selectedDBList.split(",");
		int result = 0;
		for (String database : databases) {
			System.out.println("service : databases : " + database);
			if (database.equals("ropi1")) {
				System.out.println("in ropi1");
				result = summaryDAO.setSummary(summary);
			} else if (database.equals("ropi6")) {
				summaryRopi6DAO.setSummary(summary);
			} else if (database.equals("ropi7")) {
				summaryRopi7DAO.setSummary(summary);
			}
		}
		System.out.println("service result : " + result);
		return result;
	}

	@Override
	public List<Sector> getSectorList(String database) {
		List<Sector> list = new ArrayList<>();
		if(database.equals("ropi1")) {
			list = summaryDAO.getSectorList();
		}else if(database.equals("ropi6")) {
			list = summaryRopi6DAO.getSectorList();
		}else if(database.equals("ropi7")) {
			list = summaryRopi7DAO.getSectorList();
		}
		return list;
	}

	@Override
	public List<Industry> getIndustryList(String database) {
		List<Industry> list = new ArrayList<>();
		if(database.equals("ropi1")) {
			list = summaryDAO.getIndustryList();
		}else if(database.equals("ropi6")) {
			list = summaryRopi6DAO.getIndustryList();
		}else if(database.equals("ropi7")) {
			list = summaryRopi7DAO.getIndustryList();
		}
		return list;
	}
}
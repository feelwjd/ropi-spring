package com.ropi.ropispring.Service;

import com.ropi.ropispring.Model.Second;
import com.ropi.ropispring.Model.Summary;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface SecondService {
    List<Second> listSummary2();
    void setSummary2(Second second);
    void deleteSummary2(Second second);
    void updateSummary2(Second second);
    Second getSummary2(String symbol);
}

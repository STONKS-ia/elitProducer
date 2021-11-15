package com.br.elit.business;

import com.br.elit.dto.ReportRequestDTO;
import com.br.elit.models.ReportModel;
import org.springframework.stereotype.Component;

@Component
public class ProducerBusiness {

    public ReportModel applyBusiness(ReportModel reportModel) {

        if(reportModel.getPh() > 8){
            reportModel.setPhStatus("Acido");

        }else if(reportModel.getPh() == 7){
            reportModel.setPhStatus("pura");
        }else if(reportModel.getPh() < 7){
            reportModel.setPhStatus("basico");
        }



        return reportModel;
    }



}

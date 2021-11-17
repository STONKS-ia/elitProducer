package com.br.elit.elitProducer.business;

import com.br.elit.elitProducer.models.ReportModel;
import org.springframework.stereotype.Component;

@Component
public class ProducerBusiness {

    public ReportModel applyBusiness(ReportModel reportModel) {

        if (reportModel.getPh() != 0 ) {
            reportModel.setPhStatus(classifyPh(reportModel.getPh()));
        }
        return reportModel;
    }

    protected String classifyPh(double ph){

      String phStatus = null ;

        if(ph >= 8 ){
            phStatus = "Alcalino" ;

        }else if(ph >= 6){
            phStatus = "Neutro" ;
        }else if(ph <= 5){
            phStatus = "Acido";
        }

        return  phStatus;
    }
}

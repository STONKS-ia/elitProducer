package com.br.elit.elitProducer.business;

import com.br.elit.elitProducer.models.ReportModel;
import org.springframework.stereotype.Component;

@Component
public class ProducerBusiness {

    public ReportModel applyBusiness(ReportModel reportModel) {

        if (reportModel.getPh() != 0 ) {
            reportModel.setPhStatus(classifyPh(reportModel.getPh()));
        }

        if (reportModel.getTurbidity() != 0){
            reportModel.setTurbidityStatus(classifyTurbity(reportModel.getTurbidity()));
        }

        if (reportModel.getAlkalinity() != 0){
            reportModel.setAlkalinityStatus(classifyAlkalinity(reportModel.getAlkalinity()));
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

    protected String classifyTurbity(Double turbity){

        String turbityStatus= null;

        if (turbity > 10 && turbity<200){
            turbityStatus = "Agua limpa";
        }else if(turbity <200  && turbity <1000){
            turbityStatus= "Agua turva ";

        }else if(turbity > 1000){
            turbityStatus = "Agua totalmente turva";
        }

        return turbityStatus;
    }

    protected String classifyAlkalinity(Double alkalinity){
        String alkalinityStatus = null;

         if (alkalinity < 10){
             alkalinityStatus = "Baixa capacidade tampão";
         }else if(alkalinity > 10 && alkalinity < 200){
             alkalinityStatus = "Boa capacidade tampao";
         }else{
             alkalinityStatus= "Alcalinidade muito alta";
         }


        return alkalinityStatus;
    }
}

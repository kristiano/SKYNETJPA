/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.to.secad.skynet.controller;

import br.gov.to.secad.skynet.dao.ConnectionFactory;
import br.gov.to.secad.skynet.util.ApplicationUtilies;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Named;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.query.JRJpaQueryExecuterFactory;

/**
 *
 * @author SKYNET
 */
@Named
public class ReportControl {
    private JasperPrint jasperPrint;

    public ReportControl() {
    }
    
    public void init() throws JRException {
        //JRBeanCollectionDataSource beanCollectionDataSource = new JRBeanCollectionDataSource(null);
        String reportPath = FacesContext.getCurrentInstance().getExternalContext().getRealPath("/report/historico_licencas.jasper");
       Map parameterMap = new HashMap();
       parameterMap.put(JRJpaQueryExecuterFactory.PARAMETER_JPA_ENTITY_MANAGER, ApplicationUtilies.catchEntityManager());
        parameterMap.put("id",new Long(2));
           
        jasperPrint = JasperFillManager.fillReport(reportPath,  parameterMap);
    }
    public void PDF(ActionEvent actionEvent) throws JRException, IOException {
        init();
        HttpServletResponse httpServletResponse = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
        httpServletResponse.addHeader("Content-disposition", "inline; filename=report.pdf");
        ServletOutputStream servletOutputStream = httpServletResponse.getOutputStream();
        JasperExportManager.exportReportToPdfStream(jasperPrint, servletOutputStream);
        FacesContext.getCurrentInstance().responseComplete();
    }

}

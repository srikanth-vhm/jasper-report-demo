package com.example.jasperreport;

import com.example.jasperreport.entity.Employee;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ReportService {

    EmployeeRepository employeeRepository;

    public ReportService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    String path = "C:\\Users\\jades\\Desktop\\report\\";
public  String exportReport() throws FileNotFoundException, JRException {
    List<Employee> employees = employeeRepository.findAll();
    File file= ResourceUtils.getFile("classpath:demo_report.jrxml");
    JasperReport jasperReport= JasperCompileManager.compileReport(file.getAbsolutePath());
    JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(employees);
    Map<String,Object>params= new HashMap<>();
    params.put("Admin","Admin");
    JasperPrint jasperPrint= JasperFillManager.fillReport(jasperReport,params,dataSource);
JasperExportManager.exportReportToPdfFile(jasperPrint,path+"employee.pdf");
return "report generated in path: "+path;

}

}

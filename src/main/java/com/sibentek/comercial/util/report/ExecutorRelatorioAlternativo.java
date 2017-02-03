/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sibentek.comercial.util.report;

import com.sibentek.comercial.model.Cliente;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletResponse;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.export.Exporter;
import net.sf.jasperreports.export.ExporterInput;
import net.sf.jasperreports.export.OutputStreamExporterOutput;
import net.sf.jasperreports.export.PdfExporterConfiguration;
import net.sf.jasperreports.export.PdfReportConfiguration;
import net.sf.jasperreports.export.SimpleExporterInput;
import net.sf.jasperreports.export.SimpleOutputStreamExporterOutput;

/**
 *
 * @author william
 */
public class ExecutorRelatorioAlternativo {

    private final String caminhoRelatorio = "/reports/Cherry1.jrxml";
    private HttpServletResponse response;
    private Map<String, Object> parametros = new HashMap<>();
    private String nomeArquivoSaida;
    private static final String PATHPHOTO = "/reports/cherry.jpg";
    private boolean relatorioGerado;

    public ExecutorRelatorioAlternativo(HttpServletResponse response,
            String nomeArquivoSaida) {
        this.response = response;
        this.nomeArquivoSaida = nomeArquivoSaida;
    }

    public void gerar(List<Cliente> clientes) throws Exception {
        InputStream relatorioStream = this.getClass().getResourceAsStream(this.caminhoRelatorio);
        parametros.put("photo", inputStream());
        JasperReport relatorio = JasperCompileManager.compileReport(relatorioStream);
        JasperPrint print = JasperFillManager.fillReport(relatorio, parametros, new JRBeanCollectionDataSource(clientes));
        this.relatorioGerado = print.getPages().size() > 0;
        if (this.relatorioGerado) {
            Exporter<ExporterInput, PdfReportConfiguration, PdfExporterConfiguration, OutputStreamExporterOutput> exportador = new JRPdfExporter();
            exportador.setExporterInput(new SimpleExporterInput(print));
            exportador.setExporterOutput(new SimpleOutputStreamExporterOutput(response.getOutputStream()));

            response.setContentType("application/pdf");
            response.setHeader("Content-Disposition", "filename=\""
                        + this.nomeArquivoSaida + "\"");
            exportador.exportReport();
        }
    }

    private InputStream inputStream() {
        InputStream photoRelatorioStream = this.getClass().getResourceAsStream(PATHPHOTO);
        return photoRelatorioStream;
    }

    public boolean isRelatorioGerado() {
        return relatorioGerado;
    }

}

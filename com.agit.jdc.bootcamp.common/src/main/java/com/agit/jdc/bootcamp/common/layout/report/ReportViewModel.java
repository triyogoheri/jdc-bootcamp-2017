package com.agit.jdc.bootcamp.common.layout.report;

import com.agit.jdc.bootcamp.infrastructure.report.ReportService;
import com.agit.jdc.bootcamp.shared.report.FileReport;
import com.agit.jdc.bootcamp.shared.report.ReportFormat;
import com.agit.jdc.bootcamp.shared.zul.CommonViewModel;
import java.io.ByteArrayInputStream;
import net.sf.jasperreports.engine.JRException;
import org.zkoss.bind.annotation.AfterCompose;
import org.zkoss.bind.annotation.BindingParam;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.ContextParam;
import org.zkoss.bind.annotation.ContextType;
import org.zkoss.bind.annotation.ExecutionArgParam;
import org.zkoss.bind.annotation.Init;
import org.zkoss.util.media.AMedia;
import org.zkoss.util.media.ContentTypes;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.select.Selectors;
import org.zkoss.zk.ui.select.annotation.VariableResolver;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zk.ui.select.annotation.WireVariable;
import org.zkoss.zul.Filedownload;
import org.zkoss.zul.Iframe;

/**
 *
 * @author bayutridewanto
 */
@VariableResolver(org.zkoss.zkplus.spring.DelegatingVariableResolver.class)
public class ReportViewModel {

    private ReportFormat reportFormat;
    private String reportName;
    private FileReport fileReport;
    private Object[] varargs;
    private int index;

    @Wire
    private Iframe reportframe;

    @WireVariable
    private ReportService reportService;

    @Init
    public void init(@ExecutionArgParam("reportName") String reportNameArg,
            @ExecutionArgParam("fileReport") FileReport fileReportArg,
            @ExecutionArgParam("varargs") Object... varargs) {
        reportFormat = ReportFormat.PDF;
        this.reportName = reportNameArg;
        this.fileReport = fileReportArg;
        index = varargs.length;
        this.varargs = new Object[index + 1];
        for (int i = 0; i < varargs.length; ++i) {
            this.varargs[i] = varargs[i];
        }
    }

    @AfterCompose
    public void afterCompose(@ContextParam(ContextType.VIEW) Component view) throws JRException {
        Selectors.wireComponents(view, this, false);
        byte[] byteArrays = generateReport(varargs);
        if (byteArrays != null) {
            AMedia amedia = new AMedia(reportName + "." + reportFormat.getFormat(), reportFormat.getFormat(), ContentTypes.getContentType(reportFormat.getFormat()), new ByteArrayInputStream(byteArrays));
            reportframe.setContent(amedia);
        }
    }

    private byte[] generateReport(Object... varargs) {
        try {
            varargs[index] = reportFormat;
            /* GENERATE REPORT TYPE */
            byte[] result = reportService.generateReport(reportFormat, fileReport, reportName);
            return result;
        } catch (Exception e) {
            CommonViewModel.showErrorMessagebox("Failure");
        }
        return null;
    }

    @Command("selectFormat")
    public void selectFormat(@BindingParam("obj") ReportFormat type) {
        reportFormat = type;
    }

    @Command("download")
    public void download() throws JRException {
        byte[] byteArrays = generateReport(varargs);
        AMedia amedia = new AMedia(reportName + "." + reportFormat.getFormat(), reportFormat.getFormat(), ContentTypes.getContentType(reportFormat.getFormat()), new ByteArrayInputStream(byteArrays));
        Filedownload.save(amedia);
    }

    public String concat(String s1, String s2) {
        return s1.concat(s2);
    }

    public ReportFormat[] getFormats() {
        return ReportFormat.values();
    }

    public String getReportName() {
        return reportName;
    }

    public ReportFormat getReportFormat() {
        return reportFormat;
    }

    public FileReport getFileReport() {
        return fileReport;
    }

}

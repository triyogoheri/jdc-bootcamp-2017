package com.agit.jdc.bootcamp.main.viewmodel.company;

import com.agit.jdc.bootcamp.common.application.CompanyService;
import com.agit.jdc.bootcamp.common.dto.company.CompanyDTO;
import com.agit.jdc.bootcamp.common.dto.company.CompanyDTOBuilder;
import com.agit.jdc.bootcamp.common.security.SecurityUtil;
import com.agit.jdc.bootcamp.shared.type.PlatformType;
import com.agit.jdc.bootcamp.shared.zul.CommonViewModel;
import static com.agit.jdc.bootcamp.shared.zul.CommonViewModel.showInformationMessagebox;
import com.agit.jdc.bootcamp.shared.zul.PageNavigation;
import com.agit.jdc.bootcamp.util.CommonUtil;
import com.agit.jdc.bootcamp.util.DateUtil;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.zkoss.bind.BindUtils;
import org.zkoss.bind.annotation.BindingParam;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.ContextParam;
import org.zkoss.bind.annotation.ContextType;
import org.zkoss.bind.annotation.ExecutionArgParam;
import org.zkoss.bind.annotation.GlobalCommand;
import org.zkoss.bind.annotation.Init;
import org.zkoss.bind.annotation.NotifyChange;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.select.annotation.VariableResolver;
import org.zkoss.zk.ui.select.annotation.WireVariable;
import org.zkoss.zul.ListModelList;
import org.zkoss.zul.Messagebox;
import org.zkoss.zul.Window;

/**
 *
 * @author lintang
 */
@VariableResolver(org.zkoss.zkplus.spring.DelegatingVariableResolver.class)
public class CompanyVM {

    @WireVariable
    CompanyService companyService;

    /* Object Related Company*/
    private List<CompanyDTO> companyDTOs = new ArrayList<>();
    private CompanyDTO companyDTO;

    /* search option*/
    private String companyID;
    private String namaCompany;
    private PlatformType platform;

    /* list for combobox */
    private ListModelList<PlatformType> listPlatform;
    private List<String> listBusinessGroup = new ArrayList();

    /* for pagination */
    private PageNavigation previous;
    private boolean checked;
    private int pageSize = 5;
    private int activePage = 0;
    private int selectedIndex;
    private int totalSize = 0;

    @Init
    public void init(
            @ExecutionArgParam("companyDTO") CompanyDTO company,
            @ExecutionArgParam("previous") PageNavigation previous) {

        /* Load Data */
        initData();

        /* Check Validity */
        checkValidity(company, previous);
    }

    private void initData() {
        /* get all company */
        companyDTOs = companyService.findAll();

        /* initial value of business group */
        listBusinessGroup.add("FINANCE");
        listBusinessGroup.add("CONSULTING");
        listBusinessGroup.add("SERVICES");
        listBusinessGroup.add("OTHER");

    }

    private void checkValidity(CompanyDTO company, PageNavigation previous) {
        if (company == null) {
            ListModelList<CompanyDTO> companyList = new ListModelList<>(companyService.findAll());
            String companyID = "";
            if (companyList.isEmpty()) {
                companyID = "COMP01";
            } else {
                companyID = getLatestObjectID(companyList, "companyID");
            }
            companyDTO = new CompanyDTOBuilder()
                    .setCompanyID(companyID)
                    .setCreatedBy(SecurityUtil.getUserName())
                    .setCreatedDate(new Date())
                    .createCompanyDTO();
        } else {
            this.companyDTO = company;
            companyID = companyDTO.getCompanyID();
            namaCompany = companyDTO.getCompanyName();
            platform = companyDTO.getPlatform();
            this.previous = previous;
        }

    }

    @Command("buttonSearch")
    @NotifyChange("companyDTOs")
    public void buttonSearch(@ContextParam(ContextType.VIEW) Window window) {
        Map params = new HashMap();
        params.put("companyID", companyID);
        params.put("companyName", namaCompany);
        params.put("platform", platform);

        companyDTOs = companyService.findByParameter(params);
    }

    @Command("buttonNewCompany")
    @NotifyChange("companyDTO")
    public void buttonNewCompany(@BindingParam("object") CompanyDTO obj, @ContextParam(ContextType.VIEW) Window window) {
        Map<String, Object> params = new HashMap<>();
        params.put("companyDTO", obj);
        CommonViewModel.navigateToWithoutDetach("/zk-layout/company/create.company.zul", window, params);
    }

    @Command("buttonSaveCompany")
    @NotifyChange({"companyDTO", "companyDTOs"})
    public void buttonSaveCompany(@BindingParam("object") CompanyDTO obj, @ContextParam(ContextType.VIEW) Window window) {
        companyService.saveOrUpdate(companyDTO);
        showInformationMessagebox("Data Company Berhasil Disimpan");
        BindUtils.postGlobalCommand(null, null, "refreshData", null);
        window.detach();
    }

    @GlobalCommand
    @NotifyChange("companyDTOs")
    public void refreshData() {
        companyDTOs = companyService.findAll();
    }

    @Command("detailCompany")
    @NotifyChange("company")
    public void detailCompany(@BindingParam("object") CompanyDTO obj, @ContextParam(ContextType.VIEW) Window window) {
        Map<String, Object> params = new HashMap<>();
        params.put("companyDTO", obj);
        CommonViewModel.navigateToWithoutDetach("/zk-layout/company/create.company.zul", window, params);
    }

    @Command("deleteCompany")
    @NotifyChange("companyDTOs")
    public void deleteCompany(@BindingParam("object") CompanyDTO obj, @ContextParam(ContextType.VIEW) Window window) {
        companyDTO = (CompanyDTO) obj;

        Messagebox.show("Apakah anda yakin ingin menghapus Data Company?", "Konfirmasi", Messagebox.OK | Messagebox.CANCEL, Messagebox.QUESTION,
                new org.zkoss.zk.ui.event.EventListener() {
                    @Override
                    public void onEvent(Event evt) throws InterruptedException {
                        if (evt.getName().equals("onOK")) {
                            companyService.deleteData(companyDTO);
                            showInformationMessagebox("Data Company Berhasil Dihapus");
                            BindUtils.postGlobalCommand(null, null, "refreshData", null);
                        } else {
                            System.out.println("Operation Canceled !");
                        }
                    }
                }
        );

    }

    @Command("buttonCancel")
    @NotifyChange("companyDTO")
    public void buttonCancel(@BindingParam("object") CompanyDTO obj, @ContextParam(ContextType.VIEW) Window window) {
        window.detach();
    }

    @Command("onPagingLayanan")
    @NotifyChange({"companyDTOs", "activePage"})
    private void onPagingLayanan() {
        totalSize = companyDTOs.size();
        if (activePage * pageSize >= totalSize) {//the data size was change since last paging, reysnc it.
            activePage = 0;//simply to first page
        }
        ListModelList<CompanyDTO> listCompanyTemp = (ListModelList<CompanyDTO>) companyDTOs;
        for (int i = activePage * pageSize; i < (activePage + 1) * pageSize; i++) {
            listCompanyTemp.add(companyDTOs.get(i));
        }
        companyDTOs = listCompanyTemp;
    }

    /*Helper*/
    public String timeToString(Date date) {
        return DateUtil.dateToString(date, "HH:mm");
    }

    public String toSentenceCase(String word) {
        if (word == null || word.trim().isEmpty()) {
            return word;
        }
        return word.charAt(0) + word.substring(1).toLowerCase();
    }

    protected String getLatestObjectID(ListModelList list, String attribute) {
        int count = 0;
        int pointer = 0;
        int max = 0;
        String s = "";
        for (Object obj : list) {
            Map<String, Object> map = CommonUtil.convertObject2Map(obj);
            String att = attribute;
            String[] arr = new String[attribute.length()];
            String key = "";

            if (att.contains(".")) {
                arr = att.split("\\.");
                int f = 1;
                for (Object x : arr) {
                    if (f != arr.length) {
                        map = CommonUtil.convertObject2Map(map.get(x.toString()));
                    } else {
                        key = x.toString();
                    }
                    f += 1;
                }
            } else {
                key = att;
            }

            att = map.get(key).toString();

            String temp = "";
            int countTemp = 0;
            for (int i = att.length(); i > 0; i--) {
                if (Character.isLetter(att.charAt(i - 1))) {
                    pointer = i;
                    s = att.substring(0, pointer);
                    break;
                }
                countTemp += 1;
                temp = att.charAt(i - 1) + temp;
            }
            if (Integer.parseInt(temp) > max) {
                max = Integer.parseInt(temp);
            }
            count = countTemp;
        }

        return s + String.format("%0" + count + "d", max + 1);
    }

    public List<CompanyDTO> getCompanyDTOs() {
        return companyDTOs;
    }

    public void setCompanyDTOs(List<CompanyDTO> companyDTOs) {
        this.companyDTOs = companyDTOs;
    }

    public CompanyDTO getCompanyDTO() {
        return companyDTO;
    }

    public void setCompanyDTO(CompanyDTO companyDTO) {
        this.companyDTO = companyDTO;
    }

    public String getCompanyID() {
        return companyID;
    }

    public void setCompanyID(String companyID) {
        this.companyID = companyID;
    }

    public String getNamaCompany() {
        return namaCompany;
    }

    public void setNamaCompany(String namaCompany) {
        this.namaCompany = namaCompany;
    }

    public PlatformType getPlatform() {
        return platform;
    }

    public void setPlatform(PlatformType platform) {
        this.platform = platform;
    }

    public ListModelList<PlatformType> getListPlatform() {
        return new ListModelList<>(PlatformType.values());
    }

    public void setListPlatform(ListModelList<PlatformType> listPlatform) {
        this.listPlatform = listPlatform;
    }

    public PageNavigation getPrevious() {
        return previous;
    }

    public void setPrevious(PageNavigation previous) {
        this.previous = previous;
    }

    public boolean isChecked() {
        return checked;
    }

    public void setChecked(boolean checked) {
        this.checked = checked;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getActivePage() {
        return activePage;
    }

    public void setActivePage(int activePage) {
        this.activePage = activePage;
    }

    public int getSelectedIndex() {
        return selectedIndex;
    }

    public void setSelectedIndex(int selectedIndex) {
        this.selectedIndex = selectedIndex;
    }

    public int getTotalSize() {
        return totalSize;
    }

    public void setTotalSize(int totalSize) {
        this.totalSize = totalSize;
    }

    public List<String> getListBusinessGroup() {
        return listBusinessGroup;
    }

    public void setListBusinessGroup(List<String> listBusinessGroup) {
        this.listBusinessGroup = listBusinessGroup;
    }

}

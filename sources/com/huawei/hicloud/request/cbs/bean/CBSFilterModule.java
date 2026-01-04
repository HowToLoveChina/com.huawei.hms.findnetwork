package com.huawei.hicloud.request.cbs.bean;

import java.util.List;

/* loaded from: classes6.dex */
public class CBSFilterModule {
    private List<String> emuiVers;
    private String moduleName;
    private List<String> moduleVers;

    public List<String> getEmuiVers() {
        return this.emuiVers;
    }

    public String getModuleName() {
        return this.moduleName;
    }

    public List<String> getModuleVers() {
        return this.moduleVers;
    }

    public void setEmuiVers(List<String> list) {
        this.emuiVers = list;
    }

    public void setModuleName(String str) {
        this.moduleName = str;
    }

    public void setModuleVers(List<String> list) {
        this.moduleVers = list;
    }
}

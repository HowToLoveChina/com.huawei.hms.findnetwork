package com.huawei.android.hicloud.cloudbackup.bean;

import java.util.ArrayList;
import java.util.List;

/* loaded from: classes2.dex */
public class RestoreExclude {
    private List<EmuiVersConflict> emuiVersConflict;
    private List<String> termTypes;

    public List<EmuiVersConflict> getEmuiVersConflict() {
        List<EmuiVersConflict> list = this.emuiVersConflict;
        return list == null ? new ArrayList() : list;
    }

    public List<String> getTermTypes() {
        List<String> list = this.termTypes;
        return list == null ? new ArrayList() : list;
    }

    public void setEmuiVersConflict(List<EmuiVersConflict> list) {
        this.emuiVersConflict = list;
    }

    public void setTermTypes(List<String> list) {
        this.termTypes = list;
    }
}

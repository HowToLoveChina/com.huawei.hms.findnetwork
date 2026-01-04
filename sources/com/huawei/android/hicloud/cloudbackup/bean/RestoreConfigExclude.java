package com.huawei.android.hicloud.cloudbackup.bean;

import java.util.List;

/* loaded from: classes2.dex */
public class RestoreConfigExclude {
    EmuiVersConflict emuiVersConflict;
    List<String> termTypes;

    public EmuiVersConflict getEmuiVersConflict() {
        return this.emuiVersConflict;
    }

    public List<String> getTermTypes() {
        return this.termTypes;
    }

    public void setEmuiVersConflict(EmuiVersConflict emuiVersConflict) {
        this.emuiVersConflict = emuiVersConflict;
    }

    public void setTermTypes(List<String> list) {
        this.termTypes = list;
    }
}

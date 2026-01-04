package com.huawei.android.hicloud.cloudbackup.bean;

import android.text.TextUtils;
import java.util.List;

/* loaded from: classes2.dex */
public class OverdueBackupRecordsPolicy {
    private List<RecordsDeletePhases> recordsDeletePhases;
    private int recordsDeletePhaseTime = 30;
    private int deskPopupInterval = 24;
    private int deskPopupTimes = 1;

    public enum PHASE {
        PHASE1("phase1"),
        PHASE2("phase2");

        final String type;

        PHASE(String str) {
            this.type = str;
        }

        public static PHASE getPhase(String str) {
            PHASE phase = PHASE2;
            return TextUtils.equals(str, phase.type) ? phase : PHASE1;
        }
    }

    public static class RecordsDeletePhases {
        private String phase;
        private String subscribeUri;

        public String getPhase() {
            return this.phase;
        }

        public String getSubscribeUri() {
            return this.subscribeUri;
        }

        public void setPhase(String str) {
            this.phase = str;
        }

        public void setSubscribeUri(String str) {
            this.subscribeUri = str;
        }
    }

    public int getDeskPopupInterval() {
        return this.deskPopupInterval;
    }

    public int getDeskPopupTimes() {
        return this.deskPopupTimes;
    }

    public int getRecordsDeletePhaseTime() {
        return this.recordsDeletePhaseTime;
    }

    public List<RecordsDeletePhases> getRecordsDeletePhases() {
        return this.recordsDeletePhases;
    }

    public void setDeskPopupInterval(int i10) {
        this.deskPopupInterval = i10;
    }

    public void setDeskPopupTimes(int i10) {
        this.deskPopupTimes = i10;
    }

    public void setRecordsDeletePhaseTime(int i10) {
        this.recordsDeletePhaseTime = i10;
    }

    public void setRecordsDeletePhases(List<RecordsDeletePhases> list) {
        this.recordsDeletePhases = list;
    }
}

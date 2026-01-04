package com.huawei.android.backup.service.logic.calendar;

import android.net.Uri;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public class CalendarTableType {
    private String backupTable;
    private Map<String, Integer> fields;
    private String[] projection;
    private Uri uri;

    public CalendarTableType(Uri uri, String[] strArr, Map<String, Integer> map, String str) {
        this.backupTable = str;
        this.uri = uri;
        this.fields = map;
        this.projection = strArr;
    }

    public String getBackupTable() {
        return this.backupTable;
    }

    public Map<String, Integer> getFields() {
        return this.fields;
    }

    public String[] getProjection() {
        return this.projection;
    }

    public Uri getUri() {
        return this.uri;
    }

    public void setFields(HashMap<String, Integer> map) {
        this.fields = map;
    }

    public void setProjection(String[] strArr) {
        this.projection = strArr;
    }

    public void setUri(Uri uri) {
        this.uri = uri;
    }
}

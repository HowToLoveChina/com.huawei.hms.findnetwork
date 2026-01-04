package com.huawei.hicloud.cloudbackup.p104v3.omconfig.model;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;
import p015ak.C0209d;
import p514o9.C11839m;

/* loaded from: classes6.dex */
public class OMFilterModule {
    private static final String TAG = "OMFilterModule";
    private String appId;
    private List<String> appVersRegex = new ArrayList();
    private List<String> emuiVersRegex = new ArrayList();
    private String osVersRegex;

    private boolean isMatchEmuiVerRegex() {
        String strM1186L = C0209d.m1186L();
        Iterator<String> it = this.emuiVersRegex.iterator();
        while (it.hasNext()) {
            if (Pattern.matches(it.next(), strM1186L)) {
                return true;
            }
        }
        return false;
    }

    private boolean isMatchOsVersRegex() {
        String strM1149A0 = C0209d.m1149A0();
        C11839m.m70688i(TAG, "current osVersion: " + strM1149A0);
        try {
            return Pattern.matches(this.osVersRegex, strM1149A0);
        } catch (PatternSyntaxException e10) {
            C11839m.m70687e(TAG, "match osVersRegex exception: " + e10.getMessage());
            return false;
        }
    }

    private boolean isMatchVerRegex(String str) {
        Iterator<String> it = this.appVersRegex.iterator();
        while (it.hasNext()) {
            if (Pattern.matches(it.next(), str)) {
                return true;
            }
        }
        return false;
    }

    public String getAppId() {
        return this.appId;
    }

    public List<String> getAppVersRegex() {
        return this.appVersRegex;
    }

    public List<String> getEmuiVersRegex() {
        return this.emuiVersRegex;
    }

    public String getOsVersRegex() {
        return this.osVersRegex;
    }

    public boolean isFilterModule(String str, String str2) {
        if (TextUtils.isEmpty(str) || !str.equals(this.appId)) {
            return false;
        }
        String str3 = this.osVersRegex;
        if (str3 == null || str3.isEmpty()) {
            if (!isMatchVerRegex(str2) || !isMatchEmuiVerRegex()) {
                return false;
            }
        } else if (!isMatchVerRegex(str2) || !isMatchOsVersRegex()) {
            return false;
        }
        return true;
    }

    public void setAppId(String str) {
        this.appId = str;
    }

    public void setAppVersRegex(List<String> list) {
        this.appVersRegex = list;
    }

    public void setEmuiVersRegex(List<String> list) {
        this.emuiVersRegex = list;
    }

    public void setOsVersRegex(String str) {
        this.osVersRegex = str;
    }
}

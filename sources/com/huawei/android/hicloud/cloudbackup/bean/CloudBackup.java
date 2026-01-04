package com.huawei.android.hicloud.cloudbackup.bean;

import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import p618rm.C12540b1;
import p815ym.AbstractC14026a;

/* loaded from: classes2.dex */
public class CloudBackup {
    public static final int NO_ABSENCE_OSVERS_REGEX = 1;
    private String DBDiffFileName;
    private List<AppVer> appVer;
    private List<String> appVersRegex;
    private int backgroundBackup;
    private List<Integer> bakCategory;
    private int devCompatible;
    private List<String> effectDevice;
    private List<String> effectPackage;
    private List<String> emuiVersRegex;
    private List<CloudBackupPathInfo> exclude;
    private int foregroundBackup;
    private List<String> foregroundBackupTime;
    private List<CloudBackupPathInfo> include;
    private int isSupportTwinApp;
    private int listType;
    private String osVersRegex;
    private List<PathMapping> pathMapping;
    private int showType;
    private String wakeUpService;
    private int sdcardAcptErrNum = -1;
    private int sdcardAcptErrRate = -1;
    private int dataAcptErrNum = -1;
    private int dataAcptErrRate = -1;

    public List<AppVer> getAppVer() {
        List<AppVer> list = this.appVer;
        return list == null ? new ArrayList() : list;
    }

    public List<String> getAppVersRegex() {
        List<String> list = this.appVersRegex;
        return list == null ? new ArrayList() : list;
    }

    public int getBackgroundBackup() {
        return this.backgroundBackup;
    }

    public List<Integer> getBakCategory() {
        List<Integer> list = this.bakCategory;
        return list == null ? new ArrayList() : list;
    }

    public String getDBDiffDBFileName() {
        return this.DBDiffFileName;
    }

    public int getDataAcptErrNum() {
        return this.dataAcptErrNum;
    }

    public int getDataAcptErrRate() {
        return this.dataAcptErrRate;
    }

    public int getDevCompatible() {
        return this.devCompatible;
    }

    public List<String> getEffectDevice() {
        List<String> list = this.effectDevice;
        return list == null ? new ArrayList() : list;
    }

    public List<String> getEffectPackage() {
        List<String> list = this.effectPackage;
        return list == null ? new ArrayList() : list;
    }

    public List<String> getEmuiVersRegex() {
        List<String> list = this.emuiVersRegex;
        return list == null ? new ArrayList() : list;
    }

    public List<CloudBackupPathInfo> getExclude() {
        List<CloudBackupPathInfo> list = this.exclude;
        return list == null ? new ArrayList() : list;
    }

    public int getForegroundBackup() {
        return this.foregroundBackup;
    }

    public List<String> getForegroundBackupTime() {
        List<String> list = this.foregroundBackupTime;
        return list == null ? new ArrayList() : list;
    }

    public List<CloudBackupPathInfo> getInclude() {
        List<CloudBackupPathInfo> list = this.include;
        return list == null ? new ArrayList() : list;
    }

    public int getListType() {
        return this.listType;
    }

    public String getOsVersRegex() {
        return this.osVersRegex;
    }

    public List<PathMapping> getPathMapping() {
        List<PathMapping> list = this.pathMapping;
        return list == null ? new ArrayList() : list;
    }

    public int getSdcardAcptErrNum() {
        return this.sdcardAcptErrNum;
    }

    public int getSdcardAcptErrRate() {
        return this.sdcardAcptErrRate;
    }

    public int getShowType() {
        return this.showType;
    }

    public String getWakeUpService() {
        String str = this.wakeUpService;
        return str == null ? "" : str;
    }

    public int isSupportTwinApp() {
        return this.isSupportTwinApp;
    }

    public void setAppVer(String str) {
        AppVer[] appVerArr = (AppVer[]) C12540b1.m75483a(str, AppVer[].class);
        if (AbstractC14026a.m84160b(appVerArr)) {
            this.appVer = new ArrayList();
        } else {
            this.appVer = Arrays.asList(appVerArr);
        }
    }

    public void setAppVersRegex(String str) {
        String[] strArr = (String[]) C12540b1.m75483a(str, String[].class);
        if (AbstractC14026a.m84161c(strArr)) {
            this.appVersRegex = new ArrayList();
        } else {
            this.appVersRegex = Arrays.asList(strArr);
        }
    }

    public void setBackgroundBackup(int i10) {
        this.backgroundBackup = i10;
    }

    public void setBakCategory(String str) {
        Integer[] numArr = (Integer[]) C12540b1.m75483a(str, Integer[].class);
        if (AbstractC14026a.m84160b(numArr)) {
            this.bakCategory = new ArrayList();
        } else {
            this.bakCategory = Arrays.asList(numArr);
        }
    }

    public void setDBDiffDBFileName(String str) {
        this.DBDiffFileName = str;
    }

    public void setDataAcptErrNum(int i10) {
        this.dataAcptErrNum = i10;
    }

    public void setDataAcptErrRate(int i10) {
        this.dataAcptErrRate = i10;
    }

    public void setDevCompatible(int i10) {
        this.devCompatible = i10;
    }

    public void setEffectDevice(String str) {
        this.effectDevice = Arrays.asList((String[]) C12540b1.m75483a(str, String[].class));
    }

    public void setEffectPackage(String str) {
        this.effectPackage = Arrays.asList((String[]) C12540b1.m75483a(str, String[].class));
    }

    public void setEmuiVersRegex(String str) {
        String[] strArr = (String[]) C12540b1.m75483a(str, String[].class);
        if (AbstractC14026a.m84161c(strArr)) {
            this.emuiVersRegex = new ArrayList();
        } else {
            this.emuiVersRegex = Arrays.asList(strArr);
        }
    }

    public void setExclude(String str) {
        CloudBackupPathInfo[] cloudBackupPathInfoArr = (CloudBackupPathInfo[]) C12540b1.m75483a(str, CloudBackupPathInfo[].class);
        if (AbstractC14026a.m84160b(cloudBackupPathInfoArr)) {
            this.exclude = new ArrayList();
        } else {
            this.exclude = Arrays.asList(cloudBackupPathInfoArr);
        }
    }

    public void setForegroundBackup(int i10) {
        this.foregroundBackup = i10;
    }

    public void setForegroundBackupTime(String str) {
        this.foregroundBackupTime = Arrays.asList((String[]) C12540b1.m75483a(str, String[].class));
    }

    public void setInclude(String str) {
        CloudBackupPathInfo[] cloudBackupPathInfoArr = (CloudBackupPathInfo[]) C12540b1.m75483a(str, CloudBackupPathInfo[].class);
        if (AbstractC14026a.m84160b(cloudBackupPathInfoArr)) {
            this.include = new ArrayList();
        } else {
            this.include = Arrays.asList(cloudBackupPathInfoArr);
        }
    }

    public void setListType(int i10) {
        this.listType = i10;
    }

    public void setOsVersRegex(String str) {
        this.osVersRegex = str;
    }

    public void setPathMapping(String str) {
        PathMapping[] pathMappingArr = (PathMapping[]) C12540b1.m75483a(str, PathMapping[].class);
        if (pathMappingArr != null) {
            this.pathMapping = Arrays.asList(pathMappingArr);
        }
    }

    public void setSdcardAcptErrNum(int i10) {
        this.sdcardAcptErrNum = i10;
    }

    public void setSdcardAcptErrRate(int i10) {
        this.sdcardAcptErrRate = i10;
    }

    public void setShowType(int i10) {
        this.showType = i10;
    }

    public void setSupportTwinApp(int i10) {
        this.isSupportTwinApp = i10;
    }

    public void setWakeUpService(String str) {
        this.wakeUpService = str;
    }

    public String toString() {
        return new Gson().toJson(this);
    }
}

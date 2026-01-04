package com.huawei.hicloud.request.cbs.bean;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import p514o9.C11839m;

/* loaded from: classes6.dex */
public class CBSDataBackup {
    private static final String AUTO = "auto";
    private static final String DEFAULT = "default";
    private static final String DISABLE = "disable";
    private static final String DISPLAYNAME = "displayname";
    private static final String FILESUFFIX = "fileSuffix";
    private static final String ISSWOPTION = "isSWOption";
    private static final String TAG = "CBSDataBackup";
    private static final String VERMIX = "verMix";
    private List<String> parameter;
    private List<String> pathBlackList;
    private List<String> pathList;
    private String apkName = "";
    private List<PathInfo> mDefaultInfo = new ArrayList();
    private List<PathInfo> mPathInfos = new ArrayList();
    private List<PathInfo> mBackList = new ArrayList();
    private String isSWOption = "";
    private List<String> fileSuffixes = new ArrayList();
    private String verMix = "";
    private String displayname = "";

    public static class PathInfo {
        private String path = "";
        private String versionCondition;

        public String getPath() {
            return this.path;
        }

        public String getVersionCondition() {
            return this.versionCondition;
        }

        public void setPath(String str) {
            this.path = str;
        }

        public void setVersionCondition(String str) {
            this.versionCondition = str;
        }
    }

    private String getStrAfterChar(String str) {
        int iIndexOf = str.indexOf("=") + 1;
        if (iIndexOf > 0 && iIndexOf < str.length()) {
            return str.substring(iIndexOf);
        }
        C11839m.m70689w(TAG, "changePathSelf index <= 0" + iIndexOf);
        return "";
    }

    private void getSuffixBySplit(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        String[] strArrSplit = str.split("\\|");
        if (strArrSplit.length <= 0) {
            this.fileSuffixes.add(str);
            C11839m.m70689w(TAG, "getSuffixBySplit suffixes is empty, do not split fileSuffixStr = " + str);
            return;
        }
        for (String str2 : strArrSplit) {
            this.fileSuffixes.add(str2);
        }
    }

    private void matchServiceData(String str) {
        if (TextUtils.isEmpty(str)) {
            C11839m.m70689w(TAG, "changePathSelf para is empty");
            return;
        }
        if (str.startsWith(ISSWOPTION)) {
            this.isSWOption = getStrAfterChar(str);
            return;
        }
        if (str.startsWith(FILESUFFIX)) {
            getSuffixBySplit(getStrAfterChar(str));
        } else if (str.startsWith(DISPLAYNAME)) {
            this.displayname = getStrAfterChar(str);
        } else if (str.startsWith(VERMIX)) {
            this.verMix = getStrAfterChar(str);
        }
    }

    private void pathChangeToInfo(String str, List<PathInfo> list) {
        PathInfo pathInfo = new PathInfo();
        String[] strArrSplit = str.split("=");
        if (strArrSplit.length < 2) {
            C11839m.m70689w(TAG, "pathChangeToInfo split is empty, str = " + str);
            return;
        }
        String str2 = strArrSplit[0];
        String str3 = strArrSplit[1];
        int iIndexOf = str2.indexOf("_");
        if (iIndexOf <= 0) {
            return;
        }
        pathInfo.versionCondition = str2.substring(0, iIndexOf);
        pathInfo.path = str3;
        list.add(pathInfo);
    }

    public void changePathSelf() {
        List<String> list = this.pathList;
        if (list != null && !list.isEmpty()) {
            for (String str : this.pathList) {
                if (TextUtils.isEmpty(str)) {
                    C11839m.m70689w(TAG, "changePathSelf str is null");
                } else if (str.startsWith("default")) {
                    pathChangeToInfo(str, this.mDefaultInfo);
                } else {
                    pathChangeToInfo(str, this.mPathInfos);
                }
            }
        }
        List<String> list2 = this.pathBlackList;
        if (list2 != null && !list2.isEmpty()) {
            Iterator<String> it = this.pathBlackList.iterator();
            while (it.hasNext()) {
                pathChangeToInfo(it.next(), this.mBackList);
            }
        }
        List<String> list3 = this.parameter;
        if (list3 == null || list3.isEmpty()) {
            return;
        }
        Iterator<String> it2 = this.parameter.iterator();
        while (it2.hasNext()) {
            matchServiceData(it2.next());
        }
    }

    public List<PathInfo> getBackList() {
        return this.mBackList;
    }

    public String getCBSApkName() {
        return this.apkName;
    }

    public List<PathInfo> getDefaultInfo() {
        return this.mDefaultInfo;
    }

    public String getDisplayName() {
        return this.displayname;
    }

    public List<String> getFileSuffixes() {
        return this.fileSuffixes;
    }

    public String getIsSWOption() {
        return this.isSWOption;
    }

    public List<String> getParameter() {
        return this.parameter;
    }

    public List<String> getPathBlackList() {
        return this.pathBlackList;
    }

    public List<PathInfo> getPathInfos() {
        return this.mPathInfos;
    }

    public List<String> getPathList() {
        return this.pathList;
    }

    public String getVerMix() {
        return this.verMix;
    }

    public void setBackList(List<PathInfo> list) {
        this.mBackList = list;
    }

    public void setCBSApkName(String str) {
        this.apkName = str;
    }

    public void setDefaultInfo(List<PathInfo> list) {
        this.mDefaultInfo = list;
    }

    public void setDisplayName(String str) {
        this.displayname = str;
    }

    public void setFileSuffixes(List<String> list) {
        this.fileSuffixes = list;
    }

    public void setIsSWOption(String str) {
        this.isSWOption = str;
    }

    public void setParameter(List<String> list) {
        this.parameter = list;
    }

    public void setPathBlackList(List<String> list) {
        this.pathBlackList = list;
    }

    public void setPathInfos(List<PathInfo> list) {
        this.mPathInfos = list;
    }

    public void setPathList(List<String> list) {
        this.pathList = list;
    }

    public void setVerMix(String str) {
        this.verMix = str;
    }
}

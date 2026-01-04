package com.huawei.android.remotecontrol.util.account.bean;

import android.content.Context;
import android.text.TextUtils;
import p521og.C11869b;
import p809yg.C13981a;

/* loaded from: classes4.dex */
public class AccountInfo implements Cloneable {
    public static final String TAG = "AccountInfo";
    private String accountName;
    private String accountName2;
    private String accountType;
    private String challenge;
    private String clearCmdData;
    private String clearCmdData2;
    private String countryCode;
    private String countryCode2;
    private String deviceID;
    private String deviceID2;
    private String deviceIDType;
    private String deviceType;
    private String deviceticket;
    private String deviceticket2;
    private String frpmessage;
    private String serviceToken;
    private String serviceToken2;
    private String siteID;
    private String userID;
    private String userKey;
    private String userKey2;

    private void covertAccountInfo(AccountInfo accountInfo) {
        setChallengeString(accountInfo.getChallengeString());
        setDeviceType(accountInfo.getDeviceType());
        setDeviceIDType(accountInfo.getDeviceIDType());
        setSiteID4RC(accountInfo.getSiteID4RC());
        setAccountType(accountInfo.getAccountType());
        setUserID4RC(accountInfo.getUserID4RC());
        setFrpMessage(accountInfo.getFrpMessage());
        setAccountName(accountInfo.getAccountName());
        setDeviceID(accountInfo.getDeviceID());
        setServiceToken(accountInfo.getServiceToken());
        setDeviceTicket(accountInfo.getDeviceTicket());
        setClearCmdData(accountInfo.getClearCmdData());
        setCountryCode(accountInfo.getCountryCode());
        setUserKey(accountInfo.getUserKey());
    }

    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public String getAccountName() {
        return this.accountName2;
    }

    public String getAccountNameEncrypted() {
        return this.accountName;
    }

    public String getAccountType() {
        return this.accountType;
    }

    public String getChallenge() {
        return this.challenge;
    }

    public String getChallengeString() {
        return this.challenge;
    }

    public String getClearCmdData() {
        return this.clearCmdData2;
    }

    public String getClearCmdDataEncrypted() {
        return this.clearCmdData;
    }

    public String getCountryCode() {
        return this.countryCode2;
    }

    public String getCountryCodeEncrypted() {
        return this.countryCode;
    }

    public String getDeviceID() {
        return this.deviceID2;
    }

    public String getDeviceIDEncrypted() {
        return this.deviceID;
    }

    public String getDeviceIDType() {
        return this.deviceIDType;
    }

    public String getDeviceTicket() {
        return this.deviceticket2;
    }

    public String getDeviceTicketEncrypted() {
        return this.deviceticket;
    }

    public String getDeviceType() {
        return this.deviceType;
    }

    public String getFrpMessage() {
        return this.frpmessage;
    }

    public String getServiceToken() {
        return this.serviceToken2;
    }

    public String getServiceTokenEncrypted() {
        return this.serviceToken;
    }

    public String getSiteID() {
        return this.siteID;
    }

    public String getSiteID4RC() {
        return this.siteID;
    }

    public String getUserID() {
        return this.userID;
    }

    public String getUserID4RC() {
        return this.userID;
    }

    public String getUserKey() {
        return this.userKey2;
    }

    public String getUserKeyEncrypted() {
        return this.userKey;
    }

    public void readAccountInfo(Context context, AccountInfo accountInfo) {
        if (context == null || accountInfo == null) {
            C13981a.m83988e(TAG, "context or accountInfo null");
            return;
        }
        covertAccountInfo(accountInfo);
        setAccountNameEncrypted(accountInfo.getAccountNameEncrypted());
        setDeviceIDEncrypted(accountInfo.getDeviceIDEncrypted());
        setServiceTokenEncrypted(accountInfo.getServiceTokenEncrypted());
        setDeviceTicketEncrypted(accountInfo.getDeviceTicketEncrypted());
        setClearCmdDataEncrypted(accountInfo.getClearCmdDataEncrypted());
        setCountryCodeEncrypted(accountInfo.getCountryCodeEncrypted());
        setUserKeyEncrypted(accountInfo.getUserKeyEncrypted());
    }

    public void readEncryptedAccountInfo(Context context, AccountInfo accountInfo) {
        if (context == null || accountInfo == null) {
            C13981a.m83988e(TAG, "context or accountInfo null");
            return;
        }
        if (TextUtils.isEmpty(accountInfo.getAccountName()) && !TextUtils.isEmpty(accountInfo.getAccountNameEncrypted())) {
            setAccountName(C11869b.m71139f(context, accountInfo.getAccountNameEncrypted()));
        }
        if (TextUtils.isEmpty(accountInfo.getDeviceID()) && !TextUtils.isEmpty(accountInfo.getDeviceIDEncrypted())) {
            setDeviceID(C11869b.m71139f(context, accountInfo.getDeviceIDEncrypted()));
        }
        if (TextUtils.isEmpty(accountInfo.getServiceToken()) && !TextUtils.isEmpty(accountInfo.getServiceTokenEncrypted())) {
            setServiceToken(C11869b.m71139f(context, accountInfo.getServiceTokenEncrypted()));
        }
        if (TextUtils.isEmpty(accountInfo.getDeviceTicket()) && !TextUtils.isEmpty(accountInfo.getDeviceTicketEncrypted())) {
            setDeviceTicket(C11869b.m71139f(context, accountInfo.getDeviceTicketEncrypted()));
        }
        if (TextUtils.isEmpty(accountInfo.getClearCmdData()) && !TextUtils.isEmpty(accountInfo.getClearCmdDataEncrypted())) {
            setClearCmdData(C11869b.m71139f(context, accountInfo.getClearCmdDataEncrypted()));
        }
        if (TextUtils.isEmpty(accountInfo.getCountryCode()) && !TextUtils.isEmpty(accountInfo.getCountryCodeEncrypted())) {
            setCountryCode(C11869b.m71139f(context, accountInfo.getCountryCodeEncrypted()));
        }
        if (!TextUtils.isEmpty(accountInfo.getUserKey()) || TextUtils.isEmpty(accountInfo.getUserKeyEncrypted())) {
            return;
        }
        setUserKey(C11869b.m71139f(context, accountInfo.getUserKeyEncrypted()));
    }

    public void resetAccountInfo() {
        setChallengeString("");
        setDeviceType("");
        setDeviceIDType("");
        setSiteID4RC("");
        setAccountType("");
        setUserID4RC("");
        setFrpMessage("");
        setAccountName("");
        setDeviceID("");
        setServiceToken4Empty("");
        setDeviceTicket("");
        setClearCmdData("");
        setCountryCode("");
        setUserKey("");
        setAccountNameEncrypted("");
        setDeviceIDEncrypted("");
        setServiceTokenEncrypted4Empty("");
        setDeviceTicketEncrypted("");
        setClearCmdDataEncrypted("");
        setCountryCodeEncrypted("");
        setUserKeyEncrypted("");
    }

    public void setAccountInfo(Context context, AccountInfo accountInfo) {
        if (context == null || accountInfo == null) {
            C13981a.m83988e(TAG, "context or accountInfo null");
        } else {
            covertAccountInfo(accountInfo);
        }
    }

    public void setAccountName(String str) {
        this.accountName2 = str;
    }

    public void setAccountNameEncrypted(String str) {
        this.accountName = str;
    }

    public void setAccountType(String str) {
        this.accountType = str;
    }

    public void setChallenge(String str) {
        this.challenge = str;
    }

    public void setChallengeString(String str) {
        this.challenge = str;
    }

    public void setClearCmdData(String str) {
        this.clearCmdData2 = str;
    }

    public void setClearCmdDataEncrypted(String str) {
        this.clearCmdData = str;
    }

    public void setCountryCode(String str) {
        this.countryCode2 = str;
    }

    public void setCountryCodeEncrypted(String str) {
        this.countryCode = str;
    }

    public void setDeviceID(String str) {
        this.deviceID2 = str;
    }

    public void setDeviceIDEncrypted(String str) {
        this.deviceID = str;
    }

    public void setDeviceIDType(String str) {
        this.deviceIDType = str;
    }

    public void setDeviceTicket(String str) {
        this.deviceticket2 = str;
    }

    public void setDeviceTicketEncrypted(String str) {
        this.deviceticket = str;
    }

    public void setDeviceType(String str) {
        this.deviceType = str;
    }

    public void setEncryptedAccountInfo(Context context, AccountInfo accountInfo) {
        if (context == null || accountInfo == null) {
            C13981a.m83988e(TAG, "context or accountInfo null");
            return;
        }
        if (!TextUtils.isEmpty(accountInfo.getAccountName())) {
            setAccountNameEncrypted(C11869b.m71145l(context, accountInfo.getAccountName()));
        }
        if (!TextUtils.isEmpty(accountInfo.getDeviceID())) {
            setDeviceIDEncrypted(C11869b.m71145l(context, accountInfo.getDeviceID()));
        }
        if (!TextUtils.isEmpty(accountInfo.getServiceToken())) {
            setServiceTokenEncrypted(C11869b.m71145l(context, accountInfo.getServiceToken()));
        }
        if (!TextUtils.isEmpty(accountInfo.getDeviceTicket())) {
            setDeviceTicketEncrypted(C11869b.m71145l(context, accountInfo.getDeviceTicket()));
        }
        if (!TextUtils.isEmpty(accountInfo.getClearCmdData())) {
            setClearCmdDataEncrypted(C11869b.m71145l(context, accountInfo.getClearCmdData()));
        }
        if (!TextUtils.isEmpty(accountInfo.getCountryCode())) {
            setCountryCodeEncrypted(C11869b.m71145l(context, accountInfo.getCountryCode()));
        }
        if (TextUtils.isEmpty(accountInfo.getUserKey())) {
            return;
        }
        setUserKeyEncrypted(C11869b.m71145l(context, accountInfo.getUserKey()));
    }

    public void setFrpMessage(String str) {
        this.frpmessage = str;
    }

    public void setServiceToken(String str) {
        if (TextUtils.isEmpty(str)) {
            this.serviceToken2 = "empty";
        } else {
            this.serviceToken2 = str;
        }
    }

    public void setServiceToken4Empty(String str) {
        this.serviceToken2 = str;
    }

    public void setServiceTokenEncrypted(String str) {
        if (TextUtils.isEmpty(str)) {
            this.serviceToken = "empty";
        } else {
            this.serviceToken = str;
        }
    }

    public void setServiceTokenEncrypted4Empty(String str) {
        this.serviceToken = str;
    }

    public void setSiteID(String str) {
        this.siteID = str;
    }

    public void setSiteID4RC(String str) {
        this.siteID = str;
    }

    public void setUserID(String str) {
        this.userID = str;
    }

    public void setUserID4RC(String str) {
        this.userID = str;
    }

    public void setUserKey(String str) {
        this.userKey2 = str;
    }

    public void setUserKeyEncrypted(String str) {
        this.userKey = str;
    }

    public String toString() {
        return "AccountInfo []";
    }
}

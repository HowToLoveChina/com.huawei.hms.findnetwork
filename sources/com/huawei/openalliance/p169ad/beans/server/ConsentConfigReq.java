package com.huawei.openalliance.p169ad.beans.server;

import android.content.Context;
import com.huawei.openalliance.p169ad.C6849R;
import com.huawei.openalliance.p169ad.annotations.DataKeep;
import com.huawei.openalliance.p169ad.beans.base.ReqBean;
import com.huawei.openalliance.p169ad.constant.Constants;
import com.huawei.openalliance.p169ad.utils.C7732af;

@DataKeep
/* loaded from: classes8.dex */
public class ConsentConfigReq extends ReqBean {
    private String consentVersion;
    private String countryCode;
    private Integer debugFlag;
    private String langCode;
    private String pkgName;

    public ConsentConfigReq() {
    }

    @Override // com.huawei.openalliance.p169ad.beans.base.ReqBean
    /* renamed from: a */
    public String mo39254a() {
        return "consentlookup";
    }

    @Override // com.huawei.openalliance.p169ad.beans.base.ReqBean
    /* renamed from: b */
    public String mo39256b() {
        return Constants.KIT_CONSENT_CONFIG_URI;
    }

    @Override // com.huawei.openalliance.p169ad.beans.base.ReqBean
    /* renamed from: c */
    public String mo39257c() {
        return Constants.KIT_APP_ID;
    }

    /* renamed from: d */
    public String m40944d() {
        return this.consentVersion;
    }

    public ConsentConfigReq(com.huawei.hms.ads.consent.bean.network.ConsentConfigReq consentConfigReq) {
        this.consentVersion = consentConfigReq.getConsentVersion();
        this.pkgName = consentConfigReq.getPkgName();
        this.countryCode = consentConfigReq.getCountryCode();
        this.langCode = consentConfigReq.getLangCode();
        this.debugFlag = consentConfigReq.getDebugFlag();
    }

    @Override // com.huawei.openalliance.p169ad.beans.base.ReqBean
    /* renamed from: a */
    public String mo39255a(Context context) {
        return context.getString(C7732af.m47471a() ? C6849R.string.hiad_ppskit_config_backup_sig : C6849R.string.hiad_ppskit_config_server_sig);
    }

    /* renamed from: a */
    public void m40943a(String str) {
        this.consentVersion = str;
    }
}

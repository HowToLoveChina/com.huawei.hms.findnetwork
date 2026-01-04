package com.huawei.openalliance.p169ad.beans.metadata;

import com.huawei.openalliance.p169ad.annotations.DataKeep;
import com.huawei.openalliance.p169ad.utils.AbstractC7806cz;
import java.io.Serializable;

@DataKeep
/* loaded from: classes8.dex */
public class InteractCfg implements Serializable {
    private static final int DEFAULT_TWIST_ACC = 15;
    private static final int DEFAULT_TWIST_DEGREE = 35;
    private static final int MIN_TWIST_ACC = 10;
    private static final long serialVersionUID = 9151867350505964337L;
    private Integer interactiveLogic;
    private Integer splashAdTagClickableType;
    private Integer splashInteractCfg;
    private String splashRedirectTxt;
    private String swipeClkTxt;
    private Integer swipeDirection;
    private Integer swipeDp;
    private String swipeTxt;
    private Integer twistAcc;
    private String twistClkTxt;
    private Integer twistDegree;
    private String twistTxt;

    /* renamed from: a */
    public Integer m40198a() {
        Integer num = this.splashInteractCfg;
        if (num == null || (num.intValue() >= 0 && this.splashInteractCfg.intValue() <= 4)) {
            return this.splashInteractCfg;
        }
        return 0;
    }

    /* renamed from: b */
    public Integer m40201b() {
        return this.swipeDp;
    }

    /* renamed from: c */
    public Integer m40204c() {
        Integer num = this.twistAcc;
        return Integer.valueOf((num == null || num.intValue() < 10) ? 15 : this.twistAcc.intValue());
    }

    /* renamed from: d */
    public Integer m40207d() {
        Integer num = this.twistDegree;
        int iIntValue = 35;
        if (num != null && num.intValue() >= 35) {
            iIntValue = this.twistDegree.intValue();
        }
        return Integer.valueOf(iIntValue);
    }

    /* renamed from: e */
    public Integer m40210e() {
        Integer num = this.interactiveLogic;
        if (num == null) {
            return 0;
        }
        return num;
    }

    /* renamed from: f */
    public Integer m40213f() {
        return this.splashAdTagClickableType;
    }

    /* renamed from: g */
    public Integer m40215g() {
        Integer num = this.swipeDirection;
        if (num == null || !(num.intValue() == 0 || this.swipeDirection.intValue() == 1)) {
            return 0;
        }
        return this.swipeDirection;
    }

    /* renamed from: h */
    public String m40217h() {
        return AbstractC7806cz.m48168c(this.swipeTxt);
    }

    /* renamed from: i */
    public String m40218i() {
        return AbstractC7806cz.m48168c(this.twistTxt);
    }

    /* renamed from: j */
    public String m40219j() {
        return AbstractC7806cz.m48168c(this.swipeClkTxt);
    }

    /* renamed from: k */
    public String m40220k() {
        return AbstractC7806cz.m48168c(this.twistClkTxt);
    }

    /* renamed from: l */
    public String m40221l() {
        return AbstractC7806cz.m48168c(this.splashRedirectTxt);
    }

    /* renamed from: a */
    public void m40199a(Integer num) {
        this.splashInteractCfg = num;
    }

    /* renamed from: b */
    public void m40202b(Integer num) {
        this.interactiveLogic = num;
    }

    /* renamed from: c */
    public void m40205c(Integer num) {
        this.splashAdTagClickableType = num;
    }

    /* renamed from: d */
    public void m40208d(Integer num) {
        this.swipeDp = num;
    }

    /* renamed from: e */
    public void m40211e(Integer num) {
        this.twistAcc = num;
    }

    /* renamed from: f */
    public void m40214f(Integer num) {
        this.twistDegree = num;
    }

    /* renamed from: g */
    public void m40216g(Integer num) {
        this.swipeDirection = num;
    }

    /* renamed from: a */
    public void m40200a(String str) {
        this.swipeTxt = str;
    }

    /* renamed from: b */
    public void m40203b(String str) {
        this.twistTxt = str;
    }

    /* renamed from: c */
    public void m40206c(String str) {
        this.swipeClkTxt = str;
    }

    /* renamed from: d */
    public void m40209d(String str) {
        this.twistClkTxt = str;
    }

    /* renamed from: e */
    public void m40212e(String str) {
        this.splashRedirectTxt = str;
    }
}

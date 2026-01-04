package p010a9;

import com.huawei.android.hicloud.p088ui.uiextend.dialog.ConfirmRenewAgreementDialog;
import com.huawei.android.hicloud.p088ui.views.RenewAgreementTextview;
import com.huawei.cloud.pay.model.CloudPackage;
import com.huawei.cloud.pay.model.PackageGrades;
import com.huawei.cloud.pay.model.ReportVoucherInfo;
import com.huawei.cloud.pay.model.Voucher;
import java.util.List;

/* renamed from: a9.a */
/* loaded from: classes3.dex */
public class C0079a {

    /* renamed from: a */
    public CloudPackage f304a;

    /* renamed from: b */
    public PackageGrades f305b;

    /* renamed from: c */
    public List<Voucher> f306c;

    /* renamed from: d */
    public ReportVoucherInfo f307d;

    /* renamed from: e */
    public ConfirmRenewAgreementDialog.AgreementDlgCallback f308e;

    /* renamed from: f */
    public String f309f;

    /* renamed from: g */
    public RenewAgreementTextview.RenewAgreementTVCallback f310g;

    /* renamed from: a */
    public ConfirmRenewAgreementDialog.AgreementDlgCallback m644a() {
        return this.f308e;
    }

    /* renamed from: b */
    public String m645b() {
        return this.f309f;
    }

    /* renamed from: c */
    public PackageGrades m646c() {
        return this.f305b;
    }

    /* renamed from: d */
    public RenewAgreementTextview.RenewAgreementTVCallback m647d() {
        return this.f310g;
    }

    /* renamed from: e */
    public ReportVoucherInfo m648e() {
        return this.f307d;
    }

    /* renamed from: f */
    public CloudPackage m649f() {
        return this.f304a;
    }

    /* renamed from: g */
    public List<Voucher> m650g() {
        return this.f306c;
    }

    /* renamed from: h */
    public void m651h(ConfirmRenewAgreementDialog.AgreementDlgCallback agreementDlgCallback) {
        this.f308e = agreementDlgCallback;
    }

    /* renamed from: i */
    public void m652i(String str) {
        this.f309f = str;
    }

    /* renamed from: j */
    public void m653j(PackageGrades packageGrades) {
        this.f305b = packageGrades;
    }

    /* renamed from: k */
    public void m654k(RenewAgreementTextview.RenewAgreementTVCallback renewAgreementTVCallback) {
        this.f310g = renewAgreementTVCallback;
    }

    /* renamed from: l */
    public void m655l(ReportVoucherInfo reportVoucherInfo) {
        this.f307d = reportVoucherInfo;
    }

    /* renamed from: m */
    public void m656m(CloudPackage cloudPackage) {
        this.f304a = cloudPackage;
    }

    /* renamed from: n */
    public void m657n(List<Voucher> list) {
        this.f306c = list;
    }
}

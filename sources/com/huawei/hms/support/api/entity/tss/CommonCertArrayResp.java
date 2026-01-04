package com.huawei.hms.support.api.entity.tss;

import android.util.Base64;
import com.huawei.hms.core.aidl.annotation.Packed;
import com.huawei.hms.feature.dynamic.p119f.C5335e;
import com.huawei.hms.support.api.entity.tss.base.BaseResp;
import java.io.ByteArrayInputStream;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes8.dex */
public class CommonCertArrayResp extends BaseResp {

    @Packed
    private X509Certificate[] certChain;

    public CommonCertArrayResp(String str) throws JSONException, CertificateException {
        try {
            JSONArray jSONArray = new JSONObject(str).getJSONArray("certChain");
            if (jSONArray != null && jSONArray.length() > 0) {
                this.certChain = new X509Certificate[jSONArray.length()];
                CertificateFactory certificateFactory = CertificateFactory.getInstance(C5335e.f24726b);
                for (int i10 = 0; i10 < jSONArray.length(); i10++) {
                    Certificate certificateGenerateCertificate = certificateFactory.generateCertificate(new ByteArrayInputStream(Base64.decode(jSONArray.getString(i10), 0)));
                    if (certificateGenerateCertificate instanceof X509Certificate) {
                        this.certChain[i10] = (X509Certificate) certificateGenerateCertificate;
                    }
                }
            }
        } catch (IllegalArgumentException e10) {
            throw new JSONException("decode failed, e is ： " + e10.getMessage());
        } catch (CertificateException e11) {
            throw new JSONException("common cert array error, e is ： " + e11.getMessage());
        }
    }

    public X509Certificate[] getCertChain() {
        X509Certificate[] x509CertificateArr = this.certChain;
        return x509CertificateArr != null ? (X509Certificate[]) x509CertificateArr.clone() : new X509Certificate[0];
    }

    public void setCertChain(X509Certificate[] x509CertificateArr) {
        if (x509CertificateArr != null) {
            this.certChain = (X509Certificate[]) x509CertificateArr.clone();
        } else {
            this.certChain = new X509Certificate[0];
        }
    }
}

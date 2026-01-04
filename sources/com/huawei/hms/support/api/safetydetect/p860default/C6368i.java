package com.huawei.hms.support.api.safetydetect.p860default;

import android.content.Context;
import com.huawei.hms.support.api.entity.safetydetect.RiskTokenResponse;
import java.io.IOException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;
import javax.crypto.NoSuchPaddingException;
import org.json.JSONException;

/* renamed from: com.huawei.hms.support.api.safetydetect.default.i */
/* loaded from: classes8.dex */
public class C6368i extends AbstractC6354a<RiskTokenResponse> {

    /* renamed from: c */
    private final Context f29891c;

    public C6368i(Context context, String str, String str2, boolean z10) {
        super(context, str, str2, z10);
        this.f29891c = context;
    }

    @Override // com.huawei.hms.support.api.safetydetect.p860default.AbstractC6354a
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public RiskTokenResponse mo36723a(String str, int i10, String str2) throws NoSuchPaddingException, NoSuchAlgorithmException, UnrecoverableKeyException, C6378s, IOException, InvalidKeyException, KeyStoreException, CertificateException, InvalidAlgorithmParameterException {
        try {
            RiskTokenResponse riskTokenResponse = new RiskTokenResponse(str);
            C6376q.m36750a(this.f29891c, str);
            return riskTokenResponse;
        } catch (JSONException e10) {
            throw new C6378s(e10.getLocalizedMessage());
        }
    }
}

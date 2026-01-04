package com.huawei.wisesecurity.ucs.credential.entity;

import com.huawei.hms.identity.AddressConstants;
import org.json.JSONException;
import org.json.JSONObject;
import p239dw.C9320b;
import p374iv.C10626e;
import p500nv.C11756a;
import p535ov.InterfaceC12044k;
import p857zv.C14389c;

/* loaded from: classes9.dex */
public class ErrorBody {

    @InterfaceC12044k
    private String errorCode;

    @InterfaceC12044k
    private String errorMessage;

    public static ErrorBody fromString(String str) throws C14389c {
        try {
            ErrorBody errorBody = new ErrorBody();
            JSONObject jSONObject = new JSONObject(str);
            errorBody.errorCode = jSONObject.optString(AddressConstants.Extras.EXTRA_NAME_ERR_CODE);
            errorBody.errorMessage = jSONObject.optString("errorMessage");
            C11756a.m70079b(errorBody);
            return errorBody;
        } catch (C10626e e10) {
            StringBuilder sbM58651a = C9320b.m58651a("ErrorBody param invalid : ");
            sbM58651a.append(e10.getMessage());
            throw new C14389c(1001L, sbM58651a.toString());
        } catch (JSONException e11) {
            StringBuilder sbM58651a2 = C9320b.m58651a("ErrorBody param is not a valid json string : ");
            sbM58651a2.append(e11.getMessage());
            throw new C14389c(1001L, sbM58651a2.toString());
        }
    }

    public String getErrorCode() {
        return this.errorCode;
    }

    public String getErrorMessage() {
        return this.errorMessage;
    }
}

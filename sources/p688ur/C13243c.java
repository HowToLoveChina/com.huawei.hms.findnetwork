package p688ur;

import com.huawei.android.hicloud.sync.protocol.SyncProtocol;
import com.huawei.hicloud.bean.BasicBaseResp;
import com.huawei.hicloud.notification.constants.NotifyConstants;
import com.huawei.hms.location.LocationRequest;
import com.huawei.location.activity.C6738e;
import com.huawei.location.base.activity.constant.ActivityErrorCode;
import com.huawei.location.gwi.util.C6767yn;
import com.huawei.openalliance.p169ad.constant.ErrorCode;
import com.huawei.riemann.location.common.utils.Constant;
import java.util.HashMap;
import java.util.Map;

/* renamed from: ur.c */
/* loaded from: classes8.dex */
public class C13243c {

    /* renamed from: c */
    public static final Map<Integer, String> f59922c;

    /* renamed from: a */
    public int f59923a;

    /* renamed from: b */
    public String f59924b;

    static {
        HashMap map = new HashMap();
        f59922c = map;
        C6767yn.m38372yn(0, map, "success", 1, "inner error");
        C6767yn.m38372yn(200, map, "HTTP_OK", 201, "HTTP_CREATED");
        C6767yn.m38372yn(202, map, "HTTP_ACCEPTED", 203, "HTTP_NOT_AUTHORITATIVE");
        C6767yn.m38372yn(204, map, "HTTP_NO_CONTENT", Constant.ERROR_ACC_GRAVITY_INVALID, "HTTP_RESET");
        C6767yn.m38372yn(206, map, "HTTP_PARTIAL", 300, "HTTP_MULT_CHOICE");
        C6767yn.m38372yn(LocationRequest.PRIORITY_MAG_POSITION, map, "HTTP_MOVED_PERM", 302, "HTTP_MOVED_TEMP");
        C6767yn.m38372yn(303, map, "HTTP_SEE_OTHER", 304, "HTTP_NOT_MODIFIED");
        C6767yn.m38372yn(305, map, "HTTP_USE_PROXY", 400, "HTTP_BAD_REQUEST");
        C6767yn.m38372yn(401, map, "HTTP_UNAUTHORIZED", 402, "HTTP_PAYMENT_REQUIRED");
        C6767yn.m38372yn(403, map, "HTTP_FORBIDDEN", 404, "HTTP_NOT_FOUND");
        C6767yn.m38372yn(405, map, "HTTP_BAD_METHOD", 406, "HTTP_NOT_ACCEPTABLE");
        C6767yn.m38372yn(ErrorCode.ERROR_CODE_NO_SDKVERSION, map, "HTTP_PROXY_AUTH", 408, "HTTP_CLIENT_TIMEOUT");
        C6767yn.m38372yn(409, map, "HTTP_CONFLICT", 410, "HTTP_GONE");
        C6767yn.m38372yn(NotifyConstants.MarketingConstant.CSOURCE_VALUE_BACKUP_FAIL_NOTIFICATION_POPUP, map, "HTTP_LENGTH_REQUIRED", 412, "HTTP_PRECON_FAILED");
        C6767yn.m38372yn(SyncProtocol.Status.DATA_TOO_LARGE, map, "HTTP_ENTITY_TOO_LARGE", 414, "HTTP_REQ_TOO_LONG");
        C6767yn.m38372yn(415, map, "HTTP_UNSUPPORTED_TYPE", 500, "HTTP_INTERNAL_ERROR");
        C6767yn.m38372yn(501, map, "HTTP_NOT_IMPLEMENTED", 502, "HTTP_BAD_GATEWAY");
        C6767yn.m38372yn(503, map, "HTTP_UNAVAILABLE", 504, "HTTP_GATEWAY_TIMEOUT");
        C6767yn.m38372yn(BasicBaseResp.TERM_NO_SIGN, map, "HTTP_VERSION", 10000, "internal error");
        C6767yn.m38372yn(ActivityErrorCode.ENABLE_CONVERSION_EVENT_FAILED, map, "GET_RESPONSE_FAILED", 10302, "no network");
        C6767yn.m38372yn(10304, map, "json parse failed", ActivityErrorCode.ACTIVITY_IDENTIFICATION_NOT_AVAILABLE, "server response format is error");
        C6767yn.m38372yn(10315, map, "server response error code", 10307, "okHttp Response is null");
        C6767yn.m38372yn(10309, map, "param error", 10308, "common network kit not init");
        C6767yn.m38372yn(10500, map, "TSS_SIGN_PARAM_ERROR", 10501, "TSS_GET_CREDENTIAL_API_FAILED");
        C6767yn.m38372yn(10502, map, "TSS_GET_CREDENTIAL_JSON_PARSE_FAILED", 10503, "TSS_GET_CREDENTIAL_EXC_FAILED");
        C6767yn.m38372yn(10504, map, "TSS_GET_CREDENTIAL_TIME_OUT", 10505, "TSS_GET_CREDENTIAL_TIME_OUT_RETURN");
        C6767yn.m38372yn(10506, map, "TSS_GET_CREDENTIAL_INTER_EXC", 10510, "TSS_GET_SECRET_FAILED_CREDENTIAL_EMPTY");
        C6767yn.m38372yn(10511, map, "TSS_GET_SECRET_API_FAILED", 10512, "TSS_GET_SECRET_JSON_PARSE_FAILED");
        C6767yn.m38372yn(10513, map, "TSS_GET_SECRET_EXC_FAILED", 10514, "TSS_GET_SECRET_TIME_OUT");
        C6767yn.m38372yn(10515, map, "TSS_GET_SECRET_TIME_OUT_RETURN", 10516, "TSS_GET_SECRET_INTER_EXC");
        C6767yn.m38372yn(10517, map, "TSS_GET_SECRET_FAILED_OTHER", 10518, "TSS_GET_SECRET_DROPPING_CUR_IS_VALID");
        C6767yn.m38372yn(10519, map, "TSS_ENCRYPT_FAILED", 10520, "TSS_GET_SECRET_SUCCESS");
        map.put(10550, "UCS_SIGN_FAILED");
    }

    public C13243c(int i10, String str) {
        this.f59923a = i10;
        this.f59924b = str;
    }

    /* renamed from: a */
    public static C13243c m79629a(int i10) {
        Map<Integer, String> map = f59922c;
        return map.containsKey(Integer.valueOf(i10)) ? new C13243c(i10, map.get(Integer.valueOf(i10))) : new C13243c(10000, map.get(10000));
    }

    /* renamed from: b */
    public static String m79630b(int i10) {
        Map<Integer, String> map = f59922c;
        if (!map.containsKey(Integer.valueOf(i10))) {
            i10 = 10000;
        }
        return map.get(Integer.valueOf(i10));
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder("ErrorCode{code=");
        sb2.append(this.f59923a);
        sb2.append(", msg='");
        return C6738e.m38291a(sb2, this.f59924b, "'}");
    }
}

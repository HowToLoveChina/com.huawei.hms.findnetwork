package p449ld;

import com.huawei.hicloud.bean.BasicBaseResp;
import com.huawei.hicloud.report.uba.UBAAnalyze;
import fk.C9721b;
import gp.C10028c;
import io.C10582a;
import java.util.LinkedHashMap;
import p514o9.C11839m;
import p581qk.AbstractC12367d;
import p684un.C13227f;

/* renamed from: ld.a */
/* loaded from: classes3.dex */
public class C11271a extends AbstractC12367d {

    /* renamed from: a */
    public String f52898a;

    public C11271a(String str) {
        this.f52898a = str;
    }

    @Override // p616rk.AbstractRunnableC12516b
    public void call() throws Throwable {
        LinkedHashMap<String, String> linkedHashMap;
        StringBuilder sb2;
        C10028c c10028cM62182c0;
        LinkedHashMap<String, String> linkedHashMap2;
        StringBuilder sb3;
        int i10 = 0;
        try {
            try {
                C11839m.m70688i("FollowPublicUserTask", "FollowPublicUserTask start!");
                c10028cM62182c0 = C10028c.m62182c0();
            } catch (C9721b e10) {
                e = e10;
            }
            if (c10028cM62182c0.m62370o1("follow_public_user")) {
                C11839m.m70689w("FollowPublicUserTask", "Public User has followed");
                linkedHashMap2 = new LinkedHashMap<>();
                linkedHashMap2.put("follow_request_count", "0");
                sb3 = new StringBuilder();
            } else {
                BasicBaseResp basicBaseRespM64933e = new C10582a(null).m64933e(this.f52898a);
                if (basicBaseRespM64933e == null) {
                    C11839m.m70687e("FollowPublicUserTask", "FollowPublicUserTask failed and response is null");
                    linkedHashMap2 = new LinkedHashMap<>();
                    linkedHashMap2.put("follow_request_count", "1");
                    sb3 = new StringBuilder();
                } else {
                    if (basicBaseRespM64933e.getResult() == 0) {
                        c10028cM62182c0.m62222H2("follow_public_user", true);
                        try {
                            C11839m.m70688i("FollowPublicUserTask", "FollowPublicUserTask end!");
                            linkedHashMap = new LinkedHashMap<>();
                            linkedHashMap.put("follow_request_count", "1");
                            sb2 = new StringBuilder();
                            sb2.append(1);
                        } catch (C9721b e11) {
                            e = e11;
                            i10 = 1;
                            C11839m.m70687e("FollowPublicUserTask", "FollowPublicUserTask failed and exception msg is: " + e.toString());
                            linkedHashMap = new LinkedHashMap<>();
                            linkedHashMap.put("follow_request_count", "1");
                            sb2 = new StringBuilder();
                            sb2.append(i10);
                            sb2.append("");
                            linkedHashMap.put("follow_count", sb2.toString());
                            C13227f.m79492i1().m79567R("18", linkedHashMap);
                            UBAAnalyze.m29947H("CKC", "18", linkedHashMap);
                            return;
                        } catch (Throwable th2) {
                            th = th2;
                            i10 = 1;
                            LinkedHashMap<String, String> linkedHashMap3 = new LinkedHashMap<>();
                            linkedHashMap3.put("follow_request_count", "1");
                            linkedHashMap3.put("follow_count", i10 + "");
                            C13227f.m79492i1().m79567R("18", linkedHashMap3);
                            UBAAnalyze.m29947H("CKC", "18", linkedHashMap3);
                            throw th;
                        }
                        sb2.append("");
                        linkedHashMap.put("follow_count", sb2.toString());
                        C13227f.m79492i1().m79567R("18", linkedHashMap);
                        UBAAnalyze.m29947H("CKC", "18", linkedHashMap);
                        return;
                    }
                    C11839m.m70687e("FollowPublicUserTask", "FollowPublicUserTask failed and response is:" + basicBaseRespM64933e.toString());
                    linkedHashMap2 = new LinkedHashMap<>();
                    linkedHashMap2.put("follow_request_count", "1");
                    sb3 = new StringBuilder();
                }
            }
            sb3.append(0);
            sb3.append("");
            linkedHashMap2.put("follow_count", sb3.toString());
            C13227f.m79492i1().m79567R("18", linkedHashMap2);
            UBAAnalyze.m29947H("CKC", "18", linkedHashMap2);
        } catch (Throwable th3) {
            th = th3;
        }
    }
}

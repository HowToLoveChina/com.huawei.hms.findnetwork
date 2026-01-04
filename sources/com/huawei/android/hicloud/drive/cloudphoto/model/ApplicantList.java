package com.huawei.android.hicloud.drive.cloudphoto.model;

import com.huawei.cloud.base.util.InterfaceC4648p;
import java.util.List;
import ni.C11707b;

/* loaded from: classes3.dex */
public class ApplicantList extends C11707b {

    @InterfaceC4648p
    private List<Applicant> applicants;

    @InterfaceC4648p
    private String category;

    @InterfaceC4648p
    private String nextCursor;

    public List<Applicant> getApplicants() {
        return this.applicants;
    }

    public String getCategory() {
        return this.category;
    }

    public String getNextCursor() {
        return this.nextCursor;
    }

    public void setApplicants(List<Applicant> list) {
        this.applicants = list;
    }

    public void setCategory(String str) {
        this.category = str;
    }

    public void setNextCursor(String str) {
        this.nextCursor = str;
    }
}

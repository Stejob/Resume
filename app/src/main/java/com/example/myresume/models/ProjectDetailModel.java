package com.example.myresume.models;

public class ProjectDetailModel {
    private String detailHeader;
    private String detail;

    public ProjectDetailModel(String detailHeader, String detail) {
        this.detailHeader = detailHeader;
        this.detail = detail;
    }

    public String getDetailHeader() {
        return detailHeader;
    }

    public void setDetailHeader(String detailHeader) {
        this.detailHeader = detailHeader;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }
}

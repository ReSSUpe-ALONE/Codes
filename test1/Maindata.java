package org.ReSSupe.test1;

public class Maindata {

    private int profile;
    private String pf_name;
    private String pf_content;


    public Maindata(int profile, String pf_name, String pf_content) {
        this.profile = profile;
        this.pf_name = pf_name;
        this.pf_content = pf_content;
    }

    public int getProfile() {
        return profile;
    }

    public void setProfile(int profile) {
        this.profile = profile;
    }

    public String getPf_name() {
        return pf_name;
    }

    public void setPf_name(String pf_name) {
        this.pf_name = pf_name;
    }

    public String getPf_content() {
        return pf_content;
    }

    public void setPf_content(String pf_content) {
        this.pf_content = pf_content;
    }
}

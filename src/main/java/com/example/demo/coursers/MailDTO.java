package com.example.demo.coursers;

import java.util.List;

public class MailDTO {
    private String address;
    private List<Long> ids;

    public MailDTO() {
    }

    public MailDTO(String address, List<Long> ids) {
        this.address = address;
        this.ids = ids;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<Long> getIds() {
        return ids;
    }

    public void setIds(List<Long> ids) {
        this.ids = ids;
    }
}

package com.example.demo.mail;

import java.util.List;

 class MailDTO {
    private String address;
    private List<Long> ids;

     MailDTO() {
    }

     MailDTO(String address, List<Long> ids) {
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
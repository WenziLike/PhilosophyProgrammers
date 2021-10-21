package com.philosophyprogrammers.modules.user;

import javax.persistence.Embeddable;

@Embeddable
public class StatusOnline {

    private Boolean statusOnline;

    public StatusOnline() {
    }

    public StatusOnline(Boolean statusOnline) {
        this.statusOnline = statusOnline;
    }

    public Boolean getStatusOnline() {
        return statusOnline;
    }

    public StatusOnline setStatusOnline(Boolean statusOnline) {
        this.statusOnline = statusOnline;
        return this;
    }

    @Override
    public String toString() {
        return "StatusOnline{" +
                "statusOnline=" + statusOnline +
                '}';
    }
}
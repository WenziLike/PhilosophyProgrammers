package com.philosophyprogrammers.modules;

import javax.persistence.Embeddable;
import java.util.Objects;

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
                "active=" + statusOnline +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StatusOnline that = (StatusOnline) o;
        return Objects.equals(statusOnline, that.statusOnline);
    }

    @Override
    public int hashCode() {
        return Objects.hash(statusOnline);
    }
}

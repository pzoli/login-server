package hu.infokristaly.loginserver.entity;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

@Entity
public class RFIDFailedLog implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Basic
    private String rfidCardReaderId;

    @Basic
    private String rfidCardRfId;

    private Date logDate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRfidCardReaderId() {
        return rfidCardReaderId;
    }

    public void setRfidCardReaderId(String rfidCardReaderId) {
        this.rfidCardReaderId = rfidCardReaderId;
    }

    public String getRfidCardRfId() {
        return rfidCardRfId;
    }

    public void setRfidCardRfId(String rfidCardRfId) {
        this.rfidCardRfId = rfidCardRfId;
    }

    public Date getLogDate() {
        return logDate;
    }

    public void setLogDate(Date logDate) {
        this.logDate = logDate;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        RFIDFailedLog that = (RFIDFailedLog) o;
        return Objects.equals(id, that.id) && Objects.equals(rfidCardReaderId, that.rfidCardReaderId) && Objects.equals(rfidCardRfId, that.rfidCardRfId) && Objects.equals(logDate, that.logDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, rfidCardReaderId, rfidCardRfId, logDate);
    }
}

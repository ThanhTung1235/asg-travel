package entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "devvn_tinhthanhpho")
public class City {
    @Id
    private long mtp;
    private String name;
    private String type;

    public long getMtp() {
        return mtp;
    }

    public void setMtp(long mtp) {
        this.mtp = mtp;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

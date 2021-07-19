package entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "category", schema = "wish")
public class CategoryEntity {
    private int cid;
    private String cname;

    @Id
    @Column(name = "cid", nullable = false)
    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    @Basic
    @Column(name = "cname", nullable = true, length = 200)
    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CategoryEntity that = (CategoryEntity) o;
        return cid == that.cid &&
                Objects.equals(cname, that.cname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cid, cname);
    }
}

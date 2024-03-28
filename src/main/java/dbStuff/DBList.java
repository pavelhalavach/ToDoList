package dbStuff;
import java.sql.*;

public class DBList {
    private int id;
    private String title;
    private String desc;
    private byte[] attach;
    private Date dueDate;

    @Override
    public String toString() {
//        return "id: "+id+", title: "+title+", desc: "+ desc+", attach: "+ attach+", dueDate: "+dueDate+", createdAt: " + createdAt;
        return title;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public byte[] getAttach() {
        return attach;
    }

    public void setAttach(byte[] attach) {
        this.attach = attach;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    private Date createdAt;

}

package worldline.ssm.rd.ux.wltwitter;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Tweett {
    @PrimaryKey() //ca c'est le mapping
    @NonNull
    private String id;

    @ColumnInfo() //ca c'est le mapping
    private String text ;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}

package worldline.ssm.rd.ux.wltwitter;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import worldline.ssm.rd.ux.wltwitter.interfaces.TweetDao;

//Dernier TP

@Database(entities = {Tweett.class}, version = 1)
public abstract class TweetDatabase extends RoomDatabase {

    public abstract TweetDao tweetDao();


}

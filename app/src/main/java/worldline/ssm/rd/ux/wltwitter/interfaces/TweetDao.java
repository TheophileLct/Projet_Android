package worldline.ssm.rd.ux.wltwitter.interfaces;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

import worldline.ssm.rd.ux.wltwitter.Tweett;

//Dernier TP

@Dao
public interface TweetDao {
    @Query("SELECT * FROM Tweett") //Associe une requete à une fonction.
    List<Tweett> getAll(); //automatiquement la requete est excécutée et le résultat est transformé en liste de tweet

    @Insert(onConflict = OnConflictStrategy.REPLACE) // en cas de conflit il fait un REPLACE
    void insert(Tweett tweet);


}

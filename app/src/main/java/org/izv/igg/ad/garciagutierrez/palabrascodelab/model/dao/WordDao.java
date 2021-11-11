package org.izv.igg.ad.garciagutierrez.palabrascodelab.model.dao;

/*
 * DAO - Data Access Object
 *
 * Esta cinterface me proporciona un objeto mediante el cual voy a poder acceder a la base de datos
 */

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import org.izv.igg.ad.garciagutierrez.palabrascodelab.model.data.Word;

import java.util.List;

@Dao
public interface WordDao { // Implementar ROOM

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(Word word); // hebra

    @Query("DELETE FROM word_table")
    void deleteAll(); // hebra

    @Query("SELECT * FROM word_table ORDER BY word ASC")
    List<Word> getAlphabetizedWordsOld(); // hebra

    @Query("SELECT * FROM word_table ORDER BY word ASC")
    LiveData<List<Word>> getAlphabetizedWords(); // hebra principal
}

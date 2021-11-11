package org.izv.igg.ad.garciagutierrez.palabrascodelab.model.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import org.izv.igg.ad.garciagutierrez.palabrascodelab.model.data.Word;
import org.izv.igg.ad.garciagutierrez.palabrascodelab.model.dao.WordDao;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Database(entities = {Word.class}, version = 1, exportSchema = false)
public abstract class WordRoomDatabase extends RoomDatabase {

    public abstract WordDao wordDao(); // Método abstracto que hay que implementar, lo implementa ROOM

    private static volatile WordRoomDatabase INSTANCE; // volatile -> hilo, hebra
    // Es volatile para que cuando se ejecute getDatabase(), si ya está creada la instancia,
    // el siguiente hilo vea directamente el contenido

    private static final String INSTANCIA = "hola"; // Cuando una variable es static final hay que inicializarla en el momento
    private static final int NUMBER_OF_THREADS = Runtime.getRuntime().availableProcessors(); // Permite ejecutat el nº de hilos que le digamos

    public static final ExecutorService databaseWriteExecutor = Executors.newFixedThreadPool(NUMBER_OF_THREADS);
    Thread databaseWriteThread;

    public static WordRoomDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (WordRoomDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            WordRoomDatabase.class, "word_database").build();
                }
            }
        }
        return INSTANCE;
    }

    // Método getDatabase() simplificado
    static WordRoomDatabase getWordDatabase (Context context){
        if (INSTANCE == null){ // Si es null es que todavía no se ha creado INSTANCE
            INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                    WordRoomDatabase.class, "word_database")
                    .build();
        }
        return INSTANCE;
    }
}

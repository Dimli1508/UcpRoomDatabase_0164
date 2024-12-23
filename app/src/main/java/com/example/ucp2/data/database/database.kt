import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Dosen::class, MataKuliah::class], version = 1)
abstract class database : RoomDatabase() {
    abstract fun DosenDAO(): DosenDao
    abstract fun MataKuliahDao(): MataKuliahDao

    companion object {
        @Volatile private var INSTANCE: database? = null

        fun getDatabase(context: Context): database {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    database::class.java,
                    "database"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}


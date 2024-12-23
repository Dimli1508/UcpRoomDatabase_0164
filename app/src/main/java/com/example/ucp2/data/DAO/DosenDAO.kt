import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface DosenDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertDosen(dosen: Dosen)

    @Query("SELECT * FROM dosen")
    fun getAllDosen(): LiveData<List<Dosen>>
}
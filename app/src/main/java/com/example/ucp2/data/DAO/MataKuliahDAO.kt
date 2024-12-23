import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update

@Dao
interface MataKuliahDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertMataKuliah(mataKuliah: MataKuliah)

    @Update
    suspend fun updateMataKuliah(mataKuliah: MataKuliah)

    @Delete
    suspend fun deleteMataKuliah(mataKuliah: MataKuliah)

    @Query("SELECT * FROM mata_kuliah")
    fun getAllMataKuliah(): LiveData<List<MataKuliah>>

    @Query("SELECT * FROM mata_kuliah WHERE kode = :kode")
    fun getMataKuliahByKode(kode: String): LiveData<MataKuliah>
}


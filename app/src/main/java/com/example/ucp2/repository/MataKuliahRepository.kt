import androidx.lifecycle.LiveData
import com.example.ucp2.entity.MataKuliah

class MataKuliahRepository(private val mataKuliahDao: MataKuliahDao) {


    suspend fun insert(mataKuliah: MataKuliah) {
        mataKuliahDao.insertMataKuliah(mataKuliah)
    }

    suspend fun update(mataKuliah: MataKuliah) {
        mataKuliahDao.updateMataKuliah(mataKuliah)
    }

    suspend fun delete(mataKuliah: MataKuliah) {
        mataKuliahDao.deleteMataKuliah(mataKuliah)
    }
}

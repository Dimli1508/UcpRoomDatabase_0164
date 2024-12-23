import androidx.lifecycle.LiveData

class MataKuliahRepository(private val mataKuliahDao: MataKuliahDao) {
    val allMataKuliah: LiveData<List<MataKuliah>> = mataKuliahDao.getAllMataKuliah()

    suspend fun insert(mataKuliah: MataKuliah) {
        mataKuliahDao.insertMataKuliah(mataKuliah)
    }

    suspend fun update(mataKuliah: MataKuliah) {
        mataKuliahDao.updateMataKuliah(mataKuliah)
    }

    suspend fun delete(mataKuliah: MataKuliah) {
        mataKuliahDao.deleteMataKuliah(mataKuliah)
    }

    fun getMataKuliahByKode(kode: String): LiveData<MataKuliah> {
        return mataKuliahDao.getMataKuliahByKode(kode)
    }
}

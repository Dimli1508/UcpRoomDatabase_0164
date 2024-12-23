import androidx.lifecycle.LiveData

class DosenRepository(private val dosenDao: DosenDao) {
    val allDosen: LiveData<List<Dosen>> = dosenDao.getAllDosen()

    suspend fun insert(dosen: Dosen) {
        dosenDao.insertDosen(dosen)
    }
}

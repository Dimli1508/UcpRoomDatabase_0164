import androidx.lifecycle.LiveData
import com.example.ucp2.entity.Dosen

class RepositoryDosen(private val dosenDao: DosenDao) {


    suspend fun insert(dosen: Dosen) {
        dosenDao.insertDosen(dosen)
    }
}

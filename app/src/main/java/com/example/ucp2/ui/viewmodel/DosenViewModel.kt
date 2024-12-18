import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.ucp2.entity.Dosen
import kotlinx.coroutines.launch

class DosenViewModel(application: Application) : AndroidViewModel(application) {
    private val repository: RepositoryDosen
    val allDosen: LiveData<List<Dosen>>

    init {
        val dosenDao = AppDatabase.getDatabase(application).dosenDao()
        repository = RepositoryDosen(dosenDao)
        allDosen = repository.allDosen
    }

    fun insert(dosen: Dosen) = viewModelScope.launch {
        repository.insert(dosen)
    }
}

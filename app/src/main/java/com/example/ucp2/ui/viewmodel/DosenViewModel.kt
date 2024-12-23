import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class DosenViewModel(application: Application) : AndroidViewModel(application) {
    private val repository: DosenRepository
    val allDosen: LiveData<List<Dosen>>

    init {
        val dosenDao = database.getDatabase(application).DosenDAO()
        repository = DosenRepository(dosenDao)
        allDosen = repository.allDosen
    }

    fun insert(dosen: Dosen) = viewModelScope.launch {
        repository.insert(dosen)
    }
}


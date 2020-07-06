package kun.kt.busticket.basecomponent

import androidx.lifecycle.ViewModel
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

abstract class BaseViewModel : ViewModel() {
    val disposable = CompositeDisposable()
    protected val addDisposable: (subcription: Disposable) -> Unit = {
        disposable.add(disposable)
    }

    override fun onCleared() {
        super.onCleared()
        disposable.clear()
    }
}
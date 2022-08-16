package life.league.challenge.kotlin.main

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.yuricfurusho.account.LoginUseCase
import com.yuricfurusho.post.PostListActivity
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import life.league.challenge.kotlin.R
import life.league.challenge.kotlin.api.LeagueApi
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    @Inject lateinit var leagueApi: LeagueApi
    @Inject lateinit var loginUseCase: LoginUseCase

    companion object {
        private const val TAG = "MainActivity"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        startActivity(Intent(this, PostListActivity::class.java))
        finish()
    }

    override fun onResume() {
        super.onResume()

        // example api call to login, feel free to delete this and implement the call to login
        // somewhere else differently depending on your chosen architecture
        lifecycleScope.launch(Dispatchers.IO) {
            try {
                val account = loginUseCase("hello", "world")
                // TODO LEAG-0014: Replace Android logging with java.util.logging.Logger.
                //                Log.v(TAG, account.apiKey ?: "")
            } catch (t : Throwable) {
                // TODO LEAG-0014: Replace Android logging with java.util.logging.Logger.
//                Log.e(TAG, t.message, t)
            }
        }
    }

}

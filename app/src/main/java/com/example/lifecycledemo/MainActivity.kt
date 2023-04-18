package com.example.lifecycledemo

import android.os.Binder
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.lifecycle.lifecycleScope
import com.example.lifecycledemo.databinding.ActivityMainBinding
import com.example.lifecycledemo.ui.main.MainFragment
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
/*LifecycleScope est un composant d'architecture Android qui fournit un scope (portée) pour la gestion des coroutines en fonction du cycle de vie d'un composant, tel qu'une activité ou un fragment.
 Cela permet de lancer des tâches asynchrones avec les coroutines tout en garantissant qu'elles seront automatiquement annulées lorsque le composant auquel elles sont attachées est détruit ou arrêté.
Le LifecycleScope est créé en utilisant l'objet lifecycleScope qui est accessible depuis une activité ou un fragment et qui est associé au cycle de vie de ce dernier.
Cela signifie que lorsque le cycle de vie de l'activité ou du fragment se termine, toutes les coroutines lancées à l'aide du LifecycleScope seront automatiquement annulées.
Par exemple, si vous utilisez des coroutines pour effectuer des appels réseau ou pour accéder à des données de manière asynchrone, vous pouvez les lancer en utilisant le LifecycleScope afin de vous assurer que ces coroutines seront arrêtées lorsque l'activité ou le fragment est détruit.
Cela peut aider à éviter les fuites de mémoire et les problèmes de performance.
 */
class MainActivity : AppCompatActivity() {
  private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, MainFragment.newInstance())
                .commitNow()
        }

        lifecycleScope.launch(Dispatchers.IO) {
           Log.i("MyTag","thread is : ${Thread.currentThread().name}")

        }

        lifecycleScope.launchWhenCreated {

        }
        lifecycleScope.launchWhenStarted {

        }
        lifecycleScope.launchWhenResumed {

        }
    }
}
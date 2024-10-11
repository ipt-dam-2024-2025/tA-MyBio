package pt.ipt.dam.mybio

import android.content.Context
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // encontrar o botão da interface
        findViewById<Button>(R.id.bt_mostra_curriculo).setOnClickListener {
            mostraCurriculo(it)
        }


    }

    /**
     * mostra o diminutivo do utilizador + currículo e
     * esconde o botão + 'textbox' do diminutivo
     */
    private fun mostraCurriculo(view: View) {

        // tarefas:
        //   - associar o texto da 'textbox' à 'textview' do diminutivo
        //   - esconder o botão
        //   - esconder 'textbox'
        //   - mostrar diminutivo
        //   - colocar o currículo visível
        //   - esconder o teclado

        // execução
        //   - associar o texto da 'textbox' à 'textview' do diminutivo
        val textoDiminutivo=findViewById<TextView>(R.id.textView_mostra_diminutivo)
        val textoDiminutivoTextBox=findViewById<EditText>(R.id.editTextDiminutivo)
        textoDiminutivo.text=textoDiminutivoTextBox.text

        // alterar a visibilidade dos objetos no ecrã
        textoDiminutivo.visibility=View.VISIBLE
        findViewById<TextView>(R.id.textView_mostra_curriculo).visibility=View.VISIBLE
        textoDiminutivoTextBox.visibility=View.GONE
        view.visibility=View.GONE // esconde o botão

        // esconder o teclado
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(view.windowToken, 0)


    }
}
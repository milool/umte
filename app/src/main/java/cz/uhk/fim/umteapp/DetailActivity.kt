package cz.uhk.fim.umteapp

import android.app.Activity
import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AlertDialog
import android.support.v7.app.AppCompatActivity
import android.view.MenuItem
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_detail.*

class DetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        //? = only if not null nebo !! = bez kontroly (muze hodit NullPointerException)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        detailTextView.text = "Hello from Main Activity"

        val sent = intent.getStringExtra("key")
        Toast.makeText(this, sent, Toast.LENGTH_LONG).show()

        confirmButton.setOnClickListener {
            var builder = AlertDialog.Builder(this@DetailActivity)

            builder.setTitle("Dialog")
            builder.setMessage("Opravdu chcete aktivitu ukoncit?")

            /*builder.setPositiveButton("Ano", object : DialogInterface.OnClickListener {
                override fun onClick(dialog: DialogInterface?, which: Int) {
                    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                }
            })*/
            // druha moznost
            builder.setPositiveButton("Ano") { dialog, which ->

                val resultIntent = Intent()
                resultIntent.putExtra("result", "done")
                setResult(Activity.RESULT_OK, resultIntent)

                dialog.dismiss()
                finish()
            }

            builder.setNegativeButton("Ne") {dialog, which ->
                dialog.dismiss()
            }

            builder.create().show()
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            finish()
        }
        return super.onOptionsItemSelected(item)
    }
}

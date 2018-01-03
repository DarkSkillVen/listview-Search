package nnt.dakrskillven.lolijoayo

import android.os.Handler
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.MotionEvent
import android.view.View
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import android.widget.EditText
import android.widget.ListView

import java.util.ArrayList
import java.util.Locale
import java.util.concurrent.ScheduledExecutorService

class MainActivity : AppCompatActivity() {

    private var list: MutableList<String>? = null
    private var listView: ListView? = null
    private var editSearch: EditText? = null
    private var adapter: SearchAdapter? = null
    private var arraylist: ArrayList<String>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        editSearch = findViewById<View>(R.id.editSearch) as EditText
        listView = findViewById<View>(R.id.listView) as ListView


        list = ArrayList()


        settingList()


        arraylist = ArrayList()
        val addAll = arraylist!!.addAll(list as ArrayList<String>)
        


        adapter = SearchAdapter(list, this)


        listView!!.adapter = adapter


        editSearch!!.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(charSequence: CharSequence, i: Int, i1: Int, i2: Int) {}

            override fun onTextChanged(charSequence: CharSequence, i: Int, i1: Int, i2: Int) {

            }

            override fun afterTextChanged(editable: Editable) {

                val text = editSearch!!.text.toString()
                search(text)
            }
        })


    }


    fun search(charText: String) {


        list!!.clear()


        if (charText.length == 0) {
            list!!.addAll(arraylist!!)
        } else {

            for (i in arraylist!!.indices) {

                if (arraylist!![i].toLowerCase().contains(charText)) {

                    list!!.add(arraylist!![i])
                }
            }
        }
        adapter!!.notifyDataSetChanged()
    }


    private fun settingList() {
        list!!.add("가")
        list!!.add("나")
        list!!.add("다")
        list!!.add("라")
        list!!.add("마")
        list!!.add("사")
        list!!.add("아")
        list!!.add("자")
        list!!.add("차")
        list!!.add("카")
        list!!.add("타")
        list!!.add("파")
        list!!.add("하")
        list!!.add("로리")
        list!!.add("쇼타")
       list!!.add("닼토")
        list!!.add("그마")
        list!!.add("넨카")
        list!!.add("그지")
        list!!.add("조아조아")
        list!!.add("콭흘린")
        list!!.add("조아")
        list!!.add("뭐요")
        list!!.add("로리는 사랑입니다")
        list!!.add("ㅇㅈ")
        list!!.add("흐에")
        list!!.add("헤에")
    }
}

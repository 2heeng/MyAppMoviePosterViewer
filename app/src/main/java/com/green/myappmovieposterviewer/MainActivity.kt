package com.green.myappmovieposterviewer

import android.app.AlertDialog
import android.content.Context
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.GridView
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        title="그리드뷰로 영화 포스터 보기"

//        var gv = findViewById<GridView>(R.id.gridView1)
        var gv = findViewById<View>(R.id.gridView1) as GridView //as : 자료형 변환
        var gAdapter = MyGridAdapter(this)
        gv.adapter = gAdapter

    }

    inner class MyGridAdapter(var context: Context) : BaseAdapter(){

        var posterID = arrayOf(
            R.drawable.mov01, R.drawable.mov02, R.drawable.mov03, R.drawable.mov04,
            R.drawable.mov05, R.drawable.mov06, R.drawable.mov07, R.drawable.mov08,
            R.drawable.mov09, R.drawable.mov10,
            R.drawable.mov01, R.drawable.mov02, R.drawable.mov03, R.drawable.mov04,
            R.drawable.mov05, R.drawable.mov06, R.drawable.mov07, R.drawable.mov08,
            R.drawable.mov09, R.drawable.mov10,
            R.drawable.mov01, R.drawable.mov02, R.drawable.mov03, R.drawable.mov04,
            R.drawable.mov05, R.drawable.mov06, R.drawable.mov07, R.drawable.mov08,
            R.drawable.mov09, R.drawable.mov10
        )

        var posterTitle = arrayOf("Inside Out", "주먹왕 랄프", "웡카", "엘리멘탈", "토이스토리", "코코", "업(UP)", "루카", "니모를 찾아서", "라이온킹","Inside Out", "주먹왕 랄프", "웡카", "엘리멘탈", "토이스토리", "코코", "업(UP)", "루카", "니모를 찾아서", "라이온킹","Inside Out", "주먹왕 랄프", "웡카", "엘리멘탈", "토이스토리", "코코", "업(UP)", "루카", "니모를 찾아서", "라이온킹")


        override fun getCount(): Int {
            return posterID.size
        }

        override fun getItem(position: Int): Any {
            return 0
        }

        override fun getItemId(position: Int): Long {
            return 0
        }

        override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
            var imageview = ImageView(context)
            imageview.layoutParams = ViewGroup.LayoutParams(200, 300)
            imageview.scaleType = ImageView.ScaleType.FIT_CENTER
            imageview.setPadding(5, 5, 5, 5)

            imageview.setImageResource(posterID[p0])

            imageview.setOnClickListener {
                var dialogView = View.inflate(this@MainActivity, R.layout.dialog, null)
                var dlg = AlertDialog.Builder(this@MainActivity)
                var ivPoster = dialogView.findViewById<ImageView>(R.id.ivPoster)
                ivPoster.setImageResource(posterID[p0])
                dlg.setTitle(posterTitle[p0])
                dlg.setIcon(R.drawable.ic_launcher)
                dlg.setView(dialogView)
                dlg.setNegativeButton("닫기", null)
                dlg.show()
            }

            return imageview
        }

    }

}
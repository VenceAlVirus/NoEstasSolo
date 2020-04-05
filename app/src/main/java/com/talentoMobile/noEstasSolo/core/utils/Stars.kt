package com.talentoMobile.noEstasSolo.core.utils

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import androidx.constraintlayout.widget.ConstraintLayout
import com.talentoMobile.noEstasSolo.R
import kotlinx.android.synthetic.main.component_stars.view.*

class Stars @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyle: Int = 0,
    defStyleRes: Int = 0
) : ConstraintLayout(context, attrs, defStyle) {

    private var stars = 0

    init {
        LayoutInflater.from(context).inflate(R.layout.component_stars, this, true)

        attrs.let {
            val typedArray = context.obtainStyledAttributes(it, R.styleable.stars)
            val starCount = typedArray.getString(R.styleable.stars_starCount)
            setStars(starCount!!.toInt())
            typedArray.recycle()
        }

        star1.setOnClickListener {
            setStars(1)
            stars = 1
        }
        star2.setOnClickListener {
            setStars(2)
            stars = 2
        }
        star3.setOnClickListener {
            setStars(3)
            stars = 3
        }
        star4.setOnClickListener {
            setStars(4)
            stars = 4
        }
        star5.setOnClickListener {
            setStars(5)
            stars = 5
        }
    }

    fun setStars(stars: Int) {
        LayoutInflater.from(context).inflate(R.layout.component_stars, this, true)
        when (stars) {
            0 -> {
                star1.setImageResource(R.drawable.ic_star_gray)
                star2.setImageResource(R.drawable.ic_star_gray)
                star3.setImageResource(R.drawable.ic_star_gray)
                star4.setImageResource(R.drawable.ic_star_gray)
                star5.setImageResource(R.drawable.ic_star_gray)
            }
            1 -> {
                star1.setImageResource(R.drawable.ic_star_red)
                star2.setImageResource(R.drawable.ic_star_gray)
                star3.setImageResource(R.drawable.ic_star_gray)
                star4.setImageResource(R.drawable.ic_star_gray)
                star5.setImageResource(R.drawable.ic_star_gray)
            }
            2 -> {
                star1.setImageResource(R.drawable.ic_star_red)
                star2.setImageResource(R.drawable.ic_star_red)
                star3.setImageResource(R.drawable.ic_star_gray)
                star4.setImageResource(R.drawable.ic_star_gray)
                star5.setImageResource(R.drawable.ic_star_gray)
            }
            3 -> {
                star1.setImageResource(R.drawable.ic_star_red)
                star2.setImageResource(R.drawable.ic_star_red)
                star3.setImageResource(R.drawable.ic_star_red)
                star4.setImageResource(R.drawable.ic_star_gray)
                star5.setImageResource(R.drawable.ic_star_gray)
            }
            4 -> {
                star1.setImageResource(R.drawable.ic_star_red)
                star2.setImageResource(R.drawable.ic_star_red)
                star3.setImageResource(R.drawable.ic_star_red)
                star4.setImageResource(R.drawable.ic_star_red)
                star5.setImageResource(R.drawable.ic_star_gray)
            }
            5 -> {
                star1.setImageResource(R.drawable.ic_star_red)
                star2.setImageResource(R.drawable.ic_star_red)
                star3.setImageResource(R.drawable.ic_star_red)
                star4.setImageResource(R.drawable.ic_star_red)
                star5.setImageResource(R.drawable.ic_star_red)
            }
        }
    }

    fun getStars() = stars

}
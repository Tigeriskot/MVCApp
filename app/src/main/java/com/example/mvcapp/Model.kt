package com.example.mvcapp

import java.util.*
import kotlin.collections.ArrayList

class Model : Observable() {

    val List: MutableList<Int>

    init {

        List = ArrayList(3)

        List.add(0)
        List.add(0)
        List.add(0)
    }


    @Throws(IndexOutOfBoundsException::class)
    fun getValueAtIndex(the_index: Int): Int {
        return List[the_index]
    }


    @Throws(IndexOutOfBoundsException::class)
    fun setValueAtIndex(the_index: Int) {
        List[the_index] = List[the_index] + 1
        setChanged()
        notifyObservers()
    }
}

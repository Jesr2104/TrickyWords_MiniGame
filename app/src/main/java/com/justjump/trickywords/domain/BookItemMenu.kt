package com.justjump.trickywords.domain

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class BookItemMenu(
    val ISBN: String,
    val bookNumber: String,
    val level: String,
    val numberOfLesson: Int,
    val rangeLesson: String,
    val image: String

    ): Parcelable

fun getBookList() = listOf(
    BookItemMenu(
        ISBN = "978-1-78229-242-5",
        bookNumber = "Callan Method 7",
        level = "B2 - First",
        numberOfLesson = 16,
        rangeLesson = "Lessons 95 - 111",
        image = ""
    ),
    BookItemMenu(
        ISBN = "978-1-78229-243-2",
        bookNumber = "Callan Method 8",
        level = "C1 - Advanced",
        numberOfLesson = 14,
        rangeLesson = "Lessons 112 - 126",
        image = ""
    ),
    BookItemMenu(
        ISBN = "978-1-78229-008-7",
        bookNumber = "Callan Method 9",
        level = "C1 - Advanced",
        numberOfLesson = 18,
        rangeLesson = "Lessons 127 - 145",
        image = ""
    ),
)



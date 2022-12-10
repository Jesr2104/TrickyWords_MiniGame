package com.justjump.trickywords.utilities

import com.justjump.trickywords.domain.datamodels.BookItemMenu

fun getBookList() = listOf(
    BookItemMenu(
        ISBN = "978-1-782290-95-7",
        bookName = "Callan Method 6",
        bookNumber = 6,
        difficultLevel = "B2 - First",
        numberOfLesson = 16,
        rangeLesson = "Lessons 78 - 94",
        image = "https://firebasestorage.googleapis.com/v0/b/trickyword-justjump.appspot.com/o/BooksCovers%2Fbook-6.jpg?alt=media&token=d9564cc4-877b-4c85-bd38-7a7bf76b3e82"
    ),
    BookItemMenu(
        ISBN = "978-1-78229-242-5",
        bookName = "Callan Method 7",
        bookNumber = 7,
        difficultLevel = "B2 - First",
        numberOfLesson = 16,
        rangeLesson = "Lessons 95 - 111",
        image = "https://firebasestorage.googleapis.com/v0/b/trickyword-justjump.appspot.com/o/BooksCovers%2Fbook-7.jpg?alt=media&token=79a8bfcd-7b68-42ee-b5f4-7dd890dcb794"
    ),
    BookItemMenu(
        ISBN = "978-1-78229-243-2",
        bookName = "Callan Method 8",
        bookNumber = 8,
        difficultLevel = "C1 - Advanced",
        numberOfLesson = 14,
        rangeLesson = "Lessons 112 - 126",
        image = "https://firebasestorage.googleapis.com/v0/b/trickyword-justjump.appspot.com/o/BooksCovers%2Fbook-8.jpg?alt=media&token=fee9ae9a-514d-488b-86c4-6373c6b66eb3"
    ),
    BookItemMenu(
        ISBN = "978-1-78229-008-7",
        bookName = "Callan Method 9",
        bookNumber = 9,
        difficultLevel = "C1 - Advanced",
        numberOfLesson = 18,
        rangeLesson = "Lessons 127 - 145",
        image = "https://firebasestorage.googleapis.com/v0/b/trickyword-justjump.appspot.com/o/BooksCovers%2Fbook-9.jpg?alt=media&token=fd4db025-cbc2-491d-819d-9f96e8d8e554"
    ),
)
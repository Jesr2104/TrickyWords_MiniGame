package com.justjump.trickywords.utilities

import com.justjump.trickywords.domain.datamodels.BookInfoDataModel

object BooksInformation {
    private val booksInformation: ArrayList<BookInfoDataModel> = arrayListOf()

    fun getFiltersBooksList(): ArrayList<BookInfoDataModel> {
        val newList = arrayListOf<BookInfoDataModel>()

        getBooksInformationList().forEach {
            if (it.isActive) {
                newList.add(it)
            }
        }
        return newList
    }

    fun getBooksInformationList(): ArrayList<BookInfoDataModel> {
        return booksInformation.ifEmpty {
            setBooksInformationList(getDefaultInfo())
            booksInformation
        }
    }

    fun setBooksInformationList(newList: ArrayList<BookInfoDataModel>) {
        if (booksInformation.isNotEmpty()) {
            clearListBooksinfo()
        }
        newList.forEach {
            booksInformation.add(it)
        }
    }

    private fun clearListBooksinfo() {
        booksInformation.clear()
    }

    fun getDefaultInfo(): ArrayList<BookInfoDataModel> {
        return arrayListOf(
            BookInfoDataModel(
                ISBN = "978-1-78229-000-1",
                bookName = "Callan Method 1",
                bookNumber = 1,
                difficulty = "A1",
                nLesson = 9,
                rangeLesson = "Lessons 1 - 9",
                image = "https://firebasestorage.googleapis.com/v0/b/trickyword-justjump.appspot.com/o/BooksCovers%2Fbook-1.jpg?alt=media&token=ec03e5fc-7308-4156-a2e7-83b15dcc8d80",
                isActive = true
            ),
            BookInfoDataModel(
                ISBN = "978-1-78229-001-8",
                bookName = "Callan Method 2",
                bookNumber = 2,
                difficulty = "A2 - Key",
                nLesson = 14,
                rangeLesson = "Lessons 10 - 24",
                image = "https://firebasestorage.googleapis.com/v0/b/trickyword-justjump.appspot.com/o/BooksCovers%2Fbook-2.jpg?alt=media&token=3c42e31b-9a37-4497-ade3-6896dc1d5e3c",
                isActive = true
            ),
            BookInfoDataModel(
                ISBN = "978-1-78229-002-5",
                bookName = "Callan Method 3",
                bookNumber = 3,
                difficulty = "A2 - Key",
                nLesson = 15,
                rangeLesson = "Lessons 25 - 40",
                image = "https://firebasestorage.googleapis.com/v0/b/trickyword-justjump.appspot.com/o/BooksCovers%2Fbook-3.jpg?alt=media&token=9bf51ed5-4b5b-4d01-9440-88ec832a324e",
                isActive = true
            ),
            BookInfoDataModel(
                ISBN = "978-1-78229-003-2",
                bookName = "Callan Method 4",
                bookNumber = 4,
                difficulty = "B1 - Preliminary",
                nLesson = 19,
                rangeLesson = "Lessons 41 - 60",
                image = "https://firebasestorage.googleapis.com/v0/b/trickyword-justjump.appspot.com/o/BooksCovers%2Fbook-4.jpg?alt=media&token=a95700d8-65d5-4c7d-bdb1-a7d3b839bbc1",
                isActive = true
            ),
            BookInfoDataModel(
                ISBN = "978-1-78229-237-1",
                bookName = "Callan Method 5",
                bookNumber = 5,
                difficulty = "B2 - First",
                nLesson = 19,
                rangeLesson = "Lessons 61 - 77",
                image = "https://firebasestorage.googleapis.com/v0/b/trickyword-justjump.appspot.com/o/BooksCovers%2Fbook-5.jpg?alt=media&token=e09fca89-5191-47cf-b771-886bbaafca9b",
                isActive = true
            ),

            BookInfoDataModel(
                ISBN = "978-1-782290-95-7",
                bookName = "Callan Method 6",
                bookNumber = 6,
                difficulty = "B2 - First",
                nLesson = 16,
                rangeLesson = "Lessons 78 - 94",
                image = "https://firebasestorage.googleapis.com/v0/b/trickyword-justjump.appspot.com/o/BooksCovers%2Fbook-6.jpg?alt=media&token=d9564cc4-877b-4c85-bd38-7a7bf76b3e82",
                isActive = true
            ),
            BookInfoDataModel(
                ISBN = "978-1-78229-242-5",
                bookName = "Callan Method 7",
                bookNumber = 7,
                difficulty = "B2 - First",
                nLesson = 16,
                rangeLesson = "Lessons 95 - 111",
                image = "https://firebasestorage.googleapis.com/v0/b/trickyword-justjump.appspot.com/o/BooksCovers%2Fbook-7.jpg?alt=media&token=79a8bfcd-7b68-42ee-b5f4-7dd890dcb794",
                isActive = true
            ),
            BookInfoDataModel(
                ISBN = "978-1-78229-243-2",
                bookName = "Callan Method 8",
                bookNumber = 8,
                difficulty = "C1 - Advanced",
                nLesson = 14,
                rangeLesson = "Lessons 112 - 126",
                image = "https://firebasestorage.googleapis.com/v0/b/trickyword-justjump.appspot.com/o/BooksCovers%2Fbook-8.jpg?alt=media&token=fee9ae9a-514d-488b-86c4-6373c6b66eb3",
                isActive = true
            ),
            BookInfoDataModel(
                ISBN = "978-1-78229-008-7",
                bookName = "Callan Method 9",
                bookNumber = 9,
                difficulty = "C1 - Advanced",
                nLesson = 18,
                rangeLesson = "Lessons 127 - 145",
                image = "https://firebasestorage.googleapis.com/v0/b/trickyword-justjump.appspot.com/o/BooksCovers%2Fbook-9.jpg?alt=media&token=fd4db025-cbc2-491d-819d-9f96e8d8e554",
                isActive = true
            ),
            BookInfoDataModel(
                ISBN = "978-1-78229-009-4",
                bookName = "Callan Method 10",
                bookNumber = 10,
                difficulty = "C1 - Advanced",
                nLesson = 17,
                rangeLesson = "Lessons 146 - 163",
                image = "https://firebasestorage.googleapis.com/v0/b/trickyword-justjump.appspot.com/o/BooksCovers%2Fbook-10.jpg?alt=media&token=6877eb77-12bd-4d3c-8fef-2f698169ee88",
                isActive = true
            ),
            BookInfoDataModel(
                ISBN = "978-1-78229-246-3",
                bookName = "Callan Method 11",
                bookNumber = 11,
                difficulty = "C1 - Advanced",
                nLesson = 13,
                rangeLesson = "Lessons 164 - 177",
                image = "https://firebasestorage.googleapis.com/v0/b/trickyword-justjump.appspot.com/o/BooksCovers%2Fbook-11.jpg?alt=media&token=8a67c5ae-67b5-4b9a-b2ce-e5de397f6c6f",
                isActive = true
            ),
            BookInfoDataModel(
                ISBN = "978-1-78229-247-0",
                bookName = "Callan Method 12",
                bookNumber = 12,
                difficulty = "C2 - Proficiency",
                nLesson = 13,
                rangeLesson = "Lessons 178 - 191",
                image = "https://firebasestorage.googleapis.com/v0/b/trickyword-justjump.appspot.com/o/BooksCovers%2Fbook-12.jpg?alt=media&token=ffae33fd-a736-4d3a-af9d-d54e66e47b2a",
                isActive = true
            )
        )
    }
}
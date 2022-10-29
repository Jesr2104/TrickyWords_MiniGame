package com.justjump.trickywords.ui.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.justjump.trickywords.domain.BookItemMenu
import com.justjump.trickywords.ui.theme.tdarkgrey
import com.skydoves.landscapist.glide.GlideImage

@Composable
fun ItemBookSelector(book: BookItemMenu) {
    Card(
        modifier = Modifier.fillMaxSize(0.85f),
        border = BorderStroke(0.5.dp, Color.White),
        shape = RoundedCornerShape(25.dp),
        elevation = 4.dp
    ) {
        //Image(painter = painterResource(R.drawable.), contentDescription = null)
        GlideImage(
            imageModel = "https://firebasestorage.googleapis.com/v0/b/trickyword-justjump.appspot.com/o/Book7.png?alt=media&token=3f490f84-3346-460d-bb94-cfddc36f8a1a",
            contentScale = ContentScale.FillBounds,
        )

        Column(
            modifier = Modifier
                .padding(20.dp)
        ) {

            Row(
                modifier = Modifier
                    .weight(0.08f)
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.End
            ) {
                Column() {
                    Text(
                        text = book.rangeLesson,
                        fontSize = 12.sp,

                    )
                    Text(text = "Lessons #${book.numberOfLesson}", fontSize = 10.sp)
                }
            }
            Row(modifier = Modifier
                .weight(0.82f)
                //.background(Color.Cyan)
                .fillMaxWidth()
            ) {
                Column() {
                    Text(
                        text = book.bookName,
                        fontSize = 40.sp,
                        modifier = Modifier
                            .background(tdarkgrey)
                            .padding(2.dp)
                            .clip(RoundedCornerShape(16.dp))
                    )
                    Text(text = book.difficultLevel, fontSize = 20.sp)
                }
            }
            Row(modifier = Modifier
                .weight(0.1f)
                //.background(Color.Green)
                .fillMaxWidth(),
                verticalAlignment = Alignment.Bottom
            ) {
                Text(text = "ISBN: ${book.ISBN}", fontSize = 12.sp)
            }
        }
    }
}
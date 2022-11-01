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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.justjump.trickywords.domain.BookItemMenu
import com.justjump.trickywords.ui.theme.trans_dark_grey
import com.skydoves.landscapist.glide.GlideImage

@Composable
fun ItemBookSelector(book: BookItemMenu) {
    Card(
        modifier = Modifier.fillMaxSize(0.85f),
        border = BorderStroke(0.5.dp, Color.White),
        shape = RoundedCornerShape(25.dp),
        elevation = 4.dp
    ) {
        GlideImage(
            imageModel = book.image,
            contentScale = ContentScale.FillBounds
        )

        Column(modifier = Modifier.padding(20.dp)) {
            Row(
                modifier = Modifier
                    .weight(0.06f)
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.End
            ) {
                Column {
                    Text(
                        text = book.rangeLesson,
                        fontSize = 12.sp,
                        fontWeight = FontWeight.SemiBold,
                        modifier = Modifier
                            .clip(RoundedCornerShape(5.dp, 5.dp, 5.dp, 0.dp))
                            .background(trans_dark_grey)
                            .padding(5.dp, 0.dp, 5.dp, 0.dp)
                    )
                    Spacer(modifier = Modifier.height(2.dp))
                    Text(
                        text = "Lessons #${book.numberOfLesson}",
                        fontSize = 10.sp,
                        fontWeight = FontWeight.SemiBold,
                        modifier = Modifier
                            .clip(RoundedCornerShape(5.dp, 5.dp, 5.dp, 0.dp))
                            .background(trans_dark_grey)
                            .padding(5.dp, 0.dp, 5.dp, 0.dp)
                    )
                }
            }
            Row(
                modifier = Modifier
                    .weight(0.84f)
                    .fillMaxWidth()
            ) {
                Column {
                    Text(
                        text = book.bookName,
                        fontSize = 40.sp,
                        fontWeight = FontWeight.SemiBold,
                        modifier = Modifier
                            .clip(RoundedCornerShape(15.dp, 15.dp, 15.dp, 0.dp))
                            .background(trans_dark_grey)
                            .padding(10.dp, 0.dp, 10.dp, 0.dp)
                    )
                    Spacer(modifier = Modifier.height(3.dp))
                    Text(
                        text = book.difficultLevel,
                        fontSize = 20.sp,
                        fontWeight = FontWeight.SemiBold,
                        modifier = Modifier
                            .clip(RoundedCornerShape(5.dp, 5.dp, 5.dp, 0.dp))
                            .background(trans_dark_grey)
                            .padding(10.dp, 0.dp, 10.dp, 0.dp)
                    )
                }
            }
            Row(
                modifier = Modifier
                    .weight(0.1f)
                    .fillMaxWidth(),
                verticalAlignment = Alignment.Bottom
            ) {
                Text(
                    text = "ISBN: ${book.ISBN}",
                    fontSize = 12.sp,
                    fontWeight = FontWeight.SemiBold,
                    modifier = Modifier
                        .clip(RoundedCornerShape(5.dp, 5.dp, 5.dp, 0.dp))
                        .background(trans_dark_grey)
                        .padding(10.dp, 0.dp, 10.dp, 0.dp)
                )
            }
        }
    }
}
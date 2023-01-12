package com.justjump.trickywords.ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.google.accompanist.pager.*
import com.justjump.trickywords.utilities.BooksInformation.getFiltersBooksList

@OptIn(ExperimentalPagerApi::class)
@Composable
fun BookSelectorComp(onClick: (Int) -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(0.dp)
    ) {
        val items = getFiltersBooksList()
        val pagerState = rememberPagerState()

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            Text(
                text = "Select a Book",
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.Bold,
                fontSize = 30.sp,
                modifier = Modifier.padding(10.dp)
            )
        }

        HorizontalPager(
            count = items.size,
            state = pagerState,
        ) { currentPage ->
            Column {
                // show the selector on the book
                CardBookComp(items[currentPage])
            }
        }

        HorizontalPagerIndicator(
            pagerState = pagerState,
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .padding(10.dp)
        )

        Button(
            onClick = { onClick(items[pagerState.currentPage].bookNumber) },
            modifier = Modifier.align(Alignment.CenterHorizontally),
            shape = RoundedCornerShape(25)
        ) { Text("Select book") }
    }
}
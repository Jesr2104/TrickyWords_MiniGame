package com.justjump.trickywords.ui.components.selectBook

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.google.accompanist.pager.*
import com.justjump.trickywords.domain.getBookList
import com.justjump.trickywords.ui.components.ItemBookSelector

@OptIn(ExperimentalPagerApi::class)
@Composable
fun ViewPageBookSelectorComp(gameMode: Int, onClick: (Int) -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(0.dp)
    ) {
        val items = getBookList()
        val pagerState = rememberPagerState()

        HorizontalPager(
            count = items.size,
            state =  pagerState,
        ) { currentPage ->
            Column {
                // show the selector on the book
                ItemBookSelector(items[currentPage])
            }
        }

        HorizontalPagerIndicator(
            pagerState = pagerState,
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .padding(10.dp)
        )

        Button(
            onClick = {
                onClick(pagerState.currentPage)
                //onClick(arrayOf(1, pagerState.currentPage))
            },
            modifier = Modifier
                .align(Alignment.CenterHorizontally),
            shape = RoundedCornerShape(25)
        ){
            Text("Select book")
        }
    }
}
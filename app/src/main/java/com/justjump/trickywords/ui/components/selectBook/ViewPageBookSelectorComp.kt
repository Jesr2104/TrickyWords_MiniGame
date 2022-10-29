package com.justjump.trickywords.ui.components.selectBook

import androidx.compose.foundation.layout.*
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
fun ViewPageBookSelectorComp() {
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
                    ItemBookSelector(items[currentPage])


            /*Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(50.dp)
            ) {
                Text(
                    text = items[currentPage].bookNumber,
                    style = MaterialTheme.typography.h2
                )
                Spacer(modifier = Modifier.height(10.dp))
                Text(
                    text = items[currentPage].level,
                    style = MaterialTheme.typography.h4
                )
            }*/
        }

        HorizontalPagerIndicator(
            pagerState = pagerState,
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .padding(20.dp),
        )

        Button(
            onClick = {  },
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .padding(15.dp)
        ){ Text("Select book") }

        //${pagerState.currentPage}
    }
}

/*@OptIn(ExperimentalPagerApi::class)
@Composable
fun HorizontalTabs(
    items: List<BookItemMenu>,
    pagerState: PagerState,
    scope: CoroutineScope
) {
    TabRow(
        selectedTabIndex = pagerState.currentPage,
        indicator = { tabPositions ->
            TabRowDefaults.Indicator(
                modifier = Modifier.pagerTabIndicatorOffset(pagerState, tabPositions)
            )
        }
    ) {
        items.forEachIndexed { index, item ->
            Tab(
                selected = pagerState.currentPage == index,
                onClick = {
                    scope.launch {
                        pagerState.animateScrollToPage(page = index)
                    }
                }
            ) {
                Text(text = item.bookNumber)
            }
        }
    }
}


/*@OptIn(ExperimentalPagerApi::class)
@Composable
fun HorizontalPagerScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = colorResource(dev.chrisbanes.snapper.R.color.vector_tint_theme_color))
    ) {
        val items = createItems()
        val pagerState = rememberPagerState()
        val coroutineScope = rememberCoroutineScope()


        HorizontalPager(
            count = items.size,
            state = pagerState,
            modifier = Modifier.weight(1f)
        ) { currentPage ->
            Column(
                modifier = Modifier.fillMaxSize()
            ) {
                Text(
                    text = items[currentPage].title,
                    style = MaterialTheme.typography.h2
                )
                Spacer(modifier = Modifier.height(10.dp))
                Text(
                    text = items[currentPage].subtitle,
                    style = MaterialTheme.typography.h4
                )
                Spacer(modifier = Modifier.height(10.dp))
                Text(
                    text = items[currentPage].description,
                    style = MaterialTheme.typography.body1
                )
            }
        }

        HorizontalPagerIndicator(
            pagerState = pagerState,
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .padding(16.dp),
        )

        Button(
            onClick = {
                coroutineScope.launch {
                    pagerState.animateScrollToPage(page = 2)
                }
            },
            modifier = Modifier.align(Alignment.CenterHorizontally)
        ) {
            Text(text = "Scroll to the third page")
        }
    }
}

@OptIn(ExperimentalPagerApi::class)
@Composable
fun HorizontalTabs(
    items: List<HorizontalPagerContent>,
    pagerState: PagerState,
    scope: CoroutineScope
) {
    TabRow(
        selectedTabIndex = pagerState.currentPage,
        indicator = { tabPositions ->
            TabRowDefaults.Indicator(
                modifier = Modifier.pagerTabIndicatorOffset(pagerState, tabPositions)
            )
        }
    ) {
        items.forEachIndexed { index, item ->
            Tab(
                selected = pagerState.currentPage == index,
                onClick = {
                    scope.launch {
                        pagerState.animateScrollToPage(page = index)
                    }
                }
            ) {
                Text(text = item.title)
            }
        }
    }
}

private fun createItems() = listOf(
    HorizontalPagerContent(title = "Title1", subtitle = "Subtitle1", description = "Description1"),
    HorizontalPagerContent(title = "Title2", subtitle = "Subtitle2", description = "Description2"),
    HorizontalPagerContent(title = "Title3", subtitle = "Subtitle3", description = "Description3"),
    HorizontalPagerContent(title = "Title4", subtitle = "Subtitle4", description = "Description4"),
    HorizontalPagerContent(title = "Title5", subtitle = "Subtitle5", description = "Description5")
)

data class HorizontalPagerContent(
    val title: String,
    val subtitle: String,
    val description: String
)*/
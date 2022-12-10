package com.justjump.trickywords.ui.navigation

sealed class NavItem(val route: String) {
    //----------------------------------------------------------------------
    // list of routes
    //----------------------------------------------------------------------
    object Home : NavItem("home")
    object SetGameOption : NavItem("setGameOption")


    object SelectBook : NavItem("selectBook")
    object SelectDifficulty : NavItem("chooseOption")
    object PlayGame : NavItem("playGame")

    //object BattleGame : NavItem("battleGame") //MISSING TO BE USED ------>>>
    //object WordList : NavItem("wordList") //MISSING TO BE USED ------>>>

    object Progress : NavItem("progress")
    object Settings : NavItem("settings")
}
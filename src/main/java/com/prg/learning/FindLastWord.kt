package com.prg.learning


class FindLastWord {
    fun lengthOfLastWord(s: String): Int {
        return s.trimEnd().substringAfterLast(" ").length
    }
}
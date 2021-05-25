package subtask3

class StringParser {

    fun getResult(inputString: String): Array<String> {
        val listStrings = mutableSetOf<String>()
        val mapIndexes = mutableMapOf<Int, Int>()
        val listBrackets1 = mutableListOf<Int>() // '<'
        val listBrackets2 = mutableListOf<Int>() // '('
        val listBrackets3 = mutableListOf<Int>() // ']'

        for (index in inputString.indices) {
            when (inputString[index]) {
                '<' -> {
                    listBrackets1.add(index)
                }
                '>' -> {
                    if (listBrackets1.isNotEmpty()){
                        mapIndexes[listBrackets1.last() + 1] = index
                        listBrackets1.removeAt(listBrackets1.lastIndex)
                    }
                }
                '(' -> {
                    listBrackets2.add(index)
                }
                ')' -> {
                    if (listBrackets2.isNotEmpty()){
                        mapIndexes[listBrackets2.last() + 1] = index
                        listBrackets2.removeAt(listBrackets2.lastIndex)
                    }
                }
                '[' -> {
                    listBrackets3.add(index)
                }
                ']' -> {
                    if (listBrackets3.isNotEmpty()){
                        mapIndexes[listBrackets3.last() + 1] = index
                        listBrackets3.removeAt(listBrackets3.lastIndex)
                    }
                }
            }
        }
        for ((firstSubStringIndex, lastSubStringIndex) in mapIndexes.toSortedMap()){
            listStrings.add(inputString.substring(firstSubStringIndex,lastSubStringIndex))
        }
        return listStrings.toTypedArray()
    }
}

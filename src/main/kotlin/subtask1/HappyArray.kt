package subtask1

class HappyArray {

    fun convertToHappy(sadArray: IntArray): IntArray {
        var tempArray = sadArray
        while (!isHappyArray(tempArray)) {
            var happyList = mutableListOf<Int>()
            happyList.add(tempArray[0])
            for (index in 1..tempArray.size - 2) {
                if (isHappyElement(
                        tempArray[index],
                        tempArray[index - 1],
                        tempArray[index + 1]
                    )
                ) happyList.add(tempArray[index])
            }
            happyList.add(tempArray[tempArray.size - 1])
            tempArray = happyList.toIntArray()
        }
        return  tempArray
    }

    private fun isHappyArray(array: IntArray): Boolean{
        for (index in 1..array.size-2) {
            if (!isHappyElement(array[index], array[index-1], array[index+1])) return false
        }
        return true
    }

    private fun isHappyElement(element: Int, left: Int, right: Int): Boolean{
        return (element <= left +right)
    }
}

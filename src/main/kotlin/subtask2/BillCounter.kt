package subtask2

class BillCounter {

    fun calculateFairlySplit(bill: IntArray, k: Int, b: Int): String {
        var tempAnnaAndBrainBill: Int = 0

        for (index in bill.indices) {
            if (index != k) tempAnnaAndBrainBill += bill[index]
        }
        return when (val realAnnaBill = tempAnnaAndBrainBill/2){
            b -> Companion.bonAppetit
            else -> "${b-realAnnaBill}"
        }
    }

    companion object {
        const val bonAppetit = "Bon Appetit"
    }
}

fun durationToText(seconds: Int): String {
    if (seconds == 0) {
        return "now"
    }

    val yearInSeconds = 365 * 24 * 60 * 60
    val dayInSeconds = 24 * 60 * 60
    val hourInSeconds = 60 * 60
    val minuteInSeconds = 60

    val years = seconds / yearInSeconds
    var remainingSeconds = seconds % yearInSeconds

    val days = remainingSeconds / dayInSeconds
    remainingSeconds %= dayInSeconds

    val hours = remainingSeconds / hourInSeconds
    remainingSeconds %= hourInSeconds

    val minutes = remainingSeconds / minuteInSeconds
    val finalSeconds = remainingSeconds % minuteInSeconds

    val result = mutableListOf<String>()

    if (years > 0) {
        result.add(if (years == 1) "1 year" else "$years years")
    }

    if (days > 0) {
        result.add(if (days == 1) "1 day" else "$days days")
    }

    if (hours > 0) {
        result.add(if (hours == 1) "1 hour" else "$hours hours")
    }

    if (minutes > 0) {
        result.add(if (minutes == 1) "1 minute" else "$minutes minutes")
    }

    if (finalSeconds > 0) {
        result.add(if (finalSeconds == 1) "1 second" else "$finalSeconds seconds")
    }

    if (result.size > 1) {
        val lastIndex = result.lastIndex
        result[lastIndex - 1] += " and ${result[lastIndex]}"
        result.removeAt(lastIndex)
    }

    return result.joinToString(", ")
}

fun main() {
    println(durationToText(62))       // Output: "1 minute and 2 seconds"
    println(durationToText(3662))     // Output: "1 hour, 1 minute and 2 seconds"
    println(durationToText(0))        // Output: "now"
    println(durationToText(15731080))  // Output: "182 days, 1 hour, 44 minutes and 40 seconds"
}

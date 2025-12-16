package com.jeetsrpr.mindsync.utils

import com.jeetsrpr.mindsync.data.entities.PriorityRule

object PriorityCalculator {
    
    /**
     * Calculate priority score (0-100) based on various factors
     */
    fun calculatePriority(
        sender: String,
        content: String,
        timestamp: Long,
        rules: List<PriorityRule> = emptyList(),
        contactImportance: Int = 0
    ): Int {
        var score = 50 // Base score
        
        // Apply contact importance (0-20 points)
        score += (contactImportance / 5).coerceIn(0, 20)
        
        // Apply custom rules
        rules.forEach { rule ->
            when (rule.ruleType) {
                "SENDER" -> {
                    if (sender.contains(rule.ruleValue, ignoreCase = true)) {
                        score += rule.scoreModifier
                    }
                }
                "KEYWORD" -> {
                    if (content.contains(rule.ruleValue, ignoreCase = true)) {
                        score += rule.scoreModifier
                    }
                }
                "TIME" -> {
                    // Time-based rules can be implemented here
                }
            }
        }
        
        // Urgency keywords boost (0-30 points)
        val urgentKeywords = listOf("urgent", "important", "asap", "immediately", "emergency")
        urgentKeywords.forEach { keyword ->
            if (content.contains(keyword, ignoreCase = true)) {
                score += 10
            }
        }
        
        return score.coerceIn(0, 100)
    }
}

/*
Problem:
121. Best Time to Buy and Sell Stock

Difficulty:
Easy

Topic:
Array, Greedy

Approach 1 (Using Math.min() & Math.max()):
1) Initialize `buyPrice` with Integer.MAX_VALUE to store the minimum stock price seen so far.
2) Initialize `maxProfit` as 0.
3) Traverse the array once.
4) For each stock price:
    - Update the minimum buying price using Math.min().
    - Calculate the profit if the stock is sold today.
    - Update the maximum profit using Math.max().
5) Return the maximum profit.

Approach 2 (Using if-else):
1) Initialize `buyPrice` with Integer.MAX_VALUE.
2) Initialize `maxProfit` as 0.
3) Traverse the stock prices.
4) If the current price is greater than the buying price:
    - Calculate the profit by selling today.
    - Update the maximum profit.
5) Otherwise:
    - Update the buying price since a cheaper stock has been found.
6) Return the maximum profit.

Time Complexity:
O(n)

Space Complexity:
O(1)

LeetCode:
https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
*/

class Solution {

    // ==============================
    // Approach 1 : Math.min() & Math.max() (Recommended)
    // ==============================

    public int maxProfit(int[] prices) {

        // Stores the minimum buying price seen so far
        int buyPrice = Integer.MAX_VALUE;

        // Stores the maximum profit
        int maxProfit = 0;

        // Traverse each stock price
        for (int price : prices) {

            // Update minimum buying price
            buyPrice = Math.min(buyPrice, price);

            // Update maximum profit if selling today is beneficial
            maxProfit = Math.max(maxProfit, price - buyPrice);
        }

        return maxProfit;
    }

    // ==============================
    // Approach 2 : Using if-else
    // ==============================

    public int maxProfitAlternative(int[] prices) {

        // Stores the minimum buying price seen so far
        int buyPrice = Integer.MAX_VALUE;

        // Stores the maximum profit
        int maxProfit = 0;

        // Traverse the array
        for (int i = 0; i < prices.length; i++) {

            // If selling today gives profit
            if (buyPrice < prices[i]) {

                int profit = prices[i] - buyPrice;

                // Update maximum profit
                maxProfit = Math.max(maxProfit, profit);

            } else {

                // Found a cheaper buying price
                buyPrice = prices[i];
            }
        }

        return maxProfit;
    }
}
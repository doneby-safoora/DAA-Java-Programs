import java.util.Arrays;

// Item class
class Item
{
    int profit;
    int weight;
    double ratio;

    // Constructor
    Item(int profit, int weight)
    {
        this.profit = profit;
        this.weight = weight;
        this.ratio = (double) profit / weight;
    }
}

public class FractionalKnapsack
{
    public static void main(String[] args)
    {
        int capacity = 50;

        // Create items
        Item items[] =
        {
            new Item(60, 10),
            new Item(100, 20),
            new Item(120, 30)
        };

        // Step 1: Sort items in descending order of Profit/Weight ratio
        Arrays.sort(items, (a, b) -> Double.compare(b.ratio, a.ratio));

        double totalProfit = 0;
        int remainingCapacity = capacity;

        System.out.println("Selected Items:");

        // Step 2: Select items
        for (Item item : items)
        {
            // If the entire item can be included
            if (remainingCapacity >= item.weight)
            {
                remainingCapacity -= item.weight;
                totalProfit += item.profit;

                System.out.println("Full Item  -> "
                        + "Profit = " + item.profit
                        + ", Weight = " + item.weight);
            }
            else
            {
                // Include only the required fraction
                double fraction = (double) remainingCapacity / item.weight;
                double profit = fraction * item.profit;

                totalProfit += profit;

                System.out.println("Fractional Item -> "
                        + "Profit = " + profit
                        + ", Weight Taken = " + remainingCapacity);

                remainingCapacity = 0;
                break;
            }
        }

        System.out.println("\nMaximum Profit = " + totalProfit);
    }
}

/*
Algorithm: Fractional Knapsack: 

FRACTIONAL-KNAPSACK(Items, Capacity)
1. Calculate the Profit/Weight ratio for every item.
2. Sort all items in decreasing order of Profit/Weight ratio.
3. For each item:
      a. If the item's weight is less than or equal to the
         remaining capacity:
            i. Take the complete item.
           ii. Reduce the remaining capacity.
      b. Otherwise:
            i. Take only the required fraction of the item.
           ii. Add the corresponding profit.
          iii. Stop.
4. Print the selected items.
5. Print the maximum profit.

Time Complexity :  O(n log n)

*/
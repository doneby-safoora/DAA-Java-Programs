import java.util.Arrays;

// Job class
class Job
{
    String id;
    int deadline;
    int profit;

    // Constructor
    Job(String id, int deadline, int profit)
    {
        this.id = id;
        this.deadline = deadline;
        this.profit = profit;
    }
}

public class JobSequencing
{
    public static void main(String[] args)
    {
        // Create jobs
        Job j1 = new Job("J1", 2, 100);
        Job j2 = new Job("J2", 1, 19);
        Job j3 = new Job("J3", 2, 27);
        Job j4 = new Job("J4", 1, 25);
        Job j5 = new Job("J5", 3, 15);

        Job jobs[] = {j1, j2, j3, j4, j5};

        // Step 1: Sort jobs in descending order of profit
        Arrays.sort(jobs, (a, b) -> b.profit - a.profit);

        // Step 2: Find the maximum deadline
        int maxDeadline = 0;

        for (Job job : jobs)
        {
            if (job.deadline > maxDeadline)
            {
                maxDeadline = job.deadline;
            }
        }

        // Step 3: Create slots
        String result[] = new String[maxDeadline];
        boolean slot[] = new boolean[maxDeadline];
        int profit[] = new int[maxDeadline];

        int totalProfit = 0;

        // Step 4: Schedule jobs
        for (Job job : jobs)
        {
            // Check from the last possible slot
            for (int j = job.deadline - 1; j >= 0; j--)
            {
                if (!slot[j])
                {
                    slot[j] = true;
                    result[j] = job.id;
                    profit[j] = job.profit;
                    totalProfit += job.profit;
                    break;
                }
            }
        }

        // Step 5: Print scheduled jobs
        System.out.println("Scheduled Jobs:");

        for (int i = 0; i < maxDeadline; i++)
        {
            if (slot[i])
            {
                System.out.println("Slot " + (i + 1) + " : "
                                   + result[i] + "  Profit = "
                                   + profit[i]);
            }
        }

        System.out.println("\nTotal Profit = " + totalProfit);
    }
}

/*
Here's a clean, organized, and easy-to-understand version of the Job Sequencing with Deadlines program. This version is ideal for lab exams, records, and viva.

import java.util.Arrays;

// Job class
class Job
{
    String id;
    int deadline;
    int profit;

    // Constructor
    Job(String id, int deadline, int profit)
    {
        this.id = id;
        this.deadline = deadline;
        this.profit = profit;
    }
}

public class JobSequencing
{
    public static void main(String[] args)
    {
        // Create jobs
        Job j1 = new Job("J1", 2, 100);
        Job j2 = new Job("J2", 1, 19);
        Job j3 = new Job("J3", 2, 27);
        Job j4 = new Job("J4", 1, 25);
        Job j5 = new Job("J5", 3, 15);

        Job jobs[] = {j1, j2, j3, j4, j5};

        // Step 1: Sort jobs in descending order of profit
        Arrays.sort(jobs, (a, b) -> b.profit - a.profit);

        // Step 2: Find the maximum deadline
        int maxDeadline = 0;

        for (Job job : jobs)
        {
            if (job.deadline > maxDeadline)
            {
                maxDeadline = job.deadline;
            }
        }

        // Step 3: Create slots
        String result[] = new String[maxDeadline];
        boolean slot[] = new boolean[maxDeadline];
        int profit[] = new int[maxDeadline];

        int totalProfit = 0;

        // Step 4: Schedule jobs
        for (Job job : jobs)
        {
            // Check from the last possible slot
            for (int j = job.deadline - 1; j >= 0; j--)
            {
                if (!slot[j])
                {
                    slot[j] = true;
                    result[j] = job.id;
                    profit[j] = job.profit;
                    totalProfit += job.profit;
                    break;
                }
            }
        }

        // Step 5: Print scheduled jobs
        System.out.println("Scheduled Jobs:");

        for (int i = 0; i < maxDeadline; i++)
        {
            if (slot[i])
            {
                System.out.println("Slot " + (i + 1) + " : "
                                   + result[i] + "  Profit = "
                                   + profit[i]);
            }
        }

        System.out.println("\nTotal Profit = " + totalProfit);
    }
}
Algorithm: Job Sequencing with Deadlines:

JOB-SEQUENCING(Jobs)
1. Sort all jobs in descending order of profit.
2. Find the maximum deadline.
3. Create an array of free time slots.
4. For each job:
      a. Check the latest free slot before its deadline.
      b. If the slot is free:
            i. Assign the job to that slot.
           ii. Mark the slot as occupied.
5. Print the scheduled jobs.
6. Print the total profit.

Time Complexity :  O(n log n + n × d)

*/
# COS 285 Assignment 4: QUEUES

Taylor Brookes: Project Manager

Nathaniel Lavarnway: Team Memeber

Outline:

Taylor will create the sorted arraylist and the main method.

Nathaniel will create the iterator and queue and calculate the amount of counters needed for each day.

estimate how many counters needed for each county. counters work 24/7. time to process accident is based on severity. severity 1 = 60min, 2 = 120min, 3 = 180min, 4 = 240min. 

For the input state and county, read the accident reports in an ArrayList, and then sorted based on the date of the start time (Ascending). All the accident reports should be processed on the same day they have happened (otherwise, you need more counters).

basically total time needed for the day / 24*60 = total counters needed for county (round up).

You will simulate this problem by iterating on each day (from the first to the last day). On each day, first, add all the accident reports that occurred on that day to the queue. Then, start processing each accident by removing them from the queue and then processing them (not an actual processing, just remove and consider the time required for processing). Hint: Consider you have 5 counters. They will work for 5*24*60=7200 minutes a day. So, in total, you have 7200 minutes to process your queue each day. Given this amount of time, start removing items from your queue, and based on the processing time, reducethe total amount of time, till it reaches zero. For example, if the first accident has a severity of 1, it will take 60 minutes. So the remaining time will be 7200-60. But remember, all the reports should be processed within the same day as the accident. So when removing items from the queue, you should check how long they have been waiting and if it is more than a day, then you do not have enough counters.

For the following counties, calculate the minimum number of counters needed to process all the reports on time:

a. Los Angeles, CA

b. Orange, FL

c. Harris, TX

d. Hamilton, OH

e. New Castle, DE


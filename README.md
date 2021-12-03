# MostActiveCookie



# Main Idea: 
-Loop Through CSV file (For each line):
1) Use the delimiter "," to get the Cookie name and Timestamp for each line
2) Get the timestamp using "T" as delimeter
2) Check if cookie timestamp is equal to our date
3) Add cookie to hashmap if we have never seen it or add 1 to its current count if we have seen it previously
-After looping through CSV file:
 1) Loop through hashmap 
 2) If the entrys maximum is greater than our current maximum clear the printList and add the new maximums cookie name
 3) If the entry maximum is the same as our current maximum add its key (cookie name) on to our current printlist


# Assumptions made: 
1) Only csv files coresponding to the format given -> We can handle wrongly formatted csv files or argument parameters using a regex. 
   Was not sure if the dates would always be in UTC ISO format given (there are multiple ISO formats that have slight nuance) or if there was some variance so to be safe did not error check using regex.

2) Output Cookies did not need to appear in same order that it appeared in list. -> If we need to see the output cookies in the same order we seen them in then we can just use an arraylist as we loop through csv instead of a hashmap for storing the cookies matching the date parameter (because arraylists keep order while hashmaps dont).
We would loop through the array list and grab the indices that are greater than the max or equal to it. We would then display those indices 

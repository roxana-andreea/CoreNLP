import json
# import pandas as pd
# import matplotlib.pyplot as plt

tweets_data_path = 'pollsData.txt'

tweets_data = []
tweets_file = open(tweets_data_path, "r")

failed_lines = []
line_number = 0

blank = 0

for line in tweets_file:
    line_number += 1
    if line == "\n":
        blank += 1
        continue

    try:
        tweet = json.loads(line)
        tweets_data.append(tweet)
    except:
        # print "This one failed failed. Continuing..."
        failed_lines.append(line_number)
        continue

print len(tweets_data)

print "====="
print "First captured tweet"
i = 0
while i < 30:
    print tweets_data[i]['text'] + "\n"
    i += 1
print "====="

print "\n"
print "Number of failed lines " + str(len(failed_lines))

print "\n"
print "Blanks " + str(blank)


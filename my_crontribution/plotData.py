import json
import pandas as pd
import matplotlib.pyplot as plt
import numpy as np

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

    if line_number > 200000:
        break

    try:
        tweet = json.loads(line)
        tweets_data.append(tweet)
    except:
        # print "This one failed failed. Continuing..."
        failed_lines.append(line_number)
        continue

print len(tweets_data)

tweets = pd.DataFrame()
tweets['text'] = map(lambda tweet: tweet.get('text', None), tweets_data)
tweets['lang'] = map(lambda tweet: tweet.get('lang', None), tweets_data)

def getCounty(tweet):
    if tweet.get('place', None) != None:
        return tweet['place'].get('name', None)
tweets['country'] = map(getCounty, tweets_data)

tweets_by_lang = tweets['lang'].value_counts()
tweets_by_country = tweets['country'].value_counts()
tweets_by_text = tweets['text'].value_counts()

"""
print "By lang"
print tweets_by_lang

print "By text"
print tweets_by_text
"""

print "By country"
print tweets_by_country

fig, ax = plt.subplots()

ax.tick_params(axis='x', labelsize=15)
ax.tick_params(axis='y', labelsize=10)

ax.set_xlabel('Cities', fontsize=15)
# ax.set_xlabel('Languages', fontsize=15)

ax.set_ylabel('Number of tweets', fontsize=15)

ax.set_title('Top 10 cities', fontsize=15, fontweight='bold')

tweets_by_country[:10].plot(ax=ax, kind='bar', color='red')

plt.show()










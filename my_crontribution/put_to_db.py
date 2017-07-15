import pymongo
import sys
import json

FILENAME = "pollsData3.txt"
if __name__ == '__main__':
        false=False
        true=True
        null="Null"
        try:
                mongo=pymongo.MongoClient("localhost:27017")
        except:
                sys.exit()

        with open(FILENAME) as f:
                lines = f.readlines()
                for line in lines:
                        if line:
                                try:
                                        tweet = json.loads(line)
                                        result=mongo.test.tweets.insert(tweet)
                                except:
                                        pass

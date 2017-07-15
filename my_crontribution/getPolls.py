import tweepy

CONSUMER_KEY = 'pq9XE53UEnqFogIeAW8lISaA4'
CONSUMER_SECRET = 'dWkhI4qsU4lRUiv6KVhj0UYH3wrWBXL56bfBEdKMgFg1HyElB1'
ACCESS_KEY = '182484128-DYWyql5nFDDOiUjg9DxxolwRpyYWsxLykVN9Om50'
ACCESS_SECRET = 'zouqFU2PdQ7QYmkgeBiKIo1kaxTrEFQj8Zs80QILrwrKo'

class StdOutListener(tweepy.streaming.StreamListener):
    def on_data(self, data):
        print data
        return True

    def on_error(self, status):
        print status
        return True # keep stream alive

if __name__ == '__main__':

    out_stream = StdOutListener()
    auth = tweepy.OAuthHandler(CONSUMER_KEY, CONSUMER_SECRET)
    auth.set_access_token(ACCESS_KEY, ACCESS_SECRET)
    stream = tweepy.Stream(auth, out_stream)

    try:
        stream.filter(track=["#USElection", "#Elections2016", "#USPresident"
                            , "#Debate2016", "#Debatenight", "#MakeAmericaGreatAgain"
                            , "Trump", "Donald Trump", "Hillary", "Hillary Clinton"]
                            , languages=["en"])
    except KeyboardInterrupt:
        print '\nEnding job'

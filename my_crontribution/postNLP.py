import requests
import json
import sys

FILENAME = "pollsData.txt"
if __name__ == '__main__':
    with open(FILENAME) as f:
        lines = f.readlines()
        for line in lines:
            if line:
                try:
                    tweet = json.loads(line)
                    print tweet['text']
                except:
                    pass
            break

    r = requests.post("http://corenlp.run", data={'text':tweet['text'], 'annotators':'sentiment,natlog,tokenize','outputFormat':'json'})
    print r.status_code

    parsed = json.loads(r.text)
    print json.dumps(parsed, indent=2, sort_keys=True)


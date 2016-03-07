import request
import json
url = 'https://www.googleapis.com/qpxExpress/v1/trips/search?key=mykeyhere'
payload = json.load(open("request.json"))
headers = ('content-type : application/json', 'Accept-Charset: UTF-8')
r = requests.post(url, data=json.dumps(payload), headers=headers)
